package com.example.feedme_jed0050;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class ScoreDB extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefDB";
    public static final String SCORES = "scores";
    private Context ctx;

    public ScoreDB(Context c)
    {
        ctx = c;
    }

    public void saveData(String data)
    {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS, 0);

        String allData = sharedPreferences.getString(SCORES, "");
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(allData == "")
        {
            editor.putString(SCORES, data);
        }
        else
        {
            int actScore = Integer.parseInt(data.split(" ")[0]);
            int bestScore = Integer.parseInt(allData.split(" ")[0]);

            if(actScore > bestScore)
            {
                editor.putString(SCORES, data + "," + allData);
            }
            else
            {
                String[] lines = allData.split(",");

                boolean added = false;

                String readedData = lines[0] + ",";

                for(int i = 1; i < lines.length; i++)
                {
                    bestScore = Integer.parseInt(lines[i].split(" ")[0]);

                    if(actScore > bestScore && !added)
                    {
                        readedData += data + ",";
                        added = true;
                    }

                    readedData += lines[i] + ",";
                }

                if(!added)
                {
                    editor.putString(SCORES, allData + "," + data);
                }else
                {
                    if(readedData.charAt(readedData.length() - 1) == ',')
                    {
                        readedData = readedData.substring(0, readedData.length() - 1);
                    }

                    editor.putString(SCORES, readedData);
                }

            }
        }

        editor.apply();
    }

    public String[] loadData() {

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS, 0);
        String allData = sharedPreferences.getString(SCORES, "");

        String[] lines = allData.split(",");

        if(lines[0].length() == 0)
        {
            return new String[] {""};
        }

        return lines;
    }

    public void deleteScores()
    {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SCORES, "");
        editor.apply();
    }

}