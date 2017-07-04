package org.vaadin.components.lists;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import org.vaadin.layout.Metrics;
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

        addComponents(actionPrimary, iconSecondary);
    }

    public SingleLineListItem(String primaryText) {
        this(primaryText, true);
    }

    public SingleLineListItem(Component component, String primaryText) {
        this(primaryText, true);
    }

    public SingleLineListItem(Component component, String primaryText, boolean verticalPadding) {
        this(primaryText, verticalPadding);
    }

    public SingleLineListItem(Resource icon, String primaryText) {
        this(primaryText, true);
    }

    public SingleLineListItem(Resource icon, String primaryText, boolean verticalPadding) {
        this(primaryText, verticalPadding);
    }

    public void setTheme(boolean lightTheme) {
        primary.setPrimaryStyleName(lightTheme ? Typography.Dark.Subheader.PRIMARY : Typography.Light.Subheader.PRIMARY);
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
