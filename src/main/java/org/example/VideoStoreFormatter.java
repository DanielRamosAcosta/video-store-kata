package org.example;

import java.util.List;

public interface VideoStoreFormatter {

  String format(String name, Rentals rentals);

  List<String> format(List<Rental> rentals);
}
