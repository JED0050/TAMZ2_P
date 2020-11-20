package com.example.feedme_jed0050;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class GameView extends View {

    private Player player;
    private Fruit fruit;
    private Paint pointPaint;

    private int points = 0;
    private Date currentTime = Calendar.getInstance().getTime();
    private Timer timer;
    private ScoreDB scoreDB;
    private boolean playerDied = false;

    private Bitmap[] fruits;

    private int disW = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int disH = Resources.getSystem().getDisplayMetrics().heightPixels;

    private float x1 = 0, x2 = 0, y1 = 0, y2 = 0;

    //private Button resetButton;

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);

        Date now = Calendar.getInstance().getTime();
        double dif = (now.getTime() - currentTime.getTime()) / 1000;
        //Log.d("time", "t: " + now);

        if(player.x <= 0 || player.x - 32 >= disW || player.y <= 0 || player.y - 32 >= disH || dif >= 5)
        {
            //you lose
            canvas.drawText("GAME OVER!!!", disW/2 - 50,disH/2 - 30,pointPaint);
            canvas.drawText("SCORE: " + points, disW/2 - 20,disH/2 + 30,pointPaint);

            if(!playerDied)
            {
                timer.cancel();
                playerDied = true;

                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                String data = points + " - " + formatter.format(now);
                scoreDB.saveData(data);
            }
        }
        else
        {
            player.Move();
            boolean eated = fruit.Contact(player);

            if(eated)
            {
                points++;
                currentTime = Calendar.getInstance().getTime();
            }

            canvas.drawBitmap(player.skin, player.x, player.y, null);
            canvas.drawBitmap(fruit.skin, fruit.x, fruit.y, null);
            canvas.drawText("Score: " + points + " Time: " + (5 - dif), disW/2 - 20,50,pointPaint);
        }
    }

    void init(Context context) {

        //resetButton = (Button)findViewById(R.id.buttonReset);
        //resetButton.callOnClick();
        //resetButton.setVisibility(View.GONE);

        SkinDB skinDB = new SkinDB(context);

        String skin = skinDB.loadData();

        Bitmap bPlayer;

        if(skin.equals("red"))
        {
            bPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.player_red);
        }
        else if(skin.equals("blue"))
        {
            bPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.player_blue);
        }
        else
        {
            bPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        }


        fruits = new Bitmap[] {BitmapFactory.decodeResource(getResources(), R.drawable.f0),
                BitmapFactory.decodeResource(getResources(), R.drawable.f1),
                BitmapFactory.decodeResource(getResources(), R.drawable.f2),
                BitmapFactory.decodeResource(getResources(), R.drawable.f3)};

        player = new Player(100,100,bPlayer, 25);
        fruit = new Fruit(200,200,fruits, disW, disH);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                postInvalidate();
            }
        }, 0, 50L);

        pointPaint = new Paint();
        pointPaint.setColor(Color.WHITE);
        pointPaint.setTextSize(50);

        scoreDB = new ScoreDB(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //gestureDetector.onTouchEvent(event);

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:

                x1 = event.getX();
                y1 = event.getY();

                return true;


            case MotionEvent.ACTION_UP:

                x2 = event.getX();
                y2 = event.getY();

                float valX = x2 - x1;
                float valY = y2 - y1;

                if (Math.abs(valX) > 100 && Math.abs(valX) > Math.abs(valY))
                {
                    if (x2 > x1)
                    {
                        player.MoveRight();
                    }
                    else
                    {
                        player.MoveLeft();
                    }
                }
                else if (Math.abs(valY) > 100)
                {
                    if(y2 > y1)
                    {
                        player.MoveDown();
                    }
                    else
                    {
                        player.MoveUp();
                    }
                }

        }

        return super.onTouchEvent(event);
    }

}
