package org.test.views;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import org.test.Dessert;
import org.test.components.DataTableHeader;
import org.test.layout.FlexLayout;
import org.test.layout.Margins;
import org.test.layout.Metrics;
import org.test.layout.Spacings;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonte on 16/03/2017.
 */
public class DataTablesView extends FlexLayout {

    List<Dessert> desserts = Arrays.asList(
            new Dessert("Frozen yoghurt", 159, 6.0, 24, 4.0, 87, 14, 1),
            new Dessert("Ice cream sandwich", 237, 9.0, 37, 4.3, 129, 8, 1),
            new Dessert("Eclair", 262, 16.0, 24, 6.0, 337, 6, 7),
            new Dessert("Cupcake", 305, 3.7, 67, 4.3, 413, 3, 8),
            new Dessert("Gingerbread", 356, 16.0, 49, 3.9, 327, 7, 16),
            new Dessert("Jelly bean", 375, 0.0, 94, 0.0, 50, 0, 0),
            new Dessert("Lollipop", 392, 0.2, 98, 0.0, 38, 0, 2),
            new Dessert("Honeycomb", 408, 3.2, 87, 6.5, 562, 0, 45),
            new Dessert("Donut", 452, 25.0, 51, 4.9, 326, 2, 22),
            new Dessert("KitKat", 518, 26.0, 65, 7.0, 54, 12, 6)
    );

    public DataTablesView() {
        setFlexDirection(FlexDirection.COLUMN);
        setAlignSelf(AlignSelf.BASELINE);
        addStyleName(Margins.All.LARGE);
        addStyleName(Spacings.Bottom.LARGE);
        setWidth(100, Unit.PERCENTAGE);

        Grid g1 = createGrid();
        CssLayout c1 = createCard(g1);

        Grid g2 = createGrid();
        DataTableHeader h2 = new DataTableHeader("Nutrition");
        h2.setGrid(g2);
        CssLayout c2 = createCard(h2, g2);

        addComponents(c1, c2);
    }

    private CssLayout createCard(Component... components) {
        FlexLayout card = new FlexLayout(FlexLayout.FlexDirection.COLUMN, components);
        card.addStyleName("card");
        card.setWidth(100, Unit.PERCENTAGE);
        return card;
    }

    private Grid createGrid() {
        Grid<Dessert> grid = new Grid<>();
        grid.setItems(desserts);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setWidth(100, Unit.PERCENTAGE);
        grid.addColumn(Dessert::getName).setCaption("Dessert (100g serving");
        grid.addColumn(Dessert::getCalories).setCaption("Calories");
        grid.addColumn(Dessert::getFat).setCaption("Fat (g)");
        grid.addColumn(Dessert::getCarbs).setCaption("Carbs (g)");
        grid.addColumn(Dessert::getProtein).setCaption("Protein (g)");
        grid.addColumn(Dessert::getSodium).setCaption("Sodium (mg)");
        grid.addColumn(Dessert::getCalcium).setCaption("Calcium (%)");
        grid.addColumn(Dessert::getIron).setCaption("Iron (%)");
        grid.setHeight(Metrics.Table.COLUMN_HEADER_HEIGHT + desserts.size() * Metrics.Table.ROW_HEIGHT, Unit.PIXELS);
        return grid;
    }

}
