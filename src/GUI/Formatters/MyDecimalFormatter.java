package GUI.Formatters;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;

public class MyDecimalFormatter extends DefaultTableCellRenderer {
    private static final DecimalFormat formatter = new DecimalFormat("#");

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        value = formatter.format((Number) value);

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}


