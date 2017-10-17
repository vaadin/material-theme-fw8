package org.vaadin.components;

import com.vaadin.server.FontIcon;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.vaadin.style.MaterialIcons;

/**
 * Created by jonte on 14/03/2017.
 */
public class NavigationItem extends CssLayout {

    private Component component;

    private CssLayout icon = new CssLayout();
    private Label caption = new Label();
    private Label count = new Label();

    public NavigationItem(Resource icon, String caption, Integer count) {
        String primaryStyleName = "md-naviitem";
        setPrimaryStyleName(primaryStyleName);

        this.icon.setPrimaryStyleName(primaryStyleName + "-icon");
        this.caption.setPrimaryStyleName(primaryStyleName + "-caption");
        this.count.setPrimaryStyleName(primaryStyleName + "-count");

        setIcon(icon);
        setCaption(caption);
        setCount(count);

        addComponents(this.icon, this.caption, this.count);
    }

    public NavigationItem(Resource icon, String caption) {
        this(icon, caption, (Integer) null);
    }

    public NavigationItem(Resource icon) {
        this(icon, null, (Integer) null);
    }

    public NavigationItem(String caption) {
        this(null, caption, (Integer) null);
    }

    public NavigationItem(Resource icon, String caption, Integer count, Component component) {
        this(icon, caption, count);
        setComponent(component);
    }

    public NavigationItem(Resource icon, String caption, Component component) {
        this(icon, caption, (Integer) null);
        setComponent(component);
    }

    public NavigationItem(Resource icon, Component component) {
        this(icon, null, (Integer) null);
        setComponent(component);
    }

    public NavigationItem(String caption, Component component) {
        this(null, caption, (Integer) null);
        setComponent(component);
    }

    public void setIcon(Resource source) {
        if (source == null) {
            this.icon.setVisible(false);
        } else {
            this.icon.setVisible(true);
            this.icon.removeAllComponents();
            if (source instanceof FontIcon) {
                this.icon.addComponent(new Label(((FontIcon) source).getHtml(), ContentMode.HTML));
            } else {
                this.icon.addComponent(new Image(null, source));
            }
        }
    }

    public void setCaption(String caption) {
        this.caption.setValue(caption);
    }

    public String getCaption() {
        return this.caption.getValue();
    }

    public void setCount(Integer count) {
        if (count == null) {
            this.count.setVisible(false);
        } else {
            this.count.setVisible(true);
            this.count.setValue(Integer.toString(count));
        }
    }

    public Integer getCount() {
        return Integer.parseInt(this.count.getValue());
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Component getComponent() {
        return this.component;
    }
}
