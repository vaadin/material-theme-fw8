package org.vaadin.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

/**
 * Created by jonte on 14/03/2017.
 */
public class NavigationItem extends Button {

    private Component component;

    public NavigationItem(Resource icon, String caption) {
        setPrimaryStyleName("md-naviitem");
        setIcon(icon);
        setCaption(caption);
    }

    public NavigationItem(Resource icon, String caption, Component component) {
        this(icon, caption);
        this.component = component;
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof NavigationItem) {
            return ((NavigationItem) other).getCaption().equals(getCaption());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getCaption().hashCode();
    }

    public Component getComponent() {
        return component;
    }
}
