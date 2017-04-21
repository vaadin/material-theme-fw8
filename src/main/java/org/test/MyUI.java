package org.test;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import org.test.components.NavigationDrawer;
import org.test.components.NavigationItem;
import org.test.layout.AppBar;
import org.test.layout.Margins;
import org.test.style.MaterialIcons;
import org.test.views.*;

import javax.servlet.annotation.WebServlet;

@Theme("material-design")
public class MyUI extends UI {

    public static final String BUTTONS = "Buttons";
    public static final String TEXTFIELDS = "Text fields";
    public static final String DATA_TABLES = "Data tables";
    public static final String DIALOGS = "Dialogs";
    public static final String SNACKBARS_TOASTS = "Snackbars & toasts";
    public static final String TABS = "Tabs";
    public static final String SELECTION_CONTROLS = "Selection controls";
    public static final String PICKERS = "Pickers";
    public static final String MENUS = "Menus";
    public static final String TOOLTIPS = "Tooltips";
    public static final String TYPOGRAPHY = "Typography";
    public static final String COLORS = "Colors";

    private CssLayout root;
    private AppBar appBar = new AppBar();
    private CssLayout content = new CssLayout();
    private NavigationDrawer navigationDrawer = new NavigationDrawer();
    private String LISTS;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        root = new CssLayout(appBar, navigationDrawer, content);
        root.setPrimaryStyleName("root");
        root.setSizeFull();
        Responsive.makeResponsive(root);
        setContent(root);

        appBar.getNaviIcon().addClickListener(event -> navigationDrawer.toggle());

        content.setPrimaryStyleName("content");
        content.setSizeFull();

        initNavigationItems();
        initDummyContent();
    }

    private void initDummyContent() {
        CssLayout card = new CssLayout();
        card.setWidth(100, Unit.PERCENTAGE);
        card.setHeight(320, Unit.PIXELS);
        card.addStyleName("card");
        card.addStyleName(Margins.All.LARGE);
        content.addComponent(card);
    }

    private void initNavigationItems() {
        LISTS = "Lists";
        for (String s : new String[]{"Bottom navigation", "Bottom sheets", BUTTONS, "Buttons: Floating Action Button", "Cards", "Chips", COLORS, DATA_TABLES, DIALOGS, "Dividers", "Expansion panels", "Grid lists", LISTS, "Lists: Controls", MENUS, PICKERS, "Progress & activity", SELECTION_CONTROLS, "Sliders", SNACKBARS_TOASTS, "Steppers", "Subheaders", TABS, TEXTFIELDS, "Toolbars", TOOLTIPS, TYPOGRAPHY, "Widgets"}) {
            NavigationItem item = new NavigationItem(s);
            navigationDrawer.addNavigationItem(item);
            item.addClickListener(event -> {
                navigationDrawer.selectNavigationItem(item);
                content.removeAllComponents();
                content.addComponent(item.getView());
            });
            if (s.equals(BUTTONS)) {
                item.setIcon(MaterialIcons.FILE_DOWNLOAD);
                item.setView(new ButtonsView());
            } else if (s.equals(TEXTFIELDS)) {
                item.setIcon(MaterialIcons.TEXT_FIELDS);
                item.setView(new TextFieldsView());
            } else if (s.equals(DATA_TABLES)) {
                item.setIcon(MaterialIcons.GRID_ON);
                item.setView(new DataTablesView());
            } else if (s.equals(SELECTION_CONTROLS)) {
                item.setIcon(MaterialIcons.CHECK_BOX);
                item.setView(new SelectionControlsView());
            } else if (s.equals(PICKERS)) {
                item.setIcon(MaterialIcons.EVENT);
                item.setView(new PickersView());
            } else if (s.equals(MENUS)) {
                item.setIcon(MaterialIcons.MENU);
                item.setView(new MenusView());
            } else if (s.equals(TOOLTIPS)) {
                item.setIcon(MaterialIcons.HELP);
                item.setView(new TooltipsView());
            } else if (s.equals(TABS)) {
                item.setIcon(MaterialIcons.TAB);
                item.setView(new TabsView());
            } else if (s.equals(DIALOGS)) {
                item.setIcon(MaterialIcons.DESKTOP_WINDOWS);
                item.setView(new DialogsView());
            } else if (s.equals(SNACKBARS_TOASTS)) {
                item.setIcon(MaterialIcons.DESKTOP_WINDOWS);
                item.setView(new SnackbarsToastsView());
            } else if (s.equals(TYPOGRAPHY)) {
                item.setIcon(MaterialIcons.TEXT_FORMAT);
                item.setView(new TypographyView());
            } else if (s.equals(COLORS)) {
                item.setIcon(MaterialIcons.PALETTE);
                item.setView(new ColorsView());
            } else if (s.equals(LISTS)) {
                item.setIcon(MaterialIcons.LIST);
                item.setView(new ListsView());
            }
        }
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
