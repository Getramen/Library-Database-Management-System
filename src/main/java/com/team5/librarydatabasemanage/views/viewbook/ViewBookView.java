package com.team5.librarydatabasemanage.views.viewbook;

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

@PageTitle("View Book")
@Route(value = "my-view7", layout = MainLayout.class)
public class ViewBookView extends Composite<VerticalLayout> {

    public ViewBookView() {
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
        Hr hr11 = new Hr();
        VerticalLayout layoutColumn7 = new VerticalLayout();
        H5 h55 = new H5();
        Hr hr12 = new Hr();
        MultiSelectListBox textItems5 = new MultiSelectListBox();
        Hr hr13 = new Hr();
        VerticalLayout layoutColumn8 = new VerticalLayout();
        H5 h56 = new H5();
        Hr hr14 = new Hr();
        MultiSelectListBox textItems6 = new MultiSelectListBox();
        Hr hr15 = new Hr();
        VerticalLayout layoutColumn9 = new VerticalLayout();
        H5 h57 = new H5();
        Hr hr16 = new Hr();
        MultiSelectListBox textItems7 = new MultiSelectListBox();
        Hr hr17 = new Hr();
        VerticalLayout layoutColumn10 = new VerticalLayout();
        H5 h58 = new H5();
        Hr hr18 = new Hr();
        MultiSelectListBox textItems8 = new MultiSelectListBox();
        Hr hr19 = new Hr();
        VerticalLayout layoutColumn11 = new VerticalLayout();
        H5 h59 = new H5();
        Hr hr20 = new Hr();
        MultiSelectListBox textItems9 = new MultiSelectListBox();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("View Book");
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
        h5.setText("Book ID");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        hr4.setMinWidth("5px");
        hr4.setMinHeight("5px");
        textItems.setWidth("max-content");
        setMultiSelectListBoxBookIDData(textItems);
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
        h52.setText("Book Name");
        h52.setWidth("max-content");
        hr6.setMinWidth("5px");
        hr6.setMinHeight("5px");
        textItems2.setWidth("max-content");
        setMultiSelectListBoxBookNameData(textItems2);
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
        h53.setText("Author Name");
        h53.setWidth("max-content");
        hr8.setMinWidth("5px");
        hr8.setMinHeight("5px");
        textItems3.setWidth("max-content");
        setMultiSelectListBoxAuthorNameData(textItems3);
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
        h54.setText("Publisher Name");
        h54.setWidth("max-content");
        hr10.setMinWidth("5px");
        hr10.setMinHeight("5px");
        textItems4.setWidth("max-content");
        setMultiSelectListBoxPublisherNameData(textItems4);
        hr11.setMinWidth("5px");
        hr11.setMaxWidth("10px");
        hr11.setHeight("100%");
        hr11.setMinHeight("5px");
        layoutColumn7.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.addClassName(Gap.XSMALL);
        layoutColumn7.addClassName(Padding.XSMALL);
        layoutColumn7.setWidth("min-content");
        layoutColumn7.setHeight("min-content");
        layoutColumn7.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn7.setAlignItems(Alignment.CENTER);
        h55.setText("Library Name");
        h55.setWidth("max-content");
        hr12.setMinWidth("5px");
        hr12.setMinHeight("5px");
        textItems5.setWidth("max-content");
        setMultiSelectListBoxLibraryNameData(textItems5);
        hr13.setMinWidth("5px");
        hr13.setMaxWidth("10px");
        hr13.setHeight("100%");
        hr13.setMinHeight("5px");
        layoutColumn8.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn8);
        layoutColumn8.addClassName(Gap.XSMALL);
        layoutColumn8.addClassName(Padding.XSMALL);
        layoutColumn8.setWidth("min-content");
        layoutColumn8.setHeight("min-content");
        layoutColumn8.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn8.setAlignItems(Alignment.CENTER);
        h56.setText("Location");
        h56.setWidth("max-content");
        hr14.setMinWidth("5px");
        hr14.setMinHeight("5px");
        textItems6.setWidth("max-content");
        setMultiSelectListBoxLocationData(textItems6);
        hr15.setMinWidth("5px");
        hr15.setMaxWidth("10px");
        hr15.setHeight("100%");
        hr15.setMinHeight("5px");
        layoutColumn9.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn9);
        layoutColumn9.addClassName(Gap.XSMALL);
        layoutColumn9.addClassName(Padding.XSMALL);
        layoutColumn9.setWidth("min-content");
        layoutColumn9.setHeight("min-content");
        layoutColumn9.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn9.setAlignItems(Alignment.CENTER);
        h57.setText("Genre");
        h57.setWidth("max-content");
        hr16.setMinWidth("5px");
        hr16.setMinHeight("5px");
        textItems7.setWidth("max-content");
        setMultiSelectListBoxGenreData(textItems7);
        hr17.setMinWidth("5px");
        hr17.setMaxWidth("10px");
        hr17.setHeight("100%");
        hr17.setMinHeight("5px");
        layoutColumn10.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn10);
        layoutColumn10.addClassName(Gap.XSMALL);
        layoutColumn10.addClassName(Padding.XSMALL);
        layoutColumn10.setWidth("min-content");
        layoutColumn10.setHeight("min-content");
        layoutColumn10.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn10.setAlignItems(Alignment.CENTER);
        h58.setText("Release Date");
        h58.setWidth("max-content");
        hr18.setMinWidth("5px");
        hr18.setMinHeight("5px");
        textItems8.setWidth("max-content");
        setMultiSelectListBoxReleaseDateData(textItems8);
        hr19.setMinWidth("5px");
        hr19.setMaxWidth("10px");
        hr19.setHeight("100%");
        hr19.setMinHeight("5px");
        layoutColumn11.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn11);
        layoutColumn11.addClassName(Gap.XSMALL);
        layoutColumn11.addClassName(Padding.XSMALL);
        layoutColumn11.setWidth("min-content");
        layoutColumn11.setHeight("min-content");
        layoutColumn11.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn11.setAlignItems(Alignment.CENTER);
        h59.setText("Pages");
        h59.setWidth("max-content");
        hr20.setMinWidth("5px");
        hr20.setMinHeight("5px");
        textItems9.setWidth("max-content");
        setMultiSelectListBoxPagesData(textItems9);
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
        layoutRow2.add(hr11);
        layoutRow2.add(layoutColumn7);
        layoutColumn7.add(h55);
        layoutColumn7.add(hr12);
        layoutColumn7.add(textItems5);
        layoutRow2.add(hr13);
        layoutRow2.add(layoutColumn8);
        layoutColumn8.add(h56);
        layoutColumn8.add(hr14);
        layoutColumn8.add(textItems6);
        layoutRow2.add(hr15);
        layoutRow2.add(layoutColumn9);
        layoutColumn9.add(h57);
        layoutColumn9.add(hr16);
        layoutColumn9.add(textItems7);
        layoutRow2.add(hr17);
        layoutRow2.add(layoutColumn10);
        layoutColumn10.add(h58);
        layoutColumn10.add(hr18);
        layoutColumn10.add(textItems8);
        layoutRow2.add(hr19);
        layoutRow2.add(layoutColumn11);
        layoutColumn11.add(h59);
        layoutColumn11.add(hr20);
        layoutColumn11.add(textItems9);
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

    private void getSelectListBoxViewBookDatas(List items, String listName) {
        List<Integer> bookID = new ArrayList<>();
        List<String> bookName = new ArrayList<>();
        List<String> authorName = new ArrayList<>();
        List<String> publisherName = new ArrayList<>();
        List<String> libraryName = new ArrayList<>();
        List<String> booksLocation = new ArrayList<>();
        List<String> bookGenre = new ArrayList<>();
        List<String> releaseDate = new ArrayList<>();
        List<Integer> bookPages = new ArrayList<>();
        try {
            String query = "SELECT * FROM view_Book"; // View adını buraya yazın
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);
            while (resultSet.next()) {
                bookID.add(resultSet.getInt("Book_ID"));
                bookName.add(resultSet.getString("Book_name"));
                authorName.add(resultSet.getString("Author_name"));
                publisherName.add(resultSet.getString("Publisher_name"));
                libraryName.add(resultSet.getString("Library_name"));
                booksLocation.add(resultSet.getString("Books_location"));
                bookGenre.add(resultSet.getString("Book_genre"));
                releaseDate.add(resultSet.getString("Release_date"));
                bookPages.add(resultSet.getInt("Book_pages"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        switch (listName) {
            case "bookIDItems":
                for (Integer id : bookID) {
                    items.add(Integer.toString(id));
                }
                break;
            case "bookNameItems":
                for (String name : bookName) {
                    items.add(name);
                }
                break;
            case "authorNameItems":
                for (String author : authorName) {
                    items.add(author);
                }
                break;
            case "publisherNameItems":
                for (String publisher : publisherName) {
                    items.add(publisher);
                }
                break;
            case "libraryNameItems":
                for (String library : libraryName) {
                    items.add(library);
                }
                break;
            case "locationItems":
                for (String location : booksLocation) {
                    items.add(location);
                }
                break;
            case "genreItems":
                for (String genre : bookGenre) {
                    items.add(genre);
                }
                break;
            case "releaseItems":
                for (String release : releaseDate) {
                    items.add(release);
                }
                break;
            case "pagesItems":
                for (int page : bookPages) {
                    items.add(Integer.toString(page));
                }
                break;

            default:
                break;
        }

    }

    private void setMultiSelectListBoxBookIDData(MultiSelectListBox multiSelectListBox) {
        List<String> bookIDItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(bookIDItems, "bookIDItems");

        multiSelectListBox.setItems(bookIDItems);

    }

    private void setMultiSelectListBoxBookNameData(MultiSelectListBox multiSelectListBox) {
        List<String> bookNameItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(bookNameItems, "bookNameItems");

        multiSelectListBox.setItems(bookNameItems);

    }

    private void setMultiSelectListBoxAuthorNameData(MultiSelectListBox multiSelectListBox) {
        List<String> authorNameItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(authorNameItems, "authorNameItems");

        multiSelectListBox.setItems(authorNameItems);

    }

    private void setMultiSelectListBoxPublisherNameData(MultiSelectListBox multiSelectListBox) {
        List<String> publisherNameItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(publisherNameItems, "publisherNameItems");

        multiSelectListBox.setItems(publisherNameItems);

    }

    private void setMultiSelectListBoxLibraryNameData(MultiSelectListBox multiSelectListBox) {
        List<String> libraryNameItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(libraryNameItems, "libraryNameItems");

        multiSelectListBox.setItems(libraryNameItems);

    }

    private void setMultiSelectListBoxLocationData(MultiSelectListBox multiSelectListBox) {
        List<String> locationItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(locationItems, "locationItems");

        multiSelectListBox.setItems(locationItems);

    }

    private void setMultiSelectListBoxGenreData(MultiSelectListBox multiSelectListBox) {
        List<String> genreItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(genreItems, "genreItems");

        multiSelectListBox.setItems(genreItems);

    }

    private void setMultiSelectListBoxReleaseDateData(MultiSelectListBox multiSelectListBox) {
        List<String> releaseItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(releaseItems, "releaseItems");

        multiSelectListBox.setItems(releaseItems);

    }

    private void setMultiSelectListBoxPagesData(MultiSelectListBox multiSelectListBox) {
        List<String> pagesItems = new ArrayList<>();

        getSelectListBoxViewBookDatas(pagesItems, "pagesItems");

        multiSelectListBox.setItems(pagesItems);

    }
}