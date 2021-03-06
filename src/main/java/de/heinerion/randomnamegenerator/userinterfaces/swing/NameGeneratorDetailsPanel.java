package de.heinerion.randomnamegenerator.userinterfaces.swing;

import de.heinerion.randomnamegenerator.Gender;
import de.heinerion.randomnamegenerator.Translator;
import de.heinerion.randomnamegenerator.generators.NameGenerator;
import de.heinerion.randomnamegenerator.generators.PreFilledNameGenerator;
import org.jetbrains.annotations.Contract;

import javax.swing.*;

class NameGeneratorDetailsPanel extends JPanel {
  private final NameGenerator nameGenerator;

  public NameGeneratorDetailsPanel() {
    nameGenerator = new PreFilledNameGenerator();
  }

  public void addGenderBoxAndLabel() {
    addTranslationLabel("gender");
    JComboBox<Gender> genderBox = new JComboBox<>(Gender.values());
    genderBox.addActionListener(e -> nameGenerator.setGender((Gender) genderBox.getSelectedItem()));
    add(genderBox);
  }

  public void addForenameSpinnerAndLabel() {
    addTranslationLabel("numberOfForenames");
    JSpinner forenameSpinner = createDefaultSpinner();
    forenameSpinner.addChangeListener(e -> nameGenerator.setNumberOfForenames((int) forenameSpinner.getValue()));
    add(forenameSpinner);
  }

  public void addSurnameSpinnerAndLabel() {
    addTranslationLabel("numberOfSurnames");
    JSpinner surnameSpinner = createDefaultSpinner();
    surnameSpinner.addChangeListener(e -> nameGenerator.setNumberOfSurnames((int) surnameSpinner.getValue()));
    add(surnameSpinner);
  }

  public String generateRandomName() {
    return nameGenerator.generateRandomName();
  }

  private void addTranslationLabel(String translationKey) {
    add(new JLabel(Translator.translate(translationKey)));
  }

  @Contract(" -> !null")
  private JSpinner createDefaultSpinner() {
    return new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
  }
}
