package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.console.ConsoleInterface;
import de.heinerion.randomnamegenerator.swing.SwingNameGeneratorInterface;

public class Main {
  public static void main(String[] args) {
    String choice = "";

    if (args.length > 0) {
      choice = args[0];
    }

    switch (choice) {
      case "swing":
        launchSwingInterface();
        break;
      case "fx":
        launchFxInterface();
        break;
      case "console":
      default:
        launchConsoleInterface();
    }
  }

  private static void launchSwingInterface() {
    SwingNameGeneratorInterface swingInterface = new SwingNameGeneratorInterface();

    swingInterface.showInterface();
  }

  private static void launchFxInterface() {
    throw new HeinerionException("FX Interface not implemented");
  }

  private static void launchConsoleInterface() {
    try {
      showConsoleInterface();
    } catch (Exception e) {
      throw new HeinerionException("Error in Console Interface", e);
    }
  }

  private static void showConsoleInterface() throws Exception {
    ConsoleInterface userInterface = new ConsoleInterface();

    userInterface.showInterface();
  }
}
