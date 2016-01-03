package de.heinerion.randomnamegenerator;

public class HeinerionException extends RuntimeException {
  public HeinerionException(String s) {
    super(s);
  }

  public HeinerionException(Throwable throwable) {
    super(throwable);
  }

  public HeinerionException(String s, Throwable throwable) {
    super(s, throwable);
  }
}
