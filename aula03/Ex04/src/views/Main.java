package views;

import threads.FrogThread;

public class Main {
    public static void main(String[] args) {
        int maxJumpMeters = 7;
        int totalMeters = 25;


        for (int i = 0; i < 5; i++) {
            Thread frog = new FrogThread(i, maxJumpMeters, totalMeters);
            frog.start();
        }
    }
}
