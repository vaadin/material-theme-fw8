package org.test.components.dialogs;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Window;
import org.test.layout.*;
import org.test.style.Styles;

/**
 * Created by jonte on 24/03/2017.
 */
public class ScrollableDialog extends Window {

    private final FlexLayout content;
    private final FlexLayout footer;
    private final Button cancel;
    private final Button ok;
    private FlexLayout scrollableLayout;

    public ScrollableDialog(String title, boolean lightTheme) {
        super(title);
        setPrimaryStyleName(lightTheme ? Styles.Windows.LIGHT : Styles.Windows.DARK);
        addStyleName(Styles.Windows.SCROLLABLE);

        scrollableLayout = new FlexLayout(FlexLayout.FlexDirection.COLUMN);
        scrollableLayout.setOverflow(FlexLayout.Overflow.AUTO);
        scrollableLayout.addStyleName(Paddings.Horizontal.LARGE);
        scrollableLayout.addStyleName(FlexItem.FlexGrow.GROW_1);

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
        footer.addStyleName(lightTheme ? Borders.Light.TOP : Borders.Dark.TOP);
        footer.setWidth(100, Sizeable.Unit.PERCENTAGE);

        // Content wrapper
        content = new FlexLayout(FlexLayout.FlexDirection.COLUMN, scrollableLayout, footer);
        setContent(content);
    }

    public String getTitle() {
        return getCaption();
    }

    public void setTitle(String title) {
        setCaption(title);
    }

    public void setScrollableContent(Component component) {
        scrollableLayout.removeAllComponents();
        addComponent(component);
    }

    public void addComponent(Component component) {
        scrollableLayout.addComponent(component);
    }

    public void addComponents(Component... components) {
        scrollableLayout.addComponents(components);
    }

    public void setAffirmativeActionButtonCaption(String caption) {
        ok.setCaption(caption);
    }

    public void setDismissiveActionButtonCaption(String caption) {
        cancel.setCaption(caption);
    }

    public Button getAffirmativeActionButton() {
        return ok;
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
