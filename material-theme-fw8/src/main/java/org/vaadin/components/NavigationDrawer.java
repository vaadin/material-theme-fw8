package org.vaadin.components;

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
        this(true);
    }

    public NavigationDrawer(boolean visible) {
        super();
        setPrimaryStyleName(NAVIGATION_DRAWER);
        if (visible) {
            show();
        }
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
        for (NavigationItem current : items) {
            if (current.getCaption().equals(item.getCaption())) {
                item = current; // make sure we get the shown one, even when an equal item is passed in for reference.
                break;
            }
        }

        // Note that Vaadin Framework 8 assumes that 'equals'/'hashCode'
        // are not overridden in all implementations of Component.
        // Hence we do not override those in NavigationItem directly.

        for (NavigationItem navigationItem : items) {
            navigationItem.removeStyleName(SELECTED);
        }
        item.addStyleName(SELECTED);
    }
}
