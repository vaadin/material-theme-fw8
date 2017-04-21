package org.test.components;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.test.layout.*;
import org.test.style.Typography;

/**
 * Created by jonte on 03/04/2017.
 */
public class MDDataTableLayout extends FlexLayout {

    private final FlexLayout headers;
    private final FlexLayout items;

    public MDDataTableLayout() {
        super(FlexDirection.COLUMN);
        setPrimaryStyleName("md-datatable-layout");

        headers = new FlexLayout();
        headers.setPrimaryStyleName("md-datatable-header");
        headers.setAlignItems(FlexLayout.AlignItems.CENTER);
        headers.setHeight(Metrics.Table.COLUMN_HEADER_HEIGHT, Unit.PIXELS);
        headers.addStyleName(Borders.Light.BOTTOM);
        headers.addStyleName(Spacings.Right.LARGE);

        items = new FlexLayout(FlexLayout.FlexDirection.COLUMN);
        items.setPrimaryStyleName("md-datatable-rows");

        addComponents(headers, items);
    }

    public void setHeaders(String... headers) {
        for (String header : headers) {
            Label lbl = new Label(header);
            lbl.setContentMode(ContentMode.HTML);
            lbl.setPrimaryStyleName(Typography.Dark.Table.Header.SECONDARY);
            this.headers.addComponent(lbl);
        }
    }

    public void addItem(Object... values) {
        FlexLayout item = new FlexLayout();
        item.setPrimaryStyleName("md-datatable-row");
        item.addStyleName(Spacings.Right.LARGE);
        item.addStyleName(Paddings.Vertical.TABLE);
        for (Object value : values) {
            if (value instanceof String) {
                Label lbl = new Label((String) value);
                lbl.setContentMode(ContentMode.HTML);
                lbl.setPrimaryStyleName(Typography.Dark.Table.Row.PRIMARY);
                item.addComponent(lbl);
            } else if (value instanceof Component) {
                item.addComponent((Component) value);
            }
        }
        items.addComponent(item);
    }

    public void setColumnWidth(int index, int value, Unit unit) {
        headers.getComponent(index).setWidth(value, unit);
        items.forEach(component -> ((CssLayout) component).getComponent(index).setWidth(value, unit));
    }
}
