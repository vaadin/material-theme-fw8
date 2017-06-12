package org.test.views;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TabSheet;
import org.test.components.Tabs;
import org.test.layout.FlexLayout;
import org.test.layout.Paddings;
import org.test.layout.Spacings;
import org.test.style.MaterialColor;
import org.test.style.MaterialIcons;

/**
 * Created by jonte on 23/03/2017.
 */
public class TabsView extends FlexLayout {

    public TabsView() {
        setAlignSelf(AlignSelf.BASELINE);
        setFlexDirection(FlexDirection.COLUMN);
        addStyleName(Paddings.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);
        setWidth(100, Unit.PERCENTAGE);

        addComponents(
                createTabs(true, true, false),
                createTabs(true, true, true),
                createTabs(true, false, true),
                createTabs(false, true, false),
                createTabs(false, true, true),
                createTabs(false, false, true),
                createTabSheet(true, true, false),
                createTabSheet(true, true, true),
                createTabSheet(true, false, true),
                createTabSheet(false, true, false),
                createTabSheet(false, true, true),
                createTabSheet(false, false, true)
        );

    }

    private Tabs createTabs(boolean lightTheme, boolean captions, boolean icons) {
        Tabs tabs = new Tabs(lightTheme);
        tabs.addStyleName("card" + " " + Paddings.Horizontal.LARGE);
        if (!lightTheme) tabs.addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());

        if (captions && icons) {
            tabs.addTab(MaterialIcons.PHONE, "Item One");
            tabs.addTab(MaterialIcons.FAVORITE, "Item Two");
            tabs.addTab(MaterialIcons.NEAR_ME, "Item Three");
        } else if (captions) {
            tabs.addTab("Item One");
            tabs.addTab("Item Two");
            tabs.addTab("Item Three");
        } else if (icons) {
            tabs.addTab(MaterialIcons.PHONE);
            tabs.addTab(MaterialIcons.FAVORITE);
            tabs.addTab(MaterialIcons.NEAR_ME);
        }

        return tabs;
    }

    private TabSheet createTabSheet(boolean lightTheme, boolean captions, boolean icons) {
        TabSheet tabs = new TabSheet();
        tabs.setPrimaryStyleName(lightTheme ? "md-tabsheet-light" : "md-tabsheet-dark");
        tabs.addStyleName("card" + " " + Paddings.Horizontal.LARGE);
        if (!lightTheme) {
            tabs.addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
        }

        if (captions && icons) {
            tabs.addTab(new CssLayout(), "Item One", MaterialIcons.PHONE);
            tabs.addTab(new CssLayout(), "Item Two", MaterialIcons.FAVORITE);
            tabs.addTab(new CssLayout(), "Item Three", MaterialIcons.NEAR_ME);
        } else if (captions) {
            tabs.addTab(new CssLayout(), "Item One");
            tabs.addTab(new CssLayout(), "Item Two");
            tabs.addTab(new CssLayout(), "Item Three");
        } else if (icons) {
            tabs.addTab(new CssLayout(), null, MaterialIcons.PHONE);
            tabs.addTab(new CssLayout(), null, MaterialIcons.FAVORITE);
            tabs.addTab(new CssLayout(), null, MaterialIcons.NEAR_ME);
        }

        return tabs;
    }
}
