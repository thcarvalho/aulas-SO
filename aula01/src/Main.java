public class Main {
    public static void main(String[] args) {
//        double n1000 = checkForPerformance(1000);
//        double n10000 = checkForPerformance(10000);
        double n100000 = checkForPerformance(100000);
//        System.out.println(n1000);
//        System.out.println(n10000);
        System.out.println(n100000);
    }

    static double checkForPerformance(int n) {
        double initialTime = System.nanoTime();

        for (int i = 0; i < n; i++) {}

        double finalTime = System.nanoTime();
        double totalTime = finalTime - initialTime;
//        totalTime /= (Math.pow(10, 9));

        return totalTime;
    }
}
