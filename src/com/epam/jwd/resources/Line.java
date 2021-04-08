package com.epam.jwd.resources;

public class Line implements Figure {

    private final Point[] points;

    @Override
    public String getFigureType() {
        return "Line";
    }

    Line(Point... points) {
        this.points = points;
    }

    @Override
    public boolean isNeededFigure() {
        return getPerimeter() != 0;
    }

    @Override
    public double getPerimeter() {
        return getDistanceBetweenTwoPoints(points[0], points[1]);
    }


    @Override
    public double getArea() {
        return 0;
    }


    @Override
    public String toString() {
        return "Figure {figure type=" + getFigureType() + ", length=" + getPerimeter() + ", square=" + getArea() + "}";
    }

    @Override
    public double[] getAllSides() {
        double[] sides = new double[1];
        sides[0] = getDistanceBetweenTwoPoints(points[0], points[1]);
        return sides;
    }


    private double getDistanceBetweenTwoPoints(Point a, Point b) {
        return Math.sqrt(
                Math.pow(b.getX() - a.getX(), 2)
                        + Math.pow(b.getY() - a.getY(), 2)
                        + Math.pow(b.getZ() - a.getZ(), 2)
                        + Math.pow(b.getT() - a.getT(), 2));
    }
}