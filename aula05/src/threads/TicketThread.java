package threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TicketThread extends Thread {
    private int threadId;
    private Semaphore semaphore;
    private static int tickets = 100;

    public TicketThread(int threadId, Semaphore semaphore) {
        this.threadId = threadId;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        login();
    }

    private void login() {
        System.out.println("#" + threadId + ": Em login");
        int randomMs = new Random().nextInt((2000 - 50) + 1) + 50;

        try {
            sleep(randomMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (randomMs > 1000) {
            System.out.println("#" + threadId + ": Tempo de login esgotado");
        } else {
            buy();
        }
    }

    private void buy() {
        System.out.println("#" + threadId + ": Em compra");
        int randomMs = new Random().nextInt((3000 - 1000) + 1) + 1000;

        try {
            sleep(randomMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (randomMs > 2500) {
            System.out.println("#" + threadId + ": Tempo de compra esgotado");
        } else {
            try {
                semaphore.acquire();
                validate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    private void validate() {
        System.out.println("#" + threadId + ": Em validação");
        int ticketsToBuy = new Random().nextInt(4) + 1;
        if (ticketsToBuy > tickets) {
            System.out.println("#" + threadId + ": Falha ao comprar ingressos => Comprando mais que em estoque");
        } else {
            tickets = tickets - ticketsToBuy;
            System.out.println("#" + threadId + ": Comprou " + ticketsToBuy + " e ainda restam " + tickets + " ingressos");
        }
    }
}
