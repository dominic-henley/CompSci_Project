package GUI.Formatters;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.NumberFormat;

public class CurrencyRenderer extends DefaultTableCellRenderer {

    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    //Formats JTable cell to display a currency (IDR format)
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        value = formatter.format(value);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
