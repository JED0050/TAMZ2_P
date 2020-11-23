package com.example.feedme_jed0050;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class Player {

    public int x;
    public int y;
    private int steps;
    private int speedX;
    private int speedY;
    public Bitmap skinDef;
    public Bitmap skin;

    public Player(int xPos, int yPos, Bitmap playerSkin, int playerSteps)
    {
        x = xPos;
        y = yPos;
        steps = playerSteps;
        skinDef = playerSkin;
        skin = playerSkin;

    }

    public void MoveLeft()
    {
        speedX = -steps;
        speedY = 0;

        skin = RotateBitmap(180);
    }

    public void MoveRight()
    {
        speedX = steps;
        speedY = 0;

        skin = skinDef;
    }

    public void MoveUp()
    {
        speedX = 0;
        speedY = -steps;

        skin = RotateBitmap(270);
    }

    public void MoveDown()
    {
        speedX = 0;
        speedY = steps;

        skin = RotateBitmap(90);
    }

    public void Move()
    {
        x += speedX;
        y += speedY;
    }

    private Bitmap RotateBitmap(int angle)
    {
        Bitmap newBitmap;

        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        newBitmap = Bitmap.createBitmap(skinDef, 0, 0, skinDef.getWidth(), skinDef.getHeight(), matrix, true);

        return newBitmap;
    }
}
