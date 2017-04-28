package org.test.components.lists;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import org.test.style.Typography;

/**
 * Created by jonte on 03/04/2017.
 */
public class SingleLineListItem extends ListItem {

    private Label primary;

    public SingleLineListItem(String primaryText, boolean verticalPadding) {
        super(verticalPadding);
        addStyleName("single-line");

        primary = new Label(primaryText, ContentMode.HTML);
        primary.addStyleName(Typography.Dark.Subheader.PRIMARY);

        content.addComponent(primary);
        addComponents(iconPrimary, content, iconSecondary);
    }

    public SingleLineListItem(String primaryText) {
        this(primaryText, true);
    }

    public SingleLineListItem(Component component, String primaryText) {
        this(primaryText,true);
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
}
