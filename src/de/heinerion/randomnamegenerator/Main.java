package de.heinerion.randomnamegenerator;

import de.heinerion.randomnamegenerator.userinterfaces.NameGeneratorInterface;
import de.heinerion.randomnamegenerator.userinterfaces.console.ConsoleInterface;
import de.heinerion.randomnamegenerator.userinterfaces.swing.SwingInterface;
import org.jetbrains.annotations.NotNull;

public class Main {
  public static void main(String[] args) {
    String choice = "";

    if (args.length > 0) {
      choice = args[0];
    }

    NameGeneratorInterface userInterface = getNameGeneratorInterface(choice);

    userInterface.showInterface();
  }

  @NotNull
  private static NameGeneratorInterface getNameGeneratorInterface(String choice) {
    NameGeneratorInterface userInterface;

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

    return userInterface;
  }
}
