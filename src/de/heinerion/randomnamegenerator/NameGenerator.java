package de.heinerion.randomnamegenerator;

public class NameGenerator {
  private String[] maleForenames;
  private String[] femaleForenames;
  private String[] surnames;

  private Gender gender = Gender.MALE;
  private int numberOfForenames = 0;
  private int numberOfSurnames = 0;

  public NameGenerator() {
    this.femaleForenames = NameService.getFemaleForenames();
    this.maleForenames = NameService.getMaleForenames();
    this.surnames = NameService.getSurnames();
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setNumberOfForenames(int numberOfForenames) {
    this.numberOfForenames = numberOfForenames;
  }

  public void setNumberOfSurnames(int numberOfSurnames) {
    this.numberOfSurnames = numberOfSurnames;
  }

  public String generateRandomName() {
    String combinedForenames = createCombinedForenames();
    String combinedSurnames = createCombinedSurnames();
    return combinedForenames + " " + combinedSurnames;
  }

  private String createCombinedForenames() {
    String[] forenames = gender.equals(Gender.MALE) ? maleForenames : femaleForenames;
    String[] generatedForenames = pickANumberOfStringsFromArray(numberOfForenames, forenames);

    return String.join(" ", generatedForenames);
  }

  private String createCombinedSurnames() {
    String[] generatedSurnames = pickANumberOfStringsFromArray(numberOfSurnames, surnames);

    return String.join("-", generatedSurnames);
  }

  private String[] pickANumberOfStringsFromArray(int number, String[] array) {
    String[] generatedSurnames = new String[number];

    for (int i = 0; i < number; i++) {
      generatedSurnames[i] = pickRandomFromArray(array);
    }

    return generatedSurnames;
  }

  private static String pickRandomFromArray(String[] array) {
    int max = array.length;
    int randomNumber = (int) (Math.random() * max);

    return array[randomNumber];
  }
}
