package org.test.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

/**
 * Created by jonte on 14/03/2017.
 */
public class NavigationItem extends Button {

    private Component view;

    public NavigationItem(Resource icon, String caption) {
        setPrimaryStyleName("md-naviitem");
        setIcon(icon);
        setCaption(caption);
    }

    public NavigationItem(String caption) {
        setPrimaryStyleName("md-naviitem");
        setCaption(caption);
    }

    public Component getView() {
        return view;
    }

    public void setView(Component view) {
        this.view = view;
    }
}
