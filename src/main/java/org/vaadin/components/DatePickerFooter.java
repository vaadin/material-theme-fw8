package org.vaadin.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.InlineDateField;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Paddings;
import org.vaadin.layout.Spacings;
import org.vaadin.style.Styles;

/**
 * Created by jonte on 24/03/2017.
 */
public class DatePickerFooter extends FlexLayout {

    private final InlineDateField field;
    private final Button cancel;
    private final Button ok;

    public DatePickerFooter(InlineDateField field, boolean lightTheme) {
        setAlignItems(FlexLayout.AlignItems.CENTER);
        setJustifyContent(FlexLayout.JustifyContent.FLEX_END);
        addStyleName(Paddings.All.SMALL);
        addStyleName(Spacings.Right.SMALL);

        cancel = new Button("Cancel");
        cancel.setPrimaryStyleName(lightTheme ? Styles.Buttons.Flat.LIGHT : Styles.Buttons.Flat.DARK);

        ok = new Button("OK");
        ok.setPrimaryStyleName(lightTheme ? Styles.Buttons.Flat.LIGHT : Styles.Buttons.Flat.DARK);
        ok.setEnabled(field.getValue() != null);

        this.field = field;
        this.field.addValueChangeListener(event -> ok.setEnabled(this.field.getValue() != null));

        addComponents(cancel, ok);
    }

    public void setAffirmativeActionButtonCaption(String caption) {
        ok.setCaption(caption);
    }

    public void setDismissiveActionButtonCaption(String caption) {
        cancel.setCaption(caption);
    }

    public Button getAffirmativeActionButton() {
        return ok;
    }

    public Button getDismissiveActionButton() {
        return cancel;
    }

    public void addAffirmativeActionButtonListener(Button.ClickListener listener) {
        ok.addClickListener(listener);
    }

    public void addDismissiveActionButtonListener(Button.ClickListener listener) {
        cancel.addClickListener(listener);
    }
}
