package com.example.feedme_jed0050;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class GameView extends View {

    private Player player;
    private Fruit fruit;

    private Bitmap[] fruits;

    private int disW = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int disH = Resources.getSystem().getDisplayMetrics().heightPixels;

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

        if(player.x <= 0 || player.x - 32 >= disW || player.y <= 0 || player.y - 32 >= disH)
        {
            //you lose
        }
        else
        {
            player.Move();
            fruit.Contact(player);
        }

        canvas.drawBitmap(player.skin, player.x, player.y, null);
        canvas.drawBitmap(fruit.skin, fruit.x, fruit.y, null);

    }

    void init(Context context) {

        Bitmap bPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.player);

        fruits = new Bitmap[] {BitmapFactory.decodeResource(getResources(), R.drawable.f0),
                BitmapFactory.decodeResource(getResources(), R.drawable.f1),
                BitmapFactory.decodeResource(getResources(), R.drawable.f2),
                BitmapFactory.decodeResource(getResources(), R.drawable.f3)};

        player = new Player(100,100,bPlayer, 10);
        fruit = new Fruit(200,200,fruits);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                postInvalidate();
            }
        }, 0, 100L);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
            {
                float xT = event.getX();
                float yT = event.getY();


                if(xT > disW / 2 && yT >= disH*0.30 && yT <= disH*0.60)
                {
                    player.MoveRight();
                }
                else if(xT <= disW / 2 && yT >= disH*0.30 && yT <= disH*0.60)
                {
                    player.MoveLeft();
                }
                else if(yT <= disH*0.30)
                {
                    player.MoveUp();
                }
                else
                {
                    player.MoveDown();
                }

                invalidate();

                break;
            }

        }

        return super.onTouchEvent(event);
    }




}
