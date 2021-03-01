package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EthernetController {
  public void ip(String so) {
    String command;

    if (so == "Linux") {
      command = "ifconfig";
    } else {
      command = "ipconfig";
    }

    try {
      Process process = Runtime.getRuntime().exec(command);
      InputStream flux = process.getInputStream();
      InputStreamReader reader = new InputStreamReader(flux);
      BufferedReader buffer = new BufferedReader(reader);

      Object[] lines = buffer.lines().toArray();

      for (int i = 0; i < lines.length; i++) {
        if (lines[i].toString().contains("Adaptador")) {
          for (int j = i; j < lines.length; j++) {
            if (lines[j].toString().contains("IPv4")) {
              System.out.println(lines[i].toString());
              System.out.println(lines[j].toString());
              break;
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void ping(String so) {
    String command;

    if (so == "Linux") {
      command = "ping -4 -c 10 www.google.com.br";
    } else {
      command = "ping -4 -n 10 www.google.com.br";
    }

    try {
      Process process = Runtime.getRuntime().exec(command);
      InputStream flux = process.getInputStream();
      InputStreamReader reader = new InputStreamReader(flux);
      BufferedReader buffer = new BufferedReader(reader);

      Object[] lines = buffer.lines().toArray();
      String[] ms = lines[lines.length - 1].toString().split(",");

      System.out.println(ms[ms.length - 1]);



    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
