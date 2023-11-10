package org.example.movie;

public class Movie {

  private final String title;

  public static Movie regular(final String title) {
    return new Movie(title);
  }

  public static ChildrensMovie children(final String title) {
    return new ChildrensMovie(title);
  }

  public static Movie newRelease(final String title) {
    return new NewReleaseMovie(title);
  }

  Movie(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public double getAmountFor(final int daysRented) {
    if (hasExtraDaysFor(daysRented)) {
      return getBaseAmount() + extraDaysFor(daysRented) * extraCostRate();
    }

    return getBaseAmount();
  }

  private boolean hasExtraDaysFor(final int daysRented) {
    return extraDaysFor(daysRented) > 0;
  }

  private int extraDaysFor(final int daysRented) {
    return daysRented - daysForExtraCost();
  }

  protected double getBaseAmount() {
    return 2;
  }

  protected int daysForExtraCost() {
    return 2;
  }

  protected double extraCostRate() {
    return 1.5;
  }

  public int getFrequentRenterPoints(final int daysRented) {
    return 1;
  }
}