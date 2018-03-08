/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 *
 * @author JACK
 */
public class JackOptionpane {

    public static boolean jackop(String Pesan) {
        int reply = showConfirmDialog(null, Pesan, "konfirmasi", YES_NO_OPTION);
        return reply == YES_OPTION;
    }

    private JackOptionpane() {
    }
}
