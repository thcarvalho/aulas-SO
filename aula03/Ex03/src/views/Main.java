package views;

import threads.ArrayThread;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(10) - 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            Thread thread = new ArrayThread(i, matrix[i]);
            thread.start();
        }
    }
}
