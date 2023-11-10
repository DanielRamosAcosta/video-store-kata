package org.example;

import org.example.movie.Movie;

public class Rental {
  private final Movie movie;

  private final int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  String getTitle() {
    return movie.getTitle();
  }

  int getFrequentRenterPoints() {
    return movie.getFrequentRenterPoints(daysRented);
  }

  double getAmount() {
    return movie.getAmountFor(daysRented);
  }
}
