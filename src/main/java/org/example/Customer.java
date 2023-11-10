package org.example;

public class Customer {
  private final String name;

  private final Rentals rentals = new Rentals();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String statement(final VideoStoreFormatter videoStoreFormatter) {
    return videoStoreFormatter.format(name, rentals);
  }
}
