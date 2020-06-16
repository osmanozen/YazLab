package com.kou.yazlab5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int lvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        SharedPreferences sharedPref = getSharedPreferences("GAME_DATA", MODE_PRIVATE);
        lvl = sharedPref.getInt("GAME_LEVEL", 0);

        Button continueBtn = findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(lvl);
                intent.putExtra("level", level.getLevelName());
                intent.putExtra("letters", level.getLevelLetters());
                intent.putExtra("answers", level.getlevelAnswers());
                intent.putExtra("maxPress", level.getMaxPress());
                Crossword crossword = new Crossword(level.getlevelAnswers(),10);
                Bundle b = new Bundle();
                b.putSerializable("crossword", crossword.makeCrossword());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        Button levelBtn = findViewById(R.id.levelBtn);
        levelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(intent);
            }
        });

        //TODO: HIGH SCORE SENARYOSU LOKAL TASARLANDI
        Button scoreboardBtn = findViewById(R.id.scoreboardBtn);
        scoreboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HighScoreActivity.class);
                startActivity(intent);
            }
        });
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
