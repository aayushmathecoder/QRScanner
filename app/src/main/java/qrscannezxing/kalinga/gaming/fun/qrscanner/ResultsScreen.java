package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsScreen extends AppCompatActivity {
TextView mScores;
    int scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);
        mScores=(TextView)findViewById(R.id.scores);
        scores=getIntent().getIntExtra("scores",0);
        mScores.setText(""+scores);
    }
}
