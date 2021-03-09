package views;

import threads.ThreadExample;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new ThreadExample(i);
            thread.start();
        }
    }
}
