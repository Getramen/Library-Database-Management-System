package com.team5.librarydatabasemanage.views.usersettings;

import static com.team5.librarydatabasemanage.ConnectDatabase.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.team5.librarydatabasemanage.ConnectDatabase;
import com.team5.librarydatabasemanage.components.avataritem.AvatarItem;
import com.team5.librarydatabasemanage.views.MainLayout;
import com.team5.librarydatabasemanage.views.login.LoginView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("User Settings")
@Route(value = "my-view3", layout = MainLayout.class)
public class UserSettingsView extends Composite<VerticalLayout> {

    private static String userID;

    private static String studentName;
    private static String studentSurname;
    private static String email;
    private static String telNo;
    private static LocalDate bDate;
    private static String address;
    private static String sex;

    private static String librarianName;
    private static String librarianSurname;

    private static String password;

    public UserSettingsView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        FormLayout formLayout3Col = new FormLayout();
        Hr hr = new Hr();
        Hr hr2 = new Hr();
        Hr hr3 = new Hr();
        AvatarItem avatarItem = new AvatarItem();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        FormLayout formLayout3Col2 = new FormLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();
        TextField textField3 = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField textField4 = new TextField();
        Select<String> select = new Select<>();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        h2.setText("User Settings");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, formLayout3Col);
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        avatarItem.setWidth("min-content");
        setAvatarItemSampleData(avatarItem);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.START);
        formLayout3Col2.setWidth("100%");
        formLayout3Col2.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        textField.setLabel("User Name");
        textField.setWidth("min-content");
        textField2.setLabel("User Surname");
        textField2.setWidth("min-content");
        emailField.setLabel("Email");
        emailField.setWidth("min-content");
        emailField.setVisible(false); // Set email field to be invisible by default
        passwordField.setLabel("User Password");
        passwordField.setWidth("100%");
        textField3.setLabel("User Tel No");
        textField3.setWidth("min-content");
        datePicker.setLabel("Birth Date");
        datePicker.setWidth("min-content");
        textField4.setLabel("Address");
        textField4.setWidth("min-content");
        select.setLabel("Sex");
        select.setWidth("min-content");
        setSelectSexData(select);
        buttonPrimary.setText("Update");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(h2);
        layoutRow.add(formLayout3Col);
        formLayout3Col.add(hr);
        formLayout3Col.add(hr2);
        formLayout3Col.add(hr3);
        layoutRow.add(avatarItem);
        getContent().add(layoutColumn2);
        layoutColumn2.add(formLayout3Col2);
        formLayout3Col2.add(textField);
        formLayout3Col2.add(textField2);
        formLayout3Col2.add(emailField);
        formLayout3Col2.add(passwordField);
        formLayout3Col2.add(textField3);
        formLayout3Col2.add(datePicker);
        formLayout3Col2.add(textField4);
        formLayout3Col2.add(select);
        layoutColumn2.add(buttonPrimary);

        userID = LoginView.userid;

        if (userID != null) {
            try {
                // Retrieve the current user data from the database
                String selectQuery = "SELECT * FROM Student WHERE Student_ID = " + userID + ";";
                ResultSet resultSet = ConnectDatabase.statement.executeQuery(selectQuery);

                if (resultSet.next()) {
                    // User is a Student
                    studentName = resultSet.getString("Student_name");
                    studentSurname = resultSet.getString("Student_surname");
                    email = resultSet.getString("E_mail");
                    telNo = resultSet.getString("Tel_no");
                    bDate = resultSet.getDate("B_date").toLocalDate();
                    address = resultSet.getString("Address");
                    sex = resultSet.getString("Sex");

                    // Set the retrieved data as values in the form fields
                    textField.setValue(studentName);
                    textField2.setValue(studentSurname);
                    emailField.setValue(email);
                    emailField.setVisible(true); // Make email field visible for students
                    textField3.setValue(telNo);
                    datePicker.setValue(bDate);
                    textField4.setValue(address);
                    select.setValue(sex);
                } else {
                    // User is not a Student, check if they are a Librarian
                    selectQuery = "SELECT * FROM Librarian WHERE Librarian_ID = " + userID + ";";
                    resultSet = ConnectDatabase.statement.executeQuery(selectQuery);

                    if (resultSet.next()) {
                        // User is a Librarian
                        librarianName = resultSet.getString("Librarian_name");
                        librarianSurname = resultSet.getString("Librarian_surname");
                        telNo = resultSet.getString("Tel_no");
                        bDate = resultSet.getDate("B_date").toLocalDate();
                        address = resultSet.getString("Address");
                        sex = resultSet.getString("Sex");

                        // Set the retrieved data as values in the form fields
                        textField.setValue(librarianName);
                        textField2.setValue(librarianSurname);
                        textField3.setValue(telNo);
                        datePicker.setValue(bDate);
                        textField4.setValue(address);
                        select.setValue(sex);
                    }
                }

                resultSet.close();

                // Retrieve the current password from the Authentication_System table
                String selectPasswordQuery = "SELECT Password FROM Authentication_System WHERE User_ID = " + userID
                        + ";";
                ResultSet passwordResultSet = ConnectDatabase.statement.executeQuery(selectPasswordQuery);

                if (passwordResultSet.next()) {
                    password = passwordResultSet.getString("Password");
                    passwordField.setValue(password);
                }

                passwordResultSet.close();
            } catch (SQLException e) {
                Notification.show("Failed to retrieve user settings: " + e.getMessage());
                e.printStackTrace();
            }
        }

        buttonPrimary.addClickListener(event -> {
            if (userID != null) {
                try {
                    // Check if the user is a Student
                    String selectQuery = "SELECT * FROM Student WHERE Student_ID = " + userID + ";";
                    ResultSet resultSet = ConnectDatabase.statement.executeQuery(selectQuery);

                    if (resultSet.next()) {
                        // User is a Student
                        // Update the student data in the database
                        String updateQuery = "UPDATE Student SET " +
                                "Student_name = ?, " +
                                "Student_surname = ?, " +
                                "Address = ?, " +
                                "B_date = ?, " +
                                "E_mail = ?, " +
                                "Tel_no = ?, " +
                                "Sex = ? " +
                                "WHERE Student_ID = ?;";
                        var preparedStatement = ConnectDatabase.connection.prepareStatement(updateQuery);
                        preparedStatement.setString(1, textField.getValue());
                        preparedStatement.setString(2, textField2.getValue());
                        preparedStatement.setString(3, textField4.getValue());
                        preparedStatement.setDate(4, java.sql.Date.valueOf(datePicker.getValue()));
                        preparedStatement.setString(5, emailField.getValue());
                        preparedStatement.setString(6, textField3.getValue());
                        preparedStatement.setString(7, select.getValue());
                        preparedStatement.setString(8, userID);
                        preparedStatement.executeUpdate();
                    } else {
                        // User is not a Student, check if they are a Librarian
                        selectQuery = "SELECT * FROM Librarian WHERE Librarian_ID = " + userID + ";";
                        resultSet = ConnectDatabase.statement.executeQuery(selectQuery);

                        if (resultSet.next()) {
                            // User is a Librarian
                            // Update the librarian data in the database
                            String updateQuery = "UPDATE Librarian SET " +
                                    "Librarian_name = ?, " +
                                    "Librarian_surname = ?, " +
                                    "Address = ?, " +
                                    "B_date = ?, " +
                                    "Tel_no = ?, " +
                                    "Sex = ? " +
                                    "WHERE Librarian_ID = ?;";
                            var preparedStatement = ConnectDatabase.connection.prepareStatement(updateQuery);
                            preparedStatement.setString(1, textField.getValue());
                            preparedStatement.setString(2, textField2.getValue());
                            preparedStatement.setString(3, textField4.getValue());
                            preparedStatement.setDate(4, java.sql.Date.valueOf(datePicker.getValue()));
                            preparedStatement.setString(5, textField3.getValue());
                            preparedStatement.setString(6, select.getValue());
                            preparedStatement.setString(7, userID);
                            preparedStatement.executeUpdate();
                        }
                    }

                    resultSet.close();

                    // Update the password in the Authentication_System table
                    String updatePasswordQuery = "UPDATE Authentication_System SET Password = ? WHERE User_ID = ?;";
                    var preparedStatement = ConnectDatabase.connection.prepareStatement(updatePasswordQuery);
                    preparedStatement.setString(1, passwordField.getValue());
                    preparedStatement.setString(2, userID);
                    preparedStatement.executeUpdate();

                    Notification.show("User settings updated successfully");
                } catch (SQLException e) {
                    Notification.show("Failed to update user settings: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                Notification.show("Current user ID not found");
            }
            setAvatarItemSampleData(avatarItem);
        });
    }

    public static void setAvatarItemSampleData(AvatarItem avatarItem) {

        String temp = getinfo();

        avatarItem.setHeading(temp);

        if (LoginView.userStatement == 1) {
            avatarItem.setDescription("Student");
        } else if (LoginView.userStatement == 2) {
            avatarItem.setDescription("Librarian");
        }

        avatarItem.setAvatar(new Avatar(temp));
    }

    public static String getinfo() {
        String name = "";
        String userId = LoginView.userid;

        // Log the userId to ensure it's being set correctly
        System.out.println("User ID: " + userId);

        // Check if userId is not null or empty
        if (userId == null || userId.trim().isEmpty()) {
            System.out.println("User ID is null or empty.");
            return name;
        }

        // Create the SQL query
        String selectQuery = "SELECT `Student_name`, `Student_surname` FROM `Student` WHERE `Student_ID` = '" + userId
                + "'";

        try {
            // Ensure statement is initialized properly
            if (statement == null) {
                System.out.println("Statement is not initialized.");
                return name;
            }

            // Execute the query
            ResultSet rs = statement.executeQuery(selectQuery);

            // Process the result set
            if (rs.next()) {
                String firstName = rs.getString("Student_name");
                String lastName = rs.getString("Student_surname");
                name = firstName + " " + lastName;
            } else {
                System.out.println("No record found for User ID: " + userId);
            }

            // Close the result set
            rs.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("Full Name: " + name);

        if (name.isEmpty()) {
            String Query = "SELECT `Librarian_name`, `Librarian_surname` FROM `Librarian` WHERE `Librarian_ID` = '"
                    + userId + "'";

            try {
                // Ensure statement is initialized properly
                if (statement == null) {
                    System.out.println("Statement is not initialized.");
                    return name;
                }

                // Execute the query
                ResultSet rs = statement.executeQuery(Query);

                // Process the result set
                if (rs.next()) {
                    String firstName = rs.getString("Librarian_name");
                    String lastName = rs.getString("Librarian_surname");
                    name = firstName + " " + lastName;
                } else {
                    System.out.println("No record found for User ID: " + userId);
                }

                rs.close();
            } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return name;
    }

    private void setSelectSexData(Select<String> select) {
        List<String> sexOptions = new ArrayList<>();
        sexOptions.add("M");
        sexOptions.add("F");
        select.setItems(sexOptions);
    }
}