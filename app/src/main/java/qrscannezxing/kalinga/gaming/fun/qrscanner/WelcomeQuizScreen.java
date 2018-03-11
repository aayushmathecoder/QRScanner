package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class WelcomeQuizScreen extends AppCompatActivity {
TextView mInstructions_guideline;
TextView mInstructions_guideline1;
TextView mInstructions_guideline2;
TextView mInstructions_guideline3;
    private ArrayList<Quiz> quizArrayList;
    int position;
    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_quiz_screen);
        mInstructions_guideline=(TextView)findViewById(R.id.instructions_guideline_first) ;
        mInstructions_guideline1=(TextView)findViewById(R.id.instructions_guideline_second) ;
        mInstructions_guideline2=(TextView)findViewById(R.id.instructions_guideline_third) ;
        mInstructions_guideline3=(TextView)findViewById(R.id.instructions_guideline_fourth) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        quizArrayList= (ArrayList<Quiz>) getIntent().getSerializableExtra("quizQuestions");
        position=  getIntent().getIntExtra("position",0);
        final int dialogVariable=position;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(WelcomeQuizScreen.this,PlayQuizActivity.class);
                intent.putExtra("position", dialogVariable);

                intent.putExtra("quizQuestions",  quizArrayList);
                startActivity(intent);
            }
        });
        /*mInstructions_guideline.setText("1. These Quiz contains 10 questions. "+
        "\n"+"2. The questions are based on the hints you got while playing the game."+
        "\n"+"3. Each correct answer will earn you 20 points."+
        "\n"+"4. There are no negative marks on giving the wrong answer. ");*/

        Typeface face;

        face = Typeface.createFromAsset(getAssets(), "fonts/Sail-Regular.otf");

        mInstructions_guideline.setTypeface(face);
        mInstructions_guideline1.setTypeface(face);
        mInstructions_guideline2.setTypeface(face);
        mInstructions_guideline3.setTypeface(face);
    }

}
