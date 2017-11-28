package org.vaadin.components;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.vaadin.layout.*;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;
import org.vaadin.style.Typography;

import java.util.ArrayList;

import static org.vaadin.layout.FlexLayout.FlexDirection.COLUMN;
import static org.vaadin.layout.FlexLayout.FlexDirection.ROW;
import static org.vaadin.layout.Metrics.Stepper.CIRCLE_SIZE;

/**
 * Created by jonte on 23/03/2017.
 */
public class Stepper extends FlexLayout {

    private ArrayList<Step> steps = new ArrayList<Step>();

    public Stepper() {
        addStyleName(Paddings.Horizontal.LARGE);
        addStyleName(Spacings.Right.SMALL);
        setHeight(Metrics.Stepper.HEIGHT, Unit.PIXELS);
        setJustifyContent(JustifyContent.SPACE_BETWEEN);
        setAlignItems(AlignItems.CENTER);
    }

    public Step addStep(String name, String info) {
        if (steps.size() > 0) {
            CssLayout connector = new CssLayout();
            connector.setHeight(Metrics.Stepper.CONNECTOR_HEIGHT, Unit.PIXELS);
            connector.addStyleName(MaterialColor.DARK_DIVIDER.getBackgroundColorStyle());
            connector.addStyleName(FlexItem.FlexGrow.GROW_1);
            addComponent(connector);
        }

        Step s = createStep(steps.size() + 1, name, info);
        addComponent(s);
        steps.add(s);
        return s;
    }

    protected Step createStep(int step, String name, String info) {
        return new Step(step, name, info);
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void completeStep(Step step) {
        completeStep(step, true);
    }

    public void completeStep(Step step, boolean updateIcon) {
        if (steps.contains(step)) step.setComplete(updateIcon);
    }

    public void completeStep(int step) {
        completeStep(step, true);
    }

    public void completeStep(int step, boolean updateIcon) {
        steps.get(step).setComplete(updateIcon);
    }

    public void selectStep(Step step) {
        selectStep(step, true);
    }

    public void selectStep(Step step, boolean updateIcon) {
        if (steps.contains(step)) step.setActive(updateIcon);
    }

    public void selectStep(int step) {
        selectStep(step, true);
    }

    public void selectStep(int step, boolean updateIcon) {
        steps.get(step).setActive(updateIcon);
    }

    public void deselectStep(Step step) {
        deselectStep(step, true);
    }

    public void deselectStep(Step step, boolean updateIcon) {
        if (steps.contains(step)) step.setInactive(updateIcon);
    }

    public void deselectStep(int step) {
        deselectStep(step, true);
    }

    public void deselectStep(int step, boolean updateIcon) {
        steps.get(step).setInactive(updateIcon);
    }

    public void invalidateStep(Step step) {
        invalidateStep(step, true);
    }

    public void invalidateStep(Step step, boolean updateIcon) {
        if (steps.contains(step)) step.setInvalid(updateIcon);
    }

    public void invalidateStep(int step) {
        invalidateStep(step, true);
    }

    public void invalidateStep(int step, boolean updateIcon) {
        steps.get(step).setInvalid(updateIcon);
    }

    public class Step extends FlexLayout {
        int step;
        Label stepLabel;
        Label nameLabel;
        Label infoLabel;

        public Step(int step, String name, String info) {
            setFlexDirection(ROW);
            setAlignItems(AlignItems.CENTER);
            setOverflow(Overflow.HIDDEN);

            this.step = step;

            this.stepLabel = new Label(Integer.toString(step));
            this.stepLabel.setPrimaryStyleName(Typography.Light.Caption.PRIMARY);
            this.stepLabel.addStyleName(FLEXLAYOUT);
            this.stepLabel.addStyleName(AlignItems.CENTER.getStyleName());
            this.stepLabel.addStyleName(JustifyContent.CENTER.getStyleName());
            this.stepLabel.addStyleName(Styles.Misc.BORDER_RADIUS_FULL);
            this.stepLabel.addStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());
            this.stepLabel.addStyleName(FlexItem.FlexShrink.SHRINK_0);
            this.stepLabel.addStyleName(Margins.Right.SMALL);
            this.stepLabel.setContentMode(ContentMode.HTML);
            this.stepLabel.setHeight(CIRCLE_SIZE, Unit.PIXELS);
            this.stepLabel.setWidth(CIRCLE_SIZE, Unit.PIXELS);

            this.nameLabel = new Label(name);
            this.nameLabel.setPrimaryStyleName(Typography.Dark.Body1.PRIMARY);

            this.infoLabel = new Label(info);
            this.infoLabel.setPrimaryStyleName(Typography.Dark.Caption.SECONDARY);

            FlexLayout column = new FlexLayout(COLUMN, nameLabel, infoLabel);
            addComponents(stepLabel, column);
        }

        public void setStepLabel(String value) {
            this.stepLabel.setValue(value);
        }

        public void setStepLabel(MaterialIcons icon) {
            setStepLabel(icon.getHtml());
        }

        public void setStepLabel(MaterialIcons icon, MaterialIcons.Size size) {
            setStepLabel(icon.getHtml(size));
        }

        public void setNameLabel(String value) {
            this.nameLabel.setValue(value);
        }

        public void setInfoLabel(String value) {
            this.infoLabel.setValue(value);
        }

        public void setInactive(boolean updateIcon) {
            if (updateIcon) setStepLabel(Integer.toString(step));
            this.stepLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.addStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());

            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
        }

        public void setActive(boolean updateIcon) {
            if (updateIcon) setStepLabel(Integer.toString(step));
            this.stepLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());

            this.nameLabel.addStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
        }

        public void setInvalid(boolean updateIcon) {
            if (updateIcon) setStepLabel(MaterialIcons.WARNING);
            this.stepLabel.addStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());

            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.addStyleName(MaterialColor.RED_500.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.addStyleName(MaterialColor.RED_500.getFontColorStyle());
        }

        public void setComplete(boolean updateIcon) {
            if (updateIcon) setStepLabel(MaterialIcons.CHECK, MaterialIcons.Size.SMALL);
            this.stepLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());

            this.nameLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);

            if (infoLabel != null) this.infoLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
        }
    }
}
