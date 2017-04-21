package org.test.components.dialogs;

import com.vaadin.ui.Button;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Window;
import org.test.components.DatePickerFooter;
import org.test.components.DatePickerHeader;
import org.test.layout.FlexLayout;
import org.test.style.Styles;

import java.time.LocalDate;

/**
 * Created by jonte on 24/03/2017.
 */
public class DatePickerDialog extends Window {

    private final FlexLayout content;

    private DatePickerHeader header;
    private InlineDateField field;
    private DatePickerFooter footer;

    public DatePickerDialog(boolean lightTheme) {
        setPrimaryStyleName(lightTheme ? Styles.Windows.LIGHT : Styles.Windows.DARK);
        addStyleName(Styles.Windows.NO_HEADER);

        field = new InlineDateField();
        field.setPrimaryStyleName(lightTheme ? Styles.DatePickers.LIGHT : Styles.DatePickers.DARK);

        // Header
        header = new DatePickerHeader(field, lightTheme);

        // Footer
        footer = new DatePickerFooter(field, lightTheme);

        // Content wrapper
        content = new FlexLayout(FlexLayout.FlexDirection.COLUMN, header, field, footer);
        setContent(content);
    }

    public String getTitle() {
        return getCaption();
    }

    public void setTitle(String title) {
        setCaption(title);
    }

    public void setAffirmativeActionButtonCaption(String caption) {
        footer.setAffirmativeActionButtonCaption(caption);
    }

    public void setDismissiveActionButtonCaption(String caption) {
        footer.setDismissiveActionButtonCaption(caption);
    }

    public Button getAffirmativeActionButton() {
        return footer.getAffirmativeActionButton();
    }

    public Button getDismissiveActionButton() {
        return footer.getDismissiveActionButton();
    }

    public void addAffirmativeActionButtonListener(Button.ClickListener listener) {
        footer.addAffirmativeActionButtonListener(listener);
    }

    public void addDismissiveActionButtonListener(Button.ClickListener listener) {
        footer.addDismissiveActionButtonListener(listener);
    }

    public InlineDateField getField() {
        return field;
    }

    public void setField(InlineDateField field) {
        this.field = field;
    }

    public LocalDate getValue() {
        return this.field.getValue();
    }


}
