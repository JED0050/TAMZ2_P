package com.example.feedme_jed0050;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityPlay extends AppCompatActivity {

    //private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);

        //resetButton = findViewById(R.id.buttonReset);
        //resetButton.setVisibility(View.GONE);
    }


    public void restartLevel(View view) {

        //resetButton.setVisibility(View.GONE);
        setContentView(R.layout.activity_play);

    }

}