/*
 * Created by JFormDesigner on Mon Oct 28 09:25:14 WIB 2019
 */

package GUI.GUIClasses;

import java.awt.event.*;
import javax.swing.*;

import Database.Database;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Dominic Henley
 */

public class RemoveClothes extends JFrame {

    public RemoveClothes() {
        initComponents();
        Database.comboBox();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        String clothes = removeClothesCB.getSelectedItem().toString();
        Database.deleteRecord(clothes);
        Database.displayData();
        removeClothesCB.removeAllItems();
        Database.comboBox();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        vSpacer1 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        choice = new JLabel();
        hSpacer2 = new JPanel(null);
        removeClothesCB = new JComboBox();
        okButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "10dlu, $lcgap, default, $lcgap, 10dlu, $lcgap, default",
            "3*(default, $lgap), default"));
        contentPane.add(vSpacer1, CC.xy(3, 1));
        contentPane.add(hSpacer1, CC.xy(1, 3));

        //---- choice ----
        choice.setText("Select which to delete from the database:");
        contentPane.add(choice, CC.xy(3, 3));
        contentPane.add(hSpacer2, CC.xy(5, 3));
        contentPane.add(removeClothesCB, CC.xy(3, 5));

        //---- okButton ----
        okButton.setText("OK");
        okButton.addActionListener(e -> okButtonActionPerformed(e));
        contentPane.add(okButton, CC.xy(3, 7));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel vSpacer1;
    private JPanel hSpacer1;
    private JLabel choice;
    private JPanel hSpacer2;
    public static JComboBox removeClothesCB;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
