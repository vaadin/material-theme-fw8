package org.vaadin.components.dialogs;

import com.vaadin.ui.Button;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Window;
import org.vaadin.components.DatePickerFooter;
import org.vaadin.components.DatePickerHeader;
import org.vaadin.layout.FlexItem;
import org.vaadin.layout.FlexLayout;
import org.vaadin.style.Styles;

import java.time.LocalDate;

/**
 * Created by jonte on 24/03/2017.
 */
public class DatePickerDialog extends Window {

    protected FlexLayout content;
    protected DatePickerHeader header;
    protected InlineDateField field;
    protected DatePickerFooter footer;

    public DatePickerDialog(boolean lightTheme) {
        setPrimaryStyleName(lightTheme ? Styles.Windows.LIGHT : Styles.Windows.DARK);
        addStyleName(Styles.Windows.NO_HEADER);

        field = new InlineDateField();
        field.setPrimaryStyleName(lightTheme ? Styles.DatePickers.LIGHT : Styles.DatePickers.DARK);
        field.addStyleName(FlexItem.FlexGrow.GROW_1);
        field.addStyleName(FlexLayout.Overflow.AUTO.getStyleName());

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

    public DatePickerHeader getHeader() {
        return header;
    }

    public FlexLayout getFooter() {
        return footer;
    }
}
