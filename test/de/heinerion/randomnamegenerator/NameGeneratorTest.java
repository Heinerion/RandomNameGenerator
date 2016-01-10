package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.generators.NameGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NameGeneratorTest {
  private final String[] maleForenames = {"a", "b", "c"};
  private final String[] femaleForenames = {"x", "y", "z"};
  private final String[] surnames = {"1", "2", "3"};

  private NameGenerator nameGenerator;

  @Before
  public void setUp() throws Exception {
    nameGenerator = new NameGenerator();
    nameGenerator.setMaleForenames(maleForenames);
    nameGenerator.setFemaleForenames(femaleForenames);
    nameGenerator.setSurnames(surnames);
  }

  @Test
  public void testSetGenderMale() throws Exception {
    nameGenerator.setNumberOfForenames(1);

    nameGenerator.setGender(Gender.MALE);

    String result = nameGenerator.generateRandomName();
    assertResultIsInList(result, maleForenames);
  }

  @Test
  public void testSetNumberOfForenames() throws Exception {

  }

  @Test
  public void testSetNumberOfSurnames() throws Exception {

  }

  @Test
  public void testGenerateRandomName() throws Exception {

  }

  private void assertResultIsInList(String searchString, String[] list) {
    boolean result = false;
    for (String entry : list) {
      if (entry.equals(searchString)) {
        result = true;
      }
    }

    assertTrue(searchString + " is not in " + String.join(", ", list), result);
  }
}