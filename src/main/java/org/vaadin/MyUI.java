package org.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Resource;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.vaadin.components.NavigationDrawer;
import org.vaadin.components.NavigationItem;
import org.vaadin.layout.AppBar;
import org.vaadin.layout.Margins;
import org.vaadin.style.MaterialIcons;
import org.vaadin.views.*;

import javax.servlet.annotation.WebServlet;

@Theme("material-design")
public class MyUI extends UI {

    private CssLayout root;
    private AppBar appBar = new AppBar();
    private CssLayout content = new CssLayout();
    private NavigationDrawer navigationDrawer = new NavigationDrawer();

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

    private void addNavItem(Resource icon, String caption, Component view) {
        NavigationItem item = new NavigationItem(icon, caption, view);
        item.addClickListener(event -> {
            navigationDrawer.selectNavigationItem(item);
            content.removeAllComponents();
            content.addComponent(item.getComponent());
        });
        navigationDrawer.addNavigationItem(item);
    }

    private void initNavigationItems() {
        addNavItem(null, "Bottom navigation", new Label("Todo implement"));
        addNavItem(null, "Bottom sheets", new Label("Todo implement"));
        addNavItem(MaterialIcons.FILE_DOWNLOAD, "Buttons", new ButtonsView());
        addNavItem(null, "Buttons: Floating Action Button", new Label("Todo implement"));
        addNavItem(null, "Cards", new Label("Todo implement"));
        addNavItem(null, "Chips", new Label("Todo implement"));
        addNavItem(MaterialIcons.PALETTE, "Colors", new ColorsView());
        addNavItem(MaterialIcons.GRID_ON, "Data tables", new DataTablesView());
        addNavItem(MaterialIcons.DESKTOP_WINDOWS, "Dialogs", new DialogsView());
        addNavItem(null, "Dividers", new Label("Todo implement"));
        addNavItem(null, "Expansion panels", new Label("Todo implement"));
        addNavItem(null, "Grid lists", new Label("Todo implement"));
        addNavItem(MaterialIcons.LIST, "Lists", new ListsView());
        addNavItem(null, "Lists: Controls", new Label("Todo implement"));
        addNavItem(MaterialIcons.MENU, "Menus", new MenusView());
        addNavItem(MaterialIcons.EVENT, "Pickers", new PickersView());
        addNavItem(null, "Progress & activity", new Label("Todo implement"));
        addNavItem(MaterialIcons.CHECK_BOX, "Selection controls", new SelectionControlsView());
        addNavItem(null, "Sliders", new Label("Todo implement"));
        addNavItem(MaterialIcons.DESKTOP_WINDOWS, "Snackbars & toasts", new SnackbarsToastsView());
        addNavItem(null, "Steppers", new Label("Todo implement"));
        addNavItem(null, "Subheaders", new Label("Todo implement"));
        addNavItem(MaterialIcons.TAB, "Tabs", new TabsView());
        addNavItem(MaterialIcons.TEXT_FIELDS, "Text fields", new TextFieldsView());
        addNavItem(null, "Toolbars", new Label("Todo implement"));
        addNavItem(MaterialIcons.HELP, "Tooltips", new TooltipsView());
        addNavItem(MaterialIcons.TEXT_FORMAT, "Typography", new TypographyView());
        addNavItem(null, "Widgets", new Label("Todo implement"));
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
