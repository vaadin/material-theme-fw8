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

    public Component getComponent() {
        return component;
    }
}
