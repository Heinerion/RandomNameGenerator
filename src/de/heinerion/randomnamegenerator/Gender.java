package de.heinerion.randomnamegenerator;

public enum Gender {
  MALE, FEMALE;

  public static Gender parseGender(String stringToParse) {
    if (stringToParse.matches("(^m$)|(male)|(männlich)")) {
      return MALE;
    } else {
      return FEMALE;
    }
  }

  public String toString() {
    return Translator.translate("gender." + this.name().toLowerCase());
  }
}
