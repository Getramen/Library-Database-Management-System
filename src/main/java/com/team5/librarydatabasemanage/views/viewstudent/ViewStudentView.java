package com.team5.librarydatabasemanage.views.viewstudent;

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

@PageTitle("View Student")
@Route(value = "my-view23", layout = MainLayout.class)
public class ViewStudentView extends Composite<VerticalLayout> {

    public ViewStudentView() {
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
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("View Student");
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
        h5.setText("Student ID");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        hr4.setMinWidth("5px");
        hr4.setMinHeight("5px");
        textItems.setWidth("max-content");
        setMultiSelectListBoxStudentIDData(textItems);
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
        textItems2.setWidth("max-content");
        setMultiSelectListBoxStudentNameData(textItems2);
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
        setMultiSelectListBoxStudentSurnameData(textItems3);
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
        h54.setText("Address");
        h54.setWidth("max-content");
        hr10.setMinWidth("5px");
        hr10.setMinHeight("5px");
        textItems4.setWidth("max-content");
        setMultiSelectListBoxAddressData(textItems4);
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
        h55.setText("Email");
        h55.setWidth("max-content");
        hr12.setMinWidth("5px");
        hr12.setMinHeight("5px");
        textItems5.setWidth("max-content");
        setMultiSelectListBoxEmailData(textItems5);
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
        h56.setText("Tel No");
        h56.setWidth("max-content");
        hr14.setMinWidth("5px");
        hr14.setMinHeight("5px");
        textItems6.setWidth("max-content");
        setMultiSelectListBoxTelNoData(textItems6);
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
        h57.setText("Sex");
        h57.setWidth("max-content");
        hr16.setMinWidth("5px");
        hr16.setMinHeight("5px");
        textItems7.setWidth("max-content");
        setMultiSelectListBoxSexData(textItems7);
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

    private void getSelectListBoxViewStudentDatas(List items, String listName) {
        List<Long> studentID = new ArrayList<>();
        List<String> studentName = new ArrayList<>();
        List<String> studentSurname = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> email = new ArrayList<>();
        List<String> telNo = new ArrayList<>();
        List<String> sex = new ArrayList<>();
        try {
            String query = "SELECT * FROM view_Student";
            ResultSet resultSet = ConnectDatabase.statement.executeQuery(query);
            while (resultSet.next()) {
                studentID.add(resultSet.getLong("Student_ID"));
                studentName.add(resultSet.getString("Student_name"));
                studentSurname.add(resultSet.getString("Student_surname"));
                address.add(resultSet.getString("Address"));
                email.add(resultSet.getString("E_mail"));
                telNo.add(resultSet.getString("Tel_no"));
                sex.add(resultSet.getString("Sex"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        switch (listName) {
            case "studentIDItems":
                for (Long id : studentID) {
                    items.add(Long.toString(id));
                }
                break;
            case "studentNameItems":
                for (String name : studentName) {
                    items.add(name);
                }
                break;
            case "studentSurnameItems":
                for (String surname : studentSurname) {
                    items.add(surname);
                }
                break;
            case "addressItems":
                for (String addr : address) {
                    items.add(addr);
                }
                break;
            case "emailItems":
                for (String mail : email) {
                    items.add(mail);
                }
                break;
            case "telNoItems":
                for (String tel : telNo) {
                    items.add(tel);
                }
                break;
            case "sexItems":
                for (String s : sex) {
                    items.add(s);
                }
                break;
            default:
                break;
        }
    }

    private void setMultiSelectListBoxStudentIDData(MultiSelectListBox multiSelectListBox) {
        List<String> studentIDItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(studentIDItems, "studentIDItems");
        multiSelectListBox.setItems(studentIDItems);
    }

    private void setMultiSelectListBoxStudentNameData(MultiSelectListBox multiSelectListBox) {
        List<String> studentNameItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(studentNameItems, "studentNameItems");
        multiSelectListBox.setItems(studentNameItems);
    }

    private void setMultiSelectListBoxStudentSurnameData(MultiSelectListBox multiSelectListBox) {
        List<String> studentSurnameItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(studentSurnameItems, "studentSurnameItems");
        multiSelectListBox.setItems(studentSurnameItems);
    }

    private void setMultiSelectListBoxAddressData(MultiSelectListBox multiSelectListBox) {
        List<String> addressItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(addressItems, "addressItems");
        multiSelectListBox.setItems(addressItems);
    }

    private void setMultiSelectListBoxEmailData(MultiSelectListBox multiSelectListBox) {
        List<String> emailItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(emailItems, "emailItems");
        multiSelectListBox.setItems(emailItems);
    }

    private void setMultiSelectListBoxTelNoData(MultiSelectListBox multiSelectListBox) {
        List<String> telNoItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(telNoItems, "telNoItems");
        multiSelectListBox.setItems(telNoItems);
    }

    private void setMultiSelectListBoxSexData(MultiSelectListBox multiSelectListBox) {
        List<String> sexItems = new ArrayList<>();
        getSelectListBoxViewStudentDatas(sexItems, "sexItems");
        multiSelectListBox.setItems(sexItems);
    }
}
