package org.test.views;

import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import org.test.components.ToggleButtonGroup;
import org.test.layout.FlexLayout;
import org.test.layout.Margins;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialIcons;

/**
 * Created by jonte on 24/03/2017.
 */
public class SnackbarsToastsView extends FlexLayout {

    public SnackbarsToastsView() {
        setFlexDirection(FlexDirection.COLUMN);
        setAlignSelf(AlignSelf.BASELINE);
        addStyleName("card");
        addStyleName(Paddings.All.LARGE);
        addStyleName(Margins.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);

        ToggleButtonGroup tbg1 = new ToggleButtonGroup();
        tbg1.setSelectionMode(ToggleButtonGroup.SelectionMode.SINGLE);
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_LEFT).addClickListener(e -> createNotification("Align left", Position.BOTTOM_LEFT));
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_CENTER).addClickListener(e -> createNotification("Align center", Position.BOTTOM_CENTER));
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_RIGHT).addClickListener(e -> createNotification("Align right", Position.BOTTOM_RIGHT));
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_JUSTIFY).addClickListener(e -> createNotification("Align justify", Position.MIDDLE_CENTER));

        addComponent(tbg1);

        ToggleButtonGroup tbg2 = new ToggleButtonGroup();
        tbg2.setSelectionMode(ToggleButtonGroup.SelectionMode.MULTI);
        tbg2.addToggleButton(MaterialIcons.FORMAT_BOLD).setDescription("Bold");
        tbg2.addToggleButton(MaterialIcons.FORMAT_ITALIC).setDescription("Italic");
        tbg2.addToggleButton(MaterialIcons.FORMAT_UNDERLINED).setDescription("Underline");
        tbg2.addToggleButton(MaterialIcons.FORMAT_COLOR_FILL).setDescription("Color");

        addComponent(tbg2);
    }

    private void createNotification(String message, Position pos) {
        Notification notification = new Notification(message);
        notification.setDelayMsec(3000);
        notification.setPosition(pos);
        notification.show(getUI().getPage());
    }
}
