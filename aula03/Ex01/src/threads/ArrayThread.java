package threads;

public class ArrayThread extends Thread {
    private int threadID;
    private int[] array;

    public ArrayThread(int threadID, int[] array) {
        this.array = array;
        this.threadID = threadID;
    }

    @Override
    public void run() {
        checkForPerformance();
    }

    private void checkForPerformance() {
        double initialTime = System.nanoTime();

        if (threadID % 2 == 0) {
            for (int i = 0; i < array.length; i++) {
            }
        } else {
            for (int item : array) {
            }
        }

        double finalTime = System.nanoTime();
        double totalTime = finalTime - initialTime;
        totalTime /= (Math.pow(10, 9));
        System.out.println("TID #" + threadID + ": " + totalTime);
    }
}
