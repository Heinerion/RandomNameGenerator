package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.userinterfaces.NameGeneratorInterface;
import de.heinerion.randomnamegenerator.userinterfaces.console.ConsoleInterface;
import de.heinerion.randomnamegenerator.userinterfaces.javafx.JavaFxInterface;
import de.heinerion.randomnamegenerator.userinterfaces.swing.SwingInterface;

public class Main {
  protected static NameGeneratorInterface userInterface;

  public static void main(String[] args) {
    String choice = parseChoice(args);

    startup(choice);
    run();
  }

  protected static String parseChoice(String[] args) {
    String choice = "";

    if (args.length > 0 && args[0] != null) {
      choice = args[0];
    }

    return choice;
  }

  protected static void startup(String choice) {
    switch (choice) {
      case "swing":
        userInterface = new SwingInterface();
        break;

      case "fx":
        userInterface = new JavaFxInterface();
        break;

      case "console":
      default:
        userInterface = new ConsoleInterface();
        break;
    }
  }

  protected static void run() {
    userInterface.showInterface();
  }
}
