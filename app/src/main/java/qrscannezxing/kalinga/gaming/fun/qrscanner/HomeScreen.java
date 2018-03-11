package qrscannezxing.kalinga.gaming.fun.qrscanner;

/**
 * Created by spasayat on 13-Aug-17.
 */


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import static android.R.attr.width;

public class HomeScreen extends AppCompatActivity {


    int[] resources = {
            R.drawable.campusbeauty,
            R.drawable.w1,
            R.drawable.w2,


    };
    private ViewFlipper mViewFlipper;
    private Button mStartQuizButton;
   // private Button mPlayGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        mStartQuizButton = (Button) findViewById(R.id.startQuiz);
      //  mPlayGameButton = (Button) findViewById(R.id.playGameButton);
        // Add all the images to the ViewFlipper
        for (int i = 0; i < resources.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            // imageView.setAdjustViewBounds(true);
            //imageView.setImageResource(resources[i]);
            imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), resources[i], ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
            mViewFlipper.addView(imageView);
        }
        mViewFlipper.setInAnimation(HomeScreen.this, R.anim.left_in);
        mViewFlipper.setOutAnimation(HomeScreen.this, R.anim.left_out);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(2000);
    }

    public void playGame(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(HomeScreen.this);
        builder.setTitle("Enter Passcode to Unlock BugZilla Level ");
        // I'm using fragment here so I'm using getView() to provide ViewGroup
        // but you can provide here any other instance of ViewGroup from your Fragment / Activity
        View viewInflated = LayoutInflater.from(HomeScreen.this).inflate(R.layout.custom_password_dialog, (ViewGroup) findViewById(android.R.id.content), false);
        // Set up the input
        final EditText input = (EditText) viewInflated.findViewById(R.id.input);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        builder.setView(viewInflated);

        // Set up the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String password = input.getText().toString();
                if (password.equalsIgnoreCase("passcodeLevel1")) {
                    String url = "http://13.126.90.26/level1/";
                    // Display the selected/clicked item text and position on TextView
                    //TODO:Can place only startActivity inside it
                    Intent intent = new Intent(HomeScreen.this, PlayMarioActivity.class);
                    //Log.d("position", "" + dialogVariable);
                    // intent.putExtra("position", dialogVariable);
                    intent.putExtra("url", url);
                    //intent.putExtra("quizQuestions", (ArrayList<Quiz>) quizList.get(dialogVariable));


                    //startActivityForResult(intent, 500);
                    startActivity(intent);
                } else if (password.equalsIgnoreCase("passcodeLevel2")) {
                    // Display the selected/clicked item text and position on TextView
                    String url = "http://13.126.90.26/level2/";
                    Intent intent = new Intent(HomeScreen.this, PlayMarioActivity.class);
                    intent.putExtra("url", url);
                    //Log.d("position", "" + dialogVariable);
                            /*intent.putExtra("position", dialogVariable);

                            intent.putExtra("quizQuestions", (ArrayList<Quiz>) quizList.get(dialogVariable));*/


                    //startActivityForResult(intent, 500);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Password!!Quiz could NOT be unlocked", Toast.LENGTH_SHORT).show();
                }

                dialog.dismiss();

            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }
/*Intent i = new Intent(this, PlayMarioActivity.class);
        startActivity(i);*/


    public void startQuiz(View v) {
        Intent i = new Intent(this, GridActivity.class);
        startActivity(i);
    }

    public void scanQRCode(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            // Swipe left (next)
            if (e1.getX() > e2.getX()) {

                mViewFlipper.setInAnimation(HomeScreen.this, R.anim.left_in);
                mViewFlipper.setOutAnimation(HomeScreen.this, R.anim.left_out);
                mViewFlipper.showNext();
            }

            // Swipe right (previous)
            if (e1.getX() < e2.getX()) {

                mViewFlipper.setInAnimation(HomeScreen.this, R.anim.right_in);
                mViewFlipper.setOutAnimation(HomeScreen.this, R.anim.right_out);
                mViewFlipper.showPrevious();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }

    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
