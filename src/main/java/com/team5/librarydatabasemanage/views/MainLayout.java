package com.team5.librarydatabasemanage.views;

import org.vaadin.lineawesome.LineAwesomeIcon;

import com.team5.librarydatabasemanage.views.addauthor.AddAuthorView;
import com.team5.librarydatabasemanage.views.addbooks.AddBooksView;
import com.team5.librarydatabasemanage.views.addlibrarian.AddLibrarianView;
import com.team5.librarydatabasemanage.views.addlibrary.AddLibraryView;
import com.team5.librarydatabasemanage.views.addloan.AddLoanView;
import com.team5.librarydatabasemanage.views.addpublisher.AddPublisherView;
import com.team5.librarydatabasemanage.views.addstudent.AddStudentView;
import com.team5.librarydatabasemanage.views.bookcomments.BookCommentsView;
import com.team5.librarydatabasemanage.views.login.LoginView;
import com.team5.librarydatabasemanage.views.removeauthor.RemoveAuthorView;
import com.team5.librarydatabasemanage.views.removebook.RemoveBookView;
import com.team5.librarydatabasemanage.views.removelibrarian.RemoveLibrarianView;
import com.team5.librarydatabasemanage.views.removelibrary.RemoveLibraryView;
import com.team5.librarydatabasemanage.views.removeloan.RemoveLoanView;
import com.team5.librarydatabasemanage.views.removepublisher.RemovePublisherView;
import com.team5.librarydatabasemanage.views.removestudent.RemoveStudentView;
import com.team5.librarydatabasemanage.views.runsqlcommands.RunSQLCommandsView;
import com.team5.librarydatabasemanage.views.signin.SigninView;
import com.team5.librarydatabasemanage.views.usersettings.UserSettingsView;
import com.team5.librarydatabasemanage.views.viewauthor.ViewAuthorView;
import com.team5.librarydatabasemanage.views.viewbook.ViewBookView;
import com.team5.librarydatabasemanage.views.viewlibrarian.ViewLibrarianView;
import com.team5.librarydatabasemanage.views.viewlibrary.ViewLibraryView;
import com.team5.librarydatabasemanage.views.viewloanprocess.ViewLoanProcessView;
import com.team5.librarydatabasemanage.views.viewpublisher.ViewPublisherView;
import com.team5.librarydatabasemanage.views.viewstudent.ViewStudentView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

        private H1 viewTitle;
        public static SideNav nav;
        public static Scroller scroller;

        public MainLayout() {
                setPrimarySection(Section.DRAWER);
                addDrawerContent();
                addHeaderContent();
        }

        public void addHeaderContent() {
                DrawerToggle toggle = new DrawerToggle();
                toggle.setAriaLabel("Menu toggle");

                viewTitle = new H1();
                viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

                addToNavbar(true, toggle, viewTitle);
        }

        public void addDrawerContent() {
                Span appName = new Span("Library");
                appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
                Header header = new Header(appName);

                scroller = new Scroller(createNavigation());

                addToDrawer(header, scroller, createFooter());
        }

        public static void updateDrawer() {
                scroller.setContent(createNavigation());
                MainLayout.get().getElement().executeJs("this.requestUpdate()"); // AppLayout bileşenini güncelle
        }

        private static Composite<VerticalLayout> get() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'get'");
        }

        public static SideNav createNavigation() {
                nav = new SideNav();

                nav.removeAll();

                if (LoginView.userStatement == 0) {
                        nav.addItem(new SideNavItem("Login", LoginView.class, LineAwesomeIcon.KEY_SOLID.create()));
                        nav.addItem(new SideNavItem("Sign in", SigninView.class, LineAwesomeIcon.KEY_SOLID.create()));
                }

                if (LoginView.userStatement == 1) {
                        nav.addItem(new SideNavItem("Login", LoginView.class, LineAwesomeIcon.KEY_SOLID.create()));
                        nav.addItem(new SideNavItem("Sign in", SigninView.class, LineAwesomeIcon.KEY_SOLID.create()));
                        nav.addItem(new SideNavItem("View Book", ViewBookView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("View Author", ViewAuthorView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("View Publisher", ViewPublisherView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("View Library", ViewLibraryView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("Book Comments", BookCommentsView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("User Settings", UserSettingsView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                }

                if (LoginView.userStatement == 2) {
                        nav.addItem(new SideNavItem("Login", LoginView.class, LineAwesomeIcon.KEY_SOLID.create()));
                        nav.addItem(new SideNavItem("Sign in", SigninView.class, LineAwesomeIcon.KEY_SOLID.create()));
                        nav.addItem(new SideNavItem("View Book", ViewBookView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("View Author", ViewAuthorView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("View Publisher", ViewPublisherView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("View Library", ViewLibraryView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("View Librarian", ViewLibrarianView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("View Student", ViewStudentView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("View Loan Process", ViewLoanProcessView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Add Books", AddBooksView.class,
                                        LineAwesomeIcon.ADDRESS_BOOK_SOLID.create()));
                        nav.addItem(new SideNavItem("Remove Book", RemoveBookView.class,
                                        LineAwesomeIcon.ADDRESS_BOOK_SOLID.create()));
                        nav.addItem(new SideNavItem("Add Author", AddAuthorView.class,
                                        LineAwesomeIcon.AUTOPREFIXER.create()));
                        nav.addItem(new SideNavItem("Remove Author", RemoveAuthorView.class,
                                        LineAwesomeIcon.AUTOPREFIXER.create()));
                        nav.addItem(
                                        new SideNavItem("Add Publisher", AddPublisherView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Remove Publisher", RemovePublisherView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Add Library", AddLibraryView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Remove Library", RemoveLibraryView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Add Loan", AddLoanView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Remove Loan", RemoveLoanView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Add Student", AddStudentView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Remove Student", RemoveStudentView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("Add Librarian", AddLibrarianView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));

                        nav.addItem(new SideNavItem("Remove Librarian", RemoveLibrarianView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(new SideNavItem("Run SQL Commands", RunSQLCommandsView.class,
                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("Book Comments", BookCommentsView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                        nav.addItem(
                                        new SideNavItem("User Settings", UserSettingsView.class,
                                                        LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
                }

                return nav;
        }

        private static Footer createFooter() {
                Footer layout = new Footer();

                return layout;
        }

        @Override
        protected void afterNavigation() {
                super.afterNavigation();
                viewTitle.setText(getCurrentPageTitle());
        }

        private String getCurrentPageTitle() {
                PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
                return title == null ? "" : title.value();
        }
}
