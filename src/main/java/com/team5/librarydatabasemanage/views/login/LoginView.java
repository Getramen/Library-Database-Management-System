package com.team5.librarydatabasemanage.views.login;

import java.sql.SQLException;

import com.team5.librarydatabasemanage.ConnectDatabase;
import com.team5.librarydatabasemanage.views.MainLayout;
import com.team5.librarydatabasemanage.views.removelibrarian.RemoveLibrarianView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Login")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LoginView extends Composite<VerticalLayout> {

    public static int userStatement = 0; // 0 not user, 1 student logged in, 2 librarian logged in
    private TextField textField;
    private PasswordField passwordField;

    public static String userid;
    public static String userName = RemoveLibrarianView.getinfo();

    public LoginView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        Hr hr = new Hr();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H6 h6 = new H6();
        Hr hr2 = new Hr();
        textField = new TextField();
        passwordField = new PasswordField();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Library Database Management System");
        h2.setWidth("max-content");
        hr.setWidth("100%");
        hr.setHeight("5px");
        hr.setMinHeight("5px");
        hr.setMaxHeight("5px");
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setHeight("100%");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.START);
        h6.setText("Login");
        h6.setWidth("max-content");
        hr2.setMinHeight("1px");
        textField.setLabel("ID");
        textField.setWidth("100%");
        passwordField.setLabel("Password");
        passwordField.setWidth("100%");
        buttonPrimary.setText("Login");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(h2);
        getContent().add(hr);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(h6);
        layoutColumn2.add(hr2);
        layoutColumn2.add(textField);
        layoutColumn2.add(passwordField);
        layoutColumn2.add(buttonPrimary);

        buttonPrimary.addClickListener(event -> {
            userStatement = 0;
            loginprocess();
        });
    }

    private int loginprocess() {
        String id = textField.getValue();
        String password = passwordField.getValue();

        try {
            userStatement = ConnectDatabase.searchUser(id, password);
            if (userStatement == 0) {
                Notification.show("Not a User");
            } else if (userStatement == 1) {
                Notification.show("Student Logged in successfully");
                userid = id;

            } else if (userStatement == 2) {
                Notification.show("Librarian Logged in successfully");
                userid = id;
            }
            MainLayout.updateDrawer();
        } catch (SQLException e) {
            Notification.show("Login failed: " + e.getMessage());
            e.printStackTrace();
        }

        MainLayout.updateDrawer();
        return userStatement;
    }

}