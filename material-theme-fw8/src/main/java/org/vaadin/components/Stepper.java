package org.vaadin.components;

import com.vaadin.event.LayoutEvents;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.vaadin.layout.*;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;
import org.vaadin.style.Typography;

import java.util.ArrayList;

import static org.vaadin.layout.FlexLayout.FlexDirection.COLUMN;
import static org.vaadin.layout.FlexLayout.FlexDirection.ROW;
import static org.vaadin.layout.Metrics.Stepper.CIRCLE_SIZE;
import static org.vaadin.style.Styles.Misc.CLICKABLE;

/**
 * Created by jonte on 23/03/2017.
 */
public class Stepper extends FlexLayout {

    private ArrayList<Step> steps = new ArrayList<Step>();
    private MaterialColor active = MaterialColor.BLUE_500;
    private MaterialColor inactive = MaterialColor.DARK_DISABLED;
    private MaterialColor invalid = MaterialColor.RED_500;
    private MaterialColor complete = MaterialColor.BLUE_500;

    public Stepper() {
        setAlignItems(AlignItems.CENTER);
        setHeight(Metrics.Stepper.HEIGHT, Unit.PIXELS);
        setJustifyContent(JustifyContent.SPACE_BETWEEN);
    }

    public Stepper(MaterialColor active, MaterialColor inactive, MaterialColor invalid, MaterialColor complete) {
        this();
        this.active = active;
        this.inactive = inactive;
        this.invalid = invalid;
        this.complete = complete;
    }

    public Step addStep(String name, String info) {
        if (steps.size() > 0) {
            CssLayout connector = new CssLayout();
            connector.addStyleName("step-connector");
            connector.addStyleName(FlexItem.FlexGrow.GROW_1);
            connector.addStyleName(MaterialColor.DARK_DIVIDER.getBackgroundColorStyle());
            connector.setHeight(Metrics.Stepper.CONNECTOR_HEIGHT, Unit.PIXELS);
            addComponent(connector);
        }

        Step s = createStep(steps.size() + 1, name, info);
        addComponent(s);
        steps.add(s);
        return s;
    }

    protected Step createStep(int step, String name, String info) {
        return new Step(step, name, info, active, inactive, invalid, complete);
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
        private int step;
        private Label stepLabel;
        private Label nameLabel;
        private Label infoLabel;
        private MaterialColor active;
        private MaterialColor inactive;
        private MaterialColor invalid;
        private MaterialColor complete;
        private String ACTIVE = "step-active";
        private CssLayout ripple;

        public Step(int step, String name, String info, MaterialColor active, MaterialColor inactive, MaterialColor invalid, MaterialColor complete) {
            setAlignItems(AlignItems.CENTER);
            setFlexDirection(ROW);
            setHeight(100, Unit.PERCENTAGE);
            setOverflow(Overflow.HIDDEN);
            setPosition(Position.RELATIVE);
            addStyleName("step");
            addStyleName(Paddings.Horizontal.LARGE);

            this.step = step;

            this.stepLabel = new Label(Integer.toString(step));
            this.stepLabel.setPrimaryStyleName(Typography.Light.Caption.PRIMARY);
            this.stepLabel.addStyleName(FLEXLAYOUT);
            this.stepLabel.addStyleName(AlignItems.CENTER.getStyleName());
            this.stepLabel.addStyleName(FlexItem.FlexShrink.SHRINK_0);
            this.stepLabel.addStyleName(JustifyContent.CENTER.getStyleName());
            this.stepLabel.addStyleName(Margins.Right.SMALL);
            this.stepLabel.addStyleName(inactive.getBackgroundColorStyle());
            this.stepLabel.addStyleName(Styles.Misc.BORDER_RADIUS_FULL);
            this.stepLabel.setContentMode(ContentMode.HTML);
            this.stepLabel.setHeight(CIRCLE_SIZE, Unit.PIXELS);
            this.stepLabel.setWidth(CIRCLE_SIZE, Unit.PIXELS);

            this.nameLabel = new Label(name);
            this.nameLabel.setPrimaryStyleName(Typography.Dark.Body1.PRIMARY);

            this.infoLabel = new Label(info);
            this.infoLabel.setPrimaryStyleName(Typography.Dark.Caption.SECONDARY);

            FlexLayout column = new FlexLayout(COLUMN, nameLabel, infoLabel);
            addComponents(stepLabel, column);

            this.active = active;
            this.inactive = inactive;
            this.invalid = invalid;
            this.complete = complete;
        }

        public void addClickListener(LayoutEvents.LayoutClickListener listener) {
            addStyleName(CLICKABLE);
            addLayoutClickListener(listener);
            addLayoutClickListener(event -> {
                if (ripple == null) {
                    ripple = new CssLayout();
                    ripple.setPrimaryStyleName("step-ripple");
                    addComponent(ripple, 0);
                } else {
                    CssLayout newRipple = new CssLayout();
                    newRipple.setPrimaryStyleName("step-ripple");
                    replaceComponent(ripple, newRipple);
                    ripple = newRipple;
                }
            });
        }

        public String getStepLabel() { return this.stepLabel.getValue(); }

        public void setStepLabel(String value) {
            this.stepLabel.setValue(value);
        }

        public void setStepLabel(MaterialIcons icon) {
            setStepLabel(icon.getHtml());
        }

        public void setStepLabel(MaterialIcons icon, MaterialIcons.Size size) {
            setStepLabel(icon.getHtml(size));
        }

        public String getNameLabel() { return this.nameLabel.getValue(); }

        public void setNameLabel(String value) {
            this.nameLabel.setValue(value);
        }

        public String getInfoLabel() { return this.infoLabel.getValue(); }

        public void setInfoLabel(String value) {
            this.infoLabel.setValue(value);
        }

        public void setInactive(boolean updateIcon) {
            if (updateIcon) setStepLabel(Integer.toString(step));
            this.stepLabel.removeStyleName(active.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(complete.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(invalid.getFontColorStyle());
            this.stepLabel.addStyleName(inactive.getBackgroundColorStyle());

            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.removeStyleName(invalid.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.removeStyleName(invalid.getFontColorStyle());

            removeStyleName(ACTIVE);
        }

        public void setActive(boolean updateIcon) {
            if (updateIcon) setStepLabel(Integer.toString(step));
            this.stepLabel.removeStyleName(complete.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(inactive.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(invalid.getFontColorStyle());
            this.stepLabel.addStyleName(active.getBackgroundColorStyle());

            this.nameLabel.addStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.removeStyleName(invalid.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.removeStyleName(invalid.getFontColorStyle());

            addStyleName(ACTIVE);
        }

        public void setInvalid(boolean updateIcon) {
            if (updateIcon) setStepLabel(MaterialIcons.WARNING);
            this.stepLabel.removeStyleName(active.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(complete.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(inactive.getBackgroundColorStyle());
            this.stepLabel.addStyleName(invalid.getFontColorStyle());

            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.addStyleName(invalid.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.addStyleName(invalid.getFontColorStyle());

            removeStyleName(ACTIVE);
        }

        public void setComplete(boolean updateIcon) {
            if (updateIcon) setStepLabel(MaterialIcons.CHECK, MaterialIcons.Size.SMALL);
            this.stepLabel.removeStyleName(active.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(inactive.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(invalid.getFontColorStyle());
            this.stepLabel.addStyleName(complete.getBackgroundColorStyle());

            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.removeStyleName(invalid.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.removeStyleName(invalid.getFontColorStyle());

            removeStyleName(ACTIVE);
        }
    }
}
