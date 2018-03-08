/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author JACK
 */
public class JKTextfield extends JTextField {

    int MaxText = 50;

    public JKTextfield() {
        setText("");
        setFont(new java.awt.Font("Tahoma", 0, 14));
        setDisabledTextColor(new java.awt.Color(0, 51, 102));
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                setText(getText());
                selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                setText(getText());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (getText().length() >= MaxText) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    public void setmaxtText(int J) {
        MaxText = J;
    }

}
