package com.twu.refactoring;

public class Rental {

    public static final double RENTAL_RATE = 1.5;
    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCurrentAmount() {
        double currentAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                currentAmount += 2;
                if (getDaysRented() > 2)
                    currentAmount += (getDaysRented() - 2) * RENTAL_RATE;
                break;
            case Movie.NEW_RELEASE:
                currentAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                currentAmount += RENTAL_RATE;
                if (getDaysRented() > 3)
                    currentAmount += (getDaysRented() - 3) * RENTAL_RATE;
                break;
        }
        return currentAmount;
    }

    public int getCurrentfrequentRenterPoint() {
        // add bonus for a two day new release rental
        return ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1)? 2 : 1;
    }

    @Override
    public String toString() {
        return "\t" + getMovie().getTitle() + "\t"
                + getCurrentAmount() + "\n";

    }
}