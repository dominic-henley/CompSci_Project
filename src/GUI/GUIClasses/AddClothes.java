/*
 * Created by JFormDesigner on Wed Oct 16 20:47:05 WIB 2019
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

public class AddClothes extends JFrame {

    public AddClothes() {
        initComponents();
        ((AbstractDocument)typeField.getDocument()).setDocumentFilter(new MyDocumentFilter());
    }

    private void addButtonActionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            int size = Integer.parseInt(sizeField.getText());
            double price = Double.parseDouble(priceField.getText());
            int stock = Integer.parseInt(stockField.getText());
            String type = typeField.getText();
            Database.addRecord(name, size, price, stock, type);

        }catch(NumberFormatException ex){

            ex.printStackTrace();

        }finally{

            nameField.setText(null);
            sizeField.setText(null);
            priceField.setText(null);
            stockField.setText(null);

            /*
             *   There is a bug in Java that makes a field with a Document Filter attached to it
             *   throw NPE when .setText(null) is called on it. As a compromise, .setText(" ") is called instead
             *   as there seems to be no fix as of yet
             */

            typeField.setText(" ");
            Database.displayData();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        hSpacer3 = new JPanel(null);
        label1 = new JLabel();
        nameField = new JTextField();
        hSpacer2 = new JPanel(null);
        label2 = new JLabel();
        sizeField = new JTextField();
        label3 = new JLabel();
        priceField = new JTextField();
        label4 = new JLabel();
        stockField = new JTextField();
        label5 = new JLabel();
        typeField = new JTextField();
        addButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "10dlu, $lcgap, default, $lcgap, 56dlu, $lcgap, 10dlu",
            "5*(default, $lgap), default"));
        contentPane.add(hSpacer3, CC.xy(1, 1));

        //---- label1 ----
        label1.setText("Name:");
        contentPane.add(label1, CC.xy(3, 1));
        contentPane.add(nameField, CC.xy(5, 1));
        contentPane.add(hSpacer2, CC.xy(7, 1));

        //---- label2 ----
        label2.setText("Size:");
        contentPane.add(label2, CC.xy(3, 3));
        contentPane.add(sizeField, CC.xy(5, 3));

        //---- label3 ----
        label3.setText("Price:");
        contentPane.add(label3, CC.xy(3, 5));
        contentPane.add(priceField, CC.xy(5, 5));

        //---- label4 ----
        label4.setText("Stock:");
        contentPane.add(label4, CC.xy(3, 7));
        contentPane.add(stockField, CC.xy(5, 7));

        //---- label5 ----
        label5.setText("Type:");
        contentPane.add(label5, CC.xy(3, 9));
        contentPane.add(typeField, CC.xy(5, 9));

        //---- addButton ----
        addButton.setText("Add...");
        addButton.addActionListener(e -> addButtonActionPerformed(e));
        contentPane.add(addButton, CC.xy(5, 11));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel hSpacer3;
    private JLabel label1;
    private JTextField nameField;
    private JPanel hSpacer2;
    private JLabel label2;
    private JTextField sizeField;
    private JLabel label3;
    private JTextField priceField;
    private JLabel label4;
    private JTextField stockField;
    private JLabel label5;
    private JTextField typeField;
    private JButton addButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
