package org.vaadin.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import org.vaadin.style.Styles;

/**
 * Created by jonte on 30/03/2017.
 */
public class RaisedIconButton extends Button {

    public RaisedIconButton(Resource icon) {
        setIcon(icon);
        initTheme(true);
    }

    public RaisedIconButton(Resource icon, boolean light) {
        setIcon(icon);
        initTheme(light);
    }

    private void initTheme(boolean light) {
        setPrimaryStyleName(light ? Styles.Buttons.RaisedIconButtons.LIGHT : Styles.Buttons.RaisedIconButtons.DARK);
    }
}
