package org.test.views;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.RadioButtonGroup;
import org.test.layout.FlexLayout;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.Styles;

/**
 * Created by jonte on 17/03/2017.
 */
public class SelectionControlsView extends FlexLayout {

    public SelectionControlsView() {
        setAlignItems(FlexLayout.AlignItems.FLEX_START);
        setAlignSelf(AlignSelf.BASELINE);
        setFlexWrap(FlexLayout.FlexWrap.WRAP);
        setJustifyContent(JustifyContent.CENTER);
        addStyleName(Spacings.All.LARGE);

        // Checkboxes
        CheckBox cb1 = new CheckBox("Light On");
        CheckBox cb2 = new CheckBox("Light Off");
        CheckBox cb3 = new CheckBox("Light Disabled");
        cb3.setEnabled(false);
        for (Component c : new Component[]{cb1, cb2, cb3}) {
            c.setPrimaryStyleName(Styles.CheckBoxes.LIGHT);
        }
        FlexLayout light1 = new FlexLayout(cb1, cb2, cb3);
        light1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        light1.addStyleName("card " + Paddings.All.LARGE);


        CheckBox cb4 = new CheckBox("Dark On");
        CheckBox cb5 = new CheckBox("Dark Off");
        CheckBox cb6 = new CheckBox("Dark Disabled");
        cb6.setEnabled(false);
        for (Component c : new Component[]{cb4, cb5, cb6}) {
            c.setPrimaryStyleName(Styles.CheckBoxes.DARK);
        }
        FlexLayout dark1 = new FlexLayout(cb4, cb5, cb6);
        dark1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        dark1.addStyleName("card " + MaterialColor.GREY_900.getBackgroundColorStyle() + " " + Paddings.All.LARGE);


        // Radio buttons
        RadioButtonGroup<String> rbg1 = new RadioButtonGroup();
        rbg1.setItems("One", "Two");
        rbg1.setPrimaryStyleName(Styles.OptionGroups.LIGHT);

        RadioButtonGroup<String> rbg2 = new RadioButtonGroup();
        rbg2.setItems("Disabled One", "Disabled Two");
        rbg2.setPrimaryStyleName(Styles.OptionGroups.LIGHT);
        rbg2.setEnabled(false);

        FlexLayout light2 = new FlexLayout(rbg1, rbg2);
        light2.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        light2.addStyleName("card " + Paddings.All.LARGE);

        RadioButtonGroup<String> rbg3 = new RadioButtonGroup();
        rbg3.setItems("One", "Two");
        rbg3.setPrimaryStyleName(Styles.OptionGroups.DARK);

        RadioButtonGroup<String> rbg4 = new RadioButtonGroup();
        rbg4.setItems("Disabled One", "Disabled Two");
        rbg4.setPrimaryStyleName(Styles.OptionGroups.DARK);
        rbg4.setEnabled(false);

        FlexLayout dark2 = new FlexLayout(rbg3, rbg4);
        dark2.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        dark2.addStyleName("card " + MaterialColor.GREY_900.getBackgroundColorStyle() + " " + Paddings.All.LARGE);


        // Switches
        CheckBox sw1 = new CheckBox("Light On");
        CheckBox sw2 = new CheckBox("Light Off");
        CheckBox sw3 = new CheckBox("Light Disabled");
        sw3.setEnabled(false);
        for (Component c : new Component[]{sw1, sw2, sw3}) {
            c.setPrimaryStyleName(Styles.Switches.LIGHT);
        }
        FlexLayout light3 = new FlexLayout(sw1, sw2, sw3);
        light3.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        light3.addStyleName("card " + Paddings.All.LARGE);


        CheckBox sw4 = new CheckBox("Dark On");
        CheckBox sw5 = new CheckBox("Dark Off");
        CheckBox sw6 = new CheckBox("Dark Disabled");
        sw6.setEnabled(false);
        for (Component c : new Component[]{sw4, sw5, sw6}) {
            c.setPrimaryStyleName(Styles.Switches.DARK);
        }
        FlexLayout dark3 = new FlexLayout(sw4, sw5, sw6);
        dark3.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        dark3.addStyleName("card " + MaterialColor.GREY_900.getBackgroundColorStyle() + " " + Paddings.All.LARGE);


        addComponents(light1, dark1, light2, dark2, light3, dark3);

    }
}
