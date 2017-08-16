package org.vaadin.components;

import com.vaadin.event.selection.SelectionListener;
import com.vaadin.shared.Registration;
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

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonte on 17/03/2017.
 */
public class DataTableHeader extends FlexLayout {

    private final Label titleLabel;
    private final Button filter;
    private final Button more;
    private final Button delete;
    private final SelectionListener selectionListener;
    private final Grid grid;
    boolean gridHasSelection = false;
    private String title;

    private List<HeaderButton> enabledButtons;
    private Registration registration;

    public DataTableHeader(String title, Grid grid) {
        setAlignItems(FlexLayout.AlignItems.CENTER);
        addStyleName(Paddings.Horizontal.LARGE + " " + Spacings.Right.LARGE + " " + Transitions.CubicBezier.STANDARD);
        setHeight(Metrics.Table.TITLE_HEIGHT, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);

        this.titleLabel = new Label();
        setTitle(title);
        this.titleLabel.addStyleName(Typography.Dark.Table.Title.PRIMARY);
        this.titleLabel.setWidth(100, Unit.PERCENTAGE);

        this.grid = grid;

        filter = new IconButton(MaterialIcons.FILTER_LIST, false);
        more = new IconButton(MaterialIcons.MORE_VERT, false);
        delete = new IconButton(MaterialIcons.DELETE, false);
        addComponents(this.titleLabel, filter, delete, more);
        enableButtons(HeaderButton.MORE, HeaderButton.FILTER, HeaderButton.DELETE);

        gridHasSelection = !grid.getSelectedItems().isEmpty();
        delete.setVisible(gridHasSelection);

        selectionListener = selectionEvent -> {
            int size = grid.getSelectedItems().size();
            if (size > 0) {
                gridHasSelection = true;
                titleLabel.setValue(size + (size == 1 ? " item selected" : " items selected"));
                titleLabel.removeStyleName(Typography.Dark.Table.Title.PRIMARY);
                titleLabel.addStyleName(Typography.Dark.Subheader.PRIMARY + " " + MaterialColor.BLUE_500.getFontColorStyle());

                if (enabledButtons.contains(HeaderButton.FILTER)) {
                    filter.setVisible(false);
                }
                if (enabledButtons.contains(HeaderButton.DELETE)) {
                    delete.setVisible(true);
                }

                addStyleName(MaterialColor.BLUE_50.getBackgroundColorStyle());
            } else {
                gridHasSelection = false;
                titleLabel.setValue(this.title);
                titleLabel.addStyleName(Typography.Dark.Table.Title.PRIMARY);
                titleLabel.removeStyleName(Typography.Dark.Subheader.PRIMARY + " " + MaterialColor.BLUE_500.getFontColorStyle());

                if (enabledButtons.contains(HeaderButton.FILTER)) {
                    filter.setVisible(true);
                }

                if (enabledButtons.contains(HeaderButton.DELETE)) {
                    delete.setVisible(false);
                }

                removeStyleName(MaterialColor.BLUE_50.getBackgroundColorStyle());
            }
        };

        enableSelectionListener();
    }

    public void enableSelectionListener() {
        registration = this.grid.addSelectionListener(selectionListener);
    }

    public void disableSelectionListener() {
        registration.remove();
    }

    public void enableButtons(HeaderButton... enabledButtons) {
        this.enabledButtons = Arrays.asList(enabledButtons);

        more.setVisible(false);
        more.setEnabled(false);
        delete.setVisible(false);
        delete.setVisible(false);
        filter.setVisible(false);
        filter.setVisible(false);

        for (HeaderButton enabledButton : this.enabledButtons) {
            switch (enabledButton) {
                case MORE:
                    more.setVisible(true);
                    more.setEnabled(true);
                    break;
                case DELETE:
                    delete.setVisible(gridHasSelection);
                    delete.setEnabled(true);
                    break;
                case FILTER:
                    filter.setVisible(true);
                    filter.setEnabled(true);
                    break;
                default:
                    break;
            }
        }
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleLabel.setValue(title);
    }

    public void addFilterButtonStyleName(String styleName) {
        this.filter.addStyleName(styleName);
    }

    public void removeFilterButtonStyleName(String styleName) {
        this.filter.removeStyleName(styleName);
    }

    public void addMoreButtonStyleName(String styleName) {
        this.more.addStyleName(styleName);
    }

    public void removeMoreButtonStyleName(String styleName) {
        this.more.removeStyleName(styleName);
    }

    public void addDeleteButtonStyleName(String styleName) {
        this.delete.addStyleName(styleName);
    }

    public void removeDeleteButtonStyleName(String styleName) {
        this.delete.removeStyleName(styleName);
    }

    public void addFilterButtonClickListener(Button.ClickListener listener) {
        this.filter.addClickListener(listener);
    }

    public void addMoreButtonClickListener(Button.ClickListener listener) {
        this.more.addClickListener(listener);
    }

    public void addDeleteButtonClickListener(Button.ClickListener listener) {
        this.delete.addClickListener(listener);
    }

    public enum HeaderButton {FILTER, MORE, DELETE}

}
