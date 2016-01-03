package de.heinerion.randomnamegenerator.console;

import de.heinerion.randomnamegenerator.Gender;
import de.heinerion.randomnamegenerator.NameGenerator;
import de.heinerion.randomnamegenerator.Translator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class NameGeneratorUserInterface {
  private NameGenerator nameGenerator;

  /**
   * Zeigt ein Nutzerinterface auf der Kommandozeile.
   *
   * @throws Exception
   */
  public void showInterface() throws Exception {
    initializeNameGenerator();

    askForGender();
    askForTheNumberOfForenames();
    askForTheNumberOfSurnames();

    showGeneratedName();
  }

  private void initializeNameGenerator() {
    nameGenerator = new NameGenerator();
  }

  private void askForGender() throws Exception {
    showMessageByTranslationKey("chooseGender");
    Gender gender = Gender.parseGender(readInput());
    nameGenerator.setGender(gender);
  }

  private void askForTheNumberOfForenames() throws Exception {
    showMessageByTranslationKey("chooseNumberOfForenames");
    int numberOfForenames = Integer.parseInt(readInput());
    nameGenerator.setNumberOfForenames(numberOfForenames);
  }

  private void askForTheNumberOfSurnames() throws Exception {
    showMessageByTranslationKey("chooseNumberOfSurnames");
    int numberOfSurnames = Integer.parseInt(readInput());
    nameGenerator.setNumberOfSurnames(numberOfSurnames);
  }

  private void showGeneratedName() {
    showMessageByTranslationKey("generatedName");
    showMessage(nameGenerator.generateRandomName());
  }

  private void showMessageByTranslationKey(String key) {
    showMessage(Translator.translate(key));
  }

  private static void showMessage(String message) {
    System.out.println(message);
  }

  private static String readInput() throws Exception {
    Reader inputReader = new InputStreamReader(System.in);
    BufferedReader bufferedInputReader = new BufferedReader(inputReader);

    return bufferedInputReader.readLine();
  }
}
