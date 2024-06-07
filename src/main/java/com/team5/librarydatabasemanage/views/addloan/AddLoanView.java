package com.team5.librarydatabasemanage.views.addloan;

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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import static com.team5.librarydatabasemanage.ConnectDatabase.statement;

@PageTitle("Add Loan")
@Route(value = "my-view5", layout = MainLayout.class)
public class AddLoanView extends Composite<VerticalLayout> {

    public AddLoanView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        FormLayout formLayout3Col = new FormLayout();
        Hr hr = new Hr();
        Hr hr2 = new Hr();
        Hr hr3 = new Hr();
        AvatarItem avatarItem = new AvatarItem();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        FormLayout formLayout3Col2 = new FormLayout();
        Select select = new Select();
        Select select2 = new Select();
        DatePicker datePicker = new DatePicker();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Add Loan");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, formLayout3Col);
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, avatarItem);
        avatarItem.setWidth("min-content");
        setAvatarItemSampleData(avatarItem);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        formLayout3Col2.setWidth("100%");
        formLayout3Col2.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        select.setLabel("Student Name");
        select.setWidth("min-content");
        setSelectStudentNameData(select);
        select2.setLabel("Book Name");
        select2.setWidth("min-content");
        setSelectBookNameData(select2);
        datePicker.setLabel("Due Date");
        datePicker.setWidth("min-content");
        buttonPrimary.setText("Add Loan");
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
        formLayout3Col2.add(select);
        formLayout3Col2.add(select2);
        formLayout3Col2.add(datePicker);
        layoutColumn2.add(buttonPrimary);

        buttonPrimary.addClickListener(event -> {
            String studentName = select.getValue().toString();
            String studentID = extractID(studentName);
            String bookName = select2.getValue().toString();
            String bookID = extractID(bookName);
            LocalDate dueDate = datePicker.getValue();
            String librarianID = LoginView.userid;

            String insertQuery = "INSERT INTO Loan_process (Borrow_date, Due_date, Book_ID, Student_ID, Librarian_ID) VALUES ('"
                    + LocalDate.now() + "','" + dueDate + "','" + bookID + "','" + studentID + "','" + librarianID
                    + "');";

            try {
                ConnectDatabase.statement.executeUpdate(insertQuery);
                Notification.show("Loan Added successfully");
            } catch (SQLException e) {
                Notification.show("Loan add failed: " + e.getMessage());
                e.printStackTrace();
            }
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

    private void setSelectStudentNameData(Select<String> select) {
        List<String> studentNameItems = new ArrayList<>();

        try {
            String query = "SELECT Student_ID, CONCAT(Student_name, ' ', Student_surname) AS Student_name FROM view_Student;";
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);

            while (resultSet.next()) {
                String studentID = resultSet.getString("Student_ID");
                String studentName = resultSet.getString("Student_name");
                studentNameItems.add("ID: " + studentID + ", Name: " + studentName);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        select.setItems(studentNameItems);
    }

    private void setSelectBookNameData(Select<String> select) {
        List<String> bookNameItems = new ArrayList<>();

        try {
            String query = "SELECT Book_ID, Book_name FROM view_Book;";
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);

            while (resultSet.next()) {
                String bookID = resultSet.getString("Book_ID");
                String bookName = resultSet.getString("Book_name");
                bookNameItems.add("ID: " + bookID + ", Name: " + bookName);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        select.setItems(bookNameItems);
    }

    public static String extractID(String input) {
        // Split the string at the comma
        String[] parts = input.split(",");

        // Find the part that starts with "ID:"
        for (String part : parts) {
            part = part.trim(); // Remove any leading or trailing whitespace
            if (part.startsWith("ID:")) {
                // Extract the value after "ID:"
                return part.substring(3).trim();
            }
        }

        // Return null if "ID:" is not found
        return null;
    }

}
