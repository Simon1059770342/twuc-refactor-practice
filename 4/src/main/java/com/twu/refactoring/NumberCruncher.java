package com.twu.refactoring;

import java.util.Arrays;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return EvenOrOdd(0);
    }

    private int EvenOrOdd(int i) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == i) count++;
        }
        return count;
    }

    public int countOdd() {
        return EvenOrOdd(1);
    }

    public int countPositive() {
        return (int) Arrays.stream(numbers).filter(i -> i >= 0).count();
    }

    public int countNegative() {
        return (int) Arrays.stream(numbers).filter(i -> i < 0).count();
    }
}
