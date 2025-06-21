package Jdbc;

import java.sql.*;

public class JdbcConn {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        int sid = 101;
        String sname = "manu";
        int marks = 50;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String password = "113010";

        // Load and register PostgreSQL driver (optional for JDBC 4+ but recommended)
        Class.forName("org.postgresql.Driver");

        // Create connection
        Connection conn = DriverManager.getConnection(url, uname, password);
        System.out.println("Connection established");

        // Create statement
        Statement st = conn.createStatement();

        // Insert data
        String insertSQL = "INSERT INTO students (sid, sname, marks) VALUES (" + sid + ", '" + sname + "', " + marks + ")";
        st.executeUpdate(insertSQL); // use executeUpdate for insert/update/delete

        // Fetch data
        String fetchSQL = "SELECT * FROM students";
        ResultSet rs = st.executeQuery(fetchSQL);

        // Display records
        while (rs.next()) {
            System.out.print(rs.getInt("sid") + " - ");
            System.out.print(rs.getString("sname") + " - ");
            System.out.println(rs.getInt("marks"));
        }

        // Close connection
        conn.close();
        System.out.println("Connection closed");
    }
}
