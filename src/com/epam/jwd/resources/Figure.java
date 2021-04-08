package com.epam.jwd.resources;

public interface Figure {
    boolean isNeededFigure();
    double getPerimeter();
    double getArea();
    double[] getAllSides();
    String getFigureType();

}
