package views;

import threads.ArrayThread;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(1000) - 1;
        }

        Thread threadA = new ArrayThread(1, array);
        Thread threadB = new ArrayThread(2, array);

        threadA.start();
        threadB.start();
    }
}
