package F;

import static F.JNumberTextField.DEF_PRECISION;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JNumberFieldFilter
        extends PlainDocument {

    private final JNumberTextField outer;

    JNumberFieldFilter(JNumberTextField outer) {
        this.outer = outer;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        String text = getText(0, offset) + str + getText(offset, getLength() - offset);
        if ((str == null) || (text == null)) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((this.outer.allowedChars + this.outer.negativeChars).indexOf(str.charAt(i)) == -1) {
                return;
            }
        }
        int precisionLength = 0;
        int dotLength = 0;
        int minusLength = 0;
        int textLength = text.length();
        try {
            Long aLong;
            Double aDouble;
            if ((!text.equals(this.outer.negativeChars)) || (text.length() != 1)) {
                aDouble = new Double(text);
            }
            int dotIndex = text.indexOf('.');
            if (dotIndex != -1) {
                dotLength = 1;
                precisionLength = textLength - dotIndex - dotLength;
                if (precisionLength > DEF_PRECISION) {
                    return;
                }
            }
        } catch (NumberFormatException ex) {
            return;
        }
        if (text.startsWith("-")) {
            if (!this.outer.allowNegative) {
                return;
            }
            minusLength = 1;
        }
        if (this.outer.maxLength < textLength - dotLength - precisionLength - minusLength) {
            return;
        }
        super.insertString(offset, str, attr);
    }
}
