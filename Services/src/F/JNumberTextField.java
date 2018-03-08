package F;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import static java.lang.Float.parseFloat;
import static java.lang.String.valueOf;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JNumberTextField
        extends JTextField {

    static final char DOT = '.';
    static final char NEGATIVE = '-';
    private static final String BLANK = "";
    public static final int DEF_PRECISION = 2;
    public static final int DECIMAL = 3;
    public static final String FM_DECIMAL = "0123456789.";
    private static final long serialVersionUID = 1L;
    int maxLength = 0;
    String negativeChars = "";
    String allowedChars = null;
    boolean allowNegative = false;
    private PlainDocument numberFieldFilter;

    public JNumberTextField() {
        this(10);
        listen();
    }

    public JNumberTextField(int maxLen) {
        setAllowNegative(true);
        setMaxLength(maxLen);
        setFormat(3);
        this.numberFieldFilter = new JNumberFieldFilter(this);
        super.setDocument(this.numberFieldFilter);
        checkkosong();
        setHorizontalAlignment(4);
        listen();
    }

    void listen() {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                JNumberTextField.this.setText(JNumberTextField.this.getText());
                JNumberTextField.this.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                JNumberTextField.this.setText(JNumberTextField.this.getText());
                JNumberTextField.this.checkkosong();
            }
        });
    }

    private void setMaxLength(int maxLen) {
        if (maxLen > 0) {
            this.maxLength = maxLen;
        } else {
            this.maxLength = 0;
        }
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public float getFloat() {
        return parseFloat(getText());
    }

    public void setFloat(float value) {
        setText(valueOf(value));
    }   
    public float getInt() {
        return Integer.parseInt(getText());
    }

    public void setInt(float value) {
        setText(valueOf(value));
    }

    private void setFormat(int format) {
        this.allowedChars = "0123456789.";
    }

    private void setAllowNegative(boolean value) {
        this.allowNegative = value;
        if (value) {
            this.negativeChars = "-";
        } else {
            this.negativeChars = "";
        }
    }

    public boolean isAllowNegative() {
        return this.allowNegative;
    }

    @Override
    public void setDocument(Document document) {
    }

    PlainDocument getNumberFieldFilter() {
        return this.numberFieldFilter;
    }

    void setNumberFieldFilter(PlainDocument numberFieldFilter) {
        this.numberFieldFilter = numberFieldFilter;
    }

    public void checkkosong() {
        try {
            parseFloat(getText());
        } catch (Exception e) {
            setText("0");
        }
    }
}
