import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String month = "January";
        String year = "2014";
        double avg = 30000;
        SteamController steamController = new SteamController();
        try {
            steamController.read(month, year, avg);
            steamController.write(month, year, "C:\\TEMP", "Jan2014.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
