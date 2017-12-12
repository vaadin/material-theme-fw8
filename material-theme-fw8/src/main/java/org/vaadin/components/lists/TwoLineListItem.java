package org.vaadin.components.lists;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import org.vaadin.layout.Metrics;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Typography;


/**
 * Created by jonte on 03/04/2017.
 */
public class TwoLineListItem extends ListItem {

    private Label primary;
    private Label secondary;

    public TwoLineListItem(String primaryText, String secondaryText, boolean verticalPadding) {
        super(verticalPadding);
        addStyleName("two-line");
        setHeight(Metrics.List.TWO_LINE_HEIGHT, Unit.PIXELS);

        primary = new Label(primaryText, ContentMode.HTML);
        primary.addStyleName(Typography.Dark.Subheader.PRIMARY);

        secondary = new Label(secondaryText, ContentMode.HTML);
        secondary.addStyleName(Typography.Dark.Body1.SECONDARY);

        content.addComponents(primary, secondary);

        actionPrimary.addComponents(iconPrimary, content);
        actionSecondary.addComponent(iconSecondary);

        addComponents(actionPrimary, actionSecondary, divider);
    }

    public TwoLineListItem(String primaryText, String secondaryText) {
        this(primaryText, secondaryText, true);
    }

    public TwoLineListItem(MaterialIcons primaryIcon, String primaryText, String secondaryText) {
        this(primaryText, secondaryText, true);
        setPrimaryIcon(primaryIcon);
    }

    public void setTheme(boolean lightTheme) {
        super.setTheme(lightTheme);
        primary.setPrimaryStyleName(lightTheme ? Typography.Dark.Subheader.PRIMARY : Typography.Light.Subheader.PRIMARY);
        secondary.setPrimaryStyleName(lightTheme ? Typography.Dark.Body1.SECONDARY : Typography.Light.Body1.SECONDARY);
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

    public Label getSecondaryLabel() {
        return secondary;
    }

    public void setSecondaryLabel(Label secondary) {
        content.replaceComponent(this.secondary, secondary);
        this.secondary = secondary;
    }

    public String getSecondaryText() {
        return this.secondary.getValue();
    }

    public void setSecondaryText(String text) {
        this.secondary.setValue(text);
    }
}
