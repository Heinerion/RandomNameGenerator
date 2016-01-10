package de.heinerion.randomnamegenerator;

public class PreFilledNameGenerator extends NameGenerator {
  public PreFilledNameGenerator() {
    super();
    setFemaleForenames(NameService.getFemaleForenames());
    setMaleForenames(NameService.getMaleForenames());
    setSurnames(NameService.getSurnames());
  }
}