package org.test.components;

import com.vaadin.ui.CheckBox;
import org.test.style.Styles;

/**
 * Created by jonte on 28/04/2017.
 */
public class MDCheckbox extends CheckBox {
    public MDCheckbox() {
        initTheme(true);
    }

    public MDCheckbox(boolean light) {
        initTheme(light);
    }

    public MDCheckbox(String caption) {
        super(caption);
        initTheme(true);
    }

    public MDCheckbox(String caption, boolean light) {
        super(caption);
        initTheme(light);
    }

    private void initTheme(boolean light) {
        setPrimaryStyleName(light ? Styles.CheckBoxes.LIGHT : Styles.CheckBoxes.DARK);
    }
}
