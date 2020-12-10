package com.example.feedme_jed0050;

import android.graphics.Bitmap;

import java.util.concurrent.ThreadLocalRandom;

public class RottenFruit extends Fruit {

    public boolean spawned;

    public RottenFruit(int xPos, int yPos, Bitmap[] fruitSkins, int xM, int yM) {
        super(xPos, yPos, fruitSkins, xM, yM);

        spawned = false;
    }

    @Override
    public boolean Contact(Player p) {

        //if (x < p.x + 32 && x + 64 > p.x && y < p.y + 32 && y + 64 > p.y)
        //if (spawned && x <= p.x && x + 100 >= p.x && y <= p.y && y + 100 >= p.y)

        return (spawned && x <= p.x && x + skin.getWidth() >= p.x && y <= p.y && y + skin.getHeight() >= p.y);

    }

    public void Spawn(Player p) {
        int rX; // = ThreadLocalRandom.current().nextInt(50, xMax + 1 - 50);
        int rY; // = ThreadLocalRandom.current().nextInt(50, yMax + 1 - 50);
        int rS = ThreadLocalRandom.current().nextInt(0, skins.length);

        double distance = 0;

        do {

            rX = ThreadLocalRandom.current().nextInt(50, xMax + 1 - 200);
            rY = ThreadLocalRandom.current().nextInt(50, yMax + 1 - 400);

            distance = Math.sqrt((rX - p.x) * (rX - p.x) + (rY - p.y) * (rY - p.y));

        } while (distance < 500);

        x = rX;
        y = rY;
        skin = skins[rS];

        spawned = true;
    }

    public void Despawn()
    {
        spawned = false;
    }
}
