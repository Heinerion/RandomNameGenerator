package de.heinerion.randomnamegenerator.userinterfaces.javafx;

import de.heinerion.randomnamegenerator.Gender;
import de.heinerion.randomnamegenerator.Translator;
import de.heinerion.randomnamegenerator.generators.NameGenerator;
import de.heinerion.randomnamegenerator.generators.PreFilledNameGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {
  private final NameGenerator nameGenerator = new PreFilledNameGenerator();

  @FXML
  private Text headline;

  @FXML
  private Spinner<Integer> forenameSpinner;

  @FXML
  private Spinner<Integer> surnameSpinner;

  @FXML
  private TextField result;

  @FXML
  private Label genderLabel;

  @FXML
  private Label forenameLabel;

  @FXML
  private Label surnameLabel;

  @FXML
  private Button generateButton;

  @FXML
  private final ComboBox<Gender> genderBox = new ComboBox<>();

  @SuppressWarnings({"unused", "UnusedParameters"})
  @FXML
  private void handleSubmitButtonAction(ActionEvent event) {
    nameGenerator.setNumberOfForenames(forenameSpinner.getValue());
    nameGenerator.setNumberOfSurnames(surnameSpinner.getValue());

    Gender gender = genderBox.getValue();
    nameGenerator.setGender(gender == null ? Gender.MALE : gender);

    String randomName = nameGenerator.generateRandomName();
    result.setText(randomName);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    headline.setText(translate("title"));
//    secondHeadline.setText(translate("description"));

    genderLabel.setText(translate("gender"));
    forenameLabel.setText(translate("numberOfForenames"));
    surnameLabel.setText(translate("numberOfSurnames"));

    generateButton.setText(translate("generateName"));

    genderBox.getItems().addAll(Gender.values());
  }

  @FXML
  private String translate(String key) {
    return Translator.translate(key);
  }
}
