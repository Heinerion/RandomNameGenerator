package de.heinerion.randomnamegenerator.swing;

import de.heinerion.randomnamegenerator.Gender;
import de.heinerion.randomnamegenerator.NameGenerator;
import de.heinerion.randomnamegenerator.Translator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class NameGeneratorDetailsPanel extends JPanel {
  private NameGenerator nameGenerator;

  public NameGeneratorDetailsPanel(@NotNull NameGenerator nameGenerator) {
    this.nameGenerator = nameGenerator;
  }

  public void addGenderBox() {
    addTranslationLabel("gender");
    JComboBox<Gender> genderBox = new JComboBox<>(Gender.values());
    genderBox.addActionListener(e -> nameGenerator.setGender((Gender) genderBox.getSelectedItem()));
    add(genderBox);
  }

  public void addForenameSpinner() {
    addTranslationLabel("numberOfForenames");
    JSpinner forenameSpinner = createSpinner(0, 0, 10, 1);
    forenameSpinner.addChangeListener(e -> nameGenerator.setNumberOfForenames((int) forenameSpinner.getValue()));
    add(forenameSpinner);
  }

  public void addSurnameSpinner() {
    addTranslationLabel("numberOfSurnames");
    JSpinner surnameSpinner = createSpinner(0, 0, 10, 1);
    surnameSpinner.addChangeListener(e -> nameGenerator.setNumberOfSurnames((int) surnameSpinner.getValue()));
    add(surnameSpinner);
  }

  private void addTranslationLabel(String translationKey) {
    add(new JLabel(Translator.translate(translationKey)));
  }

  @Contract("_, _, _, _ -> !null")
  private JSpinner createSpinner(int defaultValue, int min, int max, int step) {
    return new JSpinner(new SpinnerNumberModel(defaultValue, min, max, step));
  }
}
