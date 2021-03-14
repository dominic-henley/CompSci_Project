package GUI.Formatters;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/*
    Use this to limit user input to only alpha and whitespace (used in Type field to prevent unusual type names)
 */

public class MyDocumentFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int i, int o, String s, AttributeSet set) throws BadLocationException{
        for(int n = s.length(); n > 0; n--){
            char c = s.charAt(n - 1);
            if(Character.isAlphabetic(c) || c == ' '){
                super.replace(fb, i, o, String.valueOf(c), set);
            }else{
                JOptionPane.showMessageDialog(null, "Error: Type field must not contain numbers or symbols");
            }
        }
    }

    @Override
    public void remove(FilterBypass fb, int i, int o) throws  BadLocationException{
        super.remove(fb, i, o);
    }

    public void insertString(FilterBypass fb, int i, String s, AttributeSet set) throws BadLocationException{
        super.insertString(fb, i, s, set);
    }

}
