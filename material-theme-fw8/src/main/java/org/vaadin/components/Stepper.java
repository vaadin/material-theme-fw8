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

        Step s = new Step(steps.size() + 1, name, info);
        addComponent(s);
        steps.add(s);
        return s;
    }

    public void completeStep(Step step) {
        if (steps.contains(step)) step.setComplete();
    }

    public void completeStep(int step) {
        steps.get(step).setComplete();
    }

    public void selectStep(Step step) {
        if (steps.contains(step)) step.setActive();
    }

    public void selectStep(int step) {
        steps.get(step).setActive();
    }

    public void invalidateStep(Step step) {
        if (steps.contains(step)) step.setInvalid();
    }

    public void invalidateStep(int step) {
        steps.get(step).setInvalid();
    }

    public class Step extends FlexLayout {
        Label stepLabel;
        Label nameLabel;
        Label infoLabel;

        public Step(int step, String name, String info) {
            setFlexDirection(ROW);
            setAlignItems(AlignItems.CENTER);
            setOverflow(Overflow.HIDDEN);

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

            if (info != null) {
                this.infoLabel = new Label(info);
                this.infoLabel.setPrimaryStyleName(Typography.Dark.Caption.SECONDARY);
                FlexLayout column = new FlexLayout(COLUMN, nameLabel, infoLabel);
                addComponents(stepLabel, column);
            } else {
                addComponents(stepLabel, nameLabel);
            }
        }

        public void setActive() {
            this.stepLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());

            this.nameLabel.addStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
        }

        public void setInvalid() {
            this.stepLabel.setValue(MaterialIcons.WARNING.getHtml());
            this.stepLabel.addStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());

            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
            this.nameLabel.addStyleName(MaterialColor.RED_500.getFontColorStyle());

            if (infoLabel != null) this.infoLabel.addStyleName(MaterialColor.RED_500.getFontColorStyle());
        }

        public void setComplete() {
            this.stepLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.stepLabel.addStyleName(MaterialColor.BLUE_500.getBackgroundColorStyle());
            this.stepLabel.removeStyleName(MaterialColor.DARK_DISABLED.getBackgroundColorStyle());
            this.stepLabel.setValue(MaterialIcons.CHECK.getHtml(MaterialIcons.Size.SMALL));

            this.nameLabel.removeStyleName(MaterialColor.RED_500.getFontColorStyle());
            this.nameLabel.removeStyleName(Typography.FontWeight.MEDIUM);
        }
    }
}
