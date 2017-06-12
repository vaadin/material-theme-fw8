package org.test.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

import java.util.Objects;

/**
 * Created by jonte on 14/03/2017.
 */
public class NavigationItem extends Button {

    private final Component view;

    public NavigationItem(Resource icon, String caption, Component view) {
        setPrimaryStyleName("md-naviitem");
        setIcon(icon);
        setCaption(caption);
        this.view = Objects.requireNonNull(view);
    }

    public Component getView() {
        return view;
    }
}
