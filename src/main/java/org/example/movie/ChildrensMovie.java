package org.example.movie;

public class ChildrensMovie extends Movie {

  public ChildrensMovie(final String title) {
    super(title);
  }

  @Override
  protected double getBaseAmount() {
    return 1.5;
  }

  @Override
  protected int daysForExtraCost() {
    return 3;
  }
}
