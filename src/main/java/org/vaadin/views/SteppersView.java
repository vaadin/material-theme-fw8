package org.vaadin.views;

import com.vaadin.server.Sizeable;
import org.vaadin.components.Stepper;
import org.vaadin.layout.FlexLayout;
import org.vaadin.layout.Paddings;
import org.vaadin.layout.Spacings;

/**
 * Created by jonte on 08/07/2017.
 */
public class SteppersView extends FlexLayout {

    public SteppersView() {
        setAlignSelf(FlexLayout.AlignSelf.BASELINE);
        setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        addStyleName(Paddings.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);
        setWidth(100, Sizeable.Unit.PERCENTAGE);

        Stepper s1 = createStepper();
        s1.selectStep(0);

        Stepper s2 = createStepper();
        s2.completeStep(0);
        s2.selectStep(1);

        Stepper s3 = createStepper();
        s3.completeStep(0);
        s3.invalidateStep(1);
        s3.selectStep(2);

        addComponents(s1, s2, s3);
    }

    private Stepper createStepper() {
        Stepper stepper = new Stepper();
        stepper.addStyleName("card");
        stepper.addStep("Select campaign settings", null);
        stepper.addStep("Create an ad group", "Optional");
        stepper.addStep("Create an ad", null);
        return stepper;
    }
}