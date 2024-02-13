package com.scraps.app;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

public class PopUp {
  private float value;

  public void pop() {
    Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
                               .getMaximumWindowBounds()
                               .getSize();

    int x = screenSize.width - 100;
    int y = screenSize.height - 50;
    JOptionPane.showMessageDialog(null, "Value is less than 2: " + this.value,
                                  "Popup", JOptionPane.WARNING_MESSAGE);

    // Set position of the popup
    JOptionPane.getRootFrame().setLocation(x, y);
  }
  public void setValue(float value) { this.value = value; }
}
