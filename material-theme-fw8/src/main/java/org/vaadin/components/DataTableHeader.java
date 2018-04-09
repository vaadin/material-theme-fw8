package org.vaadin.components;

import com.vaadin.event.selection.SelectionListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import org.vaadin.layout.*;
import org.vaadin.motion.Transitions;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Typography;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jonte on 17/03/2017.
 */
public class DataTableHeader extends FlexLayout {

    private String title;
    private final Label titleLabel;

    private FlexLayout actionButtonLayout;

    private ArrayList<Button> persistentActions = new ArrayList<>();
    private ArrayList<Button> contextualActions = new ArrayList<>();
    private MaterialColor selectedFontColor = MaterialColor.BLUE_500;
    private MaterialColor selectedBackgroundColor = MaterialColor.BLUE_50;

    private final Grid grid;
    private final SelectionListener selectionListener;
    private Registration registration;

    public DataTableHeader(String title, Grid grid, MaterialColor selectedFontColor, MaterialColor selectedBackgroundColor) {
        this(title, grid);
        setSelectedFontColor(selectedFontColor);
        setSelectedBackgroundColor(selectedBackgroundColor);
    }

    public DataTableHeader(String title, Grid grid) {
        setAlignItems(FlexLayout.AlignItems.CENTER);
        setFlexDirection(FlexDirection.ROW);
        setHeight(Metrics.Table.TITLE_HEIGHT, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);
        addStyleName(FlexItem.FlexShrink.SHRINK_0);
        addStyleName(Paddings.Horizontal.LARGE);
        addStyleName(Transitions.CubicBezier.STANDARD);

        this.title = title;
        this.titleLabel = new Label(title);
        this.titleLabel.setPrimaryStyleName(Typography.Dark.Table.Title.PRIMARY);
        this.titleLabel.setWidth(100, Unit.PERCENTAGE);
        addComponent(this.titleLabel);

        actionButtonLayout = new FlexLayout(FlexDirection.ROW);
        actionButtonLayout.setAlignItems(AlignItems.CENTER);
        actionButtonLayout.addStyleName(Spacings.Right.LARGE);
        addComponent(actionButtonLayout);

        this.grid = grid;

        selectionListener = selectionEvent -> {
            int size = grid.getSelectedItems().size();
            if (size > 0) {
                titleLabel.setValue(size + (size == 1 ? " item selected" : " items selected"));
                titleLabel.setPrimaryStyleName(Typography.Dark.Subheader.PRIMARY);
                titleLabel.addStyleName(selectedFontColor.getFontColorStyle());
                addStyleName(selectedBackgroundColor.getBackgroundColorStyle());
                persistentActions.forEach(button -> button.setVisible(false));
                contextualActions.forEach(button -> button.setVisible(true));
            } else {
                titleLabel.setValue(this.title);
                titleLabel.setPrimaryStyleName(Typography.Dark.Table.Title.PRIMARY);
                titleLabel.removeStyleName(selectedFontColor.getFontColorStyle());
                removeStyleName(selectedBackgroundColor.getBackgroundColorStyle());
                persistentActions.forEach(button -> button.setVisible(true));
                contextualActions.forEach(button -> button.setVisible(false));
            }
        };

        enableSelectionListener();
    }

    public Layout getActionButtonLayout() {
        return actionButtonLayout;
    }

    public void addPersistentActions(Button... buttons) {
        actionButtonLayout.addComponents(buttons);
        for (Button button : buttons) {
            persistentActions.add(button);
            button.setVisible(grid.getSelectedItems().isEmpty());
        }
    }

    public void addContextualActions(Button... buttons) {
        actionButtonLayout.addComponents(buttons);
        for (Button button : buttons) {
            contextualActions.add(button);
            button.setVisible(!grid.getSelectedItems().isEmpty());
        }
    }

    public void enableSelectionListener() {
        registration = this.grid.addSelectionListener(selectionListener);
    }

    public void disableSelectionListener() {
        registration.remove();
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleLabel.setValue(title);
    }

    public void setSelectedFontColor(MaterialColor selectedFontColor) {
        this.selectedFontColor = selectedFontColor;
    }

    public MaterialColor getSelectedFontColor() {
        return selectedFontColor;
    }

    public void setSelectedBackgroundColor(MaterialColor selectedBackgroundColor) {
        this.selectedBackgroundColor = selectedBackgroundColor;
    }

    public MaterialColor getSelectedBackgroundColor() {
        return selectedBackgroundColor;
    }
}
