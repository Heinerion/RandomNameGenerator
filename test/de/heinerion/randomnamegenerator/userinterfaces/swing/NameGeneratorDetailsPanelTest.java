package de.heinerion.randomnamegenerator.userinterfaces.swing;

import org.junit.Before;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NameGeneratorDetailsPanelTest {
  private NameGeneratorDetailsPanel panel;

  @Before
  public void setupPanel() {
    panel = new NameGeneratorDetailsPanel();
  }

  @org.junit.Test
  public void testAddGenderBox() {
    int countBefore = panel.getComponentCount();
    panel.addGenderBoxAndLabel();
    int countAfter = panel.getComponentCount();

    int numberOfAddedComponents = 2;
    assertEquals(countBefore + numberOfAddedComponents, countAfter);

    assertPanelsLastComponentsAre(JComboBox.class, JLabel.class);
  }

  private void assertPanelsLastComponentsAre(Class<?> lastClass, Class<?> secondLastClass) {
    int compCount = panel.getComponentCount();
    Object lastComponent = panel.getComponent(compCount - 1);
    assertTrue("Last component is no " + lastClass.getSimpleName(), lastClass.isInstance(lastComponent));

    Object secondLastComponent = panel.getComponent(compCount - 2);
    assertTrue("Second last component is no " + lastClass.getSimpleName(), secondLastClass.isInstance
        (secondLastComponent));
  }

  @org.junit.Test
  public void testAddForenameSpinner() {
    int countBefore = panel.getComponentCount();
    panel.addForenameSpinnerAndLabel();
    int countAfter = panel.getComponentCount();

    int numberOfAddedComponents = 2;
    assertEquals(countBefore + numberOfAddedComponents, countAfter);

    assertPanelsLastComponentsAre(JSpinner.class, JLabel.class);
  }

  @org.junit.Test
  public void testAddSurnameSpinner() {
    int countBefore = panel.getComponentCount();
    panel.addSurnameSpinnerAndLabel();
    int countAfter = panel.getComponentCount();

    int numberOfAddedComponents = 2;
    assertEquals(countBefore + numberOfAddedComponents, countAfter);

    assertPanelsLastComponentsAre(JSpinner.class, JLabel.class);
  }

  @org.junit.Test
  public void testGenerateRandomNameWithoutAdjustments() {
    String name = panel.generateRandomName();

    assertEquals("", name);
  }
}