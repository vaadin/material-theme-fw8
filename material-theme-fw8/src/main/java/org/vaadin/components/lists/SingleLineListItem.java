package org.vaadin.components.lists;

import com.vaadin.ui.Label;
import org.vaadin.layout.Metrics;
import org.vaadin.layout.Paddings;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Typography;

import static org.vaadin.layout.Metrics.List.SINGLE_LINE_HEIGHT;
import static org.vaadin.layout.Metrics.List.SINGLE_LINE_WITH_AVATAR_HEIGHT;

/**
 * Created by jonte on 03/04/2017.
 */
public class SingleLineListItem extends ListItem {

    private Label primary;

    public SingleLineListItem(String primaryText, boolean verticalPadding) {
        super(verticalPadding);
        addStyleName("single-line");
        setHeight(Metrics.List.SINGLE_LINE_HEIGHT, Unit.PIXELS);

        primary = new Label(primaryText);
        primary.setPrimaryStyleName(Typography.Dark.Subheader.PRIMARY);

        content.addComponent(primary);

        actionPrimary.addComponents(iconPrimary, content);
        actionSecondary.addComponent(iconSecondary);

        addComponents(actionPrimary, actionSecondary, divider);
    }

    public SingleLineListItem(String primaryText) {
        this(primaryText, true);
    }

    public SingleLineListItem(MaterialIcons primaryIcon, String primaryText) {
        this(primaryText, true);
        setPrimaryIcon(primaryIcon);
    }

    public void setTheme(boolean lightTheme) {
        super.setTheme(lightTheme);
        primary.setPrimaryStyleName(lightTheme ? Typography.Dark.Subheader.PRIMARY : Typography.Light.Subheader.PRIMARY);
    }

    public void enableWrap(boolean horizontalPadding) {
        super.enableWrap(horizontalPadding);
        if (horizontalPadding) {
            addStyleName(getPrimaryIcon().getSize().equals(IconSize.LARGE) || getSecondaryIcon().getSize().equals(IconSize.LARGE) ?
                    Paddings.Vertical.ListItem.SINGLE_LINE_WITH_AVATAR : Paddings.Vertical.ListItem.SINGLE_LINE);
        }
    }

    public void disableWrap() {
        super.disableWrap();
        setHeight(getPrimaryIcon().getSize().equals(IconSize.LARGE) || getSecondaryIcon().getSize().equals(IconSize.LARGE) ?
                Metrics.List.SINGLE_LINE_WITH_AVATAR_HEIGHT : Metrics.List.SINGLE_LINE_HEIGHT, Unit.PIXELS);

        removeStyleName(Paddings.Vertical.ListItem.SINGLE_LINE);
        removeStyleName(Paddings.Vertical.ListItem.SINGLE_LINE_WITH_AVATAR);
    }

    public Label getPrimaryLabel() {
        return primary;
    }

    public void setPrimaryLabel(Label primary) {
        content.replaceComponent(this.primary, primary);
        this.primary = primary;
    }

    public String getPrimaryText() {
        return this.primary.getValue();
    }

    public void setPrimaryText(String text) {
        this.primary.setValue(text);
    }

    @Override
    public void setPrimaryIconSize(IconSize size) {
        super.setPrimaryIconSize(size);
        setHeight((size.equals(IconSize.LARGE)) ? SINGLE_LINE_WITH_AVATAR_HEIGHT : SINGLE_LINE_HEIGHT, Unit.PIXELS);
    }

    @Override
    public void setSecondaryIconSize(IconSize size) {
        super.setSecondaryIconSize(size);
        setHeight((size.equals(IconSize.LARGE)) ? SINGLE_LINE_WITH_AVATAR_HEIGHT : SINGLE_LINE_HEIGHT, Unit.PIXELS);
    }
}
