package jdbc;

import java.sql.*;

public class ConnectionDB{

    private static ConnectionDB instance;
    private String url="jdbc:mysql://localhost:3306/Monitors?serverTimezone=UTC";
    private String login="root";
    private String pass="Rocstar256157";

    private ConnectionDB(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new ConnectionDB();
            System.out.println(" Connection  - - - - - - - -  New DBConnection created");
        }
        try {
            return DriverManager.getConnection(instance.url, instance.login,instance.pass);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void close(Connection connection)
    {
        try {
            if (connection != null) {
                connection.close();
                connection=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
//
//public class ConnectionDB {
//
//    static ConnectionDB _instance = null;
//    private Connection connection;
//
//    private ConnectionDB(){
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors?serverTimezone=UTC","root","Rocstar256157");
//        }
//        catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ConnectionDB getInstance() {
//
//        if (_instance == null){
//            _instance = new ConnectionDB();
//        }
//
//        return _instance;
//    }
//
//    public static Connection getConnection() {
//        return _instance.connection;
//    }
//
//    public static void close(Connection connection){
//        try {
//            if (connection != null) {
//                connection.close();
//                connection=null;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
