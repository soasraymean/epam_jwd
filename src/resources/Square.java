package resources;

import java.util.Arrays;

public class Square implements Figure {
    private final Point[] points;

    public Square(Point... points) {
        this.points = points;
    }

    @Override
    public boolean isNeededFigure() {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compare(points[i + 1])) return false;
        }

        double[] sides = getAllSides();
        if (sides.length != 4) return false;
        for (int i = 0; i < 3; i++) {
            if (sides[i] != sides[i + 1]) {
                return false;
            }
        }
        return true;
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
        double[] sides = getAllSides();
        return sides[0] * sides[0];
    }

    @Override
    public double[] getAllSides() {
        double[] sides = new double[4];
        for (int i = 0; i < 3; i++) {
            sides[i] = getDistanceBetweenTwoPoints(points[i], points[i + 1]);
        }
        sides[3] = getDistanceBetweenTwoPoints(points[0], points[3]);
        return sides;
    }

    @Override
    public String toString() {
        double[] sides = getAllSides();
        return "Figure {figure type=" + getFigureType() + ", perimeter=" + getPerimeter() + ", square=" + getArea() + ", side=" + sides[0] + "}";
    }

    @Override
    public String getFigureType() {
        return "Square";
    }

    private double getDistanceBetweenTwoPoints(Point a, Point b) {
        return Math.sqrt(
                Math.pow(b.getX() - a.getX(), 2)
                        + Math.pow(b.getY() - a.getY(), 2)
                        + Math.pow(b.getZ() - a.getZ(), 2)
                        + Math.pow(b.getT() - a.getT(), 2));
    }
}