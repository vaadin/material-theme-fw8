package org.test.components;

import com.vaadin.data.HasValue;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import org.test.layout.FlexLayout;
import org.test.layout.Metrics;
import org.test.layout.Paddings;
import org.test.style.MaterialColor;
import org.test.style.Typography;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by jonte on 21/03/2017.
 */
public class DatePickerHeader extends FlexLayout {

    private final InlineDateField field;

    private final Label date = new Label("Select Date");
    private final Label year = new Label();

    public DatePickerHeader(InlineDateField field, boolean lightTheme) {
        setFlexDirection(FlexDirection.COLUMN);
        setJustifyContent(JustifyContent.CENTER);
        addStyleName(Paddings.Horizontal.LARGE);

        this.field = field;
        field.addValueChangeListener((HasValue.ValueChangeListener<LocalDate>) event -> {
            year.setValue(field.getValue().format(DateTimeFormatter.ofPattern("yyyy")));
            date.setValue(field.getValue().format(DateTimeFormatter.ofPattern("EEE, MMM d")));
        });

        setHeight(Metrics.DatePicker.HEADER_HEIGHT, Unit.PIXELS);
        addStyleName(lightTheme ? MaterialColor.BLUE_500.getBackgroundColorStyle() : MaterialColor.GREY_700.getBackgroundColorStyle());

        year.setPrimaryStyleName(Typography.Light.Body2.SECONDARY);
        date.setPrimaryStyleName(Typography.Light.DatePicker.Title.PRIMARY);

        addComponents(year, date);
    }
}
