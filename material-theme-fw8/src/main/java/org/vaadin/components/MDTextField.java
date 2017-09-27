package org.vaadin.components;

import com.vaadin.data.HasValue;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;

/**
 * Created by jonte on 15/03/2017.
 */
public class MDTextField extends CssLayout {

    private static final long serialVersionUID = 1L;

    private Label label = new Label();
    private CssLayout icon = new CssLayout();
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

        this.field.addValueChangeListener(event -> updateFloatingLabelPosition(event.getValue()));

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
            hideIcon();
        } else {
            showIcon(icon.getHtml());
        }
    }

    public void setIcon(String html) {
        if (html == null) {
            hideIcon();
        } else {
            showIcon(html);
        }
    }

    public void setIcon(ThemeResource source) {
        if (source == null) {
            hideIcon();
        } else {
            showImg(source);
        }
    }

    private void hideIcon() {
        this.icon.setVisible(false);
        removeStyleName("with-icon");
    }

    private void showIcon(String html) {
        addStyleName("with-icon");
        this.icon.setVisible(true);
        this.icon.removeAllComponents();
        this.icon.addComponent(new Label(html, ContentMode.HTML));
    }

    private void showImg(ThemeResource source) {
        addStyleName("with-icon");
        this.icon.setVisible(true);
        this.icon.removeAllComponents();
        this.icon.addComponent(new Image(null, source));
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
        updateFloatingLabelPosition(value);
    }

    private void updateFloatingLabelPosition(String value) {
        if (value == null || value.isEmpty()) {
            this.label.addStyleName("hint");
        } else {
            this.label.removeStyleName("hint");
        }
    }
}
