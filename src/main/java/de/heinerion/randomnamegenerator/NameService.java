package de.heinerion.randomnamegenerator;

public class NameService {
  private static final String[] MALE_FORENAMES = {"Milan", "Liam", "Alexander", "Elias", "Jonas", "Levi", "Julian",
      "Jan", "Lukas", "Daniel", "Samuel", "Tim", "Maris", "David", "Linus", "Felix", "Marcel", "Simon", "Andreas",
      "Valentin", "Junis", "Florian", "Patrick", "Thomas", "Tobias", "Finn", "Severin", "Sturmhart", "Joris", "Aaron",
      "Paul", "Leon", "Johannes", "Manuel", "Moritz", "Stefan", "Dominik", "Elisa", "Peter", "Marlon", "Raphael",
      "Joshua", "Martin", "Dennis"};
  private static final String[] FEMALE_FORENAMES = {"Laura", "Anna", "Lea", "Julia", "Vanessa", "Lina", "Emilia",
      "Leonie", "Lena", "Lisa", "Mia", "Mila", "Lara", "Nina", "Luca", "Alina", "Amelie", "Selina", "Elena", "Jana",
      "Sarah", "Marie", "Michelle", "Noah", "Luisa", "Sophie", "Emma", "Michael", "Hannah", "Emily", "Melanie",
      "Jasmin", "Jennifer", "Johanna", "Mina", "Celine", "Ava", "Luna", "Melina", "Jessica", "Charlotte", "Rebecca",
      "Sophia", "Franziska"};
  private static final String[] SURNAMES = {"Meiser", "Ustinov", "der Ausserirdische"};

  public static String[] getFemaleForenames() {
    return FEMALE_FORENAMES;
  }

  public static String[] getMaleForenames() {
    return MALE_FORENAMES;
  }

  public static String[] getSurnames() {
    return SURNAMES;
  }
}
