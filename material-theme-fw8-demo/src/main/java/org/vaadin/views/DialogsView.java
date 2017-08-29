package org.vaadin.views;

import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import org.vaadin.components.RaisedButton;
import org.vaadin.components.dialogs.DatePickerDialog;
import org.vaadin.components.dialogs.ScrollableDialog;
import org.vaadin.components.dialogs.SimpleDialog;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Margins;
import org.vaadin.layout.Paddings;
import org.vaadin.layout.Spacings;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.Styles;

import java.time.format.DateTimeFormatter;

/**
 * Created by jonte on 23/03/2017.
 */
public class DialogsView extends FlexLayout {
    public DialogsView() {
        setFlexDirection(FlexDirection.COLUMN);
        setAlignSelf(AlignSelf.BASELINE);
        addStyleName(Margins.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);

        Button b1 = new Button("Simple Dialog");
        b1.setPrimaryStyleName(Styles.Buttons.Flat.LIGHT);
        b1.addClickListener(clickEvent -> getUI().addWindow(createSimpleDialog(true)));

        Button b2 = new Button("Scroll Dialog");
        b2.setPrimaryStyleName(Styles.Buttons.Flat.LIGHT);
        b2.addClickListener(clickEvent -> getUI().addWindow(createScrollableDialog(true)));

        Button b3 = new Button("Date Picker Dialog");
        b3.setPrimaryStyleName(Styles.Buttons.Flat.LIGHT);
        b3.addClickListener(clickEvent -> getUI().addWindow(createDatePickerDialog(true)));

        CssLayout light = new FlexLayout(b1, b2, b3);
        light.addStyleName("card");
        light.addStyleName(Paddings.All.LARGE + " " + Spacings.Right.SMALL);

        Button b4 = new Button("Simple Dialog");
        b4.setPrimaryStyleName(Styles.Buttons.Flat.DARK);
        b4.addClickListener(clickEvent -> getUI().addWindow(createSimpleDialog(false)));

        Button b5 = new Button("Scroll Dialog");
        b5.setPrimaryStyleName(Styles.Buttons.Flat.DARK);
        b5.addClickListener(clickEvent -> getUI().addWindow(createScrollableDialog(false)));

        Button b6 = new Button("Date Picker Dialog");
        b6.setPrimaryStyleName(Styles.Buttons.Flat.DARK);
        b6.addClickListener(clickEvent -> getUI().addWindow(createDatePickerDialog(false)));

        CssLayout dark = new FlexLayout(b4, b5, b6);
        dark.addStyleName("card");
        dark.addStyleName(Paddings.All.LARGE + " " + Spacings.Right.SMALL);
        dark.addStyleName(MaterialColor.GREY_800.getBackgroundColorStyle());

        addComponents(light, dark);
    }

    private Window createSimpleDialog(boolean lightTheme) {
        SimpleDialog dlg = new SimpleDialog("Use Google's location service?", "Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.", lightTheme);
        dlg.setWidth(280, Unit.PIXELS);
        dlg.center();

        dlg.addAffirmativeActionButtonListener(event -> createNotification("User clicked the OK button"));
        dlg.addDismissiveActionButtonListener(event -> createNotification("User clicked the cancel button"));

        return dlg;
    }

    private Window createScrollableDialog(boolean lightTheme) {
        RadioButtonGroup<String> rbg = new RadioButtonGroup();
        rbg.setItems("None", "Callisto", "Dione", "Ganymede", "Hangouts Call", "Luna", "Oberon", "Phobos");
        rbg.setPrimaryStyleName(lightTheme ? Styles.OptionGroups.LIGHT : Styles.OptionGroups.DARK);

        ScrollableDialog dlg = new ScrollableDialog("Phone ringtone", lightTheme);
        dlg.setScrollableContent(rbg);
        dlg.setWidth(280, Unit.PIXELS);
        dlg.setHeight(420, Unit.PIXELS);
        dlg.center();

        dlg.addAffirmativeActionButtonListener(event -> createNotification("User clicked the OK button"));
        dlg.addDismissiveActionButtonListener(event -> createNotification("User clicked the cancel button"));

        dlg.setModal(true);

        return dlg;
    }

    private Window createDatePickerDialog(boolean lightTheme) {
        DatePickerDialog dlg = new DatePickerDialog(lightTheme);
        dlg.center();

        dlg.addDismissiveActionButtonListener(event -> dlg.close());
        dlg.addAffirmativeActionButtonListener(event -> {
            createNotification(dlg.getValue().format(DateTimeFormatter.ofPattern("EEE, MMM d")));
            dlg.close();
        });

        if (!lightTheme) {
            dlg.getDismissiveActionButton().addStyleName(MaterialColor.BLUE_200.getFontColorStyle());
            dlg.getAffirmativeActionButton().addStyleName(MaterialColor.BLUE_200.getFontColorStyle());
        }

        dlg.setModal(true);

        return dlg;
    }

    private void createNotification(String message) {
        Notification notification = new Notification(message);
        notification.setDelayMsec(3000);
        notification.setPosition(com.vaadin.shared.Position.BOTTOM_CENTER);
        notification.show(getUI().getPage());
    }
}
