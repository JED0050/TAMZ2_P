package com.example.feedme_jed0050;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivitiOptions extends AppCompatActivity {

    private SkinDB skinDB;
    private ScoreDB scoreDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiti_options);

        skinDB = new SkinDB(this);
        scoreDB = new ScoreDB(this);
    }

    public void setYellowSkin(View view) {

        String msg = "Yellow skin has been set!";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        skinDB.saveData("yellow");

    }

    public void setBlueSkin(View view) {

        int maxScore = scoreDB.getBestScore();

        if (maxScore < 15)
        {
            String msg = "Blue skin can't be set! You must have at least 15 points!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        else
        {
            String msg = "Blue skin has been set!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

            skinDB.saveData("blue");
        }

    }

    public void setRedSkin(View view) {

        int maxScore = scoreDB.getBestScore();

        if (maxScore < 30)
        {
            String msg = "Red skin can't be set! You must have at least 30 points!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
        else
        {
            String msg = "Red skin has been set!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

            skinDB.saveData("red");
        }

    }
}