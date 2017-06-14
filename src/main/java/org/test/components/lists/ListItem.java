package org.test.components.lists;

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import org.test.components.MDCheckbox;
import org.test.style.MaterialColor;
import org.test.style.MaterialIcons;

import static com.vaadin.shared.ui.ContentMode.HTML;

/**
 * Created by jonte on 03/04/2017.
 */
public abstract class ListItem extends CssLayout {

    protected CssLayout content;
    protected ListItemIcon iconPrimary = new ListItemIcon();
    protected ListItemIcon iconSecondary = new ListItemIcon();

    public ListItem() {
        setPrimaryStyleName("md-listitem");
        initContent();
        initIconPrimary();
        initIconSecondary();
    }

    public ListItem(boolean verticalPadding) {
        setPrimaryStyleName("md-listitem");
        if (!verticalPadding) addStyleName("no-pad");
        initContent();
        initIconPrimary();
        initIconSecondary();
    }

    private void initContent() {
        content = new CssLayout();
        content.setPrimaryStyleName("md-listitem-content");
    }

    private void initIconPrimary() {
        iconPrimary.setPrimaryStyleName("md-listitem-icon");
        iconPrimary.addStyleName("primary");
        setPrimaryIconSize(IconSize.SMALL);
        setPrimaryIconFontColor(MaterialColor.DARK_SECONDARY);
        setPrimaryIconVisible(false);
    }

    private void initIconSecondary() {
        iconSecondary.setPrimaryStyleName("md-listitem-icon");
        iconSecondary.addStyleName("secondary");
        setSecondaryIconSize(IconSize.SMALL);
        setSecondaryIconFontColor(MaterialColor.DARK_SECONDARY);
        setSecondaryIconVisible(false);
    }

    public void setPrimaryIconVisible(boolean visible) {
        iconPrimary.setVisible(visible);
    }

    public void setSecondaryIconVisible(boolean visible) {
        iconSecondary.setVisible(visible);
    }


    public void setPrimaryIconFontColor(MaterialColor fontColor) {
        iconPrimary.setFontColor(fontColor);
    }

    public void setSecondaryIconFontColor(MaterialColor fontColor) {
        iconSecondary.setFontColor(fontColor);
    }


    public void setPrimaryIconBackgroundColor(MaterialColor backgroundColor) {
        iconPrimary.setBackgroundColor(backgroundColor);
    }

    public void setSecondaryIconBackgroundColor(MaterialColor backgroundColor) {
        iconSecondary.setBackgroundColor(backgroundColor);
    }


    public void setPrimaryIcon(MaterialIcons icon) {
        iconPrimary.setIcon(icon);
    }

    public void setPrimaryIcon(ThemeResource image) {
        iconPrimary.setIcon(image);
    }

    public void setPrimaryIconSize(IconSize size) {
        iconPrimary.setSize(size);
    }

    public void setPrimaryCheckBox(MDCheckbox checkbox) {
        iconPrimary.setCheckBox(checkbox);
        addPrimaryActionListener(e -> checkbox.setValue(!checkbox.getValue()));
    }

    public ListItemIcon getPrimaryIcon() {
        return iconPrimary;
    }

    public void setSecondaryIcon(MaterialIcons icon) {
        iconSecondary.setIcon(icon);
    }

    public void setSecondaryIcon(ThemeResource image) {
        iconSecondary.setIcon(image);
    }

    public void setSecondaryIconSize(IconSize size) {
        iconSecondary.setSize(size);
    }

    public void setSecondaryCheckBox(MDCheckbox checkbox) { iconSecondary.setCheckBox(checkbox); }

    public ListItemIcon getSecondaryIcon() {
        return iconSecondary;
    }


    public void addPrimaryActionListener(LayoutEvents.LayoutClickListener listener) {
        addStyleName("clickable");
        addLayoutClickListener(listener);
    }

    public void addSecondaryActionListener(LayoutEvents.LayoutClickListener listener) {
        iconSecondary.addStyleName("clickable");
        iconSecondary.addLayoutClickListener(listener);
    }


    public abstract void setTheme(boolean lightTheme);


    public enum IconSize {
        SMALL("small"),
        LARGE("large");

        private String styleName;

        IconSize(String styleName) {
            this.styleName = styleName;
        }

        public String getStyleName() {
            return this.styleName;
        }
    }

    private class ListItemIcon extends CssLayout {

        protected MaterialColor fontColor;
        protected MaterialColor backgroundColor;
        protected IconSize size;

        public ListItemIcon() {
            super();
        }

        public void setFontColor(MaterialColor fontColor) {
            setVisible(true);
            if (this.fontColor != null) removeStyleName(this.fontColor.getFontColorStyle());
            this.fontColor = fontColor;
            addStyleName(this.fontColor.getFontColorStyle());
        }

        public void setBackgroundColor(MaterialColor backgroundColor) {
            setVisible(true);
            if (this.backgroundColor != null) removeStyleName(this.backgroundColor.getBackgroundColorStyle());
            this.backgroundColor = backgroundColor;
            addStyleName(this.backgroundColor.getBackgroundColorStyle());
        }

        public void setIcon(MaterialIcons icon) {
            removeStyleName("image");
            removeAllComponents();
            addComponent(new Label(icon.getHtml(), HTML));
            setVisible(true);
        }

        public void setIcon(ThemeResource image) {
            addStyleName("image");
            removeAllComponents();
            addComponent(new Image(null, image));
            setVisible(true);
        }

        public void setCheckBox(MDCheckbox checkBox) {
            removeStyleName("image");
            removeAllComponents();
            addComponent(checkBox);
            setVisible(true);
        }

        public void setSize(IconSize size) {
            if (this.size != null) removeStyleName(this.size.getStyleName());
            this.size = size;
            addStyleName(this.size.getStyleName());
        }
    }
}
