package com.team5.librarydatabasemanage.views.addbooks;

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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import static com.team5.librarydatabasemanage.ConnectDatabase.statement;

@PageTitle("Add Books")
@Route(value = "my-view4", layout = MainLayout.class)
public class AddBooksView extends Composite<VerticalLayout> {

    public AddBooksView() {
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
        Select select = new Select();
        Select select2 = new Select();
        Select select3 = new Select();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField textField5 = new TextField();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Add Books");
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
        textField.setLabel("Book ID");
        textField.setWidth("min-content");
        textField2.setLabel("Book Name");
        textField2.setWidth("min-content");
        select.setLabel("Select Author");
        select.setWidth("min-content");
        setSelectAuthorData(select);
        select2.setLabel("Select Publisher");
        select2.setWidth("min-content");
        setSelectPublisherData(select2);
        select3.setLabel("Select Library");
        select3.setWidth("min-content");
        setSelectLibraryData(select3);
        textField3.setLabel("Book Location");
        textField3.setWidth("min-content");
        textField4.setLabel("Book Genre");
        textField4.setWidth("min-content");
        datePicker.setLabel("Release Date");
        datePicker.setWidth("min-content");
        textField5.setLabel("Book Page Number");
        textField5.setWidth("min-content");
        buttonPrimary.setText("Add Book");
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
        formLayout3Col2.add(select);
        formLayout3Col2.add(select2);
        formLayout3Col2.add(select3);
        formLayout3Col2.add(textField3);
        formLayout3Col2.add(textField4);
        formLayout3Col2.add(datePicker);
        formLayout3Col2.add(textField5);
        layoutColumn2.add(buttonPrimary);

        buttonPrimary.addClickListener(event -> {

            String bookID = (textField.getValue());
            String bookName = textField2.getValue();
            String authorID = select.getValue().toString();
            String authorIDValue = extractID(authorID);
            String publisherID = select2.getValue().toString();
            String publisherIDValue = extractID(publisherID);
            String libraryID = select3.getValue().toString();
            String libraryIDValue = extractID(libraryID);

            String booksLocation = textField3.getValue();
            String bookGenre = textField4.getValue();
            LocalDate releaseDate = datePicker.getValue();
            String booksPage = textField5.getValue();

            String insertQuery = "INSERT INTO Book (Book_ID, Book_name, Author_ID, Publisher_ID, Library_ID, Books_location, Book_genre, Release_date, Book_pages) VALUES ('"
                    + bookID + "','" + bookName + "','" + authorIDValue + "','" + publisherIDValue + "','"
                    + libraryIDValue + "','"
                    + booksLocation + "','" + bookGenre + "','" + releaseDate + "','" + booksPage + "');";
            try {
                ConnectDatabase.statement.executeUpdate(insertQuery);
                Notification.show("Book Added successfully");
            } catch (SQLException e) {
                Notification.show("Book add failed: " + e.getMessage());
                e.printStackTrace();
            }

        });

    }

    private void getSelectListBoxAddBookDatas(List items, String listName) {
        List<Integer> authorID = new ArrayList<>();
        List<String> authorName = new ArrayList<>();

        List<Integer> publisherID = new ArrayList<>();
        List<String> publisherName = new ArrayList<>();

        List<Integer> libraryID = new ArrayList<>();
        List<String> libraryName = new ArrayList<>();

        try {
            String query = "SELECT Author_ID, CONCAT(Author_name, ' ', Author_surname) AS Author_name\n" + //
                    "FROM view_Author;";
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);
            while (resultSet.next()) {
                authorID.add(resultSet.getInt("Author_ID"));
                authorName.add(resultSet.getString("Author_name"));
            }

            query = "SELECT Publisher_ID, Name FROM view_Publisher;";
            resultSet = ConnectDatabase.statement.executeQuery(query);

            while (resultSet.next()) {
                publisherID.add(resultSet.getInt("Publisher_ID"));
                publisherName.add(resultSet.getString("Name"));
            }

            query = "SELECT Library_ID, Name FROM view_Library;";
            resultSet = ConnectDatabase.statement.executeQuery(query);

            while (resultSet.next()) {
                libraryID.add(resultSet.getInt("Library_ID"));
                libraryName.add(resultSet.getString("Name"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        switch (listName) {
            case "authorItems":
                for (Integer i = 0; i < authorID.size() || i < authorName.size(); i++) {
                    items.add("ID: " + authorID.get(i) + ", Name: " + authorName.get(i));
                }
                break;
            case "publisherItems":
                for (Integer i = 0; i < publisherID.size() || i < publisherName.size(); i++) {
                    items.add("ID: " + publisherID.get(i) + ", Name: " + publisherName.get(i));
                }
                break;
            case "libraryItems":
                for (Integer i = 0; i < libraryID.size() || i < libraryName.size(); i++) {
                    items.add("ID: " + libraryID.get(i) + ", Name: " + libraryName.get(i));
                }
                break;

            default:
                break;
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

    private void setSelectAuthorData(Select select) {
        List<String> authorItems = new ArrayList<>();

        getSelectListBoxAddBookDatas(authorItems, "authorItems");

        select.setItems(authorItems);

    }

    private void setSelectPublisherData(Select select) {
        List<String> publisherItems = new ArrayList<>();

        getSelectListBoxAddBookDatas(publisherItems, "publisherItems");

        select.setItems(publisherItems);

    }

    private void setSelectLibraryData(Select select) {
        List<String> libraryItems = new ArrayList<>();

        getSelectListBoxAddBookDatas(libraryItems, "libraryItems");

        select.setItems(libraryItems);

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