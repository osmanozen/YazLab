package com.kou.yazlab5;

import java.util.ArrayList;

public class Crossword {

    private int boardSize;
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> unplacedWords = new ArrayList<>();

    public Crossword(String[] answers, int boardSize){

        for(String answer : answers){
            words.add(answer);
        }
        this.boardSize=boardSize;
        makeCrossword();
    }

    public String[][] makeCrossword() {

        String[][] board = new String[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                String blank = " ";
                board[i][j] = blank;
            }
        }

        addWords(board);
        addUnplacedWords(board);
        return board;
    }

    private void addFirstWord(String word, String[][] board) {
        int col = boardSize / 2 - word.length() / 2;
        int row = boardSize / 2;

        for (int x = col; x < word.length() + col; x++) {
            board[x][row] = Character.toString(word.charAt(x - col));
        }
    }

    private boolean checkVertical(String word, int row, int col, String[][] board) {
        int blankNumber = 0;

        if (word.length() + row > boardSize) {
            return false;
        }

        if (row < boardSize - word.length()) {
            if (!board[col][row + word.length()].equals(" ")) {
                return false;
            }
        }
        if (row > 0) {
            if (!board[col][row - 1].equals(" ")) {
                return false;
            }
        }

        for (int i = row; i < word.length() + row; i++) {
            if (i >= boardSize) {
                return false;
            }
            else {
                if (board[col][i].equals(" ")) {
                    if (col == 0) {
                        if (!board[col + 1][i].equals(" ")) {
                            return false;
                        }
                    }
                    if (col == boardSize - 1) {
                        if (!board[col - 1][i].equals(" ")) {
                            return false;
                        }
                    }
                    else {
                        if (!board[col + 1][i].equals(" ") || !board[col][i].equals(" ")) {
                            return false;
                        }
                        else {
                            blankNumber++;
                        }
                    }
                }
                else {
                    if (!board[col][i].equals(Character.toString(word.charAt(i - row)))) {
                        return false;
                    }
                }
            }
        }
        return blankNumber < word.length();
    }

    private void addVertical(String word, String[][] board) {
        for (int col = 0; col < boardSize - 1; col++) {
            for (int row = 0; row < boardSize - word.length() + 1; row++) {
                if (checkVertical(word, row, col, board)) {
                    for (int i = row; i < word.length() + row; i++) {
                        board[col][i] = Character.toString(word.charAt(i - row));
                    }
                    return;
                }
            }
        }
        unplacedWords.add(word);
    }

    private boolean checkHorizontal(String word, int row, int col, String[][] board) {
        int blankNumber = 0;

        if (word.length() + col > boardSize) {
            return false;
        }
        if (col < boardSize - word.length()) {
            if (!board[col + word.length()][row].equals(" ")) {
                return false;
            }
        }
        if (col > 0) {
            if (!board[col - 1][row].equals(" ")) {
                return false;
            }
        }

        for (int i = col; i < word.length() + col; i++) {
            if (i >= boardSize) {
                return false;
            }
            else {
                if (board[i][row].equals(" ")) {
                    if (row == 0) {
                        if (!board[i][row + 1].equals(" ")) {
                            return false;
                        }
                    }
                    if (row == boardSize - 1) {
                        if (!board[i][row - 1].equals(" ")) {
                            return false;
                        }
                    }
                    else {
                        if (!board[i][row + 1].equals(" ") || !board[i][row].equals(" ")) {
                            return false;
                        }
                        else {
                            blankNumber++;
                        }
                    }
                }
                else {
                    if (!board[i][row].equals(Character.toString(word.charAt(i - col)))) {
                        return false;
                    }
                }
            }
        }
        return blankNumber < word.length();
    }

    private void addHorizontal(String word, String[][] board) {
        for (int row = 0; row < boardSize - 1; row++) {
            for (int col = 0; col < boardSize - word.length() + 1; col++) {
                if (checkHorizontal(word, row, col, board)) {
                    for (int i = col; i < word.length() + col; i++) {
                        board[i][row] = Character.toString(word.charAt(i - col));
                    }
                    return;
                }
            }
        }
        unplacedWords.add(word);
    }

    private void addWords(String[][] board) {
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                addFirstWord(words.get(i), board);
            }
            if (i != 0 && i % 2 == 0) {
                addHorizontal(words.get(i), board);
            }
            if (i % 2 != 0) {
                addVertical(words.get(i), board);
            }
        }
    }

    private void addUnplacedWords(String[][] board) {

        for (String word : unplacedWords) {
            boolean test = true;

            for (int row = 0; row < boardSize - word.length() + 1; row++) {
                for (int col = 0; col < boardSize - 1; col++) {
                    if (checkVertical(word, row, col, board) && test) {
                        for (int i = row; i < word.length() + row; i++) {
                            board[col][i] = Character.toString(word.charAt(i - row));
                        }
                        unplacedWords.remove(word);
                        test = false;
                        break;
                    }
                }
            }

            for (int row = 0; row < boardSize - 1; row++) {
                for (int col = 0; col < boardSize - word.length() + 1; col++) {
                    if (checkHorizontal(word, row, col, board) && test) {
                        for (int i = col; i < word.length() + col; i++) {
                            board[i][row] = Character.toString(word.charAt(i - col));
                        }
                        unplacedWords.remove(word);
                        test = false;
                        break;
                    }
                }
            }
        }
    }
}
