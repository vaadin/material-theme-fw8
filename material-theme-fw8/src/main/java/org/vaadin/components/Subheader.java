package org.vaadin.components;

import com.vaadin.ui.Label;
import org.vaadin.layout.FlexItem;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Metrics;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.Typography;

/**
 * Created by jonte on 17/08/2017.
 */
public class Subheader extends FlexLayout {

    private Label label;

    public Subheader(String value, boolean light) {
        addStyleName(FlexItem.FlexShrink.SHRINK_0);
        setAlignItems(AlignItems.CENTER);
        setHeight(Metrics.Subheader.HEIGHT, Unit.PIXELS);

        label = new Label(value);
        label.addStyleName(light ? Typography.Light.Body2.SECONDARY : Typography.Dark.Body2.SECONDARY);

        addComponent(label);
    }

    public Subheader(String value, boolean light, MaterialColor color) {
        this(value, light);
        setFontColor(color);
    }

    public Label getLabel() {
        return this.label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setFontColor(MaterialColor color) {
        this.label.addStyleName(color.getFontColorStyle());
    }
}
