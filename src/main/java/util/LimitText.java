package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitText extends PlainDocument {

    private int limite;

    public LimitText(int limite) {
        this.limite = limite;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {

        if (str == null) return;

        if((getLength() + str.length()) <= limite) {
            super.insertString(offset, str, a);
        }
    }
}
