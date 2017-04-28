package org.test.components;

import com.vaadin.ui.CheckBox;
import org.test.style.Styles;

/**
 * Created by jonte on 28/04/2017.
 */
public class MDCheckBox extends CheckBox {
    public MDCheckBox() {
        initTheme(true);
    }

    public MDCheckBox(boolean light) {
        initTheme(light);
    }

    public MDCheckBox(String caption) {
        super(caption);
        initTheme(true);
    }

    public MDCheckBox(String caption, boolean light) {
        super(caption);
        initTheme(light);
    }

    private void initTheme(boolean light) {
        setPrimaryStyleName(light ? Styles.CheckBoxes.LIGHT : Styles.CheckBoxes.DARK);
    }
}
