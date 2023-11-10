package org.example;

import java.util.ArrayList;
import java.util.List;

public class Rentals {

  private final List<Rental> rentals = new ArrayList<>();

  public void add(final Rental rental) {
    rentals.add(rental);
  }

  int getFrequentRenterPoints() {
    return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }

  double getTotalAmount() {
    return rentals.stream().mapToDouble(Rental::getAmount).sum();
  }

  List<String> formatRentals(final VideoStoreFormatter videoStoreFormatter) {
    return videoStoreFormatter.format(rentals);
  }

}
