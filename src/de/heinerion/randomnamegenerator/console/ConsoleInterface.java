package de.heinerion.randomnamegenerator.console;

import de.heinerion.randomnamegenerator.*;

import java.io.BufferedReader;
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

  private void interactWithUser() {
    try {
      askForDetails();
    } catch (Exception e) {
      throw new HeinerionException(e);
    }
  }

  private void askForDetails() throws Exception {
    askForGender();
    askForTheNumberOfForenames();
    askForTheNumberOfSurnames();
  }

  private void initializeNameGenerator() {
    nameGenerator = new PreFilledNameGenerator();
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
