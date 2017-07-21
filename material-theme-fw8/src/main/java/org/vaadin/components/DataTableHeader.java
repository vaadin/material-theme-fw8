package org.vaadin.components;

import com.vaadin.event.selection.SelectionListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Metrics;
import org.vaadin.layout.Paddings;
import org.vaadin.layout.Spacings;
import org.vaadin.motion.Transitions;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Typography;

/**
 * Created by jonte on 17/03/2017.
 */
public class DataTableHeader extends FlexLayout {

    private String title;
    private final Label titleLabel;
    private final Button filter;
    private final Button more;
    private final Button delete;

    public DataTableHeader(String title) {
        setAlignItems(FlexLayout.AlignItems.CENTER);
        addStyleName(Paddings.Horizontal.LARGE + " " + Spacings.Right.LARGE + " " + Transitions.CubicBezier.STANDARD);
        setHeight(Metrics.Table.TITLE_HEIGHT, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);


        this.titleLabel = new Label();
        setTitle(title);
        this.titleLabel.addStyleName(Typography.Dark.Table.Title.PRIMARY);
        this.titleLabel.setWidth(100, Unit.PERCENTAGE);

        filter = new IconButton(MaterialIcons.FILTER_LIST, false);

        more = new IconButton(MaterialIcons.MORE_VERT, false);

        delete = new IconButton(MaterialIcons.DELETE, false);
        delete.setVisible(false);

        addComponents(this.titleLabel, filter, delete, more);
    }

    public void setTitle(String title){
        this.title = title;
        this.titleLabel.setValue(title);
    }

    public void setGrid(Grid grid) {
        grid.addSelectionListener((SelectionListener) selectionEvent -> {
            int size = grid.getSelectedItems().size();
            if (size > 0) {
                titleLabel.setValue(size + (size == 1 ? " item selected" : " items selected"));
                titleLabel.removeStyleName(Typography.Dark.Table.Title.PRIMARY);
                titleLabel.addStyleName(Typography.Dark.Subheader.PRIMARY + " " + MaterialColor.BLUE_500.getFontColorStyle());

                filter.setVisible(false);
                delete.setVisible(true);
                addStyleName(MaterialColor.BLUE_50.getBackgroundColorStyle());
            } else {
                titleLabel.setValue(title);
                titleLabel.addStyleName(Typography.Dark.Table.Title.PRIMARY);
                titleLabel.removeStyleName(Typography.Dark.Subheader.PRIMARY + " " + MaterialColor.BLUE_500.getFontColorStyle());

                filter.setVisible(true);
                delete.setVisible(false);
                removeStyleName(MaterialColor.BLUE_50.getBackgroundColorStyle());
            }
        });
    }
}
