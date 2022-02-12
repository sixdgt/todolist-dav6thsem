package dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    //    variable declaration starts here
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "localhost";
    private static final String DBNAME = "dav_todolist";
    private String url;
    private static Connection connect;
    private static Statement statement;
    private static final DbConnection INSTANCE = new DbConnection();
    
//    Database configuration configuring in the constructor
    public DbConnection(){
        url = "jdbc:mysql://" + HOST + ":3306/" + DBNAME;
        try {
//            Class.forName("com.mysql.jdbc.Driver"); depricate 
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static DbConnection getInstance(){
        return INSTANCE;
    }
    /** iud = InsertUpdateDelete
     * @param String query
     * this method is used to build query for insert update and delete
     * @return int
     * executeUpdate() method is used to build INSERT, DELETE
     * query in JDBC so that it would not do any impact on database table
    * */
    public static int iudQueryBuilder(String sql){
        try {
            statement = connect.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    /** executeQuery() method is used to build SELET query in JDBC so that 
     * it would not do any impact on database table
     * @param String query
     * @return Resultset
     * */
    public ResultSet selectQueryBuilder(String sql){
        try {
            statement = connect.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
