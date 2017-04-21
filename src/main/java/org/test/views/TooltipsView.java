package org.test.views;

import org.test.components.ToggleButtonGroup;
import org.test.layout.FlexLayout;
import org.test.layout.Margins;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialIcons;

/**
 * Created by jonte on 23/03/2017.
 */
public class TooltipsView extends FlexLayout {

    public TooltipsView() {
        setFlexDirection(FlexDirection.COLUMN);
        setAlignSelf(AlignSelf.BASELINE);
        addStyleName("card");
        addStyleName(Paddings.All.LARGE);
        addStyleName(Margins.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);

        ToggleButtonGroup tbg1 = new ToggleButtonGroup();
        tbg1.setSelectionMode(ToggleButtonGroup.SelectionMode.SINGLE);
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_LEFT).setDescription("Align left");
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_CENTER).setDescription("Align center");
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_RIGHT).setDescription("Align right");
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_JUSTIFY).setDescription("Align justify");

        addComponent(tbg1);

        ToggleButtonGroup tbg2 = new ToggleButtonGroup();
        tbg2.setSelectionMode(ToggleButtonGroup.SelectionMode.MULTI);
        tbg2.addToggleButton(MaterialIcons.FORMAT_BOLD).setDescription("Bold");
        tbg2.addToggleButton(MaterialIcons.FORMAT_ITALIC).setDescription("Italic");
        tbg2.addToggleButton(MaterialIcons.FORMAT_UNDERLINED).setDescription("Underline");
        tbg2.addToggleButton(MaterialIcons.FORMAT_COLOR_FILL).setDescription("Color");

        addComponent(tbg2);
    }
}
