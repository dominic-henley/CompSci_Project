package GUI.GUIClasses;

import Database.Database;
import GUI.Formatters.CurrencyRenderer;
import GUI.Formatters.MyDecimalFormatter;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/*
 * Created by JFormDesigner on Mon Oct 14 09:29:28 WIB 2019
 */

/**
 * @author Dominic Henley
 */

public class MainPanel extends JFrame {

    /*
    *   Do not delete System.out.println method calls -----> Used for debugging purposes
    */

    public MainPanel() {
        initComponents();
        clothesTable.setModel(Database.tableModel);
        clothesTable.getColumnModel().getColumn(2).setCellRenderer(new MyDecimalFormatter());
        clothesTable.getColumnModel().getColumn(3).setCellRenderer(new CurrencyRenderer());
        clothesTable.getTableHeader().setReorderingAllowed(false);
        clothesTable.setAutoCreateRowSorter(true);
    }

    private void addClothesActionPerformed(ActionEvent e) {
        AddClothes add = new AddClothes();
        add.setVisible(true);
        add.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println("Opening add clothes window...");
    }

    private void removeClothesActionListener(ActionEvent e) {
        RemoveClothes remove = new RemoveClothes();
        remove.setVisible(true);
        remove.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println("Opening remove clothes window...");
    }

    private void viewFinanceEventHandler(ActionEvent e) {
        FinanceFrame finance = new FinanceFrame();
        finance.setVisible(true);
        finance.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        finance.displayRevenue();
        System.out.println("Opening finance window...");
    }

    private void editButtonActionPerformed(ActionEvent e) {
        EditClothes edit = new EditClothes();
        edit.setVisible(true);
        edit.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println("Opening edit window...");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        clothesMenuBar = new JMenuBar();
        clothesMenu = new JMenu();
        addClothes = new JMenuItem();
        removeClothes = new JMenuItem();
        financeMenuBar = new JMenu();
        viewFinance = new JMenuItem();
        scrollPane1 = new JScrollPane();
        clothesTable = new JTable();
        editButton = new JButton();

        //======== this ========
        setTitle("Lealo Database");
        setResizable(false);
        var contentPane = getContentPane();

        //======== clothesMenuBar ========
        {

            //======== clothesMenu ========
            {
                clothesMenu.setText("Clothes");

                //---- addClothes ----
                addClothes.setText("Add...");
                addClothes.addActionListener(e -> addClothesActionPerformed(e));
                clothesMenu.add(addClothes);

                //---- removeClothes ----
                removeClothes.setText("Remove...");
                removeClothes.addActionListener(e -> removeClothesActionListener(e));
                clothesMenu.add(removeClothes);
            }
            clothesMenuBar.add(clothesMenu);

            //======== financeMenuBar ========
            {
                financeMenuBar.setText("Finance");

                //---- viewFinance ----
                viewFinance.setText("View Estimated Revenue...");
                viewFinance.addActionListener(e -> viewFinanceEventHandler(e));
                financeMenuBar.add(viewFinance);
            }
            clothesMenuBar.add(financeMenuBar);
        }
        setJMenuBar(clothesMenuBar);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(clothesTable);
        }

        //---- editButton ----
        editButton.setText("Edit...");
        editButton.addActionListener(e -> editButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(editButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(editButton)
                    .addContainerGap(368, Short.MAX_VALUE))
        );
        setSize(545, 450);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar clothesMenuBar;
    private JMenu clothesMenu;
    private JMenuItem addClothes;
    private JMenuItem removeClothes;
    private JMenu financeMenuBar;
    private JMenuItem viewFinance;
    private JScrollPane scrollPane1;
    public static JTable clothesTable;
    private JButton editButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
