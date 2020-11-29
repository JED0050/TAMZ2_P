package com.example.feedme_jed0050;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityHowToPlay extends AppCompatActivity {

    private ImageView imageViewHowToPlay;
    private int disW = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        imageViewHowToPlay = findViewById(R.id.iVH2P);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:

                float x = event.getX();

                if(x < disW / 2.0)
                {
                    index--;

                    if(index < 0)
                        index = 5;
                }
                else
                {
                    index++;

                    if(index > 5)
                        index = 0;
                }



                switch (index)
                {
                    case 0:
                        imageViewHowToPlay.setImageResource(R.drawable.h2p0);
                        break;
                    case 1:
                        imageViewHowToPlay.setImageResource(R.drawable.h2p1);
                        break;
                    case 2:
                        imageViewHowToPlay.setImageResource(R.drawable.h2p2);
                        break;
                    case 3:
                        imageViewHowToPlay.setImageResource(R.drawable.h2p3);
                        break;
                    case 4:
                        imageViewHowToPlay.setImageResource(R.drawable.h2p4);
                        break;
                    case 5:
                        imageViewHowToPlay.setImageResource(R.drawable.h2p5);
                        break;
                }

        }

        return super.onTouchEvent(event);
    }
}