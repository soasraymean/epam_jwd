package com.epam.jwd.resources;

import java.util.Arrays;

public class Point {
    private final double[] coordinates;

    protected double getX() {
        return coordinates[0];
    }

    protected double getY() {
        if (coordinates.length < 2) return 0;
        return coordinates[1];
    }

    protected double getZ() {
        if (coordinates.length < 3) return 0;
        return coordinates[2];
    }

    protected double getT() {
        if (coordinates.length < 4) return 0;
        return coordinates[3];
    }


    protected boolean compare(Point point) {
        return this.getX() == point.getX() && this.getY() == point.getY() && this.getZ() == point.getZ() && this.getT() == point.getT();
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Point {" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }

    protected Point(double... doubles) {
        this.coordinates = doubles;
    }

}