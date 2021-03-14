/*
 * Created by JFormDesigner on Tue Nov 05 13:16:47 WIB 2019
 */

package GUI.GUIClasses;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import Database.Database;
import GUI.Formatters.MyDocumentFilter;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Dominic Henley
 */

public class EditClothes extends JFrame {
    public EditClothes() {
        initComponents();

        int row = MainPanel.clothesTable.getSelectedRow();

        sizeField.setText(MainPanel.clothesTable.getValueAt(row, 2).toString());
        priceField.setText(MainPanel.clothesTable.getValueAt(row, 3).toString());
        stockField.setText(MainPanel.clothesTable.getValueAt(row, 4).toString());
        typeField.setText(MainPanel.clothesTable.getValueAt(row, 5).toString());
        ((AbstractDocument)typeField.getDocument()).setDocumentFilter(new MyDocumentFilter());
    }

    private void editButtonActionPerformed(ActionEvent e) {
        try{
            int row = MainPanel.clothesTable.getSelectedRow();
            String name = MainPanel.clothesTable.getValueAt(row, 1).toString();
            double size = Double.parseDouble(sizeField.getText());
            double price = Double.parseDouble(priceField.getText());
            int stock = Integer.parseInt(stockField.getText());
            String type = typeField.getText();

            Database.editRecord(name, size, price, stock, type);
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }finally{
            Database.displayData();
            this.dispose();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        hSpacer3 = new JPanel(null);
        label2 = new JLabel();
        sizeField = new JTextField();
        hSpacer2 = new JPanel(null);
        label3 = new JLabel();
        priceField = new JTextField();
        label4 = new JLabel();
        stockField = new JTextField();
        label5 = new JLabel();
        typeField = new JTextField();
        editButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "10dlu, $lcgap, default, $lcgap, 56dlu, $lcgap, 10dlu",
            "8*(default, $lgap), default"));
        contentPane.add(hSpacer3, CC.xy(1, 1));

        //---- label2 ----
        label2.setText("Size:");
        contentPane.add(label2, CC.xy(3, 1));
        contentPane.add(sizeField, CC.xy(5, 1));
        contentPane.add(hSpacer2, CC.xy(7, 1));

        //---- label3 ----
        label3.setText("Price:");
        contentPane.add(label3, CC.xy(3, 3));
        contentPane.add(priceField, CC.xy(5, 3));

        //---- label4 ----
        label4.setText("Stock:");
        contentPane.add(label4, CC.xy(3, 5));
        contentPane.add(stockField, CC.xy(5, 5));

        //---- label5 ----
        label5.setText("Type:");
        contentPane.add(label5, CC.xy(3, 7));
        contentPane.add(typeField, CC.xy(5, 7));

        //---- editButton ----
        editButton.setText("Edit...");
        editButton.addActionListener(e -> editButtonActionPerformed(e));
        contentPane.add(editButton, CC.xy(5, 9));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel hSpacer3;
    private JLabel label2;
    private JTextField sizeField;
    private JPanel hSpacer2;
    private JLabel label3;
    private JTextField priceField;
    private JLabel label4;
    private JTextField stockField;
    private JLabel label5;
    private JTextField typeField;
    private JButton editButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
