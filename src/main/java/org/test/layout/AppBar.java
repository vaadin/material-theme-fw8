package org.test.layout;

import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.test.style.MaterialColor;
import org.test.style.MaterialIcons;
import org.test.style.Styles;
import org.test.style.Typography;

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
