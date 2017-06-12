package org.test.views;

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.Position;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import org.test.components.lists.ListItem;
import org.test.components.lists.SingleLineListItem;
import org.test.components.lists.TwoLineListItem;
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

        addComponent(createList(true, false, false, null, false, false, false, null, false, false));
        addComponent(createList(true, true, false, ListItem.IconSize.SMALL, false, false, false, null, false, false));
        addComponent(createList(true, false, false, ListItem.IconSize.LARGE, false, true, false, null, false, false));
        addComponent(createList(true, false, true, ListItem.IconSize.LARGE, false, false, true, null, false, false));

        addComponent(createList(false, false, false, null, false, false, false, null, false, false));
        addComponent(createList(false, true, false, ListItem.IconSize.SMALL, false, false, false, null, false, false));
        addComponent(createList(false, false, false, ListItem.IconSize.LARGE, false, true, false, null, false, false));
        addComponent(createList(false, false, true, ListItem.IconSize.LARGE, false, false, true, null, false, false));
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = enumRandomizer.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    private CssLayout createList(boolean single, boolean icon, boolean image, ListItem.IconSize iconSize, boolean iconFontColor, boolean iconBackgroundColor, boolean iconSecondary, ListItem.IconSize iconSecondarySize, boolean iconSecondaryFontColor, boolean iconSecondaryBackgroundColor) {
        CssLayout card = new CssLayout();
        card.addStyleName("card");
        card.addStyleName(Paddings.Vertical.SMALL);
        for (int i = 0; i < 3; i++)
            card.addComponent(createListItem(single, icon, image, iconSize, iconFontColor, iconBackgroundColor, iconSecondary, iconSecondarySize, iconSecondaryFontColor, iconSecondaryBackgroundColor));
        return card;
    }

    private ListItem createListItem(boolean single, boolean icon, boolean image, ListItem.IconSize iconSize, boolean iconFontColor, boolean iconBackgroundColor, boolean iconSecondary, ListItem.IconSize iconSecondarySize, boolean iconSecondaryFontColor, boolean iconSecondaryBackgroundColor) {
        ListItem item;
        if (single) item = new SingleLineListItem("Single-line item");
        else item = new TwoLineListItem("Two-line item", "Secondary text");

        if (icon) item.setPrimaryIcon(randomEnum(MaterialIcons.class));
        if (image) item.setPrimaryIcon(getRandomImage());
        if (iconSize != null) item.setPrimaryIconSize(iconSize);
        if (iconFontColor) item.setPrimaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconBackgroundColor) item.setPrimaryIconBackgroundColor(randomEnum(MaterialColor.class));

        if (iconSecondary) item.setSecondaryIcon(randomEnum(MaterialIcons.class));
        if (iconSecondarySize != null) item.setSecondaryIconSize(iconSecondarySize);
        if (iconSecondaryFontColor) item.setSecondaryIconFontColor(randomEnum(MaterialColor.class));
        if (iconSecondaryBackgroundColor) item.setSecondaryIconBackgroundColor(randomEnum(MaterialColor.class));

        item.addPrimaryActionListener((LayoutEvents.LayoutClickListener) e -> {
            if (item.getSecondaryIcon() == null || e.getChildComponent() == null || !e.getChildComponent().equals(item.getSecondaryIcon()))
                createNotification("Primary action clicked");
        });

        item.addSecondaryActionListener((LayoutEvents.LayoutClickListener) e -> createNotification("Secondary action clicked"));

        return item;
    }

    private ThemeResource getRandomImage() {
        return new ThemeResource("img/" + filenames[imageRandomizer.nextInt(filenames.length)] + ".png");
    }

    private void createNotification(String message) {
        Notification notification = new Notification(message);
        notification.setDelayMsec(3000);
        notification.setPosition(Position.BOTTOM_CENTER);
        notification.show(getUI().getPage());
    }
}
