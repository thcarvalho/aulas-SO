package threads;

public class ThreadExample extends Thread {
    private int ID;

    public ThreadExample(int ID) {
        this.ID = ID;
    }

    @Override
    public void run() {
        System.out.println("TID: " + ID);
    }
}
