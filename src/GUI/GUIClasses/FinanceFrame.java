/*
 * Created by JFormDesigner on Wed Oct 23 10:52:12 WIB 2019
 */

package GUI.GUIClasses;

import javax.swing.*;

import Database.Database;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import java.text.NumberFormat;

import static java.lang.Integer.valueOf;

/**
 * @author Dominic Henley
 */
public class FinanceFrame extends JFrame {

    private NumberFormat format = NumberFormat.getCurrencyInstance();

    public FinanceFrame() {
        initComponents();
    }

    protected void displayRevenue(){
        revenueText.setValue(format.format(Integer.valueOf(Database.showSum())));
        revenueText.setEditable(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        hSpacer1 = new JPanel(null);
        revenueLabel = new JLabel();
        revenueText = new JFormattedTextField();
        hSpacer2 = new JPanel(null);

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "[8dlu,default], $lcgap, default, $lcgap, 68dlu, $lcgap, [8dlu,default]",
            "17dlu"));
        contentPane.add(hSpacer1, CC.xy(1, 1));

        //---- revenueLabel ----
        revenueLabel.setText("Estimated Revenue:");
        contentPane.add(revenueLabel, CC.xy(3, 1));
        contentPane.add(revenueText, CC.xy(5, 1));
        contentPane.add(hSpacer2, CC.xy(7, 1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel hSpacer1;
    private JLabel revenueLabel;
    private JFormattedTextField revenueText;
    private JPanel hSpacer2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
