package Proses.XSPB;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main extends JFrame implements KeyListener {

    JComboBox<String> combobox = new JComboBox(new String[]{"a", "b", "c"});

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        combobox.setEditable(true);
        JTextField editor = (JTextField) combobox.getEditor().getEditorComponent();
        editor.addKeyListener(this);
        setLayout(new FlowLayout());
        add(combobox);
        pack();
        setVisible(true);
    }

    public void keyTyped(KeyEvent arg0) {
        System.out.println("Key Typed " + arg0.getKeyCode());
    }

    public void keyPressed(KeyEvent arg0) {
        System.out.println("Key Pressed " + arg0.getKeyCode());
    }

    public void keyReleased(KeyEvent arg0) {
        System.out.println("Key Released " + arg0.getKeyCode());
    }
}
