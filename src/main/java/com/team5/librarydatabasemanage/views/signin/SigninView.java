package com.team5.librarydatabasemanage.views.signin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.team5.librarydatabasemanage.ConnectDatabase;
import com.team5.librarydatabasemanage.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
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

@PageTitle("Sign in")
@Route(value = "my-view2", layout = MainLayout.class)
public class SigninView extends Composite<VerticalLayout> {

    public SigninView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        Hr hr = new Hr();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H6 h6 = new H6();
        Hr hr2 = new Hr();
        FormLayout formLayout2Col = new FormLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        EmailField emailField = new EmailField();
        DatePicker datePicker = new DatePicker();
        PasswordField passwordField = new PasswordField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        Select select = new Select();
        Button buttonPrimary = new Button();
        Hr hr3 = new Hr();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Library Database Management System");
        h2.setWidth("max-content");
        hr.setMinHeight("5px");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setHeight("100%");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.START);
        h6.setText("Sign In");
        h6.setWidth("max-content");
        hr2.setMinHeight("1px");
        formLayout2Col.setWidth("100%");
        textField.setLabel("ID");
        textField.setWidth("min-content");
        textField2.setLabel("Name");
        textField2.setWidth("min-content");
        textField3.setLabel("Surname");
        textField3.setWidth("min-content");
        emailField.setLabel("Email");
        emailField.setWidth("100%");
        datePicker.setLabel("Birth Date");
        datePicker.setWidth("100%");
        passwordField.setLabel("Password");
        passwordField.setWidth("100%");
        textField4.setLabel("Address");
        textField4.setWidth("100%");
        textField5.setLabel("Telephone Number");
        textField5.setWidth("100%");
        select.setLabel("Sex");
        select.setWidth("100%");
        setSelectSexData(select);
        buttonPrimary.setText("Sign in");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        hr3.setMinHeight("1px");
        getContent().add(layoutRow);
        layoutRow.add(h2);
        getContent().add(hr);
        getContent().add(layoutColumn2);
        layoutColumn2.add(h6);
        layoutColumn2.add(hr2);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(textField);
        formLayout2Col.add(textField2);
        formLayout2Col.add(textField3);
        formLayout2Col.add(emailField);
        formLayout2Col.add(datePicker);
        formLayout2Col.add(passwordField);
        formLayout2Col.add(textField4);
        formLayout2Col.add(textField5);
        formLayout2Col.add(select);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(hr3);

        buttonPrimary.addClickListener(event -> {
            String studentID = textField.getValue();
            String studentName = textField2.getValue(); // Assuming textField2 is meant for firstName
            String studentSurname = textField3.getValue();
            String email = emailField.getValue();
            LocalDate bDate = datePicker.getValue();
            String password = passwordField.getValue();
            String address = textField4.getValue();
            String telNo = textField5.getValue();
            String sex = select.getValue().toString();

            String insertQuery1 = "INSERT INTO Authentication_System (User_ID, Password) VALUES ('"
                    + studentID + "','" + password + "');";
            String insertQuery2 = "INSERT INTO Student (Student_ID, Student_name, Student_surname, Address, B_date, E_mail, Tel_no, Sex) VALUES ('"
                    + studentID + "','" + studentName + "','" + studentSurname + "','" + address + "','"
                    + bDate + "','" + email + "','" + telNo + "','" + sex + "');";

            try {
                Connection connection = ConnectDatabase.connection;
                connection.setAutoCommit(false); // Disable auto-commit
                Savepoint savepoint = connection.setSavepoint("BeforeInsert"); // Set a savepoint

                try {
                    ConnectDatabase.statement.executeUpdate(insertQuery1);
                    ConnectDatabase.statement.executeUpdate(insertQuery2);
                    connection.commit(); // Commit the transaction if both inserts succeed
                    Notification.show("Student added successfully");
                } catch (SQLException e) {
                    connection.rollback(savepoint); // Rollback to the savepoint if an error occurs
                    Notification.show("Student add failed: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    connection.setAutoCommit(true); // Reset auto-commit to true
                }
            } catch (SQLException e) {
                Notification.show("Database connection failed: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSexData(Select<String> select) {
        List<String> sexItems = new ArrayList<>();
        sexItems.add("M");
        sexItems.add("F");
        select.setItems(sexItems);
    }
}