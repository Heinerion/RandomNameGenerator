package de.heinerion.randomnamegenerator;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Translator {
  private static ResourceBundle messages = ResourceBundle.getBundle("translation", Locale.getDefault());

  public static String translate(String key) {
    String result;

    try {
      result = messages.getString(key);
    } catch (MissingResourceException mre) {
      result = "'" + key + "'";
    }

    return result;
  }
}
