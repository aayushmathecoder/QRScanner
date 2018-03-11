package qrscannezxing.kalinga.gaming.fun.qrscanner;/*
package fun.gaming.kalinga.qrscannezxing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    TextView mNameOfPlayer;
    TextView mPlayerPoints;
    TextView mQuestionText;

    ArrayList<Quiz> quizArrayList;
    int mPointsEarned;
    int timer;
    LinearLayout mOptionsLayout[];
    LinearLayout mQuestionAnswersLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_questions);
        mNameOfPlayer = (TextView) findViewById(R.id.player_name_textview);
        mPlayerPoints = (TextView) findViewById(R.id.points_textview);
        mQuestionText = (TextView) findViewById(R.id.question_textview);
        */
/*mFirstOptionText = (TextView) findViewById(R.id.first_option_textview);
        mSecondOptionText = (TextView) findViewById(R.id.second_option_textview);
        mThirdOptionText = (TextView) findViewById(R.id.third_option_textview);
        mFourthOptionText = (TextView) findViewById(R.id.fourth_option_textview);*//*

       // mOptionsLayout=(LinearLayout)findViewById(R.id.options_layout);
        mQuestionAnswersLayout=(LinearLayout)findViewById(R.id.parent_qa_layout);
       // initializeQuestionsAndOptions();
        setQuestionsAndAnswers();
    }

    //TODO:Later it should be populated with  JSON ,also to make the no. of options as dynamic
   */
/* public void initializeQuestionsAndOptions() {
        Option option = new Option("Travel,Transportation and Hospitality");
        Option option1 = new Option( "Tour,Transportation and Hospitality");
        Option option2 = new Option("Travel and Hospitality");
        Option option3 = new Option( "None of the above");
        ArrayList<Option> optionArrayList=new ArrayList<>();
        optionArrayList.add(option);
        optionArrayList.add(option1);
        optionArrayList.add(option2);
        optionArrayList.add(option3);
        Quiz quiz = new Quiz("What is the full form of T.T.H", optionArrayList, "Travel,Transportation and Hospitality",4);

        Option option4 = new Option("Travel,Transportation and Hospitality");
        Option option5 = new Option( "CTO");
        Option option6 = new Option("BFSI");
        Option option7 = new Option( "None of the above");
        ArrayList<Option> optionArrayList1=new ArrayList<>();
        optionArrayList1.add(option4);
        optionArrayList1.add(option5);
        optionArrayList1.add(option6);
        optionArrayList1.add(option7);
        //Option option1 = new Option("Travel,Transportation and Hospitality", "CTO", "BFSI", "None of the above");
      //  Quiz quiz1 = new Quiz("Marriott Hotel Belongs to which I.G?", optionArrayList1, "Travel,Transportation and Hospitality",3);

        *//*
*/
/*Option option2 = new Option("I.G.G", "Tour,Transportation and Hospitality", "Travel and Hospitality", "None of the above");
        Quiz quiz2 = new Quiz("Airlines belong to?", option2, "None of the above",4);*//*
*/
/*
        Option option8 = new Option("True");
        Option option9 = new Option( "False");

        ArrayList<Option> optionArrayList2=new ArrayList<>();
        optionArrayList2.add(option8);
        optionArrayList2.add(option9);
        //Option option3 = new Option("True", "False", "Invalid", "None of the above");
        Quiz quiz3 = new Quiz("Garbage belongs to T.T.H?", optionArrayList2, "False",2);

        *//*
*/
/*Option option4 = new Option("Travel,Transportation and Hospitality", "Tour,Transportation and Hospitality", "Travel and Hospitality", "None of the above");
        Quiz quiz4 = new Quiz("What is the full form of T.T.H", option, "Travel,Transportation and Hospitality");*//*
*/
/*

        quizArrayList=new ArrayList<>();
        quizArrayList.add(quiz);
        quizArrayList.add(quiz1);
        //quizArrayList.add(quiz2);
        quizArrayList.add(quiz3);

    }*//*

    public void setQuestionsAndAnswers()
    {
        LinearLayout.LayoutParams myLayoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i=0;i<quizArrayList.size();i++)
        {
            mOptionsLayout=new LinearLayout[quizArrayList.size()];

            Button[] options=new Button[quizArrayList.get(i).numberOfOptions];


            mQuestionText.setText(quizArrayList.get(i).questionText);
            mOptionsLayout[i]=new LinearLayout(this);
            //TODO:acc to no. of options run the loop
            for(int j=0;j<quizArrayList.get(i).numberOfOptions;j++)
            {

                options[j]=new Button(this);
                options[j].setLayoutParams(myLayoutParams);
                options[j].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                //options[j].setPadding(10,10,10,10);
               // options[j].setText(quizArrayList.get(i).optionsList.get(j).option1);
                mOptionsLayout[i].addView(options[j]);
            }
            //mQuestionAnswersLayout.addView(mQuestionText);
          //  mQuestionAnswersLayout.addView(mOptionsLayout[i]);

        }
    }
}
*/
