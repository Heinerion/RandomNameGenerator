package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.userinterfaces.console.ConsoleInterface;
import de.heinerion.randomnamegenerator.userinterfaces.javafx.JavaFxInterface;
import de.heinerion.randomnamegenerator.userinterfaces.swing.SwingInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class mainTest {
  // TODO consider making an enum for these choices
  private static final String FX = "fx";
  private static final String SWING = "swing";
  private static final String CONSOLE = "console";
  private static final String INVALID = "";

  private static final String FAIL = "failure";
  private static final String SUCCESS = "success";

  private String pseudoInterfaceResult = FAIL;

  @Test
  public void testUserInterfaceChoice() throws Exception {
    List<String> strings = new ArrayList<>();

    String result = Main.parseChoice(listToString(strings));
    assertEquals(result, "");

    strings.add("fx");
    result = Main.parseChoice(listToString(strings));
    assertEquals("fx", result);

    strings.add("swing");
    result = Main.parseChoice(listToString(strings));
    assertEquals("fx", result);
  }

  private String[] listToString(List<String> list) {
    return list.toArray(new String[1]);
  }

  @Test
  public void testStartup() throws Exception {
    Main.startup(FX);
    assertUserInterfaceIsOfType(JavaFxInterface.class);

    Main.startup(SWING);
    assertUserInterfaceIsOfType(SwingInterface.class);

    Main.startup(CONSOLE);
    assertUserInterfaceIsOfType(ConsoleInterface.class);

    Main.startup(INVALID);
    assertUserInterfaceIsOfType(ConsoleInterface.class);
  }

  private void assertUserInterfaceIsOfType(Class<?> type) {
    Assert.assertTrue("User interface is no " + type.getSimpleName(), type.isInstance(Main.userInterface));
  }

  @Test
  public void testRun() throws Exception {
    pseudoInterfaceResult = "failure";

    Main.userInterface = () -> pseudoInterfaceResult = SUCCESS;

    Main.run();

    assertEquals(SUCCESS, pseudoInterfaceResult);
  }
}
