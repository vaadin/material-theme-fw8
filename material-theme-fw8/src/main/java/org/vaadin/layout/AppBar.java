package org.vaadin.layout;

import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;
import org.vaadin.style.Typography;

/**
 * Created by jonte on 13/03/2017.
 */
public class AppBar extends CssLayout {

    private Button naviIcon = new Button();

    public AppBar() {
        super();
        setPrimaryStyleName("md-appbar");
        addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());

        naviIcon.setIcon(MaterialIcons.MENU);
        naviIcon.setPrimaryStyleName(Styles.Buttons.NAV_ICON);

        Label appBarTitle = new Label("Material Design");
        appBarTitle.setPrimaryStyleName(Typography.Light.Title.PRIMARY);
        appBarTitle.setSizeUndefined();

        addComponents(naviIcon, appBarTitle);
    }

    public Button getNaviIcon() {
        return naviIcon;
    }

    public void addNaviIconClickListener(Button.ClickListener listener) {
        naviIcon.addClickListener(listener);
    }
}
