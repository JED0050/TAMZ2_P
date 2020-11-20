package com.example.feedme_jed0050;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;


public class SkinDB extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefDB";
    public static final String SKINS = "skins";
    private Context ctx;

    public SkinDB(Context c)
    {
        ctx = c;
    }

    public void saveData(String data)
    {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(SKINS, data.toLowerCase());
        editor.apply();
    }

    public String loadData() {

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREFS, 0);
        String data = sharedPreferences.getString(SKINS, "yellow");

        return data.toLowerCase();

    }


}
