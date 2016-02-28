package de.heinerion.randomnamegenerator.userinterfaces.swing;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SwingInterfaceTest {
  private SwingInterface swingInterface;

  @Before
  public void setupPanel() {
    swingInterface = new SwingInterface();
  }

  @Test
  public void testInit() {
    interfaceContainsNothingButRootPane();

    swingInterface.showInterface();

    assertTrue(swingInterface.isVisible());
    interfaceContainsExactlyOneDetailsPanel();
  }

  private void interfaceContainsNothingButRootPane() {
    int componentCount = swingInterface.getComponentCount();
    assertEquals(1, componentCount);
  }

  private void interfaceContainsExactlyOneDetailsPanel() {
    JRootPane rootPane = swingInterface.getRootPane();
    Component[] comps = rootPane.getContentPane().getComponents();

    int detailsPanelCount = 0;
    for (Component comp : comps) {
      if (comp instanceof NameGeneratorDetailsPanel) {
        detailsPanelCount++;
      }
    }

    assertEquals(1, detailsPanelCount);
  }
}