package com.epam.jwd.resources;

import java.util.Arrays;

public class Triangle implements Figure {

    private final Point[] points;

    Triangle(Point... points) {
        this.points = points;
    }

    @Override
    public boolean isNeededFigure() {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compare(points[i + 1])) return false;
        }
        double[] sides = getAllSides();
        return sides[0] + sides[1] > sides[2] && sides[0] + sides[2] > sides[1] && sides[1] + sides[2] > sides[0];
    }

    @Override
    public double getPerimeter() {
        if (!isNeededFigure()) return -1;
        double[] sides = getAllSides();
        double result = 0;
        for (double side : sides) {
            result += side;
        }
        return result;
    }

    @Override
    public double getArea() {
        if (!isNeededFigure()) return -1;
        double p = getPerimeter() / 2;
        double[] sides = getAllSides();
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    @Override
    public double[] getAllSides() {
        double[] sides = new double[3];
        for (int i = 0; i < 2; i++) {
            sides[i] = getDistanceBetweenTwoPoints(points[i], points[i + 1]);
        }
        sides[2] = getDistanceBetweenTwoPoints(points[0], points[2]);
        return sides;
    }


    @Override
    public String toString() {
        double[] sides = getAllSides();
        return "Figure {figure type=" + getFigureType() + ", perimeter=" + getPerimeter() + ", square=" + getArea() + ", sides=" + Arrays.toString(sides) + "}";
    }

    @Override
    public String getFigureType() {
        return "Triangle";
    }

    private double getDistanceBetweenTwoPoints(Point a, Point b) {
        return Math.sqrt(
                Math.pow(b.getX() - a.getX(), 2)
                        + Math.pow(b.getY() - a.getY(), 2)
                        + Math.pow(b.getZ() - a.getZ(), 2)
                        + Math.pow(b.getT() - a.getT(), 2));
    }
}