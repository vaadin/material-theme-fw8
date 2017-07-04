package org.vaadin.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.vaadin.Mixin;
import org.vaadin.components.*;
import org.vaadin.components.lists.TwoLineListItem;
import org.vaadin.layout.*;
import org.vaadin.style.MaterialColor;
import org.vaadin.style.MaterialIcons;
import org.vaadin.style.Styles;
import org.vaadin.style.Typography;

/**
 * Created by jonte on 14/03/2017.
 */
public class ButtonsView extends FlexLayout {

    public static final String TYPE_COLOR = "hex color, rgb, rgba, hsl";
    public static final String TYPE_PX = "px";
    public static final String TYPE_SEC = "s, ms";

    public static final String ICON_TOGGLES = "Icon toggles";
    public static final String ICON_TOGGLES_LIGHT = "Icon toggles (light icon)";
    public static final String ICON_TOGGLES_DARK = "Icon toggles (dark icon)";
    public static final String ICON_TOGGLES_COLOR = "Icon toggles (color icon)";
    public static final String ICON_TOGGLES_DARKTHEME = "Icon toggles (dark theme)";

    public static final String TOGGLE_BUTTONS = "Toggle buttons";

    public static final String RAISED_BUTTONS = "Raised buttons";
    public static final String RAISED_BUTTONS_DARK_THEME = "Raised buttons (dark theme)";
    public static final String RAISED_BUTTONS_LIGHT_THEME = "Raised buttons (light theme)";

    public static final String FLAT_BUTTONS = "Flat buttons";
    public static final String FLAT_BUTTONS_DARK_THEME = "Flat buttons (dark theme)";
    public static final String FLAT_BUTTONS_LIGHT_THEME = "Flat buttons (light theme)";

    public static final String FONT_COLOR = "Font color.";
    public static final String BACKGROUND_COLOR = "Background color.";
    public static final String MINIMUM_WIDTH = "Minimum width.";
    public static final String RIGHT_AND_LEFT_PADDING = "Right and left padding.";

    public static final String ACTIVE_FONT_COLOR = "Font color when active.";
    public static final String ACTIVE_BACKGROUND_COLOR = "Background color when active.";
    public static final String INACTIVE_FONT_COLOR = "Font color when inactive.";

    public static final String FOCUSED_BACKGROUND_COLOR = "Background color when focused.";

    public static final String RIPPLE_COLOR = "Ripple color.";
    public static final String RIPPLE_DURATION = "Ripple duration.";
    public static final String RIPPLE_SIZE = "Ripple size.";

    public static final String DISABLED_FONT_COLOR = "Font color when disabled.";
    public static final String DISABLED_BACKGROUND_COLOR = "Background color when disabled.";
    public static final String BUTTON_HEIGHT = "Button height.";
    public static final String BUTTON_WIDTH = "Button width.";
    public static final String BUTTON_SIZE = "Button size (height and width).";
    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static final String STYLE_NAMES = "Style names";
    public static final String MIXINS = "Mixins";
    public static final String COMMON_VARIABLES = "Common variables";
    public static final String LIGHT_THEME_VARIABLES = "Light theme variables";
    public static final String DARK_THEME_VARIABLES = "Dark theme variables";

