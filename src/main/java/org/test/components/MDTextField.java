package org.test.components;

import com.vaadin.data.HasValue;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.ErrorMessage;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import org.test.style.MaterialIcons;
import org.test.style.Styles;

/**
 * Created by jonte on 15/03/2017.
 */
public class MDTextField extends CssLayout {

    private static final long serialVersionUID = 1L;

    private Label label = new Label();
    private Label icon = new Label();
    private Label helper = new Label();
    private boolean floatingLabelEnabled;
    private String helperText;
    private TextField field = new TextField() {
        @Override
        public void setComponentError(ErrorMessage componentError) {
            super.setComponentError(componentError);
            setError(componentError == null ? null : ((AbstractErrorMessage) componentError).getMessage());
        }
    };

    public MDTextField(String label) {
        this(label, true);
    }

    public MDTextField(String label, boolean light) {
        String primaryStyleName = light ? Styles.TextFields.LIGHT : Styles.TextFields.DARK;
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
            if (floatingLabelEnabled) {
                this.label.removeStyleName("hint");
            } else {
                this.label.addStyleName("fade");
            }

        });
        this.field.addBlurListener(event -> {
            removeStyleName("focus");
            if (floatingLabelEnabled) {
                if (field.getValue().isEmpty()) {
                    this.label.addStyleName("hint");
                }
            } else {
                if (field.getValue().isEmpty()) {
                    this.label.removeStyleName("fade");
                }
            }
        });

        this.helper.setPrimaryStyleName(primaryStyleName + "-helper");
        this.helper.setWidthUndefined();

        addComponents(this.label, icon, field, this.helper);
    }

    public TextField getField() {
        return field;
    }

    public String getLabel() {
        return label.getValue();
    }

    public void setLabel(String label) {
        this.label.setValue(label);
    }

    public String getHelper() {
        return this.helper.getValue();
    }

    public void setHelper(String text) {
        this.helperText = text;

        removeStyleName("error");
        this.helper.setValue(helperText);
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
    }

    public void setIcon(MaterialIcons icon) {
        if (icon == null) {
            this.icon.setVisible(false);
            removeStyleName("with-icon");
        } else {
            addStyleName("with-icon");
            this.icon.setVisible(true);
            this.icon.setValue(icon.getHtml());
        }
    }

    public Registration addValueChangeListener(HasValue.ValueChangeListener<String> listener) {
        return field.addValueChangeListener(listener);
    }

    @Override
    public void setComponentError(ErrorMessage componentError) {
        field.setComponentError(componentError);
    }

    public void setValue(String value) {
        this.field.setValue(value);

        if (value == null || value.isEmpty()) {
            this.label.addStyleName("hint");
        } else {
            this.label.removeStyleName("hint");
        }
    }
}
