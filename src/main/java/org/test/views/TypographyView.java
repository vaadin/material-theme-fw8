package org.test.views;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.test.layout.FlexLayout;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.Typography;

/**
 * Created by jonte on 23/03/2017.
 */
public class TypographyView extends FlexLayout {

    public TypographyView() {
        setAlignItems(AlignItems.CENTER);
        setAlignSelf(AlignSelf.BASELINE);
        setFlexDirection(FlexDirection.COLUMN);
        addStyleName(Spacings.Bottom.LARGE);
        addStyleName(Paddings.All.LARGE);
        setWidth(100, Unit.PERCENTAGE);

        addComponent(createTypography(true));
        addComponent(createTypography(false));
    }

    private Component createTypography(boolean lightTheme) {
        CssLayout card = new CssLayout();
        card.addStyleName("card" + " " + Paddings.All.LARGE);
        if (!lightTheme) card.addStyleName(MaterialColor.GREY_800.getBackgroundColorStyle());

        String[] styles = lightTheme ? new String[] {
                Typography.Dark.Body1.PRIMARY, Typography.Dark.Body1.SECONDARY, Typography.Dark.Body1.DISABLED,
                Typography.Dark.Body2.PRIMARY, Typography.Dark.Body2.SECONDARY, Typography.Dark.Body2.DISABLED,
                Typography.Dark.Caption.PRIMARY, Typography.Dark.Caption.SECONDARY, Typography.Dark.Caption.DISABLED,
                Typography.Dark.DatePicker.Title.PRIMARY, Typography.Dark.DatePicker.Title.SECONDARY, Typography.Dark.DatePicker.Title.DISABLED,
                Typography.Dark.Headline.PRIMARY, Typography.Dark.Headline.SECONDARY, Typography.Dark.Headline.DISABLED,
                Typography.Dark.Menu.PRIMARY, Typography.Dark.Menu.SECONDARY, Typography.Dark.Menu.DISABLED,
                Typography.Dark.Subheader.PRIMARY, Typography.Dark.Subheader.SECONDARY, Typography.Dark.Subheader.DISABLED,
                Typography.Dark.Table.Title.PRIMARY, Typography.Dark.Table.Title.SECONDARY, Typography.Dark.Table.Title.DISABLED,
                Typography.Dark.Table.Header.PRIMARY, Typography.Dark.Table.Header.SECONDARY, Typography.Dark.Table.Header.DISABLED,
                Typography.Dark.Table.Row.PRIMARY, Typography.Dark.Table.Row.SECONDARY, Typography.Dark.Table.Row.DISABLED,
                Typography.Dark.Title.PRIMARY, Typography.Dark.Title.SECONDARY, Typography.Dark.Title.DISABLED
        } : new String[] {
                Typography.Light.Body1.PRIMARY, Typography.Light.Body1.SECONDARY, Typography.Light.Body1.DISABLED,
                Typography.Light.Body2.PRIMARY, Typography.Light.Body2.SECONDARY, Typography.Light.Body2.DISABLED,
                Typography.Light.Caption.PRIMARY, Typography.Light.Caption.SECONDARY, Typography.Light.Caption.DISABLED,
                Typography.Light.DatePicker.Title.PRIMARY, Typography.Light.DatePicker.Title.SECONDARY, Typography.Light.DatePicker.Title.DISABLED,
                Typography.Light.Headline.PRIMARY, Typography.Light.Headline.SECONDARY, Typography.Light.Headline.DISABLED,
                Typography.Light.Menu.PRIMARY, Typography.Light.Menu.SECONDARY, Typography.Light.Menu.DISABLED,
                Typography.Light.Subheader.PRIMARY, Typography.Light.Subheader.SECONDARY, Typography.Light.Subheader.DISABLED,
                Typography.Light.Table.Title.PRIMARY, Typography.Light.Table.Title.SECONDARY, Typography.Light.Table.Title.DISABLED,
                Typography.Light.Table.Header.PRIMARY, Typography.Light.Table.Header.SECONDARY, Typography.Light.Table.Header.DISABLED,
                Typography.Light.Table.Row.PRIMARY, Typography.Light.Table.Row.SECONDARY, Typography.Light.Table.Row.DISABLED,
                Typography.Light.Title.PRIMARY, Typography.Light.Title.SECONDARY, Typography.Light.Title.DISABLED
        };

        int i = 1;
        for (String style : styles) {
            card.addComponent(createLabel(style));
            if (i % 3 == 0) {
                card.addComponent(createDivider());
            }
            i++;
        }

        return card;
    }

    private CssLayout createDivider() {
        CssLayout divider = new CssLayout();
        divider.setHeight(16, Unit.PIXELS);
        return divider;
    }

    private Label createLabel(String style) {
        Label lbl = new Label();
        lbl.setPrimaryStyleName(style);
        style = style.substring(3).replace("-", " ");
        style = style.substring(0, 1).toUpperCase() + style.substring(1);
        lbl.setValue(style);
        return lbl;
    }
}
