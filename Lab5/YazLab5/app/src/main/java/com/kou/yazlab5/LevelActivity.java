package com.kou.yazlab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Button level1Btn = findViewById(R.id.level1Btn);
        level1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(0);
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

        Button level2Btn = findViewById(R.id.level2Btn);
        level2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(1);
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

        Button level3Btn = findViewById(R.id.level3Btn);
        level3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(2);
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

        Button level4Btn = findViewById(R.id.level4Btn);
        level4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(3);
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

        Button level5Btn = findViewById(R.id.level5Btn);
        level5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(4);
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

        Button level6Btn = findViewById(R.id.level6Btn);
        level6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(5);
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

        Button level7Btn = findViewById(R.id.level7Btn);
        level7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(6);
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

        Button level8Btn = findViewById(R.id.level8Btn);
        level8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(7);
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

        Button level9Btn = findViewById(R.id.level9Btn);
        level9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(8);
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

        Button level10Btn = findViewById(R.id.level10Btn);
        level10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(9);
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

        Button level11Btn = findViewById(R.id.level11Btn);
        level11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(10);
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

        Button level12Btn = findViewById(R.id.level12Btn);
        level12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(11);
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

        Button level13Btn = findViewById(R.id.level13Btn);
        level13Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(12);
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

        Button level14Btn = findViewById(R.id.level14Btn);
        level14Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(13);
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

        Button level15Btn = findViewById(R.id.level15Btn);
        level15Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(14);
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

        Button level16Btn = findViewById(R.id.level16Btn);
        level16Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(15);
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

        Button level17Btn = findViewById(R.id.level17Btn);
        level17Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(16);
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

        Button level18Btn = findViewById(R.id.level18Btn);
        level18Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                Level level = new Level(17);
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
