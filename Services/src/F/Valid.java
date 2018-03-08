/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import javax.swing.JTextField;

/**
 *
 * @author JACK
 */
public class Valid {

    private Valid() {
    }

    public boolean cekkosong(JTextField jt) {
        boolean b = false;
        if ("".equals(jt.getText())) {
            b = true;
        }
        return b;
    }

}
