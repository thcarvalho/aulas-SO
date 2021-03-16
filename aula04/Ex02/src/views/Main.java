package views;

import threads.CookingThread;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int permitions = 1;
        Semaphore semaphore = new Semaphore(permitions);

        for (int i = 1; i <= 5; i++) {
            Thread thread = new CookingThread(i, semaphore);
            thread.start();
        }
    }
}
