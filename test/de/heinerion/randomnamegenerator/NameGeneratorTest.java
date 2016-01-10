package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.generators.NameGenerator;
import org.jetbrains.annotations.Contract;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NameGeneratorTest {
  private final String[] validMaleForenames = {"a", "b", "c"};
  private final String[] validFemaleForenames = {"x", "y", "z"};
  private final String[] validSurnames = {"1", "2", "3"};

  private NameGenerator nameGenerator;

  @Before
  public void setUp() throws Exception {
    nameGenerator = new NameGenerator();
    nameGenerator.setMaleForenames(validMaleForenames);
    nameGenerator.setFemaleForenames(validFemaleForenames);
    nameGenerator.setSurnames(validSurnames);

    nameGenerator.setNumberOfForenames(0);
    nameGenerator.setNumberOfSurnames(0);
    nameGenerator.setGender(Gender.MALE);
  }

  @Test
  public void testSetGenderMale() throws Exception {
    nameGenerator.setNumberOfForenames(1);

    nameGenerator.setGender(Gender.MALE);

    String result = nameGenerator.generateRandomName();
    assertResultIsInList(result, validMaleForenames);
  }

  @Test
  public void testSetGenderFemale() throws Exception {
    nameGenerator.setNumberOfForenames(1);

    nameGenerator.setGender(Gender.FEMALE);

    String result = nameGenerator.generateRandomName();
    assertResultIsInList(result, validFemaleForenames);
  }

  private void assertResultIsInList(String searchString, String[] list) {
    boolean result = isInList(searchString, list);

    assertTrue(searchString + " is not in " + String.join(", ", list), result);
  }

  @Contract(pure = true)
  private boolean isInList(String searchString, String[] list) {
    boolean result = false;
    for (String entry : list) {
      if (entry.equals(searchString)) {
        result = true;
      }
    }
    return result;
  }

  @Test
  public void testSetNumberOfForenamesToOne() throws Exception {
    setNumberOfForenames(1);
  }

  @Test
  public void testSetNumberOfForenamesToThree() throws Exception {
    setNumberOfForenames(3);
  }

  private void setNumberOfForenames(int number) {
    nameGenerator.setNumberOfForenames(number);

    String result = nameGenerator.generateRandomName();
    assertNumberOfForenames(result, number);
  }

  private void assertNumberOfForenames(String name, int expectedNumber) {
    String[] forenames = name.split(" ");
    int actualNumber = 0;

    for (String forename : forenames) {
      boolean isValidMaleName = isInList(forename, validMaleForenames);
      boolean isValidFemaleName = isInList(forename, validFemaleForenames);
      if (isValidMaleName || isValidFemaleName) {
        actualNumber++;
      }
    }

    assertEquals("\"" + name + "\" does not contain " + expectedNumber + " forenames", expectedNumber, actualNumber);
  }

  @Test
  public void testSetNumberOfSurnamesToOne() throws Exception {
    setNumberOfSurnames(1);
  }

  @Test
  public void testSetNumberOfSurnamesToThree() throws Exception {
    setNumberOfSurnames(3);
  }

  private void setNumberOfSurnames(int number) {
    nameGenerator.setNumberOfSurnames(number);

    String result = nameGenerator.generateRandomName();
    assertNumberOfSurnames(result, number);
  }

  private void assertNumberOfSurnames(String name, int expectedNumber) {
    String[] blankSeparatedStrings = name.split(" ");
    int lastBlankSeparated = blankSeparatedStrings.length - 1;
    String surnameString = blankSeparatedStrings[lastBlankSeparated];
    String[] surnames = surnameString.split("-");

    int actualNumber = 0;

    for (String surname : surnames) {
      if (isInList(surname, validSurnames)) {
        actualNumber++;
      }
    }

    assertEquals("\"" + name + "\" does not contain " + expectedNumber + " surnames", expectedNumber, actualNumber);
  }

  @Test
  public void testSetNumbersOfForenamesToZeroAndSurnamesTo1() throws Exception {
    setNumberOfNames(0, 1);
  }

  @Test
  public void testSetNumbersOfForenamesTo1AndSurnamesToZero() throws Exception {
    setNumberOfNames(1, 0);
  }

  @Test
  public void testSetNumbersOfForenamesTo1AndSurnamesTo1() throws Exception {
    setNumberOfNames(1, 1);
  }

  @Test
  public void testSetNumbersOfForenamesTo2AndSurnamesTo3() throws Exception {
    setNumberOfNames(2, 3);
  }

  private void setNumberOfNames(int forenames, int surnames) {
    nameGenerator.setNumberOfForenames(forenames);
    nameGenerator.setNumberOfSurnames(surnames);

    String result = nameGenerator.generateRandomName();
    assertNumberOfForenames(result, forenames);
    assertNumberOfSurnames(result, surnames);
  }
}