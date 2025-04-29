package Jdbc;
import java.sql.*;

public class JdbcConn {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String password = "113010";
        String sql = "select * from students";

        // Load and register PostgreSQL driver
       // Class.forName("org.postgresql.Driver");

        // Create connection
        Connection conn = DriverManager.getConnection(url, uname, password);
        System.out.println("connection established");
        //create statement
        Statement st = conn.createStatement();

        //execute statement
        ResultSet rs =  st.executeQuery(sql);
        // rs.next();
        // String name =rs.getString("sname");
        // System.out.println("Name of a student is " + name);

        //fetching all records
        while(rs.next()){
            System.out.print(rs.getInt(1) + "-");
            System.out.print(rs.getString(2) + "-");
            System.out.println(rs.getInt(3));
        }

        // Close connection
        conn.close();

        System.out.println("connection closed");
    }
}
