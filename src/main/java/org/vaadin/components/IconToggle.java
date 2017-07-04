package org.vaadin.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

/**
 * Created by jonte on 14/03/2017.
 */
public class IconToggle extends Button {

    public static final String INACTIVE = "inactive";

    public IconToggle(Resource icon, String primaryStyleName) {
        setIcon(icon);
        setPrimaryStyleName(primaryStyleName);
        addClickListener(clickEvent -> toggle());
    }

    public void toggle() {
        setActive(getStyleName().contains(INACTIVE));
    }

    public void setActive(boolean active) {
        if (active) removeStyleName(INACTIVE);
        else addStyleName(INACTIVE);
    }

}
