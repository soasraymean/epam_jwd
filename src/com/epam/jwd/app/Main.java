package com.epam.jwd.app;

import com.epam.jwd.resources.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.Scanner;

public class Main {

    private static final Logger Logger = LogManager.getLogger();

    public static void main(String[] args) {

        Point[] points = new Point[4];
        points = createArrayOfPoints(points.length);
        showPointsInfoDoWhile(points);

        Figure[] lines = new Figure[3];
        lines = createArrayOfFigures(lines.length, "LiNe");
        showArrayInfo(lines);

        Figure[] triangles = new Figure[2];
        triangles = createArrayOfFigures(triangles.length, "tRiAnGlE");
        showArrayInfo(triangles);

        Figure[] squares = new Figure[1];
        squares = createArrayOfFigures(squares.length, "SQuARe");
        showArrayInfo(squares);

    }

    private static Point[] createArrayOfPoints(int size) {
        Point[] points = new Point[size];
        PointFactory pointFactory = new PointFactory();
        for (int i = 0; i < size; i++) {
            points[i] = pointFactory.createPoint(i, (double) (i * i + 1) / 2);
        }
        return points;
    }

    private static Figure[] createArrayOfFigures(int size, String name) {
        FigureFactory figureFactory = new FigureFactory();
        Figure[] figures = new Figure[size];
        for (int i = 0; i < size; i++) {
            figures[i] = figureFactory.createFigure(name);
        }
        return figures;
    }

    private static void showArrayInfo(Figure... figures) {
        if (figures.length < 1) {
            Logger.error("Empty array was passed into showArrayInfo method.");
            return;
        }
        for (Figure figure : figures) {
            if (figure.isNeededFigure()) {
                Logger.info(figure.toString());
            } else {
                Logger.error("Figure is not a " + figure.getFigureType());
            }
        }
    }

    private static void showPointsInfoDoWhile(Point... points) {
        if (points.length < 1) {
            Logger.error("Empty array was passed into showPointsInfoDoWhile method.");
            return;
        }
        int index = 0;
        do {
            Logger.info(points[index++].toString());
        } while (index < points.length);
    }
}