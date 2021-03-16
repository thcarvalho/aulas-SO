package threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BDThread extends Thread {
    private int threadID;
    private Semaphore semaphore;

    public BDThread(int threadID, Semaphore semaphore) {
        this.threadID = threadID;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        transact();
    }

    private void transact() {
        int transactNumber;
        int min;
        int max;
        int seconds;

        if (threadID % 3 == 1) {
            transactNumber = 2;
            min = 200;
            max = 1000;
            seconds = 1000;
        } else if (threadID % 3 == 2) {
            transactNumber = 3;
            min = 500;
            max = 1500;
            seconds = 1500;
        } else {
            transactNumber = 3;
            min = 1000;
            max = 2000;
            seconds = 1500;
        }

        for (int i = 0; i <= transactNumber; i++) {
            calculate(min, max);
            try {
                semaphore.acquire();
                transactBD(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    private void transactBD(int seconds) {
        try {
            System.out.println("Thread #" + threadID + " está usando o banco por " + (seconds) + "ms.");
            sleep(seconds);
            System.out.println("Thread #" + threadID + " parou de usar o banco");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void calculate(int min, int max) {
        int random = new Random().nextInt(min) + max;
        try {
            System.out.println("Thread #" + threadID + " está fazendo calculos por " + (random) + "ms.");
            sleep(random);
            System.out.println("Thread #" + threadID + " parou de calcular");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
