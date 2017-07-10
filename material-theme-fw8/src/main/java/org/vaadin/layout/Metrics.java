package org.vaadin.layout;

/**
 * Created by jonte on 13/03/2017.
 */
public class Metrics {

    public static class NavigationDrawer {
        public static int MAX_WIDTH_MOBILE = 280;
        public static int MAX_WIDTH_TABLET = 320;
    }

    public static class AppBar {
        public static int HEIGHT_MOBILE_LANDSCAPE = 48;
        public static int HEIGHT_MOBILE_PORTRAIT = 56;
        public static int HEIGHT_TABLET = 64;

        public static int PADDING_HORIZONTAL_MOBILE = 16;
        public static int PADDING_HORIZONTAL_TABLE = 24;

        public static class NavIcon {
            public static int SIZE = 24;
        }
    }

    public static class Table {
        public static int TITLE_HEIGHT = 64;
        public static int COLUMN_HEADER_HEIGHT = 56;
        public static int ROW_HEIGHT = 48;
    }

    public static class DatePicker {
        public static int HEADER_HEIGHT = 96;
    }

    public static class Subheader {
        public static int HEIGHT = 48;
    }

    public static class List {
        public static int SINGLE_LINE_HEIGHT = 48;
        public static int SINGLE_LINE_WITH_AVATAR_HEIGHT = 56;

        public static int TWO_LINE_HEIGHT = 72;

        public static int ICON_SIZE_LARGE = 40;
        public static int ICON_SIZE_SMALL = 24;
    }

    public static class Stepper {
        public static int HEIGHT = 72;
        public static int CIRCLE_SIZE = 24;
        public static int CONNECTOR_HEIGHT = 1;
    }
}
