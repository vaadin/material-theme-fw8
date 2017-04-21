package org.test.views;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.InlineDateField;
import org.test.components.DatePickerFooter;
import org.test.components.DatePickerHeader;
import org.test.layout.FlexLayout;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.Styles;

/**
 * Created by jonte on 20/03/2017.
 */
public class PickersView extends FlexLayout {

    public PickersView() {
        setAlignItems(FlexLayout.AlignItems.FLEX_START);
        setAlignSelf(AlignSelf.BASELINE);
        setFlexWrap(FlexLayout.FlexWrap.WRAP);
        setJustifyContent(JustifyContent.CENTER);
        addStyleName(Spacings.All.LARGE);

        InlineDateField idf1 = new InlineDateField();
        idf1.setPrimaryStyleName(Styles.DatePickers.LIGHT);
        FlexLayout c1 = new FlexLayout(FlexDirection.COLUMN, idf1);
        c1.addStyleName("card");

        InlineDateField idf2 = new InlineDateField();
        idf2.setPrimaryStyleName(Styles.DatePickers.LIGHT);

        FlexLayout c2 = new FlexLayout(FlexDirection.COLUMN, new DatePickerHeader(idf2, true), idf2, createFooter(idf2, true));
        c2.addStyleName("card");


        InlineDateField idf3 = new InlineDateField();
        idf3.setPrimaryStyleName(Styles.DatePickers.DARK);
        FlexLayout c3 = new FlexLayout(FlexDirection.COLUMN, idf3);
        c3.addStyleName("card" + " " + MaterialColor.GREY_800.getBackgroundColorStyle());

        InlineDateField idf4 = new InlineDateField();
        idf4.setPrimaryStyleName(Styles.DatePickers.DARK);
        FlexLayout c4 = new FlexLayout(FlexDirection.COLUMN, new DatePickerHeader(idf4, false), idf4, createFooter(idf4, false));
        c4.addStyleName("card" + " " + MaterialColor.GREY_800.getBackgroundColorStyle());


        addComponents(c1, c2, c3, c4);
    }

    public CssLayout createFooter(InlineDateField field, boolean lightTheme) {
        DatePickerFooter footer = new DatePickerFooter(field, lightTheme);

        if (!lightTheme) {
            footer.getDismissiveActionButton().addStyleName(MaterialColor.BLUE_200.getFontColorStyle());
            footer.getAffirmativeActionButton().addStyleName(MaterialColor.BLUE_200.getFontColorStyle());
        }

        return footer;

    }


}
