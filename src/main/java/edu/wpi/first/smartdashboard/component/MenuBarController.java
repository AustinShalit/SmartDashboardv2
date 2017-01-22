package edu.wpi.first.smartdashboard.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuBarController extends javafx.scene.control.MenuBar {

  @FXML
  private MenuItem newMenuItem;

  @FXML
  private MenuItem addTestRecMenuItem;

  /**
   * Set the action to perform when the New menu item is pressed.
   *
   * @param action The action
   */
  public void setOnNewAction(EventHandler<ActionEvent> action) {
    newMenuItem.setOnAction(action);
  }

  @FXML
  void initialize() {
    assert newMenuItem != null : "fx:id=\"newMenuItem\" was not injected: check your FXML file 'MenuBarController.fxml'.";

  }

}
