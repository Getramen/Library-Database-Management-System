package com.team5.librarydatabasemanage.views.runsqlcommands;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Run SQL Commands")
@Route(value = "run-sql-commands", layout = MainLayout.class)
public class RunSQLCommandsView extends Composite<VerticalLayout> {

    private TextArea resultArea = new TextArea();

    public RunSQLCommandsView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        FormLayout formLayout3Col = new FormLayout();
        Hr hr = new Hr();
        Hr hr2 = new Hr();
        Hr hr3 = new Hr();
        AvatarItem avatarItem = new AvatarItem();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        TextArea textArea = new TextArea();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        h2.setText("Run SQL Commands");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, formLayout3Col);
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        avatarItem.setWidth("min-content");
        setAvatarItemSampleData(avatarItem);
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        textArea.setLabel("Run SQL Commands");
        textArea.setWidth("100%");
        buttonPrimary.setText("Run");
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
        layoutColumn2.add(textArea);
        layoutColumn2.add(buttonPrimary);

        // Add TextArea for displaying results
        resultArea.setLabel("SQL Command Results");
        resultArea.setWidth("100%");
        resultArea.setReadOnly(true);
        layoutColumn2.add(resultArea);

        buttonPrimary.addClickListener(event -> {
            String sqlCommand = textArea.getValue();
            if (!sqlCommand.isEmpty()) {
                if (sqlCommand.trim().toLowerCase().startsWith("select")) {
                    // Execute the SELECT SQL command and display results
                    displaySelectResultsAsString(sqlCommand);
                } else {
                    // Execute other SQL commands
                    try {
                        ConnectDatabase.statement.execute(sqlCommand);
                        Notification.show("SQL command executed successfully");
                    } catch (SQLException e) {
                        Notification.show("Error executing SQL command: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void displaySelectResultsAsString(String sqlCommand) {
        try {
            ResultSet rs = ConnectDatabase.statement.executeQuery(sqlCommand);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Determine the maximum width for each column
            int[] columnWidths = new int[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnWidths[i - 1] = metaData.getColumnName(i).length();
            }

            List<List<String>> rows = new ArrayList<>();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    row.add(value);
                    if (value != null && value.length() > columnWidths[i - 1]) {
                        columnWidths[i - 1] = value.length();
                    }
                }
                rows.add(row);
            }

            // Build the result string with fixed column widths
            StringBuilder resultString = new StringBuilder();

            // Add column names with fixed width and borders
            resultString.append("| ");
            for (int i = 1; i <= columnCount; i++) {
                resultString.append(String.format("%-" + columnWidths[i - 1] + "s", metaData.getColumnName(i)))
                        .append(" | ");
            }
            resultString.append("\n");

            // Add separator line
            resultString.append("| ");
            for (int i = 0; i < columnCount; i++) {
                resultString.append("-".repeat(columnWidths[i])).append(" | ");
            }
            resultString.append("\n");

            // Add rows with fixed width and borders
            for (List<String> row : rows) {
                resultString.append("| ");
                for (int i = 0; i < columnCount; i++) {
                    resultString.append(String.format("%-" + columnWidths[i] + "s", row.get(i))).append(" | ");
                }
                resultString.append("\n");
            }

            // Set result string to TextArea
            resultArea.setValue(resultString.toString());

            rs.close();
        } catch (SQLException e) {
            Notification.show("Error executing SELECT command: " + e.getMessage());
            e.printStackTrace();
        }
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
            if (ConnectDatabase.statement == null) {
                System.out.println("Statement is not initialized.");
                return name;
            }

            // Execute the query
            ResultSet rs = ConnectDatabase.statement.executeQuery(selectQuery);

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
                if (ConnectDatabase.statement == null) {
                    System.out.println("Statement is not initialized.");
                    return name;
                }

                // Execute the query
                ResultSet rs = ConnectDatabase.statement.executeQuery(Query);

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
}