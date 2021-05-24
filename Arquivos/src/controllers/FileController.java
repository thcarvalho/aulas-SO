package controllers;

import java.io.*;

public class FileController implements IFileController {
    @Override
    public void read(String path, String name) throws IOException {
        File file = new File(path, name);
        if (!file.exists() || !file.isFile()) throw new IOException("Arquivo Inválido");
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();
        System.out.println("FOOD NAME, SCIENTIFIC NAME, SUBGROUP");
        while (line != null) {
            if (line.contains("Fruits")) {
                String[] infos = line.split(",");
                System.out.println(infos[0] + "\t" + infos[1] + "\t" + infos[3]);
            }
            line = buffer.readLine();
        }
    }
}
