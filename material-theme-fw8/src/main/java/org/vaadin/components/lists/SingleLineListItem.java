package org.vaadin.components.lists;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import org.vaadin.layout.Metrics;
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

        primary = new Label(primaryText, ContentMode.HTML);
        primary.addStyleName(Typography.Dark.Subheader.PRIMARY);

        content.addComponent(primary);

        actionPrimary.addComponents(iconPrimary, content);
        actionSecondary.addComponent(iconSecondary);

        addComponents(actionPrimary, actionSecondary);
    }

    public SingleLineListItem(String primaryText) {
        this(primaryText, true);
    }

    public SingleLineListItem(MaterialIcons primaryIcon, String primaryText) {
        this(primaryText, true);
        setPrimaryIcon(primaryIcon);
    }

    public void setTheme(boolean lightTheme) {
        primary.setPrimaryStyleName(lightTheme ? Typography.Dark.Subheader.PRIMARY : Typography.Light.Subheader.PRIMARY);
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
