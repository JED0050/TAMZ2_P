package com.example.feedme_jed0050;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPlay(View view) {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }

    public void onClickHow(View view) {
        Intent intent = new Intent(this, ActivityHowToPlay.class);
        startActivity(intent);
    }

    public void onClickScores(View view) {
        Intent intent = new Intent(this, ActivityScores.class);
        startActivity(intent);
    }

    public void onClickOptions(View view) {
        Intent intent = new Intent(this, ActivitiOptions.class);
        startActivity(intent);
    }

}