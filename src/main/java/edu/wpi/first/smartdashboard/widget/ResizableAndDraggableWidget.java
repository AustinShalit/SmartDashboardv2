package edu.wpi.first.smartdashboard.widget;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * A {@link Widget} that is resizable and draggable.  Almost all widgets are going to be resizable
 * and draggable.
 */
public abstract class ResizableAndDraggableWidget extends Widget {

  private static final int MARGIN = 8;
  private static final int MIN_SIZE = 20;

  private State state;
  private double lastHeight;
  private double lastWidth;
  private double lastX;
  private double lastY;
  private double lastClickRelativeX;
  private double lastClickRelativeY;

  public ResizableAndDraggableWidget() {
    setMinSize(MIN_SIZE, MIN_SIZE);

    setOnMousePressed(event -> {
      state = getMouseState(event);
      lastWidth = getWidth();
      lastHeight = getHeight();
      lastX = getLayoutX();
      lastY = getLayoutY();
      lastClickRelativeX = getLayoutX() - event.getSceneX();
      lastClickRelativeY = getLayoutY() - event.getSceneY();
    });

    setOnMouseDragged(event -> {
      if (state == State.DRAG) {
        handleDrag(event);
      } else {
        handleResize(event);
      }
    });

    setOnMouseMoved(event -> setCursor(getMouseState(event).getCursor()));
    setOnMouseReleased(event -> setCursor(getMouseState(event).getCursor()));
  }

  private void setWidgetSize(final double xLocation, final double yLocation, final double width,
                             final double height) {
    setLayoutX(Math.max(xLocation, 0));
    setLayoutY(Math.max(yLocation, 0));
    setWidth(Math.max(width, MIN_SIZE));
    setHeight(Math.max(height, MIN_SIZE));
  }

  private void handleResize(MouseEvent event) {
    double xLocation = getLayoutX();
    double yLocation = getLayoutY();
    double width = getWidth();
    double height = getHeight();

    if (state == State.N_RESIZE || state == State.NE_RESIZE || state == State.NW_RESIZE) {
      yLocation = Math.min(event.getSceneY() + lastClickRelativeY, lastY + lastHeight - MIN_SIZE);
      height = lastHeight + lastY - yLocation;
    }

    if (state == State.E_RESIZE || state == State.NE_RESIZE || state == State.SE_RESIZE) {
      width = event.getX();
    }

    if (state == State.S_RESIZE || state == State.SE_RESIZE || state == State.SW_RESIZE) {
      height = event.getY();
    }

    if (state == State.W_RESIZE || state == State.NW_RESIZE || state == State.SW_RESIZE) {
      xLocation = Math.min(event.getSceneX() + lastClickRelativeX, lastX + lastWidth - MIN_SIZE);
      width = lastWidth + lastX - xLocation;
    }

    setWidgetSize(xLocation, yLocation, width, height);
  }

  private void handleDrag(MouseEvent event) {
    setCursor(Cursor.CLOSED_HAND);
    setLayoutX(event.getSceneX() + lastClickRelativeX);
    setLayoutY(event.getSceneY() + lastClickRelativeY);
  }

  private boolean inResizeZone(final MouseEvent event) {
    return inLeftResizeZone(event)
        || inRightResizeZone(event)
        || inBottomResizeZone(event)
        || inTopResizeZone(event);
  }

  private boolean inDragZone(final MouseEvent event) {
    return !inResizeZone(event);
  }

  private boolean inLeftResizeZone(final MouseEvent event) {
    return intersect(0, event.getX());
  }

  private boolean inRightResizeZone(final MouseEvent event) {
    return intersect(getWidth(), event.getX());
  }

  private boolean inTopResizeZone(final MouseEvent event) {
    return intersect(0, event.getY());
  }

  private boolean inBottomResizeZone(final MouseEvent event) {
    return intersect(getHeight(), event.getY());
  }

  private boolean intersect(final double side, final double point) {
    return side + MARGIN > point && side - MARGIN < point;
  }

  private State getMouseState(final MouseEvent event) {
    final boolean left = inLeftResizeZone(event);
    final boolean right = inRightResizeZone(event);
    final boolean top = inTopResizeZone(event);
    final boolean bottom = inBottomResizeZone(event);

    State state;

    if (top && left) {
      state = State.NW_RESIZE;
    } else if (top && right) {
      state = State.NE_RESIZE;
    } else if (bottom && left) {
      state = State.SW_RESIZE;
    } else if (bottom && right) {
      state = State.SE_RESIZE;
    } else if (top) {
      state = State.N_RESIZE;
    } else if (bottom) {
      state = State.S_RESIZE;
    } else if (left) {
      state = State.W_RESIZE;
    } else if (right) {
      state = State.E_RESIZE;
    } else if(inDragZone(event)) {
      state = State.DRAG;
    } else {
      state = State.DEFAULT;
    }

    return state;
  }

  private enum State {
    DEFAULT(Cursor.DEFAULT),
    N_RESIZE(Cursor.N_RESIZE),
    NE_RESIZE(Cursor.NE_RESIZE),
    E_RESIZE(Cursor.E_RESIZE),
    SE_RESIZE(Cursor.SE_RESIZE),
    S_RESIZE(Cursor.S_RESIZE),
    SW_RESIZE(Cursor.SW_RESIZE),
    W_RESIZE(Cursor.W_RESIZE),
    NW_RESIZE(Cursor.NW_RESIZE),
    DRAG(Cursor.OPEN_HAND);

    private Cursor cursor;

    State(Cursor cursor) {
      this.cursor = cursor;
    }

    public Cursor getCursor() {
      return cursor;
    }
  }

}
