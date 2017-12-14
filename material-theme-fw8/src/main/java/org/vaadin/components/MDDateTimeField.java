package org.vaadin.components;

import com.vaadin.data.HasValue;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;

import java.time.LocalDateTime;

import static org.vaadin.style.Styles.TextFields.FloatingLabel.RESTING;

/**
 * Created by jonte on 15/03/2017.
 */
public class MDDateTimeField extends CssLayout {

    private static final long serialVersionUID = 1L;

    private Label label = new Label();
    private CssLayout icon = new CssLayout();
    private Label helper = new Label();
    private boolean floatingLabelEnabled;
    private String helperText;
    private DateTimeField field = new DateTimeField() {
        @Override
        public void setComponentError(ErrorMessage componentError) {
            super.setComponentError(componentError);
            setError(componentError == null ? null : ((AbstractErrorMessage) componentError).getMessage());
        }
    };

    public MDDateTimeField(String label) {
        this(label, true);
    }

    public MDDateTimeField(String label, boolean light) {
        String primaryStyleName = light ? Styles.DateFields.LIGHT : Styles.DateFields.DARK;
        setPrimaryStyleName(primaryStyleName);
        setFloatingLabelEnabled(true);

        this.label.setValue(label);
        this.label.setPrimaryStyleName(primaryStyleName + "-label");
        this.label.addStyleName(RESTING);
        this.label.setWidthUndefined();

        this.icon.setPrimaryStyleName(primaryStyleName + "-icon");

        this.field.setPrimaryStyleName(primaryStyleName + "-input");
        this.field.addFocusListener(event -> {
            addStyleName("focus");
            updateFloatingLabelPosition(this.field.getValue());
        });
        this.field.addBlurListener(event -> {
            removeStyleName("focus");
            updateFloatingLabelPosition(this.field.getValue());
        });

        this.field.addValueChangeListener(event -> updateFloatingLabelPosition(event.getValue()));

        this.helper.setPrimaryStyleName(primaryStyleName + "-helper");
        this.helper.setWidthUndefined();

        addComponents(this.label, icon, field, this.helper);
    }

    public DateTimeField getField() {
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

    public void setIcon(Resource source) {
        if (source == null) {
            hideIcon();
        } else {
            showImg(source);
        }
    }

    private void hideIcon() {
        removeStyleName("with-icon");
    }

    private void showIcon(String html) {
        addStyleName("with-icon");
        this.icon.removeAllComponents();
        this.icon.addComponent(new Label(html, ContentMode.HTML));
    }

    private void showImg(Resource source) {
        addStyleName("with-icon");
        this.icon.removeAllComponents();
        this.icon.addComponent(new Image(null, source));
    }

    public Registration addValueChangeListener(HasValue.ValueChangeListener<LocalDateTime> listener) {
        return field.addValueChangeListener(listener);
    }

    @Override
    public void setComponentError(ErrorMessage componentError) {
        field.setComponentError(componentError);
    }

    public void setValue(LocalDateTime value) {
        this.field.setValue(value);
        updateFloatingLabelPosition(value);
    }

    private void updateFloatingLabelPosition(LocalDateTime value) {
        // Focused
        if (getStyleName().contains("focus")) {

            // Floating
            if (floatingLabelEnabled) this.label.removeStyleName(RESTING);

            // Non-floating
            else this.label.addStyleName(Styles.TextFields.FloatingLabel.HIDE);
        }

        // Not focused
        else {

            // Floating
            if (floatingLabelEnabled) {
                if (value == null) this.label.addStyleName(RESTING);
                else this.label.removeStyleName(Styles.TextFields.FloatingLabel.RESTING);
            }

            // Non-floating
            else {
                if (value == null) this.label.removeStyleName(Styles.TextFields.FloatingLabel.HIDE);
                else this.label.addStyleName(Styles.TextFields.FloatingLabel.HIDE);
            }
        }
    }

}
