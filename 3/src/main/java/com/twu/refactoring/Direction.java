package com.twu.refactoring;

import java.lang.reflect.Array;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    private static final String DirectionList = "NESW";

    //    0
    //  3    1
    //     2
    public Direction trunDirection(String turnDirection) {
        switch (turnDirection) {
            case "left":
                return new Direction(DirectionList.charAt((DirectionList.indexOf(direction) + 3) % 4));
            case "right":
                return new Direction(DirectionList.charAt((DirectionList.indexOf(direction) + 1) % 4));
            default:
                throw new IllegalArgumentException();
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
