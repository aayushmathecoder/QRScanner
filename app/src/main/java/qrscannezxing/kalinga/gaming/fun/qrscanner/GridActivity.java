package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.internal.widget.AdapterViewICS.OnItemClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridActivity extends Activity implements OnItemClickListener {
    List<List<Quiz>> quizList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));
        quizList = new ArrayList<>();


        initializeQuestionsAndOptions();

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the GridView selected/clicked item text
                // String selectedItem = parent.getItemAtPosition(position).toString();
                final int dialogVariable = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(GridActivity.this);
                builder.setTitle("Enter Password to Unlock Quiz Level " + (position + 1));
                // I'm using fragment here so I'm using getView() to provide ViewGroup
                // but you can provide here any other instance of ViewGroup from your Fragment / Activity
                View viewInflated = LayoutInflater.from(GridActivity.this).inflate(R.layout.custom_password_dialog, (ViewGroup) findViewById(android.R.id.content), false);
                // Set up the input
                final EditText input = (EditText) viewInflated.findViewById(R.id.input);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                builder.setView(viewInflated);

                // Set up the buttons
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String password = input.getText().toString();
                        if ((dialogVariable == 0) && (password.equalsIgnoreCase("abcde"))) {
                            // Display the selected/clicked item text and position on TextView
                            //TODO:Can place only startActivity inside it
                            Intent intent = new Intent(GridActivity.this, WelcomeQuizScreen.class);
                            Log.d("position", "" + dialogVariable);
                            intent.putExtra("position", dialogVariable);

                            intent.putExtra("quizQuestions", (ArrayList<Quiz>) quizList.get(dialogVariable));


                            //startActivityForResult(intent, 500);
                            startActivity(intent);
                        } else if ((dialogVariable == 1) && (password.equalsIgnoreCase("fghijk"))) {
                            // Display the selected/clicked item text and position on TextView
                            Intent intent = new Intent(GridActivity.this, WelcomeQuizScreen.class);
                            Log.d("position", "" + dialogVariable);
                            intent.putExtra("position", dialogVariable);

                            intent.putExtra("quizQuestions", (ArrayList<Quiz>) quizList.get(dialogVariable));


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
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


        //  Toast.makeText(this, mOrderDetailsList.get(i).get(KEY_TITLE),Toast.LENGTH_SHORT).show();
    }

    public void initializeQuestionsAndOptions() {
        List<Quiz> quizArrayListLevel1 = new ArrayList<>();
        String[] options1 = {"Travel,Transportation and Hospitality",
                "Tour,Transportation and Hospitality",
                "Travel and Hospitality",
                "None of the above"};
        ArrayList<String> optionArrayList = new ArrayList<String>(Arrays.asList(options1));
        Quiz quiz = new Quiz("1. What is the full form of T.T.H ?", optionArrayList, "Travel,Transportation and Hospitality", 4);

        String[] options2 = {"CTO",
                "Travel,Transportation and Hospitality",
                "BFSI",
                "None of the above"};
        ArrayList<String> optionArrayList1 = new ArrayList<String>(Arrays.asList(options2));
        Quiz quiz1 = new Quiz("2. Marriott Hotel Belongs to  I.G?", optionArrayList1, "Travel,Transportation and Hospitality", 4);

        String[] options3 = {"True",
                "False",
        };
        ArrayList<String> optionArrayList2 = new ArrayList<String>(Arrays.asList(options3));
        Quiz quiz2 = new Quiz("3. Marriott Hotel Belongs to  T.T.H I.G?", optionArrayList2, "True", 2);


        String[] level1options4 = {"True",
                "False",
        };
        ArrayList<String> optionListLevel1Question4 = new ArrayList<String>(Arrays.asList(level1options4));
        Quiz quizLevel1Question4 = new Quiz("4. S.I.T.A is part of T.T.H I.G?", optionListLevel1Question4, "False", 2);

        String[] level1options5 = {"2012",
                "2015",
                "1998",
                "2010"
        };
        ArrayList<String> optionListLevel1Question5 = new ArrayList<String>(Arrays.asList(level1options5));
        Quiz quizLevel1Question5 = new Quiz("5. T.T.H was founded in which year?", optionListLevel1Question5, "2012", 4);


        //quizArrayList = new ArrayList<>();
        quizArrayListLevel1.add(quiz);
        quizArrayListLevel1.add(quiz1);
        quizArrayListLevel1.add(quiz2);
        quizArrayListLevel1.add(quizLevel1Question4);
        quizArrayListLevel1.add(quizLevel1Question5);
        quizList.add(quizArrayListLevel1);

        //Level 2
        List<Quiz> quizArrayListLevel2 = new ArrayList<>();
        String[] level2options1 = {"Chief Technician Officer",
                "Chief Technology Officer",
                "Common Technology Officer",
                "None of the above"};
        ArrayList<String> optionListLevel2Question1 = new ArrayList<String>(Arrays.asList(level2options1));
        Quiz quizLevel2 = new Quiz("What is the full form of C.T.O?", optionListLevel2Question1, "Chief Technician Officer", 4);

        String[] level2options2 = {"CTO",
                "Travel,Transportation and Hospitality",
                "BFSI",
                "None of the above"};
        ArrayList<String> optionListLevel2Question2 = new ArrayList<String>(Arrays.asList(level2options2));
        Quiz quizLevel2Question2 = new Quiz("CAPE project belongs to which I.G?", optionListLevel2Question2, "CTO", 4);

        String[] level2options3 = {"True",
                "False",
        };
        ArrayList<String> optionListLevel2Question3 = new ArrayList<String>(Arrays.asList(level2options3));
        Quiz quizLevel2Question3 = new Quiz("CAG is part of C.T.O I.G?", optionListLevel2Question3, "True", 2);

        String[] level2options4 = {"True",
                "False",
        };
        ArrayList<String> optionListLevel2Question4 = new ArrayList<String>(Arrays.asList(level2options4));
        Quiz quizLevel2Question4 = new Quiz("S.I.T.A is part of C.T.O I.G?", optionListLevel2Question4, "False", 2);

        String[] level2options5 = {"2012",
                "2015",
                "1998",
                "2010"
        };
        ArrayList<String> optionListLevel2Question5 = new ArrayList<String>(Arrays.asList(level2options5));
        Quiz quizLevel2Question5 = new Quiz("C.T.O was founded in which year?", optionListLevel2Question5, "2010", 4);
        //quizArrayList = new ArrayList<>();
        quizArrayListLevel2.add(quizLevel2);
        quizArrayListLevel2.add(quizLevel2Question2);
        quizArrayListLevel2.add(quizLevel2Question3);
        quizArrayListLevel2.add(quizLevel2Question4);
        quizArrayListLevel2.add(quizLevel2Question5);
        quizList.add(quizArrayListLevel2);
        //TODO:remove later
        quizList.add(quizArrayListLevel1);
        quizList.add(quizArrayListLevel2);

    }
}






