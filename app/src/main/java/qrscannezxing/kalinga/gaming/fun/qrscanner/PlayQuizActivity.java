package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class PlayQuizActivity extends AppCompatActivity {
    TextView mNameOfPlayer;
    TextView mPlayerPoints;
    TextView mQuestionText;
    TextView mTimer;
    int count = 10;
    private ArrayList<Quiz> quizArrayList;
    Animation slideUpAnimation;
    int scores = 0;
    public static final String PREFS_NAME = "MyPrefsFile";
    int position;
    LinearLayout mParentLayout;
   /* Timer timer;
    private Timer timer1;
    private TimerTask timerTask1;*/
   @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quiz_questions);
       /* mNameOfPlayer = (TextView) findViewById(R.id.player_name_textview);
        mPlayerPoints = (TextView) findViewById(R.id.points_textview);*/
        mQuestionText = (TextView) findViewById(R.id.question_textview);
       ImageView ivBackground = (ImageView) findViewById(R.id.background);
       ivBackground.setImageDrawable(getResources().getDrawable(R.drawable.w1));
      //  mParentLayout = (LinearLayout) findViewById(R.id.parent_quiz_layout);
       //mParentLayout.setBackground(decodeSampledBitmapFromResource(getResources(), R.drawable.sundialblur, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        // mTimer = (TextView) findViewById(R.id.counter_textview);
    /*    timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTimer.setText("" + count);

                        if (count == 0) {
                            timer.cancel();

                        }
                        count--;
                    }
                });
            }
        }, 1000, 1000);*/

        //initializeQuestionsAndOptions();

//        quizArrayList= (ArrayList<Quiz>) getIntent().getSerializableExtra("quizQuestions");
       quizArrayList= (ArrayList<Quiz>) getIntent().getSerializableExtra("quizQuestions");
        position=  getIntent().getIntExtra("position",0);
        setQuestionsAndAnswers(0);

    }




    public void setQuestionsAndAnswers(int loopCounter) {

        LinearLayout childLayout = (LinearLayout) findViewById(R.id.options_layout);
        childLayout.setOrientation(LinearLayout.VERTICAL);
        slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);
        //final ImageView balloon = (ImageView) findViewById(R.id.balloon_image);
        LinearLayout.LayoutParams optionsLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        optionsLayout.setMargins(0, 40, 0, 0);
        int i = loopCounter;
        if (i < quizArrayList.size()) {
            //TODO:recheck the below method
            childLayout.removeAllViewsInLayout();
            mQuestionText.setText(quizArrayList.get(i).questionText);
            final Button[] options = new Button[quizArrayList.get(i).numberOfOptions];

            final LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.VERTICAL);
            // row.setLayoutParams();

            for (int j = 0; j < quizArrayList.get(i).numberOfOptions; j++) {
                options[j] = new Button(this);
                options[j].setClickable(true);
                options[j].setPadding(0, 80, 0, 80);
                options[j].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                options[j].setLayoutParams(optionsLayout);
                options[j].setText(quizArrayList.get(i).optionsList.get(j));
                options[j].setBackgroundResource(R.drawable.border);
                //options[j].setAlpha(0.75f);
                //options[j].setBackgroundColor(getResources().getColor(R.color.light_pink_text));
                options[j].setTextColor(Color.WHITE);
                options[j].setTextSize(16);
                // options[j].setId(j + 1 + (i * quizArrayList.get(i).numberOfOptions));
                options[j].setId(j + 1);
                options[j].startAnimation(slideUpAnimation);
                row.addView(options[j]);
                final int index = j;
                final int index1 = i;
                options[j].setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                                      Log.i("TAG", "The index is" + index);

                                                      if (options[index].getText().toString().equalsIgnoreCase(quizArrayList.get(index1).correctAnswer)) {
                                                          options[index].setBackgroundColor(getResources().getColor(R.color.zxing_possible_result_points));
                                                          //Note:Not changing colour
                                                          /*options[index].setBackgroundColor(getResources().getColor(R.color.zxing_result_points));
                                                          Toast.makeText(getApplicationContext(), "Excellent!!Correct Answer.", Toast.LENGTH_SHORT).show();*/
                                                          countScores();
                                                          /*TranslateAnimation animate;
                                                          animate = new TranslateAnimation(0,0,0, -v.getHeight()); // <------  slide up
                                                          animate.setDuration(200);
                                                          animate.setFillAfter(true);
                                                          balloon.setVisibility(View.VISIBLE);
                                                          balloon.startAnimation(animate);
                                                          balloon.setVisibility(View.GONE);*/
                                                          for (int l = 0; l < row.getChildCount(); l++) {
                                                              if (l == index) {

                                                              } else {
                                                                  row.getChildAt(l).setClickable(false);
                                                              }
                                                          }

                                                      } else {
                                                          options[index].setBackgroundColor(getResources().getColor(R.color.zxing_possible_result_points));
                                                          //Note:Not doing these now
                                                          //If the selected answer is wrong,then make it red
                                                         /* options[index].setBackgroundColor(Color.RED);*/
                                                          for (int k = 0; k < row.getChildCount(); k++) {

                                                              Button b = (Button) row.getChildAt(k);
                                                              //Note:Not doing these right now
                                                              //Setting right answer to green
                                                             /* if (b.getText().toString().equalsIgnoreCase(quizArrayList.get(index1).correctAnswer)) {
                                                                  row.getChildAt(k).setBackgroundColor(getResources().getColor(R.color.zxing_result_points));
                                                              }*/
                                                              //making all other options as unclickable
                                                              if (k != index) {
                                                                  row.getChildAt(k).setClickable(false);
                                                              }
                                                          }
                                                          //Note:Not telling user the wrong answer
                                                         // Toast.makeText(getApplicationContext(), "Oops!!You missed it.", Toast.LENGTH_SHORT).show();
                                                      }
                                                      //To delay it by 5seconds
                                                      new Handler().postDelayed(new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              //Do something after 5 seconds
                                                              increment(index1);
                                                          }
                                                      }, 1500);

                                                  }
                                              }
                );

            }
            childLayout.addView(row);
            //TODO:I++ at right place,,,also give 5 seconds of animation..so that question text changes
            //TODO:allow selection of one button at a time..>>>>Done
            //TODO:Later add background sound and animation before doing i++
        }
        else
        {
            //TODO:
            //Save the scores to saved preferences
            //from last question,,,go to review answers
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("scores", scores);
            editor.commit();
            Intent intent=new Intent(PlayQuizActivity.this,ResultsScreen.class);
            intent.putExtra("scores",scores);
            startActivity(intent);
            //Toast.makeText(getApplicationContext(), "Oops!!You missed it."+scores, Toast.LENGTH_SHORT).show();
        }

    }

    public void increment(int index) {
        index = index + 1;
        setQuestionsAndAnswers(index);
    }
    public void countScores()
    {
        scores=scores+20;
        //Note: Not doing these for now
        //TODO:Store these scores locally
      //  mPlayerPoints.setText(""+scores);
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




