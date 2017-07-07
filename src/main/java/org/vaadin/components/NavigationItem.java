package org.vaadin.components;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

public class NavigationItem extends Button {

    public NavigationItem(Resource icon, String caption) {
        setPrimaryStyleName("md-naviitem");
        setIcon(icon);
        setCaption(caption);
    }

    @Override
    public boolean equals(Object other){
        if (other != null && other instanceof NavigationItem){
            return ((NavigationItem) other).getCaption().equals(getCaption());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return getCaption().hashCode();
    }
}
