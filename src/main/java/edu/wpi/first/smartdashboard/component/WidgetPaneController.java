package edu.wpi.first.smartdashboard.component;

import edu.wpi.first.smartdashboard.widget.ConnectionIndicator;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class WidgetPaneController {

  @FXML
  private Pane pane;

  @FXML
  void initialize() {
    assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'WidgetPaneController.fxml'.";

    ConnectionIndicator test = new ConnectionIndicator();

    pane.getChildren().addAll(test);
  }

}
