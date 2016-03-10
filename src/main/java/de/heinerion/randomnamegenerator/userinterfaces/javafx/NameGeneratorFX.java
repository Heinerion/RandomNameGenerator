package de.heinerion.randomnamegenerator.userinterfaces.javafx;

import de.heinerion.randomnamegenerator.Translator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class NameGeneratorFX extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("nameGenerator.fxml"));
    primaryStage.setTitle(Translator.translate("title"));
    primaryStage.setScene(new Scene(root, 500, 240));
    primaryStage.show();
  }
}
