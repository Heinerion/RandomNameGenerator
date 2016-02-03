package de.heinerion.randomnamegenerator.userinterfaces.javafx;

import de.heinerion.randomnamegenerator.Gender;
import de.heinerion.randomnamegenerator.generators.NameGenerator;
import de.heinerion.randomnamegenerator.generators.PreFilledNameGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {
  private final NameGenerator nameGenerator = new PreFilledNameGenerator();

  @FXML
  private Spinner<Integer> forenameSpinner;

  @FXML
  private Spinner<Integer> surnameSpinner;

  @FXML
  private Text result;

  @FXML
  private ComboBox<Gender> genderBox = new ComboBox<>();

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
    // TODO translate keys

    genderBox.getItems().addAll(Gender.values());
  }
}
