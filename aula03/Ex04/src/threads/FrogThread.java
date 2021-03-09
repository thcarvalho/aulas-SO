package threads;

import java.util.Random;

public class FrogThread extends Thread {
    private int ID;
    private int maxJumpMeters;
    private int totalMeters;

    public FrogThread(int ID, int maxJumpMeters, int totalMeters) {
        this.ID = ID;
        this.maxJumpMeters = maxJumpMeters;
        this.totalMeters = totalMeters;
    }

    @Override
    public void run() {
        startRace();
    }

    private void startRace() {
        int totalFrogJumps = 0;

        do {
            totalFrogJumps += jump();
            System.out.println("Sapo #" + ID + " percorreu " + totalFrogJumps + " metros");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (totalFrogJumps < totalMeters);

        System.out.println("Sapo #" + ID + " teminou!");
//        result();
    }

    private int jump() {
        int jump = new Random().nextInt(maxJumpMeters);
        System.out.println("Sapo #" + ID + " saltou " + jump + " metros");
        return jump;
    }

//    private void result() {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("Sapo "+ID+"\n");
//        System.out.println(buffer);
//    }
}
