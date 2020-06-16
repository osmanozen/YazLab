package com.kou.yazlab5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class GameActivity extends AppCompatActivity {

    Animation animation1;
    EditText suggestText;
    TextView levelText;
    LinearLayout letterLayout, crosswordArea;
    Button shuffleBtn, addLetterBtn;
    private String level, regex, clue;
    private String[] letters, answers;
    private String[][] crossword;
    private int maxPress, pressCounter = 0, levelCounter=0, letterCounter=0, wrongCounter=0;
    private Date date = new Date();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        animation1 = AnimationUtils.loadAnimation(this, R.anim.animation1);
        suggestText = findViewById(R.id.suggestText);
        letterLayout = findViewById(R.id.letterLayout);
        crosswordArea = findViewById(R.id.crosswordArea);
        levelText = findViewById(R.id.levelText);
        shuffleBtn = findViewById(R.id.shuffleBtn);
        addLetterBtn = findViewById(R.id.addLetterBtn);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            level = bundle.getString("level");
            levelText.setText(level);
            letters = bundle.getStringArray("letters");
            answers = bundle.getStringArray("answers");
            maxPress = bundle.getInt("maxPress");
            crossword = (String[][]) bundle.getSerializable("crossword");
        }

        addCrossword();

        letters = shuffle(letters);
        for(String letter : letters){
            addView(letterLayout, letter, suggestText);
        }


        shuffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letters = shuffle(letters);
                letterLayout.removeAllViews();
                suggestText.setText("");
                for(String letter : letters){
                    addView(letterLayout, letter, suggestText);
                }
            }
        });

        //TODO: HARFLERIN YENILENMESI GEREKIYOR
        addLetterBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                regex = "^"+suggestText.getText().toString();
                letterCounter++;

                for (String answer : answers) {

                    if(suggestText.getText().toString().equals("") && !answer.equals(" ")){
                        suggestText.setText(Character.toString(answer.charAt(0)));
                        break;
                    }

                    if(!Pattern.compile(regex).matcher(answer).find() && !answer.equals(" ")){
                        suggestText.setText(Character.toString(answer.charAt(0)));
                        break;
                    }

                    if(Pattern.compile(regex).matcher(answer).find() && !suggestText.getText().toString().equals("")) {
                        clue = difference(suggestText.getText().toString(),answer);
                        suggestText.setText(suggestText.getText()+Character.toString(clue.charAt(0)));
                        doValidate();
                        break;
                    }
                }
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

    private void addCrossword(){
        for(int y=0;y<10;y++){
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(linearLayoutParams);

            for(int x=0;x<10;x++){
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        .1f
                );
                textView.setLayoutParams(textParams);
                textView.setBackground(this.getResources().getDrawable(R.drawable.border));
                textView.setTextColor(this.getResources().getColor(R.color.colorText));
                textView.setGravity(Gravity.CENTER);
                textView.setText(crossword[x][y]);
                textView.setTextSize(18);
                linearLayout.addView(textView);
            }
            crosswordArea.addView(linearLayout);
        }
    }

    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        linearLayoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.btn));
        textView.setTextColor(this.getResources().getColor(R.color.colorText));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);
        textView.setPadding(35,0,35,0);
        //TODO: FONT STYLE EKLE - TYPEFACE

        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(pressCounter < maxPress) {
                    if (pressCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(animation1);
                    textView.animate().alpha(0).setDuration(300);
                    textView.setClickable(false);
                    textView.setFocusable(false);
                    pressCounter++;
                    doValidate();
                }
            }
        });
        viewParent.addView(textView);
    }

    private void doValidate(){
        for(int i=0; i<answers.length; i++){
            if(suggestText.getText().toString().equals(answers[i])) {
                levelCounter++;
                answers[i]=" "; //logical error, fix: arraylist remove
                pressCounter = 0;
                suggestText.setText("");

                letterLayout.removeAllViews();

                for (String letter : letters) {
                    addView(letterLayout, letter, suggestText);
                }

                if(levelCounter!=answers.length){
                    Toast.makeText(GameActivity.this, "Buldun! Kalan Kelime: "+(answers.length-levelCounter), Toast.LENGTH_SHORT).show();
                }
            }
        }

        if(levelCounter==answers.length){
            Intent intent = new Intent(getApplicationContext(), LevelUpActivity.class);
            String[] lvl = level.split(" ");
            intent.putExtra("lvl", Integer.parseInt(lvl[1]));
            intent.putExtra("date", Long.toString((date.getTime()/1000)));
            intent.putExtra("letterCounter", letterCounter);
            intent.putExtra("wrongCounter", wrongCounter);
            startActivity(intent);
        }

        if(pressCounter == maxPress){
            pressCounter = 0;
            wrongCounter++;
            letterLayout.removeAllViews();
            for (String letter : letters) {
                addView(letterLayout, letter, suggestText);
            }
        }
    }

    private String[] shuffle(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    private String difference(String str1, String str2) {

        if(str1 == null) return str2;
        if(str2 == null) return str1;

        int at = indexOfDifference(str1, str2);
        if(at == -1) return "";

        return str2.substring(at);
    }

    private int indexOfDifference(String str1, String str2) {
        if (str1 == str2) {
            return -1;
        }
        if (str1 == null || str2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < str1.length() && i < str2.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        if (i < str2.length() || i < str1.length()) {
            return i;
        }
        return -1;
    }
}
