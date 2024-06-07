package com.team5.librarydatabasemanage.views.addstudent;

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
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import static com.team5.librarydatabasemanage.ConnectDatabase.statement;

@PageTitle("Add Student")
@Route(value = "my-view17", layout = MainLayout.class)
public class AddStudentView extends Composite<VerticalLayout> {

    public AddStudentView() {
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
        TextField textField3 = new TextField();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();
        TextField textField4 = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField textField5 = new TextField();
        Select select = new Select();
        Button buttonPrimary = new Button();
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Add Student");
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
        textField.setLabel("Student ID");
        textField.setWidth("min-content");
        textField2.setLabel("Student Name");
        textField2.setWidth("min-content");
        textField3.setLabel("Student Surname");
        textField3.setWidth("min-content");
        emailField.setLabel("Email");
        emailField.setWidth("min-content");
        passwordField.setLabel("Password");
        passwordField.setWidth("100%");
        textField4.setLabel("Tel No");
        textField4.setWidth("min-content");
        datePicker.setLabel("Birth Date");
        datePicker.setWidth("min-content");
        textField5.setLabel("Address");
        textField5.setWidth("min-content");
        select.setLabel("Sex");
        select.setWidth("min-content");
        setSelectSexData(select);
        buttonPrimary.setText("Add User");
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
        formLayout3Col2.add(textField3);
        formLayout3Col2.add(emailField);
        formLayout3Col2.add(passwordField);
        formLayout3Col2.add(textField4);
        formLayout3Col2.add(datePicker);
        formLayout3Col2.add(textField5);
        formLayout3Col2.add(select);
        layoutColumn2.add(buttonPrimary);

        buttonPrimary.addClickListener(event -> {
            String studentID = textField.getValue();
            String studentName = textField2.getValue();
            String studentSurname = textField3.getValue();
            String email = emailField.getValue();
            String password = passwordField.getValue();
            String telNo = textField4.getValue();
            LocalDate bDate = datePicker.getValue();
            String address = textField5.getValue();
            String sex = select.getValue().toString();

            String insertQuery1 = "INSERT INTO Authentication_System (User_ID, Password) VALUES ('"
                    + studentID + "','" + password + "');";

            String insertQuery2 = "INSERT INTO Student (Student_ID, Student_name, Student_surname, Address, B_date, E_mail, Tel_no, Sex) VALUES ('"
                    + studentID + "','" + studentName + "','" + studentSurname + "','" + address + "','"
                    + bDate + "','" + email + "','" + telNo + "','" + sex + "');";

            try {
                ConnectDatabase.statement.executeUpdate(insertQuery1);
                ConnectDatabase.statement.executeUpdate(insertQuery2);
                Notification.show("Student Added successfully");
            } catch (SQLException e) {
                Notification.show("Student add failed: " + e.getMessage());
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

    private void setSelectSexData(Select select) {
        List<String> sexItems = new ArrayList<>();
        sexItems.add("M");
        sexItems.add("F");
        select.setItems(sexItems);

    }
}
