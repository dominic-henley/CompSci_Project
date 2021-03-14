import Database.Database;
import GUI.GUIClasses.MainPanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new MainPanel();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //this function creates a Database object and displays it onto the JTable
        Database db = new Database();
        Database.displayData();
    }
}