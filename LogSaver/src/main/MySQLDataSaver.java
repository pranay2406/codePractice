package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MySQLDataSaver {

    public static void main(String[] args) {
        // Data to be inserted into the database
        String aValue = "name";
        String bValue = "data";
        LocalDate date = LocalDate.now();

        // Call the function to save data in the database
        saveDataToDatabase(aValue, bValue, date);
    }

    // Function to save data to the MySQL database
    public static void saveDataToDatabase(String a, String b, LocalDate c) {
        // Database connection details
        String dbUrl = "jdbc:mysql://localhost:3306/Demo"; // Replace with your database URL
        String dbUser = "root"; // Replace with your database user
        String dbPassword = "123Welcome"; // Replace with your database password

        // SQL query to insert data
        String insertSQL = "INSERT INTO econnector_daily_logsys_config (filename, filecontent, createdate) VALUES (?, ?, ?)";

        // Establishing a database connection and inserting data
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Set the values for the columns a, b, and c
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c.toString());

            // Execute the insert statement
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
