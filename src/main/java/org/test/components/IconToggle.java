package org.test.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

/**
 * Created by jonte on 14/03/2017.
 */
public class IconToggle extends Button {

    public static final String ACTIVE = "active";

    public IconToggle(Resource icon, String primaryStyleName) {
        setIcon(icon);
        setPrimaryStyleName(primaryStyleName);
        addClickListener(clickEvent -> toggle());
    }

    public void toggle() {
        if (getStyleName().contains(ACTIVE)) {
            hide();
        } else {
            show();
        }
    }

    public void show() {
        addStyleName(ACTIVE);
    }

    public void hide() {
        removeStyleName(ACTIVE);
    }
}
