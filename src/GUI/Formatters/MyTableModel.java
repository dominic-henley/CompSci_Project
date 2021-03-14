package GUI.Formatters;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

    public MyTableModel(String[] colNames, int rowCount){
        super(colNames,rowCount);
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }
}

