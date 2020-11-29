package com.example.feedme_jed0050;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.concurrent.ThreadLocalRandom;

public class Fruit {
    public int x;
    public int y;
    public Bitmap skin;
    public Bitmap[] skins;

    protected int xMax;
    protected int yMax;

    public Fruit(int xPos, int yPos, Bitmap[] fruitSkins, int xM, int yM)
    {
        x = xPos;
        y = yPos;
        skins = fruitSkins;

        skin = skins[0];

        xMax = xM;
        yMax = yM;

    }

    public boolean Contact(Player p) {

        //if (x < p.x + 32 && x + 64 > p.x && y < p.y + 32 && y + 64 > p.y)

        if (x <= p.x  && x + 100 >= p.x && y <= p.y  && y + 100 >= p.y)
        {
            int rX; // = ThreadLocalRandom.current().nextInt(50, xMax + 1 - 50);
            int rY; // = ThreadLocalRandom.current().nextInt(50, yMax + 1 - 50);
            int rS = ThreadLocalRandom.current().nextInt(0, skins.length);

            double distance = 0;

            do {

                rX = ThreadLocalRandom.current().nextInt(50, xMax + 1 - 200);
                rY = ThreadLocalRandom.current().nextInt(50, yMax + 1 - 400);

                distance = Math.sqrt((rX - x)*(rX - x) + (rY - y)*(rY - y));

            }while(distance < 500);

            x = rX;
            y = rY;
            skin = skins[rS];

            return true;
        }

        return false;
    }
}
