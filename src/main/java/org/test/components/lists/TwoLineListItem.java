package org.test.components.lists;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import org.test.style.Typography;

/**
 * Created by jonte on 03/04/2017.
 */
public class TwoLineListItem extends ListItem {

    private Label primary;
    private Label secondary;

    public TwoLineListItem(String primaryText, String secondaryText, boolean verticalPadding) {
        super(verticalPadding);
        addStyleName("two-line");

        primary = new Label(primaryText, ContentMode.HTML);
        primary.addStyleName(Typography.Dark.Subheader.PRIMARY);

        secondary = new Label(secondaryText, ContentMode.HTML);
        secondary.addStyleName(Typography.Dark.Body1.SECONDARY);

        content.addComponents(primary, secondary);
        addComponents(iconPrimary, content, iconSecondary);
    }


    public TwoLineListItem(String primaryText, String secondaryText) {
        this(primaryText, secondaryText, true);
    }

    public TwoLineListItem(Component component, String primaryText, String secondaryText) {
        this(primaryText, secondaryText, true);
    }

    public TwoLineListItem(Component component, String primaryText, String secondaryText, boolean verticalPadding) {
        this(primaryText, secondaryText, verticalPadding);
    }

    public TwoLineListItem(Resource icon, String primaryText, String secondaryText) {
        this(primaryText, secondaryText, true);
    }

    public TwoLineListItem(Resource icon, String primaryText, String secondaryText, boolean verticalPadding) {
        this(primaryText, secondaryText, verticalPadding);
    }

    public void setTheme(boolean lightTheme) {
        primary.setPrimaryStyleName(lightTheme ? Typography.Dark.Subheader.PRIMARY : Typography.Light.Subheader.PRIMARY);
        secondary.setPrimaryStyleName(lightTheme ? Typography.Dark.Body1.PRIMARY : Typography.Light.Body1.PRIMARY);
    }
}
