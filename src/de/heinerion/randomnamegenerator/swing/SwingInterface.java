package de.heinerion.randomnamegenerator.swing;

import de.heinerion.randomnamegenerator.NameGeneratorInterface;
import de.heinerion.randomnamegenerator.Translator;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class SwingInterface extends JFrame implements NameGeneratorInterface {
  private NameGeneratorDetailsPanel detailsPanel;

  public SwingInterface() {
    setLayout(new BorderLayout(10, 10));
  }

  private void init() {
    addHeader();
    addDetailsPanel();
    addWhitespaceLeftAndRight();
    addResultField();

    pack();
  }

  private void addHeader() {
    JPanel headerPanel = new JPanel();
    headerPanel.add(new JLabel(Translator.translate("title")));
    headerPanel.add(new JLabel(Translator.translate("description")));
    add(headerPanel, BorderLayout.PAGE_START);
  }

  private void addDetailsPanel() {
    detailsPanel = createDetailsPanel();

    add(detailsPanel, BorderLayout.CENTER);
  }

  @NotNull
  private NameGeneratorDetailsPanel createDetailsPanel() {
    NameGeneratorDetailsPanel detailsPanel = new NameGeneratorDetailsPanel();
    detailsPanel.setLayout(new GridLayout(0, 2, 1, 1));

    detailsPanel.addGenderBox();
    detailsPanel.addForenameSpinner();
    detailsPanel.addSurnameSpinner();

    return detailsPanel;
  }

  private void addWhitespaceLeftAndRight() {
    JPanel leftSpace = createSpacePanel(5, 5);
    JPanel rightSpace = createSpacePanel(5, 5);

    add(leftSpace, BorderLayout.LINE_START);
    add(rightSpace, BorderLayout.LINE_END);
  }

  private JPanel createSpacePanel(int width, int height) {
    JPanel spacePanel = new JPanel();
    spacePanel.setPreferredSize(new Dimension(width, height));

    return spacePanel;
  }

  private void addResultField() {
    JPanel resultPanel = new JPanel(new BorderLayout(10, 10));

    JButton generateButton = new JButton(Translator.translate("generateName"));
    resultPanel.add(generateButton, BorderLayout.LINE_START);

    JLabel resultLabel = new JLabel();
    resultPanel.add(resultLabel, BorderLayout.CENTER);

    generateButton.addActionListener(e -> resultLabel.setText(detailsPanel.generateRandomName()));

    add(resultPanel, BorderLayout.PAGE_END);
  }

  public void showInterface() {
    init();
    setVisible(true);
  }
}
