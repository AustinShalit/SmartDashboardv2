package edu.wpi.first.smartdashboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The SmartDashboard is a driver aid for <i>FIRST</i> Robotics Competition teams.
 *
 * <p>The SmartDashboard typically runs on the Driver Station computer and will do two functions:
 * <ul>
 * <li>View robot data that is displayed as program status as your program is running
 * <li>View sensor data and operate actuators in Test mode for robot subsystems to verify correct
 * operation
 * </ul>
 */
public class SmartDashboard extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    StackPane root = new StackPane();

    primaryStage.setTitle("SmartDashboard");
    primaryStage.setScene(new Scene(root, 480, 360));
    primaryStage.show();
  }
}
