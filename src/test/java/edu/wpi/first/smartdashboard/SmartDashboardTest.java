package edu.wpi.first.smartdashboard;

import static org.junit.Assert.assertTrue;

import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class SmartDashboardTest extends ApplicationTest {

  private Stage stage;

  @Override
  public void start(Stage stage) throws Exception {
    this.stage = stage;
    new SmartDashboard().start(stage);
  }

  @Test
  public void hasSceneTest() {
    assertTrue("Main stage is not showing", stage.isShowing());
  }

}
