package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.userinterfaces.NameGeneratorInterface;
import de.heinerion.randomnamegenerator.userinterfaces.console.ConsoleInterface;
import de.heinerion.randomnamegenerator.userinterfaces.swing.SwingInterface;

public class Main {
  private static NameGeneratorInterface userInterface;

  public static void main(String[] args) {
    String choice = "";

    if (args.length > 0) {
      choice = args[0];
    }

    startup(choice);
    run();
  }

  private static void startup(String choice) {
    switch (choice) {
      case "swing":
        userInterface = new SwingInterface();
        break;
      case "fx":
        throw new HeinerionException("FX Interface not implemented");
      case "console":
      default:
        userInterface = new ConsoleInterface();
    }
  }

  private static void run() {
    userInterface.showInterface();
  }
}
