package views;

import threads.TicketThread;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int permitions = 1;
        Semaphore semaphore = new Semaphore(permitions);

        for (int i = 0; i < 300; i++) {
            Thread thread = new TicketThread(i, semaphore);
            thread.start();
        }
    }
}
