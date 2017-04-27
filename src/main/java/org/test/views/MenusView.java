package org.test.views;

import com.vaadin.server.UserError;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.IconGenerator;
import org.test.components.MDComboBox;
import org.test.components.MDTextField;
import org.test.layout.FlexLayout;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.MaterialIcons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonte on 14/03/2017.
 */
public class MenusView extends CssLayout {

    public static final String MERCURY = "Mercury";
    public static final String VENUS = "Venus";
    public static final String EARTH = "Earth";

    List<String> planets = new ArrayList<>();

    private IconGenerator generator = (IconGenerator) o -> {
        if (o.equals(VENUS)) {
            return MaterialIcons.PREGNANT_WOMAN;
        } else if (o.equals(EARTH)) {
            return MaterialIcons.PUBLIC;
        }
        return null;
    };

    public MenusView() {
        addStyleName(Spacings.Bottom.LARGE);
        addStyleName(Spacings.Right.LARGE);

        planets.add(MERCURY);
        planets.add(VENUS);
        planets.add(EARTH);

        addComponents(createLightFields());
        addComponents(createDarkFields());
    }

    private CssLayout createLightFields() {
        MDComboBox tf1 = createComboBox("Floating label", null, null, null, true, true);
        MDComboBox tf2 = createComboBox("Hint text", null, null, null, false, true);
        MDComboBox tf3 = createComboBox("Floating label with helper", "Helper information goes here!", "Empty value not allowed", null, true, true);
        MDComboBox tf4 = createComboBox("Hint text with helper", "Helper information goes here!", "Empty value not allowed", null, false, true);
        MDComboBox tf5 = createComboBox("Floating label with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, true, true);
        MDComboBox tf6 = createComboBox("Hint text with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, false, true);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card" + " " + Paddings.All.LARGE);
        card.setWidth(100, Unit.PERCENTAGE);

        for (MDComboBox cb : new MDComboBox[]{tf1, tf2, tf3, tf4, tf5, tf6}) {
            cb.getField().setItems(planets);
            cb.getField().setItemIconGenerator(generator);
        }

        return card;
    }

    private CssLayout createDarkFields() {
        MDComboBox tf1 = createComboBox("Floating label", null, null, null, true, false);
        MDComboBox tf2 = createComboBox("Hint text", null, null, null, false, false);
        MDComboBox tf3 = createComboBox("Floating label with helper", "Helper information goes here!", "Empty value not allowed", null, true, false);
        MDComboBox tf4 = createComboBox("Hint text with helper", "Helper information goes here!", "Empty value not allowed", null, false, false);
        MDComboBox tf5 = createComboBox("Floating label with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, true, false);
        MDComboBox tf6 = createComboBox("Hint text with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, false, false);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card" + " " + Paddings.All.LARGE + " " + MaterialColor.GREY_800.getBackgroundColorStyle());
        card.setWidth(100, Unit.PERCENTAGE);

        for (MDComboBox cb : new MDComboBox[]{tf1, tf2, tf3, tf4, tf5, tf6}) {
            cb.getField().setItems(planets);
            cb.getField().setItemIconGenerator(generator);
        }

        return card;
    }

    private MDComboBox createComboBox(String label, String helper, String error, MaterialIcons icon, boolean floating, boolean light) {
        MDComboBox cb = new MDComboBox(label, light);
        if (helper != null) cb.setHelper(helper);
        if (icon != null) cb.setIcon(icon);
        if (error != null) {
            cb.addValueChangeListener(event -> {
                if (event.getValue() == null || event.getValue().isEmpty()) {
                    cb.setComponentError(new UserError(error));
                } else {
                    cb.setComponentError(null);
                }
            });
            cb.setComponentError(new UserError(error));
        }
        cb.setFloatingLabelEnabled(floating);
        return cb;
    }
}
