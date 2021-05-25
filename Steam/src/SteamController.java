import java.io.*;

public class SteamController {
    public void read(String month, String year, double avg) throws IOException {
        File file = new File("C:\\TEMP", "SteamCharts.csv");
        if (!file.exists() || !file.isFile()) throw new IOException("Arquivo Inválido");

        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();

        while (line != null) {
            String[] infos = line.split(",");
            if (infos[1].equalsIgnoreCase(year) && infos[2].equalsIgnoreCase(month) && Double.parseDouble(infos[3]) >= avg) {
                System.out.println(infos[0] + " | " + infos[3]);
            }
            line = buffer.readLine();
        }

        inputStream.close();
        reader.close();
        buffer.close();
    }

    public void write(String month, String year, String path, String name) throws IOException {
        File filePath = new File(path);
        File file = new File(path, name);
        if (!filePath.isDirectory() || !filePath.exists()) throw new IOException("Diretório Inválido");

        boolean exists = file.exists();

        StringBuffer sb = new StringBuffer();
        File current = new File("C:\\TEMP", "SteamCharts.csv");
        FileInputStream inputStream = new FileInputStream(current);
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();
        while (line != null) {
            String[] infos = line.split(",");
            if (infos[1].equalsIgnoreCase(year) && infos[2].equalsIgnoreCase(month)) {
                sb.append(infos[0] + ";" + infos[3]+"\n");
            }
            line = buffer.readLine();
        }
        inputStream.close();
        reader.close();
        buffer.close();

        FileWriter writer = new FileWriter(file, exists);
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.write(sb.toString());
        printWriter.flush();
        writer.close();
    }

}

