package org.test.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import org.test.style.Styles;

import java.util.ArrayList;

import static org.test.style.Styles.Buttons.Toggle.GROUP;

/**
 * Created by jonte on 14/03/2017.
 */
public class ToggleButtonGroup extends CssLayout {

    public static final String ACTIVE = "active";
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private SelectionMode mode = SelectionMode.MULTI;

    public ToggleButtonGroup() {
        setPrimaryStyleName(GROUP);
    }

    public void setSelectionMode(SelectionMode mode) {
        this.mode = mode;
    }

    public Button addToggleButton(Resource icon) {
        Button button = new Button(icon);
        button.setPrimaryStyleName(Styles.Buttons.Toggle.BUTTON);
        button.addClickListener(event -> selectToggleButton(button));
        buttons.add(button);
        addComponent(button);
        return button;
    }

    public Button addToggleButton(Button button) {
        buttons.add(button);
        addComponent(button);
        return button;
    }

    public void selectToggleButton(Button button) {
        if (!buttons.contains(button)) return;

        if (this.mode == SelectionMode.SINGLE) {
            for (Button b : buttons) {
                b.removeStyleName(ACTIVE);
            }
        }

        if (button.getStyleName().contains(ACTIVE)) {
            button.removeStyleName(ACTIVE);
        } else {
            button.addStyleName(ACTIVE);
        }

        for (Button btn : buttons) {
            if (btn.getStyleName().contains(ACTIVE)) {
                addStyleName("card");
                return;
            }
            removeStyleName("card");
        }
    }

    public enum SelectionMode {
        MULTI, SINGLE
    }

}
