package com.scraps.app.view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

public class PopUp {
  private float value;

  public PopUp() {}
  public void init() {
    Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
                               .getMaximumWindowBounds()
                               .getSize();
  }
  public void pop() {
    JOptionPane.showMessageDialog(null, "Value is less than 2: " + this.value,
                                  "Popup", JOptionPane.WARNING_MESSAGE);
    int x = screenSize.width - 100;
    int y = screenSize.height - 600;
    // Set position of the popup
    JOptionPane.getRootFrame().setLocation(x, y);
  }
  public void setValue(float value) { this.value = value; }
}
