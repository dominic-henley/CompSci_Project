package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    private static String urlUnix = "jdbc:h2:~/Lealo";
    private static String driver = "org.h2.Driver";

    public static Connection getConnection(){

        try{
            Class.forName(driver);
            if(System.getProperty("os.name").startsWith("Windows")){
                connection = DriverManager.getConnection("jdbc:h2:" + System.getProperty("user.home") + "/Lealo");
            }else{
                connection = DriverManager.getConnection(urlUnix);
            }

        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }

}
