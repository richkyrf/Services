package F;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.out;
import javax.swing.JTextField;

public class RibuanTextField extends JTextField {

    private char separator = ',';
    private int maxlimit = 2147483647;
    private final int minlimit = -2147483647;
    private boolean allownegative = false;

    public RibuanTextField() {
        setHorizontalAlignment(4);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                selectAll();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != '\b') && (c != '')) {
                    getToolkit().beep();
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setText(formatNumber(getText().replace(",", "").replace(".", "")));
            }
        });
    }

    public void setAllowNegative(boolean b) {
        allownegative = b;
    }

    public void setSeparator(char s) {
        separator = s;
    }

    public void setmaxnum(int max) {
        maxlimit = max;
    }

    public void setmin(int min) {
        maxlimit = min;
    }

    public void setInt(int s) {
        setText(formatNumber(Integer.toString(s)));
    }

    public Integer getInt() {
        String s = getText();
        if (s.isEmpty()) {
            s = "0";
        }
        return parseInt(s.replace(",", "").replace(".", ""));
    }

    public String getNumberFormattedText() {
        return getText();
    }

    public String formatNumber(String s) {
        try {
            int v = parseInt(s);
            if (v < -2147483647) {
                v = -2147483647;
            }
            if (v >= maxlimit) {
                v = maxlimit;
            }
            return format("%,d", new Object[]{v}).replace(",", separator + "").replace(".", separator + "");
        } catch (Exception e) {
            out.println("E31" + e);
        }
        return "0";
    }
}
