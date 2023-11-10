package org.example;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.example.movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideoStoreTest {

  private final ConsoleVideoStoreFormatter formatter = new ConsoleVideoStoreFormatter();

  private Customer customer;

  @BeforeEach
  public void setUp() {
    customer = new Customer("Fred");
  }

  @Test
  public void testSingleNewReleaseStatement() {
    customer.addRental(new Rental(Movie.newRelease("The Cell"), 3));
    assertThat(customer.statement(formatter)).isEqualTo("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n");
  }

  @Test
  public void testDualNewReleaseStatement() {
    customer.addRental(new Rental(Movie.newRelease("The Cell"), 3));
    customer.addRental(new Rental(Movie.newRelease("The Tigger Movie"), 3));

    extracted();
  }

  private void extracted() {
    assertThat(customer.statement(formatter)).isEqualTo("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n");
  }

  @Test
  public void testSingleChildrensStatement() {
    customer.addRental(new Rental(Movie.children("The Tigger Movie"), 3));
    assertThat(customer.statement(formatter)).isEqualTo("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n");
  }

  @Test
  public void testSingleChildrensStatementRentedMoreThanThreeDaysAgo() {
    customer.addRental(new Rental(Movie.children("The Tigger Movie"), 4));
    assertThat(customer.statement(formatter)).isEqualTo("Rental Record for Fred\n\tThe Tigger Movie\t3.0\nYou owed 3.0\nYou earned 1 frequent renter points\n");
  }

  @Test
  public void testMultipleRegularStatement() {
    customer.addRental(new Rental(Movie.regular("Plan 9 from Outer Space"), 1));
    customer.addRental(new Rental(Movie.regular("8 1/2"), 2));
    customer.addRental(new Rental(Movie.regular("Eraserhead"), 3));
    assertThat(customer.statement(formatter)).isEqualTo("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n");
  }

}
