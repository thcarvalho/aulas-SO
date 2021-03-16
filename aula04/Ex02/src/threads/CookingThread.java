package threads;

import java.text.Format;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class CookingThread extends Thread {
    private int threadID;
    private Semaphore semaphore;

    public CookingThread(int threadID, Semaphore semaphore) {
        this.threadID = threadID;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        startGame();
    }

    private void startGame() {
        int min;
        int max;

        if (threadID % 2 == 0) {
            min = 600;
            max = 1200;
        } else {
            min = 500;
            max = 800;
        }

        cook(min, max);

        try {
            semaphore.acquire();
            deliver();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void cook(int min, int max) {
        int random = new Random().nextInt(min) + max;
        for (int i = 1; i < random; i += 100) {
            try {
                double percentage = ((double) i /random) * 100;
                System.out.println("Thread #" + threadID + " está cozinhando o prato: " + String.format("%,.2f", percentage) + "% concluido");
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread #" + threadID + " concluiu o prato");
    }

    private void deliver() {
        try {
            System.out.println("Thread #" + threadID + " está fazendo a entrega");
            sleep(500);
            System.out.println("Thread #" + threadID + " concluiu a entrega");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
