package com.kou.yazlab5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {

    private int highScore;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        SharedPreferences sharedPref = getSharedPreferences("GAME_DATA", MODE_PRIVATE);

        TextView highScoreLevel1 = findViewById(R.id.highScoreLevel1);
        highScore = sharedPref.getInt("GAME_HIGHSCORE0", 0);
        highScoreLevel1.setText(highScore +" PUAN");

        TextView highScoreLevel2 = findViewById(R.id.highScoreLevel2);
        highScore = sharedPref.getInt("GAME_HIGHSCORE1", 0);
        highScoreLevel2.setText(highScore +" PUAN");

        TextView highScoreLevel3 = findViewById(R.id.highScoreLevel3);
        highScore = sharedPref.getInt("GAME_HIGHSCORE2", 0);
        highScoreLevel3.setText(highScore +" PUAN");

        TextView highScoreLevel4 = findViewById(R.id.highScoreLevel4);
        highScore = sharedPref.getInt("GAME_HIGHSCORE3", 0);
        highScoreLevel4.setText(highScore +" PUAN");

        TextView highScoreLevel5 = findViewById(R.id.highScoreLevel5);
        highScore = sharedPref.getInt("GAME_HIGHSCORE4", 0);
        highScoreLevel5.setText(highScore +" PUAN");

        TextView highScoreLevel6 = findViewById(R.id.highScoreLevel6);
        highScore = sharedPref.getInt("GAME_HIGHSCORE5", 0);
        highScoreLevel6.setText(highScore +" PUAN");

        TextView highScoreLevel7 = findViewById(R.id.highScoreLevel7);
        highScore = sharedPref.getInt("GAME_HIGHSCORE6", 0);
        highScoreLevel7.setText(highScore +" PUAN");

        TextView highScoreLevel8 = findViewById(R.id.highScoreLevel8);
        highScore = sharedPref.getInt("GAME_HIGHSCORE7", 0);
        highScoreLevel8.setText(highScore +" PUAN");

        TextView highScoreLevel9 = findViewById(R.id.highScoreLevel9);
        highScore = sharedPref.getInt("GAME_HIGHSCORE8", 0);
        highScoreLevel9.setText(highScore +" PUAN");

        TextView highScoreLevel10 = findViewById(R.id.highScoreLevel10);
        highScore = sharedPref.getInt("GAME_HIGHSCORE9", 0);
        highScoreLevel10.setText(highScore +" PUAN");

        TextView highScoreLevel11 = findViewById(R.id.highScoreLevel11);
        highScore = sharedPref.getInt("GAME_HIGHSCORE10", 0);
        highScoreLevel11.setText(highScore +" PUAN");

        TextView highScoreLevel12 = findViewById(R.id.highScoreLevel12);
        highScore = sharedPref.getInt("GAME_HIGHSCORE11", 0);
        highScoreLevel12.setText(highScore +" PUAN");

        TextView highScoreLevel13 = findViewById(R.id.highScoreLevel13);
        highScore = sharedPref.getInt("GAME_HIGHSCORE12", 0);
        highScoreLevel13.setText(highScore +" PUAN");

        TextView highScoreLevel14 = findViewById(R.id.highScoreLevel14);
        highScore = sharedPref.getInt("GAME_HIGHSCORE13", 0);
        highScoreLevel14.setText(highScore +" PUAN");

        TextView highScoreLevel15 = findViewById(R.id.highScoreLevel15);
        highScore = sharedPref.getInt("GAME_HIGHSCORE14", 0);
        highScoreLevel15.setText(highScore +" PUAN");

        TextView highScoreLevel16 = findViewById(R.id.highScoreLevel16);
        highScore = sharedPref.getInt("GAME_HIGHSCORE15", 0);
        highScoreLevel16.setText(highScore +" PUAN");

        TextView highScoreLevel17 = findViewById(R.id.highScoreLevel17);
        highScore = sharedPref.getInt("GAME_HIGHSCORE16", 0);
        highScoreLevel17.setText(highScore +" PUAN");

        TextView highScoreLevel18 = findViewById(R.id.highScoreLevel18);
        highScore = sharedPref.getInt("GAME_HIGHSCORE17", 0);
        highScoreLevel18.setText(highScore +" PUAN");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
