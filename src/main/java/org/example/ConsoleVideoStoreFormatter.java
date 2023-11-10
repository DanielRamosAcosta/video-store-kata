package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleVideoStoreFormatter implements VideoStoreFormatter {

  public static final String TAB = "\t";

  public static final String LINE_BREAK = "\n";

  @Override
  public String format(final String name, final Rentals rentals) {
    List<String> lines = new ArrayList<>();
    lines.add(formatHeader(name));
    lines.addAll(rentals.formatRentals(this));
    lines.add(formatOwed(rentals.getTotalAmount()));
    lines.add(formatFrequentRenterPoints(rentals.getFrequentRenterPoints()));

    return String.join(LINE_BREAK, lines);
  }

  @Override
  public List<String> format(final List<Rental> rentals) {
    return rentals.stream().map(rental -> TAB + rental.getTitle() + TAB + rental.getAmount()).collect(Collectors.toList());
  }

  private static String formatHeader(final String name) {
    return "Rental Record for " + name;
  }

  private static String formatOwed(final double totalAmount) {
    return "You owed " + totalAmount;
  }

  private static String formatFrequentRenterPoints(final int frequentRenterPoints) {
    return "You earned " + frequentRenterPoints + " frequent renter points\n";
  }
}
