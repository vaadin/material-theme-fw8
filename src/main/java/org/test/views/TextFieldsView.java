package org.test.views;

import com.vaadin.server.UserError;
import com.vaadin.ui.CssLayout;
import org.test.components.MDTextField;
import org.test.components.MDTextFieldBox;
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
        MDTextField tf1 = createTextField("Floating label", null, null, null, true, true);
        MDTextField tf2 = createTextField("Hint text", null, null, null, false, true);
        MDTextField tf3 = createTextField("Floating label with helper", "Helper information goes here!", "Empty value not allowed", null, true, true);
        MDTextField tf4 = createTextField("Hint text with helper", "Helper information goes here!", "Empty value not allowed", null, false, true);
        MDTextField tf5 = createTextField("Floating label with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, true, true);
        MDTextField tf6 = createTextField("Hint text with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, false, true);

        MDTextFieldBox tf7 = createTextFieldBox("Text field box", "Helper information goes here!", "Empty value not allowed", null, true, true);
        MDTextFieldBox tf8 = createTextFieldBox("Disabled text field box", "Helper information goes here!", "Empty value not allowed", null, true, true);
        tf8.setValue("Input");
        tf8.setValue("");
        tf8.setEnabled(false);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card");
        card.addStyleName(Paddings.All.LARGE);
        card.addStyleName(Spacings.Bottom.LARGE);
        card.setWidth(100, Unit.PERCENTAGE);

        return card;
    }

    private CssLayout createDarkFields() {
        MDTextField tf1 = createTextField("Floating label", null, null, null, true, false);
        MDTextField tf2 = createTextField("Hint text", null, null, null, false, false);
        MDTextField tf3 = createTextField("Floating label with helper", "Helper information goes here!", "Empty value not allowed", null, true, false);
        MDTextField tf4 = createTextField("Hint text with helper", "Helper information goes here!", "Empty value not allowed", null, false, false);
        MDTextField tf5 = createTextField("Floating label with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, true, false);
        MDTextField tf6 = createTextField("Hint text with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, false, false);

        MDTextFieldBox tf7 = createTextFieldBox("Text field box", "Helper information goes here!", "Empty value not allowed", null, true, false);
        MDTextFieldBox tf8 = createTextFieldBox("Label", "Helper information goes here!", null, null, true, false);
        tf8.setValue("Input");
        tf8.setEnabled(false);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card");
        card.addStyleName(Paddings.All.LARGE);
        card.addStyleName(Spacings.Bottom.LARGE);
        card.addStyleName(MaterialColor.GREY_900.getBackgroundColorStyle());
        card.setWidth(100, Unit.PERCENTAGE);

        return card;
    }

    private MDTextField createTextField(String label, String helper, String error, MaterialIcons icon, boolean floating, boolean light) {
        MDTextField tf = new MDTextField(label, light);
        if (helper != null) tf.setHelper(helper);
        if (icon != null) tf.setIcon(icon);
        if (error != null) {
            tf.addValueChangeListener(event -> {
                if (event.getValue() == null || event.getValue().isEmpty()) {
                    tf.setComponentError(new UserError(error));
                } else {
                    tf.setComponentError(null);
                }
            });
            tf.setComponentError(new UserError(error));
        }
        tf.setFloatingLabelEnabled(floating);
        return tf;
    }

    private MDTextFieldBox createTextFieldBox(String label, String helper, String error, MaterialIcons icon, boolean floating, boolean light) {
        MDTextFieldBox tf = new MDTextFieldBox(label, light);
        if (helper != null) tf.setHelper(helper);
        if (icon != null) tf.setIcon(icon);
        if (error != null) {
            tf.addValueChangeListener(event -> {
                if (event.getValue() == null || event.getValue().isEmpty()) {
                    tf.setComponentError(new UserError(error));
                } else {
                    tf.setComponentError(null);
                }
            });
            tf.setComponentError(new UserError(error));
        }
        return tf;
    }
}
