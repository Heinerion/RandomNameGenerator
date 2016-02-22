package de.heinerion.randomnamegenerator.userinterfaces.javafx;

import de.heinerion.randomnamegenerator.userinterfaces.NameGeneratorInterface;
import javafx.application.Application;

public class JavaFxInterface implements NameGeneratorInterface {
  @Override
  public void showInterface() {
    Application.launch(NameGeneratorFX.class);
  }
}
