package Database;

import GUI.Formatters.MyTableModel;
import GUI.GUIClasses.RemoveClothes;

import javax.swing.*;
import java.sql.*;

public class Database {

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;
    public static MyTableModel tableModel = new MyTableModel(new String[]{"ID", "Name", "Size", "Price", "Stock", "Type"}, 0);

    //gets connection
    public Database() {
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            initTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void initTable(){
        String sql = "CREATE TABLE CLOTHES_DATABASE" +
                     "(" +
                     "CLOTHES_NAME VARCHAR(255)," +
                     "CLOTHES_SIZE INT," +
                     "PRICE INT," +
                     "STOCK INT," +
                     "CLOTHES_TYPE VARCHAR(255)," +
                     "CLOTHES_ID INT AUTO_INCREMENT," +
                     "PRIMARY KEY (CLOTHES_ID)" +
                     ")";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        }catch(SQLException e){
            System.out.println("Table already exists...");
        }
    }

    //refreshes the database to account for updates
    //call .displayData() every time there is a change in database data
    public static void displayData() {
        tableModel.setRowCount(0);

        try {
            String sql = "SELECT * FROM CLOTHES_DATABASE";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int clothesID = rs.getInt("CLOTHES_ID");
                String clothesName = rs.getString("CLOTHES_NAME");
                double clothesSize = rs.getDouble("CLOTHES_SIZE");
                float clothesPrice = rs.getFloat("PRICE");
                int clothesStock = rs.getInt("STOCK");
                String clothesType = rs.getString("CLOTHES_TYPE");
                tableModel.addRow(new Object[]{clothesID, clothesName, clothesSize, clothesPrice, clothesStock, clothesType});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addRecord(String name, double size, double price, int stock, String type) {

        String sql = "INSERT INTO CLOTHES_DATABASE(CLOTHES_NAME, CLOTHES_SIZE, PRICE, STOCK, CLOTHES_TYPE) VALUES(?,?,?,?,?)";

        try{
            String check = "SELECT * FROM CLOTHES_DATABASE WHERE CLOTHES_NAME = ?";
            preparedStatement = connection.prepareStatement(check);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Error: record already exists!");
            } else{

                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setDouble(2, size);
                    preparedStatement.setDouble(3, price);
                    preparedStatement.setInt(4, stock);
                    preparedStatement.setString(5, type);
                    preparedStatement.execute();
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public static void editRecord(String name, double size, double price, int stock, String type) {

        String sql = "UPDATE CLOTHES_DATABASE SET CLOTHES_SIZE = ?, PRICE = ?, STOCK = ?, CLOTHES_TYPE = ? WHERE CLOTHES_NAME = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, size);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, stock);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, name);
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //sums up the data in the price column from CLOTHES_DATABASE and returns a String
    //returns String object because it is easier to format Strings than numbers
    public static String showSum() {

        var sum = 0;
        String sql = "SELECT SUM(PRICE * STOCK) FROM CLOTHES_DATABASE";

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int c = rs.getInt(1);
                sum += c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.toString(sum);
    }

    public static void comboBox() {

        String sql = "SELECT * FROM CLOTHES_DATABASE";

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("CLOTHES_NAME");
                RemoveClothes.removeClothesCB.addItem(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(String s){

        String sql = "DELETE FROM CLOTHES_DATABASE WHERE CLOTHES_NAME = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



