package edu.wpi.first.smartdashboard.component;

import edu.wpi.first.smartdashboard.widget.ConnectionIndicator;

import edu.wpi.first.smartdashboard.widget.LabeledTextField;
import edu.wpi.first.smartdashboard.widget.ResizableAndDraggableWidget;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class WidgetPaneController {

  @FXML
  private Pane pane;

  @FXML
  void initialize() {
    int yValue = 0;
    assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'WidgetPaneController.fxml'.";

    ResizableAndDraggableWidget connectionIndicator = new ConnectionIndicator();
    ResizableAndDraggableWidget labeledText = new LabeledTextField("X Value");

    pane.getChildren().add(labeledText);
    labeledText.setLayoutY(yValue);
    yValue += labeledText.getHeight() + 5;

    pane.getChildren().add(connectionIndicator);
    connectionIndicator.setLayoutY(yValue);
  }

}
