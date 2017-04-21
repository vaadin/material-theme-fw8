package org.test.components;

import com.vaadin.ui.Button;
import org.test.layout.FlexLayout;
import org.test.style.MaterialIcons;
import org.test.style.Styles;

import java.util.ArrayList;

/**
 * Created by jonte on 23/03/2017.
 */
public class Tabs extends FlexLayout {

    public static final String SELECTED = "selected";
    private final boolean lightTheme;
    private ArrayList<Button> buttons = new ArrayList<Button>();

    public Tabs(boolean lightTheme) { this.lightTheme = lightTheme; }

    public Button addTab(MaterialIcons icon, String text) {
        Button button = new Button(text);
        button.setPrimaryStyleName(lightTheme ? Styles.Tabs.IconText.LIGHT : Styles.Tabs.IconText.DARK);
        button.setIcon(icon);
        button.addClickListener(event -> selectTab(button));
        buttons.add(button);
        addComponent(button);
        return button;
    }

    public Button addTab(MaterialIcons icon) {
        Button button = new Button();
        button.setPrimaryStyleName(lightTheme ? Styles.Tabs.Icon.LIGHT : Styles.Tabs.Icon.DARK);
        button.setIcon(icon);
        button.addClickListener(event -> selectTab(button));
        buttons.add(button);
        addComponent(button);
        return button;
    }

    public Button addTab(String text) {
        Button button = new Button(text);
        button.setPrimaryStyleName(lightTheme ? Styles.Tabs.Text.LIGHT : Styles.Tabs.Text.DARK);
        button.addClickListener(event -> selectTab(button));
        buttons.add(button);
        addComponent(button);
        return button;
    }

    public void selectTab(Button button) {
        if (!buttons.contains(button)) return;

        for (Button b : buttons) {
            b.removeStyleName(SELECTED);
        }

        if (button.getStyleName().contains(SELECTED)) {
            button.removeStyleName(SELECTED);
        } else {
            button.addStyleName(SELECTED);
        }
    }
}
