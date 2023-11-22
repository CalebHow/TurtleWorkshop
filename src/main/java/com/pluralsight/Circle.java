package com.pluralsight;

import com.pluralsight.Turtle;

import java.awt.*;
public class Circle extends Shape{
    public Circle(Turtle turtle, Point location, Color color, int border) {
        super(turtle, location, color, border);
    }

    @Override
    public void paint() {

    }
    public void drawCircle(double radius) {
        setTurtleProperties();
        int numSegments = 360;
        double angleIncrement = 360.0 / numSegments;

        for (int i = 0; i < numSegments; i++) {
            turtle.forward(radius * Math.PI * angleIncrement / 180.0);
            turtle.turnRight(angleIncrement);
        }
    }}

