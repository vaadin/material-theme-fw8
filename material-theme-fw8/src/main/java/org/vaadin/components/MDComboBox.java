package org.vaadin.components;

import com.vaadin.data.HasValue;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;

import java.util.Collection;

import static org.vaadin.style.Styles.TextFields.FloatingLabel.RESTING;

/**
 * Created by jonte on 15/03/2017.
 */
public class MDComboBox<T> extends CssLayout {

    private static final long serialVersionUID = 1L;

    private Resource defaultIcon;

    private IconGenerator<T> generator;

    private Label label = new Label();
    private CssLayout icon = new CssLayout();
    private Label helper = new Label();
    private boolean floatingLabelEnabled;
    private String helperText;
    private ComboBox<T> field = new ComboBox<T>() {
        @Override
        public void setComponentError(ErrorMessage componentError) {
            super.setComponentError(componentError);
            setError(componentError == null ? null : ((AbstractErrorMessage) componentError).getMessage());
        }
    };

    public MDComboBox(String label) {
        this(label, true);
    }

    public MDComboBox(String label, boolean light) {
        String primaryStyleName = light ? Styles.ComboBoxes.LIGHT : Styles.ComboBoxes.DARK;
        setPrimaryStyleName(primaryStyleName);

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
        this.field.addValueChangeListener(event -> {
            if (generator != null) {
                Resource itemIcon = generator.apply(event.getValue());
                if (itemIcon instanceof MaterialIcons) setIcon((MaterialIcons) itemIcon);
                else setIcon(itemIcon);
            }
            updateFloatingLabelPosition(event.getValue());
        });

        this.helper.setPrimaryStyleName(primaryStyleName + "-helper");
        this.helper.setWidthUndefined();

        addComponents(this.label, icon, field, this.helper);

        setFloatingLabelEnabled(true);
    }

    public ComboBox<T> getField() {
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

    public void setEmptySelectionAllowed(boolean emptySelectionAllowed) {
        this.field.setEmptySelectionAllowed(emptySelectionAllowed);
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

    public void setDefaultIcon(Resource icon) {
        this.defaultIcon = icon;
        if (icon instanceof MaterialIcons) {
            setIcon((MaterialIcons) icon);
        } else {
            setIcon(icon);
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
        if (defaultIcon != null) {
            if (defaultIcon instanceof MaterialIcons) {
                setIcon((MaterialIcons) defaultIcon);
            } else {
                setIcon(defaultIcon);
            }
        } else {
            removeStyleName("with-icon");
        }
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

    public Registration addValueChangeListener(HasValue.ValueChangeListener<T> listener) {
        return field.addValueChangeListener(listener);
    }

    @Override
    public void setComponentError(ErrorMessage componentError) {
        field.setComponentError(componentError);
    }

    public void setItems(Collection<T> items) {
        this.field.setItems(items);
    }

    public void setValue(T value) {
        this.field.setValue(value);
        updateFloatingLabelPosition(value);
    }

    public void setSelectedItem(T item) {
        this.field.setSelectedItem(item);
        updateFloatingLabelPosition(item);
    }

    public void setItemIconGenerator(IconGenerator generator) {
        this.generator = generator;
        this.field.setItemIconGenerator(generator);
    }

    private void updateFloatingLabelPosition(T value) {
        // Focused
        if (getStyleName().contains("focus")) {

            // Floating
            if (floatingLabelEnabled) this.label.removeStyleName(Styles.TextFields.FloatingLabel.RESTING);

                // Non-floating
            else this.label.addStyleName(Styles.TextFields.FloatingLabel.HIDE);
        }

        // Not focused
        else {

            // Floating
            if (floatingLabelEnabled) {
                if (value == null) this.label.addStyleName(Styles.TextFields.FloatingLabel.RESTING);
                else this.label.removeStyleName(Styles.TextFields.FloatingLabel.RESTING);
            }

            // Non-floating
            else {
                if (value == null) this.label.removeStyleName(Styles.TextFields.FloatingLabel.HIDE);
                else this.label.addStyleName(Styles.TextFields.FloatingLabel.HIDE);
            }
        }
    }

    public void setTextInputAllowed(boolean textInputAllowed) {
        this.field.setTextInputAllowed(textInputAllowed);
    }

}
