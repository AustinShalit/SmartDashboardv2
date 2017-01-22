package edu.wpi.first.smartdashboard.widget;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Displays the status of the connection between the SmartDashboard and the NetworkTable server
 * (in most cases this is the robot).
 */
public class ConnectionIndicator extends ResizableAndDraggableWidget {

  private static final double DEFAULT_SIZE = 50;

  private final Rectangle rectangle;

  public ConnectionIndicator() {
    super();

    setHeight(DEFAULT_SIZE);
    setWidth(DEFAULT_SIZE);

    setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

    rectangle = new Rectangle(DEFAULT_SIZE, DEFAULT_SIZE, Color.RED);

    rectangle.heightProperty().bind(heightProperty());
    rectangle.widthProperty().bind(widthProperty());

    getChildren().addAll(rectangle);
  }

}
