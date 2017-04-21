package org.test.components;

import com.vaadin.ui.CssLayout;

import java.util.ArrayList;

/**
 * Created by jonte on 13/03/2017.
 */
public class NavigationDrawer extends CssLayout {

    public static final String VISIBLE = "visible";
    public static final String NAVIGATION_DRAWER = "md-navidrawer";
    public static final String SELECTED = "selected";

    ArrayList<NavigationItem> items = new ArrayList<NavigationItem>();

    public NavigationDrawer() {
        super();
        setPrimaryStyleName(NAVIGATION_DRAWER);
        addStyleName(VISIBLE);
    }

    public void toggle() {
        if (getStyleName().contains(VISIBLE)) {
            hide();
        } else {
            show();
        }
    }

    public void show() {
        addStyleName(VISIBLE);
    }

    public void hide() {
        removeStyleName(VISIBLE);
    }

    public void addNavigationItem(NavigationItem item) {
        items.add(item);
        addComponent(item);
    }

    public void selectNavigationItem(NavigationItem item) {
        if (!items.contains(item)) return;

        for (NavigationItem navigationItem : items) {
            navigationItem.removeStyleName(SELECTED);
        }
        item.addStyleName(SELECTED);
    }
}
