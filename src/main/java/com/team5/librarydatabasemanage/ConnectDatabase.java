package com.team5.librarydatabasemanage;

import static com.team5.librarydatabasemanage.views.login.LoginView.userStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */

public class ConnectDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection connection;
    public static Statement statement;

    public static void connectDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            System.out.println("connected");
            // insertData();
            // statement.close();
            // connection.close();
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
    }

    public static void insertDataLogin(long ID, String firstNamez, LocalDate Bdate, String Email, String Tel_no,
            String Address,
            char Sex) throws SQLException {

        String[] parts = firstNamez.split(" ");

        String firstName = parts[0];
        String lastName = (parts.length > 1) ? parts[1] : ""; // Check if the last name exists

        String insertQuery = "INSERT INTO `Student` (`Student_ID`, `Student_name`, `Student_surname`,`Address`, `B_date`, `E_mail`, `Tel_no`, `Sex`) VALUES ('"
                + ID + "','" + firstName + "','" + lastName + "','" + Address + "','" + Bdate + "','" + Email + "','"
                + Tel_no + "','" + "','"
                + Sex + "')";
        System.out.println("İnsort ediyom");
        statement.executeUpdate(insertQuery);
    }

    public static int searchUser(String id, String password) throws SQLException {
        String selectQuery = "SELECT `User_ID` FROM `Authentication_System` WHERE `User_ID` = '" + id
                + "' AND `Password` = '" + password
                + "';";
        ResultSet rs = statement.executeQuery(selectQuery);

        String Std = "SELECT `Student_ID` FROM `Student` WHERE `Student_ID` = '" + id + "';";
        String Lib = "SELECT `Librarian_ID` FROM `Librarian` WHERE `Librarian_ID` = '" + id + "';";

        if (rs.next()) {
            StringBuilder isStd = new StringBuilder();
            StringBuilder isLib = new StringBuilder();

            try (ResultSet stdRs = statement.executeQuery(Std)) {
                while (stdRs.next()) {
                    isStd.append(stdRs.getString("Student_ID")).append("\n");
                }
            }

            try (ResultSet libRs = statement.executeQuery(Lib)) {
                while (libRs.next()) {
                    isLib.append(libRs.getString("Librarian_ID")).append("\n");
                }
            }

            // Determine user statement based on the results
            if (isStd.length() > 0) {
                userStatement = 1; // It's a student
            }
            if (isLib.length() > 0) {
                userStatement = 2; // It's a librarian
            }
            if (isStd.length() > 0 && isLib.length() > 0) {
                userStatement = 0; // It's both a student and a librarian (if such a case is possible)
            }
        }

        System.out.println(userStatement);
        return userStatement;
    }

}