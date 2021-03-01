package views;

import controllers.EthernetController;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    EthernetController ethernetController = new EthernetController();
    String os = System.getProperty("os.name");

    while (opc != 9) {
      opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: " +
          "\n1 .Ip" +
          "\n2 .Ping" +
          "\n9. Sair"));

      switch (opc) {
        case 1:
          ethernetController.ip(os);
          break;
        case 2:
          ethernetController.ping(os);
          break;
        case 9:
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opção invalida");
          break;
      }
    }



  }
}
