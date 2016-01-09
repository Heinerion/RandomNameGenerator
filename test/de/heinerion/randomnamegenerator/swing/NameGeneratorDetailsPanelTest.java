package de.heinerion.randomnamegenerator.swing;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class NameGeneratorDetailsPanelTest {
  private NameGeneratorDetailsPanel panel;

  @Before
  public void setupPanel() {
    panel = new NameGeneratorDetailsPanel();
  }

  @org.junit.Test
  public void testAddGenderBox() throws Exception {
    int before = panel.getComponentCount();
    panel.addGenderBox();
    int after = panel.getComponentCount();

    int numberOfAddedComponents = 2;
    assertEquals(before + numberOfAddedComponents, after);
  }

  @org.junit.Test
  public void testAddForenameSpinner() throws Exception {
    int before = panel.getComponentCount();
    panel.addGenderBox();
    int after = panel.getComponentCount();

    int numberOfAddedComponents = 2;
    assertEquals(before + numberOfAddedComponents, after);
  }

  @org.junit.Test
  public void testAddSurnameSpinner() throws Exception {
    int before = panel.getComponentCount();
    panel.addGenderBox();
    int after = panel.getComponentCount();

    int numberOfAddedComponents = 2;
    assertEquals(before + numberOfAddedComponents, after);
  }

  @org.junit.Test
  public void testGenerateRandomNameWithoutAdjustments() throws Exception {
    String name = panel.generateRandomName();

    // TODO refactor to get "" instead of " "
    assertEquals(" ", name);
  }
}