package edu.wpi.first.smartdashboard;

import edu.wpi.first.smartdashboard.component.MenuBarController;

import javafx.fxml.FXML;

public class MainWindowController {

  @FXML
  private MenuBarController menuBar;

  @FXML
  void initialize() {
    assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'MainWindowController.fxml'.";

  }

}
