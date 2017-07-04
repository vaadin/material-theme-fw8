package org.vaadin.components;

import com.vaadin.ui.Button;
import org.vaadin.style.Styles;

/**
 * Created by jonte on 30/03/2017.
 */
public class RaisedButton extends Button {

    public RaisedButton(String caption) {
        super(caption);
        setPrimaryStyleName(Styles.Buttons.Raised.LIGHT);
    }

    public RaisedButton(String caption, boolean light) {
        super(caption);
        setPrimaryStyleName(light ? Styles.Buttons.Raised.LIGHT : Styles.Buttons.Raised.DARK);
    }
}
