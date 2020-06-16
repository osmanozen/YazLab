package com.kou.yazlab5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class LevelUpActivity extends AppCompatActivity {

    private int lvl, score, letterCounter, wrongCounter;
    private String date;
    private Date date2 = new Date();
    Animation animation2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        animation2 = AnimationUtils.loadAnimation(this, R.anim.animation2);
        ImageView successLogo = findViewById(R.id.successLogo);
        successLogo.startAnimation(animation2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            lvl = bundle.getInt("lvl");
            date = bundle.getString("date");
            letterCounter = bundle.getInt("letterCounter");
            wrongCounter = bundle.getInt("wrongCounter");
        }

        Level level = new Level(lvl-1);

        //TODO: EN SON OYNANAN LEVELI KAYIT EDER, EN UST LEVELI KAYDETMELI
        SharedPreferences sharedPref = getSharedPreferences("GAME_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("GAME_LEVEL",lvl);
        editor.apply();

        String time = Long.toString((date2.getTime()-Long.parseLong(date)*1000)/1000);
        TextView timeText = findViewById(R.id.timeText);
        timeText.setText(timeText.getText()+time+"SN");

        TextView letterCountText = findViewById(R.id.letterCountText);
        letterCountText.setText(letterCountText.getText()+Integer.toString(letterCounter));

        TextView scoreText = findViewById(R.id.scoreText);
        // score=startScoreLevel-time-wrongCounter*10
        score =level.getStartScoreLevel()-(int)(date2.getTime()-Long.parseLong(date)*1000)/1000-10*wrongCounter;
        if(score<0)  score=0;
        scoreText.setText(scoreText.getText()+Integer.toString(score));

        int highScore = sharedPref.getInt("GAME_HIGHSCORE"+(lvl-1), 0);
        if(score>highScore){
            editor.putInt("GAME_HIGHSCORE"+(lvl-1),score);
            editor.apply();
            highScore=score;
        }
        TextView highScoreText = findViewById(R.id.highScoreText);
        highScoreText.setText(highScoreText.getText()+Integer.toString(highScore));

        //TODO: SON LEVELDE OYUN SON BULMALI
        Button nextLevelBtn = findViewById(R.id.nextLevelBtn);
        nextLevelBtn.setOnClickListener(new View.OnClickListener() {
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

        Button replayBtn = findViewById(R.id.replayBtn);
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(lvl-1);
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

        Button homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
