package com.pluralsight;

import java.awt.*;

public class Square extends Shape {
    public Square(Turtle turtle, Point location, Color color, int border) {
        super(turtle, location, color, border);
    }

    @Override
    public void paint() {
        setTurtleProperties();
        for (int i = 0; i < 4; i++) {
            turtle.forward(50);
            turtle.turnRight(90);
        }
    }
    //    @Override
    public void paint( int sideLength) {
        setTurtleProperties();
        for (int i = 0; i < 4; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(90);
        }
    }

}


