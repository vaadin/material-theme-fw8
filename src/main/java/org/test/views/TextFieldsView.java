package org.test.views;

import com.vaadin.server.UserError;
import com.vaadin.ui.CssLayout;
import org.test.components.MDTextField;
import org.test.layout.FlexLayout;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.MaterialIcons;

/**
 * Created by jonte on 14/03/2017.
 */
public class TextFieldsView extends CssLayout {

    public TextFieldsView() {
        addStyleName(Spacings.Bottom.LARGE);
        addStyleName(Spacings.Right.LARGE);

        addComponents(createLightFields());
        addComponents(createDarkFields());

    }

    private CssLayout createLightFields() {
        MDTextField tf1 = new MDTextField("Floating label");

        MDTextField tf2 = new MDTextField("Floating label with helper");
        tf2.setHelper("Helper information goes here!");

        MDTextField tf3 = new MDTextField("Hint text");
        tf3.setFloatingLabelEnabled(false);

        MDTextField tf4 = new MDTextField("Hint text with helper");
        tf4.setHelper("Helper information goes here!");
        tf4.setFloatingLabelEnabled(false);

        MDTextField tf5 = new MDTextField("Floating label with helper");
        tf5.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf5.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf5.setComponentError(null);
            }
        });
        tf5.setComponentError(new UserError("Empty value not allowed"));

        MDTextField tf6 = new MDTextField("Hint text with helper");
        tf6.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf6.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf6.setComponentError(null);
            }
        });
        tf6.setFloatingLabelEnabled(false);
        tf6.setComponentError(new UserError("Empty value not allowed"));

        MDTextField tf7 = new MDTextField("Floating label with icon");
        tf7.setIcon(MaterialIcons.INPUT);

        MDTextField tf8 = new MDTextField("Hint text with icon");
        tf8.setFloatingLabelEnabled(false);
        tf8.setIcon(MaterialIcons.INPUT);

        MDTextField tf9 = new MDTextField("Floating label with icon and helper");
        tf9.setHelper("Helper information goes here!");
        tf9.setIcon(MaterialIcons.INPUT);
        tf9.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf9.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf9.setComponentError(null);
            }
        });
        tf9.setComponentError(new UserError("Empty value not allowed"));

        MDTextField tf10 = new MDTextField("Hint text with icon and helper");
        tf10.setHelper("Helper information goes here!");
        tf10.setIcon(MaterialIcons.INPUT);
        tf10.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf10.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf10.setComponentError(null);
            }
        });
        tf10.setComponentError(new UserError("Empty value not allowed"));
        tf10.setFloatingLabelEnabled(false);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card");
        card.addStyleName(Paddings.All.LARGE);
        card.setWidth(100, Unit.PERCENTAGE);

        return card;
    }

    private CssLayout createDarkFields() {
        MDTextField tf1 = new MDTextField("Floating label", false);

        MDTextField tf2 = new MDTextField("Floating label with helper", false);
        tf2.setHelper("Helper information goes here!");

        MDTextField tf3 = new MDTextField("Hint text", false);
        tf3.setFloatingLabelEnabled(false);

        MDTextField tf4 = new MDTextField("Hint text with helper", false);
        tf4.setHelper("Helper information goes here!");
        tf4.setFloatingLabelEnabled(false);

        MDTextField tf5 = new MDTextField("Floating label with helper", false);
        tf5.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf5.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf5.setComponentError(null);
            }
        });
        tf5.setComponentError(new UserError("Empty value not allowed"));

        MDTextField tf6 = new MDTextField("Hint text with helper", false);
        tf6.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf6.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf6.setComponentError(null);
            }
        });
        tf6.setFloatingLabelEnabled(false);
        tf6.setComponentError(new UserError("Empty value not allowed"));

        MDTextField tf7 = new MDTextField("Floating label with icon", false);
        tf7.setIcon(MaterialIcons.INPUT);

        MDTextField tf8 = new MDTextField("Hint text with icon", false);
        tf8.setFloatingLabelEnabled(false);
        tf8.setIcon(MaterialIcons.INPUT);

        MDTextField tf9 = new MDTextField("Floating label with icon and helper", false);
        tf9.setHelper("Helper information goes here!");
        tf9.setIcon(MaterialIcons.INPUT);
        tf9.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf9.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf9.setComponentError(null);
            }
        });
        tf9.setComponentError(new UserError("Empty value not allowed"));

        MDTextField tf10 = new MDTextField("Hint text with icon and helper", false);
        tf10.setHelper("Helper information goes here!");
        tf10.setIcon(MaterialIcons.INPUT);
        tf10.addValueChangeListener(event -> {
            if (event.getValue() == null || event.getValue().isEmpty()) {
                tf10.setComponentError(new UserError("Empty value not allowed"));
            } else {
                tf10.setComponentError(null);
            }
        });
        tf10.setComponentError(new UserError("Empty value not allowed"));
        tf10.setFloatingLabelEnabled(false);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card");
        card.addStyleName(Paddings.All.LARGE);
        card.addStyleName(MaterialColor.GREY_900.getBackgroundColorStyle());
        card.setWidth(100, Unit.PERCENTAGE);

        return card;
    }
}
