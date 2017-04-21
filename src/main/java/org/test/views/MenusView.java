package org.test.views;

import com.vaadin.server.UserError;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.IconGenerator;
import org.test.components.MDComboBox;
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
        MDComboBox cb1 = new MDComboBox("Floating label");

        MDComboBox cb2 = new MDComboBox("Floating label with helper");
        cb2.setHelper("Helper information goes here!");

        MDComboBox cb3 = new MDComboBox("Hint text");
        cb3.setFloatingLabelEnabled(false);

        MDComboBox cb4 = new MDComboBox("Hint text with helper");
        cb4.setHelper("Helper information goes here!");
        cb4.setFloatingLabelEnabled(false);

        MDComboBox cb5 = new MDComboBox("Floating label with helper");
        cb5.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb5.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb5.setComponentError(null);
            }
        });
        cb5.setComponentError(new UserError("Empty value not allowed"));

        MDComboBox cb6 = new MDComboBox("Hint text with helper");
        cb6.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb6.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb6.setComponentError(null);
            }
        });
        cb6.setFloatingLabelEnabled(false);
        cb6.setComponentError(new UserError("Empty value not allowed"));

        MDComboBox cb7 = new MDComboBox("Floating label with icon");
        cb7.setIcon(MaterialIcons.INPUT, true);

        MDComboBox cb8 = new MDComboBox("Hint text with icon");
        cb8.setFloatingLabelEnabled(false);
        cb8.setIcon(MaterialIcons.INPUT, true);

        MDComboBox cb9 = new MDComboBox("Floating label with icon and helper");
        cb9.setHelper("Helper information goes here!");
        cb9.setIcon(MaterialIcons.INPUT, true);
        cb9.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb9.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb9.setComponentError(null);
            }
        });
        cb9.setComponentError(new UserError("Empty value not allowed"));

        MDComboBox cb10 = new MDComboBox("Hint text with icon and helper");
        cb10.setHelper("Helper information goes here!");
        cb10.setIcon(MaterialIcons.INPUT, true);
        cb10.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb10.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb10.setComponentError(null);
            }
        });
        cb10.setComponentError(new UserError("Empty value not allowed"));
        cb10.setFloatingLabelEnabled(false);

        FlexLayout card = new FlexLayout(cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card" + " " + Paddings.All.LARGE);
        card.setWidth(100, Unit.PERCENTAGE);

        for (MDComboBox cb : new MDComboBox[]{cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10}) {
            cb.getField().setItems(planets);
            cb.getField().setItemIconGenerator(generator);
        }

        return card;
    }

    private CssLayout createDarkFields() {
        MDComboBox cb1 = new MDComboBox("Floating label", false);

        MDComboBox cb2 = new MDComboBox("Floating label with helper", false);
        cb2.setHelper("Helper information goes here!");

        MDComboBox cb3 = new MDComboBox("Hint text", false);
        cb3.setFloatingLabelEnabled(false);

        MDComboBox cb4 = new MDComboBox("Hint text with helper", false);
        cb4.setHelper("Helper information goes here!");
        cb4.setFloatingLabelEnabled(false);

        MDComboBox cb5 = new MDComboBox("Floating label with helper", false);
        cb5.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb5.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb5.setComponentError(null);
            }
        });
        cb5.setComponentError(new UserError("Empty value not allowed"));

        MDComboBox cb6 = new MDComboBox("Hint text with helper", false);
        cb6.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb6.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb6.setComponentError(null);
            }
        });
        cb6.setFloatingLabelEnabled(false);
        cb6.setComponentError(new UserError("Empty value not allowed"));

        MDComboBox cb7 = new MDComboBox("Floating label with icon", false);
        cb7.setIcon(MaterialIcons.INPUT, true);

        MDComboBox cb8 = new MDComboBox("Hint text with icon", false);
        cb8.setFloatingLabelEnabled(false);
        cb8.setIcon(MaterialIcons.INPUT, true);

        MDComboBox cb9 = new MDComboBox("Floating label with icon and helper", false);
        cb9.setHelper("Helper information goes here!");
        cb9.setIcon(MaterialIcons.INPUT, true);
        cb9.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb9.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb9.setComponentError(null);
            }
        });
        cb9.setComponentError(new UserError("Empty value not allowed"));

        MDComboBox cb10 = new MDComboBox("Hint text with icon and helper", false);
        cb10.setHelper("Helper information goes here!");
        cb10.setIcon(MaterialIcons.INPUT, true);
        cb10.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                cb10.setComponentError(new UserError("Empty value not allowed"));
            } else {
                cb10.setComponentError(null);
            }
        });
        cb10.setComponentError(new UserError("Empty value not allowed"));
        cb10.setFloatingLabelEnabled(false);

        FlexLayout card = new FlexLayout(cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card" + " " + Paddings.All.LARGE + " " + MaterialColor.GREY_800.getBackgroundColorStyle());
        card.setWidth(100, Unit.PERCENTAGE);

        for (MDComboBox cb : new MDComboBox[]{cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10}) {
            cb.getField().setItems(planets);
            cb.getField().setItemIconGenerator(generator);
        }

        return card;
    }
}
