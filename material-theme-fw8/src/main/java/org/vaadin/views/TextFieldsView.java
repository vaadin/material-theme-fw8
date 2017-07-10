package org.vaadin.views;

import com.vaadin.server.UserError;
import com.vaadin.ui.CssLayout;
import org.vaadin.components.MDTextField;
import org.vaadin.components.MDTextFieldBox;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Paddings;
import org.vaadin.layout.Spacings;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;

/**
 * Created by jonte on 14/03/2017.
 */
public class TextFieldsView extends CssLayout {

    public TextFieldsView() {
        addStyleName(Spacings.Bottom.LARGE);
        addStyleName(Spacings.Right.LARGE);
        addComponents(createFields(true));
        addComponents(createFields(false));
    }

    private CssLayout createFields(boolean light) {
        MDTextField tf1 = createTextField("Floating label", null, null, null, true, light);
        MDTextField tf2 = createTextField("Hint text", null, null, null, false, light);

        MDTextField tf3 = createTextField("Floating label with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, true, light);
        MDTextField tf4 = createTextField("Hint text with icon and helper", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, false, light);

        MDTextField tf5 = createTextField("Floating label", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, true, light);
        tf5.setValue("Disabled");
        tf5.setEnabled(false);

        MDTextFieldBox tf6 = createTextFieldBox("Text field box", "Helper information goes here!", "Empty value not allowed", null, light);
        MDTextFieldBox tf7 = createTextFieldBox("Text field box", "Helper information goes here!", "Empty value not allowed", MaterialIcons.INPUT, light);

        MDTextFieldBox tf8 = createTextFieldBox("Floating label", "Helper information goes here!", "Empty value not allowed", null, light);
        tf8.setValue("Disabled");
        tf8.setEnabled(false);

        FlexLayout card = new FlexLayout(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8);
        card.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        card.addStyleName("card");
        card.addStyleName(Paddings.All.LARGE);
        card.addStyleName(Spacings.Bottom.LARGE);
        if (!light) card.addStyleName(MaterialColor.GREY_900.getBackgroundColorStyle());
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

    private MDTextFieldBox createTextFieldBox(String label, String helper, String error, MaterialIcons icon, boolean light) {
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
