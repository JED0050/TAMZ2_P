package com.example.feedme_jed0050;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityScores extends AppCompatActivity {

    private TextView textScores;
    private String[] scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        textScores = findViewById(R.id.textViewScores);

        getScores();
    }

    private void getScores()
    {
        ScoreDB scoreDB = new ScoreDB(this);
        //scoreDB.deleteScores();

        scores = scoreDB.loadData();

        if(scores[0] != "")
        {
            textScores.setText("");

            for(String score : scores)
            {
                textScores.append(score + "\n");
            }
        }
    }
}