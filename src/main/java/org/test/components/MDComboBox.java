package org.test.components;

import com.vaadin.data.HasValue;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.ErrorMessage;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.IconGenerator;
import com.vaadin.ui.Label;
import org.test.style.MaterialIcons;
import org.test.style.Styles;

import java.util.Collection;

/**
 * Created by jonte on 15/03/2017.
 */
public class MDComboBox extends CssLayout {

    private static final long serialVersionUID = 1L;

    private MaterialIcons defaultIcon;

    private Label label = new Label();
    private Label icon = new Label();
    private ComboBox field = new ComboBox() {
        @Override
        public void setComponentError(ErrorMessage componentError) {
            super.setComponentError(componentError);
            setError(componentError == null ? null : ((AbstractErrorMessage) componentError).getMessage());
        }
    };
    private Label helper = new Label();

    private boolean floatingLabelEnabled;
    private String helperText;

    public MDComboBox(String label) {
        this(label, true);
    }

    public MDComboBox(String label, boolean light) {
        String primaryStyleName = light ? Styles.ComboBoxes.LIGHT : Styles.ComboBoxes.DARK;
        setPrimaryStyleName(primaryStyleName);
        setFloatingLabelEnabled(true);

        this.label.setValue(label);
        this.label.setPrimaryStyleName(primaryStyleName + "-label");
        this.label.addStyleName("hint");
        this.label.setWidthUndefined();

        this.icon.setPrimaryStyleName(primaryStyleName + "-icon");
        this.icon.setContentMode(ContentMode.HTML);
        this.icon.setVisible(false);

        this.field.setPrimaryStyleName(primaryStyleName + "-input");
        this.field.addFocusListener(event -> {
            addStyleName("focus");
            this.label.removeStyleName("hint");
        });
        this.field.addBlurListener(event -> {
            removeStyleName("focus");
            if (field.getValue() == null) {
                this.label.addStyleName("hint");
            }
        });
        this.field.addValueChangeListener(event -> {
            if (this.field.getItemIconGenerator() == null) return;
            setIcon(this.field.getValue() == null ? null : (MaterialIcons) this.field.getItemIconGenerator().apply(this.field.getValue()), false);
        });

        this.helper.setPrimaryStyleName(primaryStyleName + "-helper");
        this.helper.setWidthUndefined();

        addComponents(this.label, icon, field, this.helper);
    }

    public ComboBox getField() {
        return field;
    }

    public void setLabel(String label) {
        this.label.setValue(label);
    }

    public String getLabel() {
        return label.getValue();
    }

    public void setHelper(String text) {
        this.helperText = text;

        removeStyleName("error");
        this.helper.setValue(helperText);
    }

    public String getHelper() {
        return this.helper.getValue();
    }

    public void setError(String text) {
        if (text == null) {
            removeStyleName("error");
            this.helper.setValue(helperText);
        } else {
            addStyleName("error");
            this.helper.setValue(text);
        }
    }

    public void setFloatingLabelEnabled(boolean enabled) {
        this.floatingLabelEnabled = enabled;

        if (enabled) {
            removeStyleName("float-disabled");
        } else {
            addStyleName("float-disabled");
        }

        this.field.setItems();
    }

    public void setIcon(MaterialIcons icon) {
        setIcon(icon, true);
    }

    public void setIcon(MaterialIcons icon, boolean def) {
        if (def) {
            this.defaultIcon = icon;
        }
        if (defaultIcon != null || icon != null) {
            addStyleName("with-icon");
            this.icon.setVisible(true);
            this.icon.setValue(icon != null ? icon.getHtml() : defaultIcon.getHtml());
        } else {
            removeStyleName("with-icon");
            this.icon.setVisible(false);
        }
    }

    public Registration addValueChangeListener(HasValue.ValueChangeListener<String> listener) {
        return field.addValueChangeListener(listener);
    }

    @Override
    public void setComponentError(ErrorMessage componentError) {
        field.setComponentError(componentError);
    }

    public void setItems(Collection items) {
        this.field.setItems(items);
    }

    public void setValue(Object value) {
        this.field.setValue(value);
        if (value == null) {
            this.label.addStyleName("hint");
        } else {
            this.label.removeStyleName("hint");
        }
    }

    public void setSelectedItem(Object item) {
        this.field.setSelectedItem(item);
        if (item == null) {
            this.label.addStyleName("hint");
        } else {
            this.label.removeStyleName("hint");
        }
    }

    public void setItemIconGenerator(IconGenerator itemIconGenerator) {
        this.field.setItemIconGenerator(itemIconGenerator);
    }

}
