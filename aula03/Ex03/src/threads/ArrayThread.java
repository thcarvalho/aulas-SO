package threads;

import java.util.Arrays;

public class ArrayThread extends Thread{
    private int ID;
    private int[] array;

    public ArrayThread(int ID, int[] array) {
        this.ID = ID;
        this.array = array;
    }

    @Override
    public void run() {
        calculateArraySumA();
    }
    private void calculateArraySumA() {
        int sum = Arrays.stream(array).sum();
        System.out.println("Linha "+ID+": "+sum);
    }
}
