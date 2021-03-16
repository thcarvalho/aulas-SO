package views;

import threads.BDThread;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int permitions = 1;
        Semaphore semaphore = new Semaphore(permitions);

        for (int i = 1; i <= 21; i++) {
            Thread thread = new BDThread(i, semaphore);
            thread.start();
        }
    }
}
