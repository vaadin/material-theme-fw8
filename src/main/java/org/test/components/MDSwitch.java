package org.test.components;

import com.vaadin.ui.CheckBox;
import org.test.style.Styles;

/**
 * Created by jonte on 28/04/2017.
 */
public class MDSwitch extends CheckBox {
    public MDSwitch() {
        initTheme(true);
    }

    public MDSwitch(boolean light) {
        initTheme(light);
    }

    public MDSwitch(String caption) {
        super(caption);
        initTheme(true);
    }

    public MDSwitch(String caption, boolean light) {
        super(caption);
        initTheme(light);
    }

    private void initTheme(boolean light) {
        setPrimaryStyleName(light ? Styles.Switches.LIGHT : Styles.Switches.DARK);
    }
}
