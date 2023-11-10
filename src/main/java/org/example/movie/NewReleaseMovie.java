package org.example.movie;

public class NewReleaseMovie extends Movie {

  public NewReleaseMovie(final String title) {
    super(title);
  }

  @Override
  protected double getBaseAmount() {
    return 0;
  }

  @Override
  protected int daysForExtraCost() {
    return 0;
  }

  @Override
  protected double extraCostRate() {
    return 3;
  }

  @Override
  public int getFrequentRenterPoints(final int daysRented) {
    if (daysRented > 1) {
      return 2;
    }

    return 1;
  }
}
