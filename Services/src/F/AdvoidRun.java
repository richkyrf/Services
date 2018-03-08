/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import java.io.IOException;
import static java.lang.System.exit;
import java.net.BindException;
import static java.net.InetAddress.getLocalHost;
import java.net.ServerSocket;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class AdvoidRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(65535, 1, getLocalHost());
            showMessageDialog(null, "Hello World \n");
        } catch (BindException ex) {
            showMessageDialog(null, "Aplikasi Sudah Terbuka . . . \n");
            exit(0);
        } catch (IOException ex) {
            showMessageDialog(null, "Aplikasi Sudah Terbuka . . . \n");
            exit(0);
        }
    }

}
