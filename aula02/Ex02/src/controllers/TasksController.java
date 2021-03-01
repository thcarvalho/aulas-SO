package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TasksController {
  public static String detectSO() {
    String SO = System.getProperty("os.name");
    return SO;
  }

  public static void listTasks(String so) {
    String command;
    if (so.contains("Windows")) {
      command = "TASKLIST /FO TABLE";
    } else {
      command = "ps -ef";
    }

    try {
      Process process = Runtime.getRuntime().exec(command);
      InputStream flux = process.getInputStream();
      InputStreamReader reader = new InputStreamReader(flux);
      BufferedReader buffer = new BufferedReader(reader);

      Object[] lines = buffer.lines().toArray();

      for (int i = 0; i < lines.length; i++) {
        System.out.println(lines[i]);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void killProcessByPID(String so, int PID) {
    String command;
    if (so.contains("Windows")) {
      command = "TASKKILL /PID " + PID;
    } else {
      command = "kill -9 " + PID;
    }

    try {
      Runtime.getRuntime().exec(command);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public static void killProcessByName(String so, String processName) {
    String command;
    if (so == "linux") {
      command = "pkill -f " + processName;
    } else {
      command = "TASKKILL /IM " + processName;
    }

    try {
      Runtime.getRuntime().exec(command);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
