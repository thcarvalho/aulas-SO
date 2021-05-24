import controllers.FileController;
import controllers.IFileController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\TEMP";
        String name = "generic_food.csv";
        IFileController fileController = new FileController();
        try {
            fileController.read(path, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
