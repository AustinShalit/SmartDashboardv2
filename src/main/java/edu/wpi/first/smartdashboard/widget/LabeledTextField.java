package edu.wpi.first.smartdashboard.widget;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LabeledTextField extends ResizableAndDraggableWidget {
    private static final double DEFAULT_HEIGHT = 50;
    private static final double DEFAULT_WIDTH = 300;
    private GridPane grid;

    public LabeledTextField(String labelString) {
        super();

        setHeight(DEFAULT_HEIGHT);
        setWidth(DEFAULT_WIDTH);

        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label(labelString), 0, 0);
        grid.add(new TextField(), 1, 0);

        getChildren().addAll(grid);
    }
}
