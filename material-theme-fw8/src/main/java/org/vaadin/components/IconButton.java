package org.vaadin.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import org.vaadin.style.Styles;

/**
 * Created by jonte on 14/03/2017.
 */
public class IconButton extends Button {

    public IconButton(Resource icon) {
        setIcon(icon);
        initTheme(true);
    }

    public IconButton(Resource icon, boolean light) {
        setIcon(icon);
        initTheme(light);
    }

    private void initTheme(boolean light) {
        setPrimaryStyleName(light ? Styles.Buttons.IconButtons.LIGHT : Styles.Buttons.IconButtons.DARK);
    }

    public void setSize(Size size) {
        for (Size value : Size.values()) {
            removeStyleName(value.getStyleName());
        }
        addStyleName(size.getStyleName());
    }

    public enum Size {
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large");

        private final String styleName;

        Size(String styleName) {
            this.styleName = styleName;
        }

        public String getStyleName() {
            return styleName;
        }
    }
}
