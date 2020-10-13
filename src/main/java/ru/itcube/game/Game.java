package ru.itcube.game;

import java.util.Scanner;

public class Game {
    private int[][] field = new int[3][3];
    private int nextTurn = 1;

    public Game() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 0;
            }
        }
    }

    public boolean player1Turn() {
        return playerTurn(1);
    }

    public boolean player2Turn() {
        return playerTurn(2);
    }

    private boolean playerTurn(int player) {
        Scanner in = new Scanner(System.in);
        String coords = in.nextLine();
        if (coords.matches("\\d,\\d")) {
            int x = Integer.valueOf(coords.split(",")[0]);
            int y = Integer.valueOf(coords.split(",")[1]);
            if (x < 3 && x >= 0 && y < 3 && y >= 0) {
                field[x][y] = player;
                return true;
            }
            else {
                System.out.println("Вы ввели неверные координаты поля!");
                return false;
            }
        } else {
            System.out.println("Вы ввели неверные координаты поля!");
            return false;
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + format(field[i][j]));
            }
            System.out.println();
        }
    }

    private String format(int value) {
        if (value == 0) return "-";
        else if (value == 1) return "X";
        else return "O";
    }

    public int whoNext() {
        return nextTurn;
    }

    public void changeTurn() {
        if (nextTurn == 1) nextTurn = 2;
        else if (nextTurn == 2) nextTurn = 1;
    }

    public boolean player1Won() {
        return playerWon(1);
    }

    public boolean player2Won() {
        return playerWon(2);
    }

    private boolean playerWon(int player) {
        for (int i = 0; i < 3; i++) {
            if (lineAll(player, field[i])) return true;
        }
        for (int j = 0; j < 3; j++) {
            int[] col = new int[3];
            for (int i = 0; i < 3; i++) {
                col[i] = field[i][j];
            }
            if (lineAll(player, col)) return true;
        }
        int diag1[] = new int[3];
        for (int i = 0; i < 3; i++) {
            diag1[i] = field[i][i];
        }
        if (lineAll(player, diag1)) return true;

        int diag2[] = new int[3];
        for (int i = 0; i < 3; i++) {
            diag2[i] = field[i][3 - i - 1];
        }
        if (lineAll(player, diag2)) return true;

        return false;
    }

    private boolean lineAll(int pattern, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != pattern) return false;
        }
        return true;
    }


}
