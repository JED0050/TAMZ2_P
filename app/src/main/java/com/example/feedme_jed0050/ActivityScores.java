package com.example.feedme_jed0050;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityScores extends AppCompatActivity {

    private TextView textScores;
    private ListView lWScores;
    private String[] scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        getScores();

        lWScores = findViewById(R.id.listViewScores);

        if(scores.length > 0 && scores[0] != "")
        {
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_view_center_text, scores);
            lWScores.setAdapter(arrayAdapter);
        }
        else
        {
            String[] emptyScores = new String[] { "There is no score right now!" };

            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_view_center_text, emptyScores);
            lWScores.setAdapter(arrayAdapter);
        }

    }

    private void getScores()
    {
        ScoreDB scoreDB = new ScoreDB(this);
        //scoreDB.deleteScores();

        scores = scoreDB.loadData();

    }
}