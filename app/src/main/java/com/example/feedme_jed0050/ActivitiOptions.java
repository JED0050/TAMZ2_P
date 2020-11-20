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

        String msg = "Žlutý skin byl nastaven!";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        skinDB.saveData("yellow");

    }

    public void setBlueSkin(View view) {

        int maxScore = scoreDB.getBestScore();

        if (maxScore < 15)
        {
            String msg = "Modrý skin nelze nastavit! Musíš mít minimálně 15 bodů!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        else
        {
            String msg = "Modrý skin byl nastaven!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

            skinDB.saveData("blue");
        }

    }

    public void setRedSkin(View view) {

        int maxScore = scoreDB.getBestScore();

        if (maxScore < 30)
        {
            String msg = "Červený skin nelze nastavit! Musíš mít minimálně 30 bodů!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
        else
        {
            String msg = "Červený skin byl nastaven!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

            skinDB.saveData("red");
        }

    }
}