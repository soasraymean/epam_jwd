package com.epam.jwd.resources;

public class PointFactory {
    public Point createPoint(double... nums) {
        if (nums.length < 1) return null;
        return new Point(nums);
    }
}
