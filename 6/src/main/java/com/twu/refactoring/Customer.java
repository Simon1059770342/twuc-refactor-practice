package com.twu.refactoring;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Customer {

	public static final String RENTAL_RECORD_FOR = "Rental Record for ";
	public static final String AMOUNT_OWED_IS = "Amount owed is ";
	public static final String YOU_EARNED = "You earned ";
	public static final String FREQUENT_RENTER_POINTS = " frequent renter points";
	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = rentalList.stream().mapToDouble(Rental::getCurrentAmount).sum();
		int frequentRenterPoints = rentalList.stream().mapToInt(Rental::getCurrentfrequentRenterPoint).sum();
		ArrayList<Rental> rentals = new ArrayList<>(rentalList);
		String result = RENTAL_RECORD_FOR + getName() + "\n";
		result += rentals.stream().map(Rental::toString).collect(Collectors.joining());

		result += AMOUNT_OWED_IS + String.valueOf(totalAmount) + "\n";
		result += YOU_EARNED + String.valueOf(frequentRenterPoints)
				+ FREQUENT_RENTER_POINTS;
		return result;
	}

}
