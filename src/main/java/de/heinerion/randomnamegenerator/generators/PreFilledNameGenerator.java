package de.heinerion.randomnamegenerator.generators;

import de.heinerion.randomnamegenerator.NameService;

public class PreFilledNameGenerator extends NameGenerator {
  public PreFilledNameGenerator() {
    super();
    setFemaleForenames(NameService.getFemaleForenames());
    setMaleForenames(NameService.getMaleForenames());
    setSurnames(NameService.getSurnames());
  }
}