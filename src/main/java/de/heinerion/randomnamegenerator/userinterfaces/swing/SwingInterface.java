package de.heinerion.randomnamegenerator.userinterfaces.swing;

import de.heinerion.randomnamegenerator.Translator;
import de.heinerion.randomnamegenerator.userinterfaces.NameGeneratorInterface;

import javax.swing.*;
import java.awt.*;

public class SwingInterface extends JFrame implements NameGeneratorInterface {
  private static final int SPACE = 5;

  private NameGeneratorDetailsPanel detailsPanel;

  private JPanel headerPanel;
  private JPanel resultPanel;
  private JButton generateButton;
  private JLabel resultLabel;

  public SwingInterface() {
    setLayout(new BorderLayout(10, 10));
  }

  public void showInterface() {
    initComponents();
    setVisible(true);
  }

  private void initComponents() {
    createWidgets();
    addWidgets();
    setupInteractions();

    setTitle(Translator.translate("title"));
    pack();
  }

  private void createWidgets() {
    createHeaderPanel();
    createDetailsPanel();
    createResultPanel();
  }

  private void createHeaderPanel() {
    headerPanel = new JPanel();
    headerPanel.add(new JLabel(Translator.translate("title")));
    headerPanel.add(new JLabel(Translator.translate("description")));
  }

  private void createDetailsPanel() {
    detailsPanel = new NameGeneratorDetailsPanel();
    detailsPanel.setLayout(new GridLayout(0, 2, 1, 1));

    detailsPanel.addGenderBoxAndLabel();
    detailsPanel.addForenameSpinnerAndLabel();
    detailsPanel.addSurnameSpinnerAndLabel();
  }

  private void createResultPanel() {
    resultPanel = new JPanel(new BorderLayout(10, 10));

    generateButton = new JButton(Translator.translate("generateName"));
    resultLabel = new JLabel();

    resultPanel.add(generateButton, BorderLayout.LINE_START);
    resultPanel.add(resultLabel, BorderLayout.CENTER);
  }

  private void addWidgets() {
    add(headerPanel, BorderLayout.PAGE_START);
    add(detailsPanel, BorderLayout.CENTER);
    addWhitespaceLeftAndRight();
    add(resultPanel, BorderLayout.PAGE_END);
  }

  private void addWhitespaceLeftAndRight() {
    JPanel leftSpace = createSpacePanel();
    JPanel rightSpace = createSpacePanel();

    add(leftSpace, BorderLayout.LINE_START);
    add(rightSpace, BorderLayout.LINE_END);
  }

  private JPanel createSpacePanel() {
    JPanel spacePanel = new JPanel();
    spacePanel.setPreferredSize(new Dimension(SPACE, SPACE));

    return spacePanel;
  }

  private void setupInteractions() {
    generateButton.addActionListener(e -> resultLabel.setText(detailsPanel.generateRandomName()));
  }
}