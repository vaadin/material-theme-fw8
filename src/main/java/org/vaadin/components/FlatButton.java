package org.vaadin.components;

import com.vaadin.ui.Button;
import org.vaadin.style.Styles;

/**
 * Created by jonte on 30/03/2017.
 */
public class FlatButton extends Button {

    public FlatButton(String caption) {
        super(caption);
        setPrimaryStyleName(Styles.Buttons.Flat.LIGHT);
    }

    public FlatButton(String caption, boolean light) {
        super(caption);
        setPrimaryStyleName(light ? Styles.Buttons.Flat.LIGHT : Styles.Buttons.Flat.DARK);
    }
}
