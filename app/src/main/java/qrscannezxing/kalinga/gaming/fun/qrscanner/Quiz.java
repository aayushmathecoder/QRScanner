package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.graphics.BitmapFactory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by spasayat on 08-Aug-17.
 */

public class Quiz implements Serializable {
    String questionText;
    ArrayList<String> optionsList;
    String correctAnswer;
    int numberOfOptions;
    public Quiz(String questionText, ArrayList<String> optionsList, String correctAnswer, int numberOfOptions) {
        this.questionText = questionText;
        this.optionsList = optionsList;
        this.correctAnswer = correctAnswer;
        this.numberOfOptions = numberOfOptions;
    }



    public Quiz(String questionText, ArrayList<String> optionsList, String correctAnswer) {
        this.questionText = questionText;
        this.optionsList = optionsList;
        this.correctAnswer = correctAnswer;
    }


}
