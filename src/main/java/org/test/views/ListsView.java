package org.test.views;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import org.test.components.ListItem;
import org.test.components.SingleLineListItem;
import org.test.components.TwoLineListItem;
import org.test.layout.FlexLayout;
import org.test.layout.Margins;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.MaterialIcons;

import java.security.SecureRandom;

/**
 * Created by jonte on 17/03/2017.
 */
public class ListsView extends FlexLayout {

    private static final SecureRandom enumRandomizer = new SecureRandom();
    private static final SecureRandom imageRandomizer = new SecureRandom();
    private String[] filenames = new String[]{"hannu", "jarmo", "joacim", "jouni", "rofa"};

    public ListsView() {
        setAlignSelf(AlignSelf.BASELINE);
        setFlexDirection(FlexDirection.COLUMN);
        addStyleName(Margins.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);
        setWidth(360, Unit.PIXELS);


        addComponent(createSingleLineList(false, null, false, false, false, null, false, false));

        addComponent(createSingleLineList(false, ListItem.IconSize.SMALL, false, true, false, null, false, false));
        addComponent(createSingleLineList(false, ListItem.IconSize.LARGE, false, true, false, null, false, false));
        addComponent(createSingleLineList(false, ListItem.IconSize.LARGE, false, true, true, ListItem.IconSize.SMALL, false, false));

        addComponent(createSingleLineList(true, ListItem.IconSize.SMALL, true, false, false, null, false, false));

        addComponent(createSingleLineList(true, ListItem.IconSize.SMALL, true, true, false, null, false, false));
        addComponent(createSingleLineList(true, ListItem.IconSize.LARGE, true, true, false, null, false, false));

        addComponent(createSingleLineListWithAvatar(true, ListItem.IconSize.SMALL, false, false, false, null, false, false));
        addComponent(createSingleLineListWithAvatar(true, ListItem.IconSize.LARGE, false, false, false, null, false, false));


        addComponent(createTwoLineList(false, null, false, false));

        addComponent(createTwoLineList(false, ListItem.IconSize.SMALL, false, true));
        addComponent(createTwoLineList(false, ListItem.IconSize.LARGE, false, true));

        addComponent(createTwoLineList(true, ListItem.IconSize.SMALL, true, false));

        addComponent(createTwoLineList(true, ListItem.IconSize.SMALL, true, true));
        addComponent(createTwoLineList(true, ListItem.IconSize.LARGE, true, true));

        addComponent(createTwoLineListWithAvatar(true, ListItem.IconSize.SMALL, false, false));
        addComponent(createTwoLineListWithAvatar(true, ListItem.IconSize.LARGE, false, false));

    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = enumRandomizer.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    private CssLayout createSingleLineList(boolean icon,
                                           ListItem.IconSize iconSize,
                                           boolean iconFontColor,
                                           boolean iconBackgroundColor,
                                           boolean iconSecondary,
                                           ListItem.IconSize iconSecondarySize,
                                           boolean iconSecondaryFontColor,
                                           boolean iconSecondaryBackgroundColor) {
        CssLayout card = new CssLayout();
        card.addStyleName("card");
        card.addStyleName(Paddings.Vertical.SMALL);
        for (int i = 0; i < 3; i++)
            card.addComponent(createSingleLineListItem(icon, iconSize, iconFontColor, iconBackgroundColor, iconSecondary, iconSecondarySize, iconSecondaryFontColor, iconSecondaryBackgroundColor));
        return card;
    }

    private CssLayout createSingleLineListWithAvatar(boolean icon,
                                                     ListItem.IconSize iconSize,
                                                     boolean iconFontColor,
                                                     boolean iconBackgroundColor,
                                                     boolean iconSecondary,
                                                     ListItem.IconSize iconSecondarySize,
                                                     boolean iconSecondaryFontColor,
                                                     boolean iconSecondaryBackgroundColor) {
        CssLayout card = new CssLayout();
        card.addStyleName("card");
        card.addStyleName(Paddings.Vertical.SMALL);
        for (int i = 0; i < 3; i++)
            card.addComponent(createSingleLineListItemWithAvatar(icon, iconSize, iconFontColor, iconBackgroundColor, iconSecondary, iconSecondarySize, iconSecondaryFontColor, iconSecondaryBackgroundColor));
        return card;
    }

    private SingleLineListItem createSingleLineListItem(boolean icon,
                                                        ListItem.IconSize iconSize,
                                                        boolean iconFontColor,
                                                        boolean iconBackgroundColor,
                                                        boolean iconSecondary,
                                                        ListItem.IconSize iconSecondarySize,
                                                        boolean iconSecondaryFontColor,
                                                        boolean iconSecondaryBackgroundColor) {
        SingleLineListItem item = new SingleLineListItem("Single-line item");

        if (icon) item.setPrimaryIcon(randomEnum(MaterialIcons.class));
        if (iconSize != null) item.setPrimaryIconSize(iconSize);
        if (iconFontColor) item.setPrimaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconBackgroundColor) item.setPrimaryIconBackgroundColor(randomEnum(MaterialColor.class));

        if (iconSecondary) item.setSecondaryIcon(randomEnum(MaterialIcons.class));
        if (iconSecondarySize != null) item.setSecondaryIconSize(iconSecondarySize);
        if (iconSecondaryFontColor) item.setSecondaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconSecondaryBackgroundColor) item.setSecondaryIconBackgroundColor(randomEnum(MaterialColor.class));

