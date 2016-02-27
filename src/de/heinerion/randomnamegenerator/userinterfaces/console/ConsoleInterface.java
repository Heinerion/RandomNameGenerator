package de.heinerion.randomnamegenerator.userinterfaces.console;

import de.heinerion.randomnamegenerator.Gender;
import de.heinerion.randomnamegenerator.HeinerionException;
import de.heinerion.randomnamegenerator.Translator;
import de.heinerion.randomnamegenerator.generators.NameGenerator;
import de.heinerion.randomnamegenerator.generators.PreFilledNameGenerator;
import de.heinerion.randomnamegenerator.userinterfaces.NameGeneratorInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ConsoleInterface implements NameGeneratorInterface {
  private NameGenerator nameGenerator;

  /**
   * Zeigt ein Nutzerinterface auf der Kommandozeile.
   */
  public void showInterface() {
    initializeNameGenerator();
    interactWithUser();
    showGeneratedName();
  }

  private void initializeNameGenerator() {
    nameGenerator = new PreFilledNameGenerator();
  }

  private void interactWithUser() {
    askForGender();
    askForTheNumberOfForenames();
    askForTheNumberOfSurnames();
  }

  private void askForGender() {
    showMessageByTranslationKey("chooseGender");
    Gender gender = Gender.parseGender(readInput());
    nameGenerator.setGender(gender);
  }

  private void askForTheNumberOfForenames() {
    showMessageByTranslationKey("chooseNumberOfForenames");
    int numberOfForenames = Integer.parseInt(readInput());
    nameGenerator.setNumberOfForenames(numberOfForenames);
  }

  private void askForTheNumberOfSurnames() {
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

  private static String readInput() {
    try {
      return readFromInputStream();
    } catch (Exception e) {
      throw new HeinerionException(e);
    }
  }

  private static String readFromInputStream() throws IOException {
    Reader inputReader = new InputStreamReader(System.in);
    BufferedReader bufferedInputReader = new BufferedReader(inputReader);

    return bufferedInputReader.readLine();
  }
}
