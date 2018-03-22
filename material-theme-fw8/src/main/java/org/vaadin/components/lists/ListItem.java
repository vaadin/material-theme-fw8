package org.vaadin.components.lists;

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import org.vaadin.components.IconButton;
import org.vaadin.components.MDCheckbox;
import org.vaadin.layout.FlexLayout;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;

import static com.vaadin.shared.ui.ContentMode.HTML;

/**
 * Created by jonte on 03/04/2017.
 */
public abstract class ListItem extends CssLayout {

    protected FlexLayout content = new FlexLayout();
    protected CssLayout actionPrimary = new CssLayout();
    protected CssLayout actionSecondary = new CssLayout();
    protected CssLayout divider = new CssLayout();
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
        content.setPrimaryStyleName("md-listitem-content");
        content.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        content.setOverflow(FlexLayout.Overflow.HIDDEN);

        actionPrimary.setPrimaryStyleName("md-listitem-primary");
        actionSecondary.setPrimaryStyleName("md-listitem-secondary");

        divider.setPrimaryStyleName("md-listitem-divider");
        divider.addStyleName(MaterialColor.DARK_DIVIDER.getBackgroundColorStyle());
        divider.setVisible(false);
    }


    public FlexLayout getContentLayout() {
        return content;
    }

    public CssLayout getPrimaryLayout() {
        return actionPrimary;
    }

    public CssLayout getSecondaryLayout() {
        return actionSecondary;
    }

    public void enableWrap(boolean horizontalPadding) {
        setHeightUndefined();
        content.addStyleName("wrap");
    };

    public void disableWrap() {
        content.removeStyleName("wrap");
    };

    public void setInsetDividerVisible(boolean visible) {
        divider.setVisible(visible);
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
        setPrimaryIconVisible(true);
        iconPrimary.setBackgroundColor(backgroundColor);
    }

    public void setSecondaryIconBackgroundColor(MaterialColor backgroundColor) {
        setSecondaryIconVisible(true);
        iconSecondary.setBackgroundColor(backgroundColor);
    }


    public void setPrimaryIcon(MaterialIcons icon) {
        setPrimaryIconVisible(true);
        iconPrimary.setIcon(icon);
    }

    public void setPrimaryIcon(String html) {
        setPrimaryIconVisible(true);
        iconPrimary.setIcon(html);
    }

    public void setPrimaryIconSize(IconSize size) {
        iconPrimary.setSize(size);
    }

    public void setPrimaryCheckBox(MDCheckbox checkbox) {
        setPrimaryIconVisible(true);
        iconPrimary.setCheckBox(checkbox);
        addPrimaryActionListener((LayoutEvents.LayoutClickListener) e -> checkbox.setValue(!checkbox.getValue()));
    }

    public void setPrimaryIconButton(IconButton button) {
        setPrimaryIconVisible(true);
        iconPrimary.setIconButton(button);
    }

    public void setPrimaryIconCircular(boolean circular) {
        this.iconPrimary.setCircular(circular);
    }

    public ListItemIcon getPrimaryIcon() {
        return iconPrimary;
    }

    public void setPrimaryIcon(Resource image) {
        setPrimaryIconVisible(true);
        iconPrimary.setIcon(image);
    }

    public void setSecondaryIcon(MaterialIcons icon) {
        setSecondaryIconVisible(true);
        iconSecondary.setIcon(icon);
    }

    public void setSecondaryIcon(String html) {
        setSecondaryIconVisible(true);
        iconSecondary.setIcon(html);
    }

    public void setSecondaryIconSize(IconSize size) {
        iconSecondary.setSize(size);
    }

    public void setSecondaryCheckBox(MDCheckbox checkbox) {
        setSecondaryIconVisible(true);
        iconSecondary.setCheckBox(checkbox);
        addSecondaryActionListener((LayoutEvents.LayoutClickListener) e -> checkbox.setValue(!checkbox.getValue()));
    }

    public void setSecondaryIconButton(IconButton button) {
        setSecondaryIconVisible(true);
        iconSecondary.setIconButton(button);
    }

    public void setSecondaryIconCircular(boolean circular) {
        this.iconSecondary.setCircular(circular);
    }

    public ListItemIcon getSecondaryIcon() {
        return iconSecondary;
    }

    public void setSecondaryIcon(ThemeResource image) {
        setSecondaryIconVisible(true);
        iconSecondary.setIcon(image);
    }

    public void addPrimaryActionListener(LayoutEvents.LayoutClickListener listener) {
        addStyleName("clickable");
        actionPrimary.addLayoutClickListener(listener);
    }

    public void addSecondaryActionListener(LayoutEvents.LayoutClickListener listener) {
        addStyleName("clickable");
        actionSecondary.addLayoutClickListener(listener);
    }


    public void setTheme(boolean lightTheme) {
        divider.removeStyleName(lightTheme ? MaterialColor.LIGHT_DIVIDER.getBackgroundColorStyle() : MaterialColor.DARK_DIVIDER.getBackgroundColorStyle());
        divider.addStyleName(lightTheme ? MaterialColor.DARK_DIVIDER.getBackgroundColorStyle() : MaterialColor.LIGHT_DIVIDER.getBackgroundColorStyle());
    }


    public enum IconSize {
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large");

        private String styleName;

        IconSize(String styleName) {
            this.styleName = styleName;
        }

        public String getStyleName() {
            return this.styleName;
        }
    }

    public class ListItemIcon extends CssLayout {

        protected MaterialColor fontColor;
        protected MaterialColor backgroundColor;
        protected IconSize size;

        public ListItemIcon() {
            super();
        }

        public void setFontColor(MaterialColor fontColor) {
            if (this.fontColor != null) removeStyleName(this.fontColor.getFontColorStyle());
            this.fontColor = fontColor;
            addStyleName(this.fontColor.getFontColorStyle());
        }

        public void setBackgroundColor(MaterialColor backgroundColor) {
            if (this.backgroundColor != null) removeStyleName(this.backgroundColor.getBackgroundColorStyle());
            this.backgroundColor = backgroundColor;
            addStyleName(this.backgroundColor.getBackgroundColorStyle());
        }

        public void setIcon(MaterialIcons icon) {
            removeAllComponents();
            addComponent(new Label(icon.getHtml(), HTML));
        }

        public void setIcon(String html) {
            removeAllComponents();
            addComponent(new Label(html, HTML));
        }

        public void setIcon(Resource image) {
            removeAllComponents();
            addComponent(new Image(null, image));
        }

        public void setCheckBox(MDCheckbox checkBox) {
            removeAllComponents();
            addComponent(checkBox);
        }
        
        public void setIconButton(IconButton iconButton) {
            removeAllComponents();
            addComponent(iconButton);
        }

        public void setSize(IconSize size) {
            if (this.size != null) removeStyleName(this.size.getStyleName());
            this.size = size;
            addStyleName(this.size.getStyleName());
        }

        public IconSize getSize() {
            return size;
        }

        public void setCircular(boolean circular) {
            if (circular) {
                addStyleName(Styles.Misc.BORDER_RADIUS_FULL);
                addStyleName(FlexLayout.Overflow.HIDDEN.getStyleName());
            } else {
                removeStyleName(Styles.Misc.BORDER_RADIUS_FULL);
                removeStyleName(FlexLayout.Overflow.HIDDEN.getStyleName());
            }
        }
    }
}
