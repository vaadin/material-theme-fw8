package org.vaadin.views;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.vaadin.components.lists.SingleLineListItem;
import org.vaadin.components.lists.TwoLineListItem;
import org.vaadin.layout.*;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Typography;

import java.util.Arrays;

import static com.vaadin.shared.ui.ContentMode.HTML;

/**
 * Created by jonte on 23/03/2017.
 */
public class ColorsView extends CssLayout {

    public ColorsView() {
        addStyleName(MaxWidths.MW_720);

        /* INFO SECTION */
        addComponent(createHeadline("Colors"));
        CssLayout infoSection = new CssLayout(
                createBody1Label("Every color in Material Design's color palette is available as a font and background color. The colors are listed in the <b>MaterialColor.java</b> enum, which has three methods:"),
                createListItem(MaterialIcons.FORMAT_COLOR_FILL, "getBackgroundColorStyle", "Return the background color style name.", false),
                createListItem(MaterialIcons.FORMAT_COLOR_TEXT, "getFontColorStyle", "Returns the font color style name.", false),
                createListItem(MaterialIcons.BRIGHTNESS_MEDIUM, "isColorDark", "Returns true if the color is dark, false if light.", true),
                createSubheader("Background color example"),
                createListItem("component.addStyleName(<b>MaterialColor.BLUE_500.getBackgroundColorStyle()</b>);", false),
                createListItem("component.addStyleName(\"<b>" + MaterialColor.BLUE_500.getBackgroundColorStyle() + "</b>\");", true),
                createSubheader("Font color example"),
                createListItem("component.addStyleName(<b>MaterialColor.RED_500.getFontColorStyle()</b>);", false),
                createListItem("component.addStyleName(\"<b>" + MaterialColor.RED_500.getFontColorStyle() + "</b>\");", true)
        );
        addComponent(infoSection);

        /* COLOR PALETTE SECTION */
        FlexLayout colorsLayout = new FlexLayout();
        colorsLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        colorsLayout.setAlignItems(FlexLayout.AlignItems.BASELINE);
        colorsLayout.setJustifyContent(FlexLayout.JustifyContent.CENTER);
        colorsLayout.addStyleName(Spacings.All.MEDIUM);
        addComponent(colorsLayout);

        // Group each color (and its shades) in a card.
        CssLayout card = createCard();

        // Skip the first six values, which are MD_(PRIMARY/SECONDARY/DISABLED)_(LIGHT/DARK).
        // They'll be mentioned in the info section as they are difficult to demo.
        MaterialColor[] colors = Arrays.copyOfRange(MaterialColor.values(), 6, MaterialColor.values().length);
        String name = colors[0].getFontColorStyle();

        // Use the colors base name as ID, e.g. "blue", "red" and "green".
        String id1 = name.substring(0, name.indexOf("-", 3));

        for (MaterialColor color : colors) {
            name = color.getFontColorStyle();
            String id2 = name.substring(0, name.indexOf("-", 3));

            if (!id1.equals(id2)) {
                id1 = id2;
                colorsLayout.addComponent(card);
                card = createCard();
            }

            card.addComponent(createItem("MaterialColor." + name.toUpperCase().replace("-", "_"), color));
        }

        colorsLayout.addComponent(card);
    }

    private Component createItem(String styleName, MaterialColor color) {
        SingleLineListItem item = new SingleLineListItem(styleName);
        item.addStyleName(color.getBackgroundColorStyle());
        item.setTheme(color.isColorLight());
        return item;
    }

    private CssLayout createCard() {
        CssLayout card = new CssLayout();
        card.addStyleName("card");
        card.setWidth(320, Unit.PIXELS);
        return card;
    }

    private Component createSubheader(String text) {
        Label lbl = new Label(text);
        lbl.addStyleName(Typography.Dark.Body2.SECONDARY + " " + MaterialColor.BLUE_500.getFontColorStyle());
        FlexLayout subheader = new FlexLayout(lbl);
        subheader.setAlignItems(FlexLayout.AlignItems.CENTER);
        subheader.setHeight(Metrics.Subheader.HEIGHT, Unit.PIXELS);
        return subheader;
    }

    private Component createListItem(MaterialIcons icon, String primary, String secondary, boolean last) {
        TwoLineListItem item = new TwoLineListItem(primary, secondary, false);
        item.setPrimaryIcon(icon);
        if (last) item.addStyleName(Margins.Bottom.LARGE);
        return item;
    }

    private Component createListItem(String primary, boolean last) {
        SingleLineListItem item = new SingleLineListItem(primary, false);
        if (last) item.addStyleName(Margins.Bottom.LARGE);
        return item;
    }

    private Label createBody1Label(String text) {
        Label lbl = new Label(text);
        lbl.setContentMode(HTML);
        lbl.addStyleName(Typography.Dark.Body1.PRIMARY);
        lbl.addStyleName(Margins.Bottom.LARGE);
        return lbl;
    }

    private Component createHeadline(String text) {
        Label lbl = new Label(text);
        lbl.addStyleName(Typography.Dark.DatePicker.Title.PRIMARY + " " + MaterialColor.BLUE_500.getFontColorStyle());

        FlexLayout layout = new FlexLayout(lbl);
        layout.setAlignItems(FlexLayout.AlignItems.CENTER);
        layout.setHeight(Metrics.DatePicker.HEADER_HEIGHT, Unit.PIXELS);

        return layout;
    }

}
