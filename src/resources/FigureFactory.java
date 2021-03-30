package resources;

import java.util.Scanner;

public class FigureFactory {
    public Figure createFigure(String type) {
        Figure figure = null;
        PointFactory pointFactory = new PointFactory();
//        Scanner in = new Scanner(System.in);

        if ("line".equalsIgnoreCase(type)) {
//            System.out.print("Enter your points:\nA: ");
//            Point a = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));
//            System.out.print("B: ");
//            Point b = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));

            figure = new Line(
                    pointFactory.createPoint(Math.random() * 10, Math.random() * 10),
                    pointFactory.createPoint(10 + Math.random() * 20, 10 + Math.random() * 20));
        } else if ("triangle".equalsIgnoreCase(type)) {
//            System.out.print("Enter your points:\nA: ");
//            Point a = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));
//            System.out.print("B: ");
//            Point b = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));
//            System.out.print("C: ");
//            Point c = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));

            figure = new Triangle(
                    pointFactory.createPoint(1 + (int) (Math.random() * 5), 1 + (int) (Math.random() * 5)),
                    pointFactory.createPoint(1 + (int) (Math.random() * 5), 1 + (int) (Math.random() * 5)),
                    pointFactory.createPoint(1 + (int) (Math.random() * 5), 1 + (int) (Math.random() * 5)));

        } else if ("square".equalsIgnoreCase(type)) {
//            System.out.print("Enter your points:\nA: ");
//            Point a = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));
//            System.out.print("B: ");
//            Point b = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));
//            System.out.print("C: ");
//            Point c = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));
//            System.out.print("D: ");
//            Point d = pointFactory.createPoint(getCoordinatesFromString(in.nextLine().trim()));

            figure = new Square(
                    pointFactory.createPoint(5, 5),
                    pointFactory.createPoint(7, 5),
                    pointFactory.createPoint(7, 7),
                    pointFactory.createPoint(5, 7));
        }
        return figure;
    }

    private double[] getCoordinatesFromString(String str) {
        final int AXES_NUMBER = 2;
        double[] doubles = new double[AXES_NUMBER];
        doubles[0] = Double.parseDouble(str.substring(0, str.indexOf(" ")));
        doubles[1] = Double.parseDouble(str.substring(str.indexOf(" ") + 1));
        return doubles;
    }
}