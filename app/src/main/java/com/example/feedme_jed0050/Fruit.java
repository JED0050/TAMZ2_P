package com.example.feedme_jed0050;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.concurrent.ThreadLocalRandom;

public class Fruit {
    public int x;
    public int y;
    public Bitmap skin;
    public Bitmap[] skins;

    public Fruit(int xPos, int yPos, Bitmap[] fruitSkins)
    {
        x = xPos;
        y = yPos;
        skins = fruitSkins;

        skin = skins[0];
    }

    public boolean Contact(Player p) {
        if (x < p.x + 32 && x + 64 > p.x && y < p.y + 32 && y + 64 > p.y)
        {
            int rX = ThreadLocalRandom.current().nextInt(50, 500 + 1);
            int rY = ThreadLocalRandom.current().nextInt(50, 500 + 1);
            int rS = ThreadLocalRandom.current().nextInt(0, 3 + 1);

            x = rX;
            y = rY;
            skin = skins[rS];

            return true;
        }

        return false;
    }
}
