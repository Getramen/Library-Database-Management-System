package com.team5.librarydatabasemanage.views.viewauthor;

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
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import static com.team5.librarydatabasemanage.ConnectDatabase.statement;

@PageTitle("View Author")
@Route(value = "my-view19", layout = MainLayout.class)
public class ViewAuthorView extends Composite<VerticalLayout> {

    public ViewAuthorView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        FormLayout formLayout3Col = new FormLayout();
        Hr hr = new Hr();
        Hr hr2 = new Hr();
        Hr hr3 = new Hr();
        AvatarItem avatarItem = new AvatarItem();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        H5 h5 = new H5();
        Hr hr4 = new Hr();
        MultiSelectListBox textItems = new MultiSelectListBox();
        Hr hr5 = new Hr();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        H5 h52 = new H5();
        Hr hr6 = new Hr();
        MultiSelectListBox textItems2 = new MultiSelectListBox();
        Hr hr7 = new Hr();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        H5 h53 = new H5();
        Hr hr8 = new Hr();
        MultiSelectListBox textItems3 = new MultiSelectListBox();
        Hr hr9 = new Hr();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        H5 h54 = new H5();
        Hr hr10 = new Hr();
        MultiSelectListBox textItems4 = new MultiSelectListBox();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("View Author");
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
        layoutColumn2.setHeight("min-content");
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.XSMALL);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.START);
        layoutRow2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn3.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("min-content");
        layoutColumn3.setHeight("min-content");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn3.setAlignItems(Alignment.CENTER);
        h5.setText("Author ID");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        hr4.setMinWidth("5px");
        hr4.setMinHeight("5px");
        textItems.setWidth("max-content");
        setMultiSelectListBoxAuthorIDData(textItems);
        hr5.setMinWidth("5px");
        hr5.setMaxWidth("10px");
        hr5.setHeight("100%");
        hr5.setMinHeight("5px");
        layoutColumn4.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Gap.XSMALL);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth("min-content");
        layoutColumn4.setHeight("min-content");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        h52.setText("Name");
        h52.setWidth("max-content");
        hr6.setMinWidth("5px");
        hr6.setMinHeight("5px");
        textItems2.setWidth("mx-content");
        setMultiSelectListBoxNameData(textItems2);
        hr7.setMinWidth("5px");
        hr7.setMaxWidth("10px");
        hr7.setHeight("100%");
        hr7.setMinHeight("5px");
        layoutColumn5.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.addClassName(Gap.XSMALL);
        layoutColumn5.addClassName(Padding.XSMALL);
        layoutColumn5.setWidth("min-content");
        layoutColumn5.setHeight("min-content");
        layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn5.setAlignItems(Alignment.CENTER);
        h53.setText("Surname");
        h53.setWidth("max-content");
        hr8.setMinWidth("5px");
        hr8.setMinHeight("5px");
        textItems3.setWidth("max-content");
        setMultiSelectListBoxSurnameData(textItems3);
        hr9.setMinWidth("5px");
        hr9.setMaxWidth("10px");
        hr9.setHeight("100%");
        hr9.setMinHeight("5px");
        layoutColumn6.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.addClassName(Gap.XSMALL);
        layoutColumn6.addClassName(Padding.XSMALL);
        layoutColumn6.setWidth("min-content");
        layoutColumn6.setHeight("min-content");
        layoutColumn6.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn6.setAlignItems(Alignment.CENTER);
        h54.setText("Other Books");
        h54.setWidth("max-content");
        hr10.setMinWidth("5px");
        hr10.setMinHeight("5px");
        textItems4.setWidth("max-content");
        setMultiSelectListBoxOtherBooksData(textItems4);
        getContent().add(layoutRow);
        layoutRow.add(h2);
        layoutRow.add(formLayout3Col);
        formLayout3Col.add(hr);
        formLayout3Col.add(hr2);
        formLayout3Col.add(hr3);
        layoutRow.add(avatarItem);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(h5);
        layoutColumn3.add(hr4);
        layoutColumn3.add(textItems);
        layoutRow2.add(hr5);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(h52);
        layoutColumn4.add(hr6);
        layoutColumn4.add(textItems2);
        layoutRow2.add(hr7);
        layoutRow2.add(layoutColumn5);
        layoutColumn5.add(h53);
        layoutColumn5.add(hr8);
        layoutColumn5.add(textItems3);
        layoutRow2.add(hr9);
        layoutRow2.add(layoutColumn6);
        layoutColumn6.add(h54);
        layoutColumn6.add(hr10);
        layoutColumn6.add(textItems4);
    }

    public static void setAvatarItemSampleData(AvatarItem avatarItem) {

        String temp = getinfo();


        avatarItem.setHeading(temp);


        if (LoginView.userStatement == 1)
        {
            avatarItem.setDescription("Student");
        }
        else if(LoginView.userStatement == 2)
        {
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
        String selectQuery = "SELECT `Student_name`, `Student_surname` FROM `Student` WHERE `Student_ID` = '" + userId + "'";

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

        if (name.isEmpty())
        {
            String Query = "SELECT `Librarian_name`, `Librarian_surname` FROM `Librarian` WHERE `Librarian_ID` = '" + userId + "'";

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

    private void getSelectListBoxViewAuthorDatas(List items, String listName) {
        List<Integer> authorID = new ArrayList<>();
        List<String> authorName = new ArrayList<>();
        List<String> authorSurname = new ArrayList<>();
        List<String> otherBooks = new ArrayList<>();
        try {
            String query = "SELECT * FROM view_Author"; // View adını buraya yazın
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);
            while (resultSet.next()) {
                authorID.add(resultSet.getInt("Author_ID"));
                authorName.add(resultSet.getString("Author_name"));
                authorSurname.add(resultSet.getString("Author_surname"));
                otherBooks.add(resultSet.getString("Other_books"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        switch (listName) {
            case "authorIDItems":
                for (Integer id : authorID) {
                    items.add(Integer.toString(id));
                }
                break;
            case "nameItems":
                for (String name : authorName) {
                    items.add(name);
                }
                break;
            case "surnameItems":
                for (String surname : authorSurname) {
                    items.add(surname);
                }
                break;
            case "otherBooksItems":
                for (String ob : otherBooks) {
                    items.add(ob);
                }
                break;

            default:
                break;
        }

    }

    private void setMultiSelectListBoxAuthorIDData(MultiSelectListBox multiSelectListBox) {
        List<String> authorIDItems = new ArrayList<>();

        getSelectListBoxViewAuthorDatas(authorIDItems, "authorIDItems");

        multiSelectListBox.setItems(authorIDItems);

    }

    private void setMultiSelectListBoxNameData(MultiSelectListBox multiSelectListBox) {
        List<String> nameItems = new ArrayList<>();

        getSelectListBoxViewAuthorDatas(nameItems, "nameItems");

        multiSelectListBox.setItems(nameItems);

    }

    private void setMultiSelectListBoxSurnameData(MultiSelectListBox multiSelectListBox) {
        List<String> surnameItems = new ArrayList<>();

        getSelectListBoxViewAuthorDatas(surnameItems, "surnameItems");

        multiSelectListBox.setItems(surnameItems);

    }

    private void setMultiSelectListBoxOtherBooksData(MultiSelectListBox multiSelectListBox) {
        List<String> otherBooksItems = new ArrayList<>();

        getSelectListBoxViewAuthorDatas(otherBooksItems, "otherBooksItems");

        multiSelectListBox.setItems(otherBooksItems);

    }

}
