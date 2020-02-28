package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/java2c1";
        String user = "root";
        String password = "";

        // ALT + ENTER
        Connection con = DriverManager.getConnection(url, user, password); // CTRL + P

        String sql = "INSERT INTO angajat VALUES (null, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, "gigel");
        stmt.setInt(2, 25);

        stmt.executeUpdate();
    }
}
