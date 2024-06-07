package com.team5.librarydatabasemanage.views.removelibrarian;

import java.sql.ResultSet;
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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import static com.team5.librarydatabasemanage.ConnectDatabase.statement;

@PageTitle("Remove Librarian")
@Route(value = "my-view26", layout = MainLayout.class)
public class RemoveLibrarianView extends Composite<VerticalLayout> {

    public RemoveLibrarianView() {
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
        Button buttonPrimary = new Button();
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Remove Librarian");
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
        select.setLabel("Select Librarian");
        select.setWidth("min-content");
        setSelectLibrarianData(select);
        buttonPrimary.setText("Remove Librarian");
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
        layoutColumn2.add(buttonPrimary);

        buttonPrimary.addClickListener(event -> {
            String librarianID = select.getValue().toString();
            String librarianIDValue = extractID(librarianID);

            String deleteQuery = "DELETE FROM Librarian WHERE Librarian_ID = " + librarianIDValue + ";";
            try {
                ConnectDatabase.statement.executeUpdate(deleteQuery);
                Notification.show("Librarian removed successfully");
            } catch (SQLException e) {
                Notification.show("Librarian remove failed: " + e.getMessage());
                e.printStackTrace();
            }
            setSelectLibrarianData(select);
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

    private void getSelectListBoxRemoveLibrarianDatas(List<String> items) {
        List<Integer> librarianID = new ArrayList<>();
        List<String> librarianName = new ArrayList<>();

        try {
            String query = "SELECT Librarian_ID, CONCAT(Librarian_name, ' ', Librarian_surname) AS Librarian_name FROM view_Librarian;";
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);
            while (resultSet.next()) {
                librarianID.add(resultSet.getInt("Librarian_ID"));
                librarianName.add(resultSet.getString("Librarian_name"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < librarianID.size() && i < librarianName.size(); i++) {
            items.add("ID: " + librarianID.get(i) + ", Name: " + librarianName.get(i));
        }
    }

    private void setSelectLibrarianData(Select<String> select) {
        List<String> librarianItems = new ArrayList<>();
        getSelectListBoxRemoveLibrarianDatas(librarianItems);
        select.setItems(librarianItems);
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
