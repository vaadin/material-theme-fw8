package org.test.components.lists;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import org.test.layout.Metrics;
import org.test.style.MaterialIcons;
import org.test.style.Typography;

import static org.test.layout.Metrics.List.SINGLE_LINE_HEIGHT;
import static org.test.layout.Metrics.List.SINGLE_LINE_WITH_AVATAR_HEIGHT;

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
    public void setPrimaryIcon(MaterialIcons icon) {
        super.setPrimaryIcon(icon);
        setHeight(SINGLE_LINE_HEIGHT, Unit.PIXELS);
    }

    @Override
    public void setPrimaryIcon(ThemeResource image) {
        super.setPrimaryIcon(image);
        setHeight(SINGLE_LINE_WITH_AVATAR_HEIGHT, Unit.PIXELS);
    }

    @Override
    public void setSecondaryIcon(MaterialIcons icon) {
        super.setSecondaryIcon(icon);
        setHeight(SINGLE_LINE_HEIGHT, Unit.PIXELS);
    }

    @Override
    public void setSecondaryIcon(ThemeResource image) {
        super.setSecondaryIcon(image);
        setHeight(SINGLE_LINE_WITH_AVATAR_HEIGHT, Unit.PIXELS);
    }
}