        return item;
    }

    private SingleLineListItem createSingleLineListItemWithAvatar(boolean icon,
                                                                  ListItem.IconSize iconSize,
                                                                  boolean iconFontColor,
                                                                  boolean iconBackgroundColor,
                                                                  boolean iconSecondary,
                                                                  ListItem.IconSize iconSecondarySize,
                                                                  boolean iconSecondaryFontColor,
                                                                  boolean iconSecondaryBackgroundColor) {
        SingleLineListItem item = new SingleLineListItem("Single-line item");

        if (icon) item.setPrimaryIcon(getRandomImage());
        if (iconSize != null) item.setPrimaryIconSize(iconSize);
        if (iconFontColor) item.setPrimaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconBackgroundColor) item.setPrimaryIconBackgroundColor(randomEnum(MaterialColor.class));

        if (iconSecondary) item.setSecondaryIcon(randomEnum(MaterialIcons.class));
        if (iconSecondarySize != null) item.setSecondaryIconSize(iconSecondarySize);
        if (iconSecondaryFontColor) item.setSecondaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconSecondaryBackgroundColor) item.setSecondaryIconBackgroundColor(randomEnum(MaterialColor.class));

        return item;
    }

    private CssLayout createTwoLineList(boolean icon, ListItem.IconSize iconSize, boolean iconFontColor, boolean iconBackgroundColor) {
        CssLayout card = new CssLayout();
        card.addStyleName("card");
        card.addStyleName(Paddings.Vertical.SMALL);
        for (int i = 0; i < 3; i++)
            card.addComponent(createTwoLineListItem(icon, iconSize, iconFontColor, iconBackgroundColor));
        return card;
    }

    private CssLayout createTwoLineListWithAvatar(boolean image, ListItem.IconSize iconSize, boolean iconFontColor, boolean iconBackgroundColor) {
        CssLayout card = new CssLayout();
        card.addStyleName("card");
        card.addStyleName(Paddings.Vertical.SMALL);
        for (int i = 0; i < 3; i++)
            card.addComponent(createTwoLineListItemWithAvatar(image, iconSize, iconFontColor, iconBackgroundColor));
        return card;
    }

    private TwoLineListItem createTwoLineListItem(boolean icon, ListItem.IconSize iconSize, boolean iconFontColor, boolean iconBackgroundColor) {
        TwoLineListItem item = new TwoLineListItem("Two-line item", "Secondary text");
        if (icon) item.setPrimaryIcon(randomEnum(MaterialIcons.class));
        if (iconSize != null) item.setPrimaryIconSize(iconSize);
        if (iconFontColor) item.setPrimaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconBackgroundColor) item.setPrimaryIconBackgroundColor(randomEnum(MaterialColor.class));
        return item;
    }

    private TwoLineListItem createTwoLineListItemWithAvatar(boolean image, ListItem.IconSize iconSize, boolean iconFontColor, boolean iconBackgroundColor) {
        TwoLineListItem item = new TwoLineListItem("Two-line item", "Secondary text");
        if (image) item.setPrimaryIcon(getRandomImage());
        if (iconSize != null) item.setPrimaryIconSize(iconSize);
        if (iconFontColor) item.setPrimaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconBackgroundColor) item.setPrimaryIconBackgroundColor(randomEnum(MaterialColor.class));
        return item;
    }

    private ThemeResource getRandomImage() {
        return new ThemeResource("img/" + filenames[imageRandomizer.nextInt(filenames.length)] + ".png");
    }
}
