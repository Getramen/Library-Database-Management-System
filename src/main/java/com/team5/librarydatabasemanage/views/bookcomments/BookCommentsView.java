package com.team5.librarydatabasemanage.views.bookcomments;

import java.sql.PreparedStatement;
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
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Book Comments")
@Route(value = "my-view8", layout = MainLayout.class)
public class BookCommentsView extends Composite<VerticalLayout> {

    private Select<String> bookSelect;
    private TextArea commentTextArea;
    private VerticalLayout commentLayout;

    public BookCommentsView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        bookSelect = new Select<>();
        FormLayout formLayout3Col = new FormLayout();
        Hr hr = new Hr();
        Hr hr2 = new Hr();
        Hr hr3 = new Hr();
        AvatarItem avatarItem = new AvatarItem();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        AvatarItem avatarItem2 = new AvatarItem();
        AvatarItem avatarItem3 = new AvatarItem();
        TextArea textArea = new TextArea();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        h2.setText("\"Book Name\"");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        bookSelect.setLabel("Select Book");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, bookSelect);
        bookSelect.setWidth("min-content");
        setSelectBookData(bookSelect);
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, formLayout3Col);
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, avatarItem);
        avatarItem.setWidth("min-content");
        setAvatarItemSampleData(avatarItem);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        avatarItem2.setWidth("min-content");
        commentLayout = new VerticalLayout();
        commentLayout.setWidth("100%");
        layoutColumn2.add(commentLayout);
        setAvatarItemSampleData(avatarItem2);
        avatarItem3.setWidth("min-content");
        setAvatarItemSampleData(avatarItem3);
        textArea.setLabel("Comment");
        textArea.setWidth("100%");
        buttonPrimary.setText("Send Comment");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(h2);
        layoutRow.add(bookSelect);
        layoutRow.add(formLayout3Col);
        formLayout3Col.add(hr);
        formLayout3Col.add(hr2);
        formLayout3Col.add(hr3);
        layoutRow.add(avatarItem);
        getContent().add(layoutColumn2);
        layoutColumn2.add(textArea);
        layoutColumn2.add(buttonPrimary);

        bookSelect.addValueChangeListener(event -> {
            displayComments();
        });

        buttonPrimary.addClickListener(event -> {
            String comment = textArea.getValue();
            String bookID = extractID(bookSelect.getValue());
            String studentID = LoginView.userid;

            if (!comment.isEmpty() && bookID != null && studentID != null) {
                try {
                    // Insert the comment into the database
                    String insertQuery = "INSERT INTO Comment (Comments, Comment_date, Book_ID, Student_ID) " +
                            "VALUES (?, CURRENT_DATE(), ?, ?);";
                    PreparedStatement statement = ConnectDatabase.connection.prepareStatement(insertQuery);
                    statement.setString(1, comment);
                    statement.setString(2, bookID);
                    statement.setString(3, studentID);
                    statement.executeUpdate();

                    // Clear the comment text area
                    textArea.setValue("");

                    // Refresh the comment layout
                    displayComments();
                } catch (SQLException e) {
                    Notification.show("Failed to add comment: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                Notification.show("Please select a book and enter a comment.");
            }
        });

        displayComments();

    }

    private void setSelectBookData(Select<String> select) {
        List<String> bookItems = new ArrayList<>();

        try {
            String query = "SELECT Book_ID, Book_name FROM view_Book;";
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);

            while (resultSet.next()) {
                String bookID = resultSet.getString("Book_ID");
                String bookName = resultSet.getString("Book_name");
                bookItems.add("ID: " + bookID + ", Name: " + bookName);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        select.setItems(bookItems);
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

    private void refreshCommentLayout() {
        commentLayout.removeAll();

        try {
            String bookID = extractID(bookSelect.getValue());
            if (bookID != null) {
                String selectQuery = "SELECT c.Comments, c.Comment_date, s.Student_name, s.Student_surname " +
                        "FROM Comment c " +
                        "JOIN Student s ON c.Student_ID = s.Student_ID " +
                        "WHERE c.Book_ID = " + bookID + " " +
                        "ORDER BY c.Comment_date DESC;";
                ResultSet resultSet = ConnectDatabase.statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    String comment = resultSet.getString("Comments");
                    String commentDate = resultSet.getString("Comment_date");
                    String studentName = resultSet.getString("Student_name");
                    String studentSurname = resultSet.getString("Student_surname");

                    HorizontalLayout commentItem = new HorizontalLayout();
                    commentItem.setWidthFull();
                    commentItem.setAlignItems(Alignment.CENTER);

                    Paragraph studentNameText = new Paragraph(studentName + " " + studentSurname);
                    Paragraph commentText = new Paragraph(comment);
                    Paragraph commentDateText = new Paragraph(commentDate);

                    commentItem.add(studentNameText, commentText, commentDateText);
                    commentLayout.add(commentItem);
                }

                resultSet.close();
            }
        } catch (SQLException e) {
            Notification.show("Failed to load comments: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int getCurrentStudentID() {
        // Implement your logic to get the current student ID
        // For example, you can retrieve it from the session or authentication system

        // Assuming you have a session attribute named "studentID"
        if (LoginView.userStatement != 0) {
            return LoginView.userStatement;
        }

        // If the student ID is not available in the session, you can use a default
        // value or handle it accordingly
        return 0; // Default value
    }

    private void displayComments() {
        try {
            String bookID = extractID(bookSelect.getValue());
            if (bookID != null) {
                String selectQuery = "SELECT c.Comments, c.Comment_date, s.Student_name, s.Student_surname " +
                        "FROM Comment c " +
                        "JOIN Student s ON c.Student_ID = s.Student_ID " +
                        "WHERE c.Book_ID = ? " +
                        "ORDER BY c.Comment_date DESC;";
                PreparedStatement statement = ConnectDatabase.connection.prepareStatement(selectQuery);
                statement.setString(1, bookID);
                ResultSet resultSet = statement.executeQuery();

                List<HorizontalLayout> commentItems = new ArrayList<>();

                while (resultSet.next()) {
                    String comment = resultSet.getString("Comments");
                    String commentDate = resultSet.getString("Comment_date");
                    String studentName = resultSet.getString("Student_name");
                    String studentSurname = resultSet.getString("Student_surname");

                    AvatarItem avatarItem = new AvatarItem();
                    avatarItem.setHeading(studentName + " " + studentSurname);
                    avatarItem.setDescription("Student");
                    avatarItem.setAvatar(new Avatar(studentName.substring(0, 1) + studentSurname.substring(0, 1)));

                    Paragraph commentParagraph = new Paragraph(comment);
                    Paragraph commentDateParagraph = new Paragraph("Date: " + commentDate);

                    VerticalLayout commentLayout = new VerticalLayout(commentParagraph, commentDateParagraph);
                    commentLayout.setSpacing(false);
                    commentLayout.setPadding(false);

                    HorizontalLayout commentItem = new HorizontalLayout(avatarItem, commentLayout);
                    commentItem.setWidthFull();
                    commentItem.setAlignItems(Alignment.CENTER);
                    commentItem.setSpacing(true);

                    commentItems.add(commentItem);
                }

                resultSet.close();
                statement.close();

                // Clear previous comments
                commentLayout.removeAll();

                // Add comment items to the comment layout
                commentItems.forEach(commentLayout::add);
            }
        } catch (SQLException e) {
            Notification.show("Failed to load comments: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getinfo() {
        String name = "";
        String userId = LoginView.userid;

        // Check if userId is not null or empty
        if (userId == null || userId.trim().isEmpty()) {
            return name;
        }

        // Create the SQL query
        String selectQuery = "SELECT `Student_name`, `Student_surname` FROM `Student` WHERE `Student_ID` = '" + userId
                + "'";

        try {
            // Execute the query
            ResultSet rs = ConnectDatabase.statement.executeQuery(selectQuery);

            // Process the result set
            if (rs.next()) {
                String firstName = rs.getString("Student_name");
                String lastName = rs.getString("Student_surname");
                name = firstName + " " + lastName;
            }

            // Close the result set
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (name.isEmpty()) {
            String Query = "SELECT `Librarian_name`, `Librarian_surname` FROM `Librarian` WHERE `Librarian_ID` = '"
                    + userId + "'";

            try {
                // Execute the query
                ResultSet rs = ConnectDatabase.statement.executeQuery(Query);

                // Process the result set
                if (rs.next()) {
                    String firstName = rs.getString("Librarian_name");
                    String lastName = rs.getString("Librarian_surname");
                    name = firstName + " " + lastName;
                }

                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return name;
    }

    public static String extractID(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

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
