package com.example.feedme_jed0050;

import android.graphics.Bitmap;

public class Player {

    public int x;
    public int y;
    private int steps;
    private int speedX;
    private int speedY;
    public Bitmap skin;

    public Player(int xPos, int yPos, Bitmap playerSkin, int playerSteps)
    {
        x = xPos;
        y = yPos;
        steps = playerSteps;
        skin = playerSkin;

    }

    public void MoveLeft()
    {
        speedX = -steps;
        speedY = 0;
    }

    public void MoveRight()
    {
        speedX = steps;
        speedY = 0;
    }

    public void MoveUp()
    {
        speedX = 0;
        speedY = -steps;
    }

    public void MoveDown()
    {
        speedX = 0;
        speedY = steps;
    }

    public void Move()
    {
        x += speedX;
        y += speedY;
    }

}
