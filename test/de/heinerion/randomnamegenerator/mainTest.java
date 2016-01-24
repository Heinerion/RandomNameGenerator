package de.heinerion.randomnamegenerator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class mainTest {
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
}
