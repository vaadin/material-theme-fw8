package org.vaadin.components.dialogs;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import org.vaadin.layout.FlexItem;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Paddings;
import org.vaadin.layout.Spacings;
import org.vaadin.style.Styles;
import org.vaadin.style.Typography;

/**
 * Created by jonte on 24/03/2017.
 */
public class SimpleDialog extends Window {

    private final FlexLayout content;
    private final FlexLayout footer;
    private Button cancel;
    private Button ok;
    private Label label;

    public SimpleDialog(String title, String message, boolean lightTheme) {
        super(title);
        addStyleName(lightTheme ? Styles.Windows.LIGHT : Styles.Windows.DARK);

        label = new Label(message);
        label.setPrimaryStyleName(lightTheme ? Typography.Dark.Subheader.SECONDARY : Typography.Light.Subheader.SECONDARY);
        label.addStyleName(Paddings.Horizontal.LARGE + " " + Paddings.Bottom.LARGE);

        // Footer
        cancel = new Button("Cancel");
        cancel.setPrimaryStyleName(lightTheme ? Styles.Buttons.Flat.LIGHT : Styles.Buttons.Flat.DARK);
        cancel.addClickListener(e -> close());

        ok = new Button("OK");
        ok.setPrimaryStyleName(lightTheme ? Styles.Buttons.Flat.LIGHT : Styles.Buttons.Flat.DARK);
        ok.addClickListener(e -> close());

        footer = new FlexLayout(cancel, ok);
        footer.setJustifyContent(FlexLayout.JustifyContent.FLEX_END);
        footer.addStyleName(Paddings.All.SMALL + " " + Spacings.Right.SMALL + " " + FlexItem.FlexShrink.SHRINK_0);
        footer.setWidth(100, Unit.PERCENTAGE);

        // Content wrapper
        content = new FlexLayout(FlexLayout.FlexDirection.COLUMN, label, footer);
        setContent(content);
    }

    public String getTitle() {
        return getCaption();
    }

    public void setTitle(String title) {
        setCaption(title);
    }

    public String getMessage() {
        return label.getValue();
    }

    public void setMessage(String message) {
        label.setValue(message);
    }

    public void setAffirmativeActionButtonCaption(String caption) {
        ok.setCaption(caption);
    }

    public void setDismissiveActionButtonCaption(String caption) {
        cancel.setCaption(caption);
    }

    public void setAffirmativeActionButton(Button button) {
        ok = button;
    }

    public Button getAffirmativeActionButton() {
        return ok;
    }

    public void setDismissiveActionButton(Button button) {
        cancel = button;
    }

    public Button getDismissiveActionButton() {
        return cancel;
    }

    public void addAffirmativeActionButtonListener(Button.ClickListener listener) {
        ok.addClickListener(listener);
    }

    public void addDismissiveActionButtonListener(Button.ClickListener listener) {
        cancel.addClickListener(listener);
    }
}
