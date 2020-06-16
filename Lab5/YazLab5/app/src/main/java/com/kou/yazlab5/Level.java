package com.kou.yazlab5;

import java.util.ArrayList;

public class Level {

    private final int maxLevel = 18, maxLetters = 5, maxAnswers = 6;
    private final String[] levelName = new String[maxLevel];
    private final int[] maxPress = new int[maxLevel];
    private final ArrayList<Object> levelLetters = new ArrayList<>(maxLetters);
    private final ArrayList<Object> levelAnswers = new ArrayList<>(maxAnswers);
    private int[] startScoreLevel = new int[maxLevel];
    private int level;

    public Level(int level){

        this.level=level;
        defaultLevels();
    }

    public void defaultLevels(){

        String[] letters, answers;

        levelName[0]="LEVEL 1";
        letters = new String[] {"K","O","Ü"};
        levelLetters.add(letters);
        answers = new String[] {"KOÜ"};
        levelAnswers.add(answers);
        maxPress[0]=3;
        startScoreLevel[0]=100;

        levelName[1]="LEVEL 2";
        letters = new String[] {"S","E","V"};
        levelLetters.add(letters);
        answers = new String[] {"SEV","EV"};
        levelAnswers.add(answers);
        maxPress[1]=3;
        startScoreLevel[1]=100;

        levelName[2]="LEVEL 3";
        letters = new String[] {"T","A","M"};
        levelLetters.add(letters);
        answers = new String[] {"TAM","MAT"};
        levelAnswers.add(answers);
        maxPress[2]=3;
        startScoreLevel[2]=100;

        levelName[3]="LEVEL 4";
        letters = new String[] {"M","A","Ç"};
        levelLetters.add(letters);
        answers = new String[] {"MAÇ","ÇAM", "AÇ"};
        levelAnswers.add(answers);
        maxPress[3]=3;
        startScoreLevel[3]=100;

        levelName[4]="LEVEL 5";
        letters = new String[] {"A","Ş","K"};
        levelLetters.add(letters);
        answers = new String[] {"AŞK","KAŞ","AŞ","AK"};
        levelAnswers.add(answers);
        maxPress[4]=3;
        startScoreLevel[4]=100;

        levelName[5]="LEVEL 6";
        letters = new String[] {"Y","A","T"};
        levelLetters.add(letters);
        answers = new String[] {"AT","YAT","AY","TAY"};
        levelAnswers.add(answers);
        maxPress[5]=3;
        startScoreLevel[5]=100;

        levelName[6]="LEVEL 7";
        letters = new String[] {"N","E","Ş","E"};
        levelLetters.add(letters);
        answers = new String[] {"NEŞE","ŞEN"};
        levelAnswers.add(answers);
        maxPress[6]=4;
        startScoreLevel[6]=200;

        levelName[7]="LEVEL 8";
        letters = new String[] {"R","Ü","Y","A"};
        levelLetters.add(letters);
        answers = new String[] {"RÜYA","RAY","YAR"};
        levelAnswers.add(answers);
        maxPress[7]=4;
        startScoreLevel[7]=200;

        levelName[8]="LEVEL 9";
        letters = new String[] {"Ö","Y","K","Ü"};
        levelLetters.add(letters);
        answers = new String[] {"ÖYKÜ","KÖY","YÜK"};
        levelAnswers.add(answers);
        maxPress[8]=4;
        startScoreLevel[8]=200;

        levelName[9]="LEVEL 10";
        letters = new String[] {"E","K","İ","P"};
        levelLetters.add(letters);
        answers = new String[] {"EKİP","PEKİ","PİKE","EPİK"};
        levelAnswers.add(answers);
        maxPress[9]=4;
        startScoreLevel[9]=200;

        levelName[10]="LEVEL 11";
        letters = new String[] {"A","T","K","I"};
        levelLetters.add(letters);
        answers = new String[] {"ATKI","KITA","TAKI","KATI","ATIK"};
        levelAnswers.add(answers);
        maxPress[10]=4;
        startScoreLevel[10]=200;

        levelName[11]="LEVEL 12";
        letters = new String[] {"S","I","R","A"};
        levelLetters.add(letters);
        answers = new String[] {"SIRA","ASIR","SARI","SIR","ARI"};
        levelAnswers.add(answers);
        maxPress[11]=4;
        startScoreLevel[11]=200;

        levelName[12]="LEVEL 13";
        letters = new String[] {"K","A","R","Ş","I"};
        levelLetters.add(letters);
        answers = new String[] {"KARŞI","KAŞ","AŞI","ŞARKI","ŞIK"};
        levelAnswers.add(answers);
        maxPress[12]=5;
        startScoreLevel[12]=300;

        levelName[13]="LEVEL 14";
        letters = new String[] {"H","E","L","V","A"};
        levelLetters.add(letters);
        answers = new String[] {"HELVA","VALE","ALEV","ELA","LEVHA"};
        levelAnswers.add(answers);
        maxPress[13]=5;
        startScoreLevel[13]=300;

        levelName[14]="LEVEL 15";
        letters = new String[] {"T","A","N","I","M"};
        levelLetters.add(letters);
        answers = new String[] {"TANIM","TAM","TANI","ANT","MANTI","ANI"};
        levelAnswers.add(answers);
        maxPress[14]=5;
        startScoreLevel[14]=300;

        levelName[15]="LEVEL 16";
        letters = new String[] {"M","A","S","A","L"};
        levelLetters.add(letters);
        answers = new String[] {"MASAL","LAMA","SAL","SALAM","MASA","ASAL"};
        levelAnswers.add(answers);
        maxPress[15]=5;
        startScoreLevel[15]=300;

        levelName[16]="LEVEL 17";
        letters = new String[] {"R","O","M","A","N"};
        levelLetters.add(letters);
        answers = new String[] {"ROMAN","ROMA","ORAN","NAR","MOR","ORMAN"};
        levelAnswers.add(answers);
        maxPress[16]=5;
        startScoreLevel[16]=300;

        levelName[17]="LEVEL 18";
        letters = new String[] {"S","E","L","A","M"};
        levelLetters.add(letters);
        answers = new String[] {"SELAM","SELMA","ELMAS","SELA","SAL","ELA","ELMA"};
        levelAnswers.add(answers);
        maxPress[17]=5;
        startScoreLevel[17]=300;
    }

    public String getLevelName() {
        return levelName[level];
    }

    public String[] getLevelLetters() {
        return (String[]) levelLetters.get(level);
    }

    public String[] getlevelAnswers() {
        return (String[]) levelAnswers.get(level);
    }

    public int getMaxPress() {
        return maxPress[level];
    }

    public int getStartScoreLevel() {
        return startScoreLevel[level];
    }
}