    public ButtonsView() {
        setFlexDirection(FlexDirection.COLUMN);
        setAlignSelf(AlignSelf.BASELINE);
        addStyleName(Margins.All.LARGE);
        addStyleName(MaxWidths.MW_720);
        addStyleName(Spacings.Bottom.LARGE);

        // BUTTONS
        CssLayout buttons = new FlexLayout(FlexDirection.COLUMN);
        buttons.addStyleName("card");
        buttons.addStyleName(Paddings.Horizontal.LARGE);
        addComponent(buttons);
        buttons.addComponent(createHeadline("Buttons"));
        buttons.addComponent(createInfoText(LOREM_IPSUM));
        buttons.addComponent(createButtonVariables());

        // FLAT BUTTONS
        CssLayout flatButtons = new FlexLayout(FlexDirection.COLUMN);
        flatButtons.addStyleName("card");
        flatButtons.addStyleName(Paddings.Horizontal.LARGE);
        addComponent(flatButtons);
        flatButtons.addComponent(createTitle(FLAT_BUTTONS));
        flatButtons.addComponent(createInfoText(LOREM_IPSUM));
        flatButtons.addComponent(createFlatButtons());
        flatButtons.addComponent(createSubheader(STYLE_NAMES));
        flatButtons.addComponent(createStyleNameItem(MaterialColor.BLUE_500, "Styles.Buttons.Flat.LIGHT", Styles.Buttons.Flat.LIGHT, false));
        flatButtons.addComponent(createStyleNameItem(MaterialColor.GREY_800, "Styles.Buttons.Flat.DARK", Styles.Buttons.Flat.DARK, true));
        flatButtons.addComponent(createSubheader(MIXINS));
        flatButtons.addComponent(createMixin(new Mixin("md-flatbtn", "$font-color<br>$focus-bg-color<br>$disabled-color<br>$ripple-color<br>$ripple-size", LOREM_IPSUM)));
        flatButtons.addComponent(createSubheader(COMMON_VARIABLES));
        flatButtons.addComponent(createFlatButtonVariables());
        flatButtons.addComponent(createSubheader(LIGHT_THEME_VARIABLES));
        flatButtons.addComponent(createFlatButtonVariables(true));
        flatButtons.addComponent(createSubheader(DARK_THEME_VARIABLES));
        flatButtons.addComponent(createFlatButtonVariables(false));

        // RAISED BUTTONS
        CssLayout raisedButtons = new FlexLayout(FlexDirection.COLUMN);
        raisedButtons.addStyleName("card");
        raisedButtons.addStyleName(Paddings.Horizontal.LARGE);
        addComponent(raisedButtons);
        raisedButtons.addComponent(createTitle(RAISED_BUTTONS));
        raisedButtons.addComponent(createInfoText(LOREM_IPSUM));
        raisedButtons.addComponent(createRaisedButtons());
        raisedButtons.addComponent(createSubheader(STYLE_NAMES));
        raisedButtons.addComponent(createStyleNameItem(MaterialColor.BLUE_500, "Styles.Buttons.Raised.LIGHT", Styles.Buttons.Raised.LIGHT, false));
        raisedButtons.addComponent(createStyleNameItem(MaterialColor.GREY_800, "Styles.Buttons.Raised.DARK", Styles.Buttons.Raised.DARK, true));
        raisedButtons.addComponent(createSubheader(MIXINS));
        raisedButtons.addComponent(createMixin(new Mixin("md-raisedbtn", "$font-color<br>$bg-color<br>$focus-bg-color<br>$disabled-font-color<br>$disabled-bg-color<br>$ripple-color<br>$ripple-size", LOREM_IPSUM)));
        raisedButtons.addComponent(createSubheader(COMMON_VARIABLES));
        raisedButtons.addComponent(createRaisedButtonVariables());
        raisedButtons.addComponent(createSubheader(LIGHT_THEME_VARIABLES));
        raisedButtons.addComponent(createRaisedButtonVariables(true));
        raisedButtons.addComponent(createSubheader(DARK_THEME_VARIABLES));
        raisedButtons.addComponent(createRaisedButtonVariables(false));

        // TOGGLE BUTTONS
        CssLayout toggleButtons = new FlexLayout(FlexDirection.COLUMN);
        toggleButtons.addStyleName("card");
        toggleButtons.addStyleName(Paddings.Horizontal.LARGE);
        addComponent(toggleButtons);
        toggleButtons.addComponent(createTitle(TOGGLE_BUTTONS));
        toggleButtons.addComponent(createInfoText(LOREM_IPSUM));
        toggleButtons.addComponent(createToggleButtons());
        toggleButtons.addComponent(createSubheader(STYLE_NAMES));
        toggleButtons.addComponent(createStyleNameItem(MaterialColor.BLUE_500, "Styles.Buttons.Toggle.GROUP", Styles.Buttons.Toggle.GROUP, false));
        toggleButtons.addComponent(createStyleNameItem(MaterialColor.BLUE_500, "Styles.Buttons.Toggle.BUTTON", Styles.Buttons.Toggle.BUTTON, true));
        toggleButtons.addComponent(createSubheader(COMMON_VARIABLES));
        toggleButtons.addComponent(createToggleButtonVariables());

        // ICON TOGGLES
        CssLayout iconToggles = new FlexLayout(FlexDirection.COLUMN);
        iconToggles.addStyleName("card");
        iconToggles.addStyleName(Paddings.Horizontal.LARGE);
        addComponent(iconToggles);
        iconToggles.addComponent(createTitle(ICON_TOGGLES));
        iconToggles.addComponent(createInfoText(LOREM_IPSUM));
        iconToggles.addComponent(createIconToggles());
        iconToggles.addComponent(createSubheader(STYLE_NAMES));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.BLUE_500, "Styles.Buttons.IconToggles.LIGHT", Styles.Buttons.IconToggles.LIGHT, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.BLUE_500, "Styles.Buttons.IconToggles.LIGHT_ALT", Styles.Buttons.IconToggles.LIGHT_ALT, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.TEAL_500, "Styles.Buttons.IconToggles.DARK", Styles.Buttons.IconToggles.DARK, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.TEAL_500, "Styles.Buttons.IconToggles.DARK_ALT", Styles.Buttons.IconToggles.DARK_ALT, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.RED_500, "Styles.Buttons.IconToggles.COLOR", Styles.Buttons.IconToggles.COLOR, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.RED_500, "Styles.Buttons.IconToggles.COLOR_ALT", Styles.Buttons.IconToggles.COLOR_ALT, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.GREY_800, "Styles.Buttons.IconToggles.DARK_THEME", Styles.Buttons.IconToggles.DARK_THEME, false));
        iconToggles.addComponent(createStyleNameItem(MaterialColor.GREY_800, "Styles.Buttons.IconToggles.DARK_THEME_ALT", Styles.Buttons.IconToggles.DARK_THEME_ALT, true));
        iconToggles.addComponent(createSubheader(COMMON_VARIABLES));
        iconToggles.addComponent(createIconToggleVariables());
        iconToggles.addComponent(createSubheader("Light icon variables"));
        iconToggles.addComponent(createIconToggleVariables(ICON_TOGGLES_LIGHT));
        iconToggles.addComponent(createSubheader("Dark icon variables"));
        iconToggles.addComponent(createIconToggleVariables(ICON_TOGGLES_DARK));
        iconToggles.addComponent(createSubheader("Color icon variables"));
        iconToggles.addComponent(createIconToggleVariables(ICON_TOGGLES_COLOR));
        iconToggles.addComponent(createSubheader("Dark theme variables"));
        iconToggles.addComponent(createIconToggleVariables(ICON_TOGGLES_DARKTHEME));
    }

    private Component createButtonVariables() {
        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem("$md-btn-height", createVariableLayout(BUTTON_HEIGHT, TYPE_PX, "Flat buttons, raised buttons"));
        dt.addItem("$md-btn-border-radius", createVariableLayout("Button border radius.", TYPE_PX, "Flat buttons, raised buttons, toggle buttons"));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createIconToggles() {
        IconToggle it1 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.LIGHT);
        IconToggle it2 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.LIGHT_ALT);
        IconToggle it3 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.LIGHT);
        it2.setActive(false);
        it3.setEnabled(false);

        IconToggle it4 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.DARK);
        IconToggle it5 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.DARK_ALT);
        IconToggle it6 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.DARK);
        it5.setActive(false);
        it6.setEnabled(false);

        IconToggle it7 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.COLOR);
        IconToggle it8 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.COLOR_ALT);
        IconToggle it9 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.COLOR);
        it8.setActive(false);
        it9.setEnabled(false);

        IconToggle it10 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.DARK_THEME);
        IconToggle it11 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.DARK_THEME_ALT);
        IconToggle it12 = new IconToggle(MaterialIcons.FAVORITE, Styles.Buttons.IconToggles.DARK_THEME);
        it11.setActive(false);
        it12.setEnabled(false);

        FlexLayout layout = new FlexLayout(
                createIconToggleLayout(MaterialColor.BLUE_500, it1, it2, it3),
                createIconToggleLayout(MaterialColor.TEAL_500, it4, it5, it6),
                createIconToggleLayout(MaterialColor.GREY_200, it7, it8, it9),
                createIconToggleLayout(MaterialColor.GREY_800, it10, it11, it12)
        );
        layout.setAlignItems(AlignItems.BASELINE);
        layout.setFlexWrap(FlexWrap.WRAP);
        layout.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        layout.addStyleName(Spacings.Bottom.LARGE);

        return layout;
    }

    private Component createIconToggleLayout(MaterialColor backgroundColor, Component... components) {
        FlexLayout layout = new FlexLayout(components);
        layout.setAlignItems(AlignItems.CENTER);
        layout.setJustifyContent(JustifyContent.CENTER);
        layout.setWidth(320, Unit.PIXELS);
        layout.addStyleName("card");
        layout.addStyleName(backgroundColor.getBackgroundColorStyle());
        layout.addStyleName(Spacings.All.LARGE);
        return layout;
    }

    private Component createIconToggleVariables() {
        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem("$md-iconbtn-size", createVariableLayout(BUTTON_SIZE, TYPE_PX, ICON_TOGGLES));
        dt.addItem("$md-iconbtn-ripple-size", createVariableLayout(RIPPLE_SIZE, TYPE_PX, ICON_TOGGLES));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createIconToggleVariables(String theme) {
        String prefix = "";

        if (theme.equals(ICON_TOGGLES_LIGHT)) {
            prefix = Styles.Buttons.IconToggles.LIGHT;
        }
        if (theme.equals(ICON_TOGGLES_DARK)) {
            prefix = Styles.Buttons.IconToggles.DARK;
        }
        if (theme.equals(ICON_TOGGLES_COLOR)) {
            prefix = Styles.Buttons.IconToggles.COLOR;
        }
        if (theme.equals(ICON_TOGGLES_DARKTHEME)) {
            prefix = Styles.Buttons.IconToggles.DARK_THEME;
        }

        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem(prefix + "-active-color", createVariableLayout(ACTIVE_FONT_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-inactive-color", createVariableLayout(INACTIVE_FONT_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-focus-bg-color", createVariableLayout(FOCUSED_BACKGROUND_COLOR, TYPE_COLOR, theme));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createRaisedButtons() {
        Button light = new RaisedButton("Raised Light");
        Button lightDisabled = new RaisedButton("Raised Light Disabled");
        lightDisabled.setEnabled(false);

        FlexLayout l1 = new FlexLayout(FlexDirection.COLUMN, light, lightDisabled);
        l1.setWidth(320, Unit.PIXELS);
        l1.setAlignItems(AlignItems.CENTER);
        l1.addStyleName(Paddings.All.LARGE);
        l1.addStyleName(Spacings.Bottom.MEDIUM);
        l1.addStyleName(MaterialColor.GREY_50.getBackgroundColorStyle());

        Button dark = new RaisedButton("Raised Dark", false);
        Button darkDisabled = new RaisedButton("Raised Dark Disabled", false);
        darkDisabled.setEnabled(false);

        FlexLayout l2 = new FlexLayout(FlexDirection.COLUMN, dark, darkDisabled);
        l2.setWidth(320, Unit.PIXELS);
        l2.setAlignItems(AlignItems.CENTER);
        l2.addStyleName(Paddings.All.LARGE);
        l2.addStyleName(Spacings.Bottom.MEDIUM);
        l2.addStyleName(MaterialColor.GREY_800.getBackgroundColorStyle());
        l2.addStyleName("card");

        FlexLayout row = new FlexLayout(l1, l2);
        row.setAlignItems(AlignItems.BASELINE);
        row.setFlexWrap(FlexWrap.WRAP);
        row.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        row.addStyleName(Spacings.Bottom.LARGE);

        return row;
    }

    private Component createRaisedButtonVariables() {
        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem("$md-raisedbtn-pad-horizontal", createVariableLayout(RIGHT_AND_LEFT_PADDING, TYPE_PX, RAISED_BUTTONS));
        dt.addItem("$md-raisedbtn-ripple-duration", createVariableLayout(RIPPLE_DURATION, TYPE_SEC, RAISED_BUTTONS));
        dt.addItem("$md-raisedbtn-ripple-size", createVariableLayout(RIPPLE_SIZE, TYPE_PX, RAISED_BUTTONS));
        dt.addItem("$md-raisedbtn-width-min", createVariableLayout(MINIMUM_WIDTH, TYPE_PX, RAISED_BUTTONS));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createRaisedButtonVariables(boolean lightTheme) {
        String theme = lightTheme ? RAISED_BUTTONS_LIGHT_THEME : RAISED_BUTTONS_DARK_THEME;
        String prefix = "$" + (lightTheme ? Styles.Buttons.Raised.LIGHT : Styles.Buttons.Raised.DARK);

        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem(prefix + "-font-color", createVariableLayout(FONT_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-bg-color", createVariableLayout(BACKGROUND_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-focus-bg-color", createVariableLayout(FOCUSED_BACKGROUND_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-ripple-color", createVariableLayout(RIPPLE_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-disabled-font-color", createVariableLayout(DISABLED_FONT_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-disabled-bg-color", createVariableLayout(DISABLED_BACKGROUND_COLOR, TYPE_COLOR, theme));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createFlatButtons() {
        Button light = new FlatButton("Flat Light");
        Button lightDisabled = new FlatButton("Flat Light Disabled");
        lightDisabled.setEnabled(false);

        FlexLayout l1 = new FlexLayout(FlexDirection.COLUMN, light, lightDisabled);
        l1.setWidth(320, Unit.PIXELS);
        l1.setAlignItems(AlignItems.CENTER);
        l1.addStyleName(Paddings.All.LARGE);
        l1.addStyleName(Spacings.Bottom.MEDIUM);
        l1.addStyleName(MaterialColor.GREY_50.getBackgroundColorStyle());
        l1.addStyleName("card");

        Button dark = new FlatButton("Flat Dark", false);
        Button darkDisabled = new FlatButton("Flat Dark Disabled", false);
        darkDisabled.setEnabled(false);

        FlexLayout l2 = new FlexLayout(FlexDirection.COLUMN, dark, darkDisabled);
        l2.setWidth(320, Unit.PIXELS);
        l2.setAlignItems(AlignItems.CENTER);
        l2.addStyleName(Paddings.All.LARGE);
        l2.addStyleName(Spacings.Bottom.MEDIUM);
        l2.addStyleName(MaterialColor.GREY_800.getBackgroundColorStyle());
        l2.addStyleName("card");

        FlexLayout row = new FlexLayout(l1, l2);
        row.setAlignItems(AlignItems.BASELINE);
        row.setFlexWrap(FlexWrap.WRAP);
        row.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        row.addStyleName(Spacings.Bottom.LARGE);

        return row;
    }

    private Component createFlatButtonVariables() {
        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem("$md-flatbtn-pad-horizontal", createVariableLayout(RIGHT_AND_LEFT_PADDING, TYPE_PX, FLAT_BUTTONS));
        dt.addItem("$md-flatbtn-ripple-duration", createVariableLayout(RIPPLE_DURATION, TYPE_SEC, FLAT_BUTTONS));
        dt.addItem("$md-flatbtn-ripple-size", createVariableLayout(RIPPLE_SIZE, TYPE_PX, FLAT_BUTTONS));
        dt.addItem("$md-flatbtn-width-min", createVariableLayout(MINIMUM_WIDTH, TYPE_PX, FLAT_BUTTONS));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createFlatButtonVariables(boolean lightTheme) {
        String theme = lightTheme ? FLAT_BUTTONS_LIGHT_THEME : FLAT_BUTTONS_DARK_THEME;
        String prefix = "$" + (lightTheme ? Styles.Buttons.Flat.LIGHT : Styles.Buttons.Flat.DARK);

        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem(prefix + "-font-color", createVariableLayout(FONT_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-focus-bg-color", createVariableLayout(FOCUSED_BACKGROUND_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-ripple-color", createVariableLayout(RIPPLE_COLOR, TYPE_COLOR, theme));
        dt.addItem(prefix + "-disabled-font-color", createVariableLayout(DISABLED_FONT_COLOR, TYPE_COLOR, theme));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createToggleButtons() {
        ToggleButtonGroup tbg1 = new ToggleButtonGroup();
        tbg1.setSelectionMode(ToggleButtonGroup.SelectionMode.SINGLE);
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_LEFT);
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_CENTER);
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_RIGHT);
        tbg1.addToggleButton(MaterialIcons.FORMAT_ALIGN_JUSTIFY);

        ToggleButtonGroup tbg2 = new ToggleButtonGroup();
        tbg2.setSelectionMode(ToggleButtonGroup.SelectionMode.MULTI);
        tbg2.addToggleButton(MaterialIcons.FORMAT_BOLD);
        tbg2.addToggleButton(MaterialIcons.FORMAT_ITALIC);
        tbg2.addToggleButton(MaterialIcons.FORMAT_UNDERLINED);
        tbg2.addToggleButton(MaterialIcons.FORMAT_COLOR_FILL);

        FlexLayout l1 = new FlexLayout(FlexDirection.COLUMN, tbg1, tbg2);
        l1.setAlignItems(AlignItems.CENTER);
        l1.addStyleName(Paddings.All.LARGE);
        l1.addStyleName(Spacings.Bottom.MEDIUM);
        l1.addStyleName(Margins.Bottom.LARGE);
        l1.addStyleName(MaterialColor.GREY_50.getBackgroundColorStyle());

        return l1;
    }

    private Component createToggleButtonVariables() {
        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Information");
        dt.addItem("$md-togglebtn-height", createVariableLayout(BUTTON_HEIGHT, TYPE_PX, TOGGLE_BUTTONS));
        dt.addItem("$md-togglebtn-width", createVariableLayout(BUTTON_WIDTH, TYPE_PX, TOGGLE_BUTTONS));
        dt.addItem("$md-togglebtn-active-color", createVariableLayout(ACTIVE_FONT_COLOR, TYPE_COLOR, TOGGLE_BUTTONS));
        dt.addItem("$md-togglebtn-active-bg-color", createVariableLayout(ACTIVE_BACKGROUND_COLOR, TYPE_COLOR, TOGGLE_BUTTONS));
        dt.addItem("$md-togglebtn-inactive-color", createVariableLayout(INACTIVE_FONT_COLOR, TYPE_COLOR, TOGGLE_BUTTONS));
        dt.setColumnWidth(0, 40, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    private Component createSubheader(String text) {
        Label lbl = new Label(text);
        lbl.addStyleName(Typography.Dark.Body2.SECONDARY + " " + MaterialColor.BLUE_500.getFontColorStyle());
        FlexLayout subheader = new FlexLayout(lbl);
        subheader.setAlignItems(AlignItems.CENTER);
        subheader.setHeight(Metrics.Subheader.HEIGHT, Unit.PIXELS);
        return subheader;
    }

    private Label createInfoText(String text) {
        Label lbl = new Label(text);
        lbl.setPrimaryStyleName(Typography.Dark.Subheader.SECONDARY);
        lbl.addStyleName(Margins.Bottom.LARGE);
        return lbl;
    }

    private Component createTitle(String text) {
        Label lbl = new Label(text);
        lbl.addStyleName(Typography.Dark.Table.Title.PRIMARY);

        FlexLayout layout = new FlexLayout(lbl);
        layout.setAlignItems(AlignItems.CENTER);
        layout.setHeight(Metrics.Table.TITLE_HEIGHT, Unit.PIXELS);

        return layout;
    }

    private Component createHeadline(String text) {
        Label lbl = new Label(text);
        lbl.addStyleName(Typography.Dark.DatePicker.Title.PRIMARY + " " + MaterialColor.BLUE_500.getFontColorStyle());

        FlexLayout layout = new FlexLayout(lbl);
        layout.setAlignItems(AlignItems.CENTER);
        layout.setHeight(Metrics.DatePicker.HEADER_HEIGHT, Unit.PIXELS);

        return layout;
    }

    private Component createStyleNameItem(MaterialColor color, String className, String styleName, boolean last) {
        TwoLineListItem item = new TwoLineListItem(className, styleName, false);
        item.setPrimaryIconBackgroundColor(color);
        if (last) item.addStyleName(Margins.Bottom.LARGE);
        return item;
    }

    private Component createMixin(Mixin mixin) {
        MDDataTableLayout dt = new MDDataTableLayout();
        dt.setHeaders("Name", "Parameters", "Description");
        dt.addItem(mixin.getName(), mixin.getParameters(), mixin.getDescription());
        dt.setColumnWidth(0, 20, Unit.PERCENTAGE);
        dt.setColumnWidth(1, 20, Unit.PERCENTAGE);
        dt.setColumnWidth(2, 60, Unit.PERCENTAGE);
        dt.addStyleName(Margins.Bottom.LARGE);
        return dt;
    }

    public Component createVariableLayout(String desc, String type, String usedBy) {
        return new FlexLayout(FlexLayout.FlexDirection.COLUMN,
                createCaptionRow("Description", desc),
                createCaptionRow("Type", type),
                createCaptionRow("Used by", usedBy));
    }

    private Component createCaptionRow(String key, String value) {
        FlexLayout row = new FlexLayout(createCaption(key), createTableRow(value));
        row.setAlignItems(AlignItems.CENTER);
        return row;
    }

    private Label createCaption(String text) {
        Label lbl = new Label(text);
        lbl.setPrimaryStyleName(Typography.Dark.Caption.SECONDARY);
        lbl.addStyleName(FlexItem.FlexShrink.SHRINK_0);
        lbl.setWidth(120, Unit.PIXELS);
        return lbl;
    }

    private Label createTableRow(String text) {
        Label lbl = new Label(text);
        lbl.setPrimaryStyleName(Typography.Dark.Table.Row.PRIMARY);
        return lbl;
    }
}
