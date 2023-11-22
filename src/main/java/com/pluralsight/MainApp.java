package com.pluralsight;

import java.awt.*;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        RunProgram();


    }

    private static void RunProgram() {
        Scanner scanner= new Scanner(System.in);
        double worldWidth;
        double worldHeight;
        int endProgram = 3;
        System.out.println("Hello welcome to Turtle Drawer! ");
        System.out.println("What is the width you would like it to be?");
        worldWidth = scanner.nextDouble();
        System.out.println("What is the height you would like it to be?");
        worldHeight = scanner.nextDouble();


        World world = new World((int) worldWidth,(int) worldHeight);
        Turtle turtle = new Turtle(world,0, 0);

        while (endProgram != 0){
            System.out.println("1) Add Shape");
            System.out.println("2) Save Image");
            System.out.println("0) Exit");
            endProgram = scanner.nextInt();

            switch (endProgram) {
                case 1: {
                    int chosenShape;
                    int borderWidth;
                    String tempColor;
                    Color borderColor;
                    Point location;
                    double radius = 0;
                    System.out.println("Which shape (1. square, 2. circle, 3. triangle)?");
                    chosenShape = scanner.nextInt();
                    if (chosenShape == 2) {
                        System.out.println("What is the radius");
                        radius = scanner.nextDouble();
                    }
                    System.out.println("What is the border width?");
                    borderWidth = scanner.nextInt();

                    System.out.println("What is the border color? Blue, Red or Green");
                    tempColor = scanner.next().toLowerCase();

                    borderColor = getColor(tempColor);

                    System.out.println("What is the location of the shape (x,y)?");
                    location = readPointFromUserInput(scanner);
                    scanner.nextLine();

                    if (chosenShape == 2) {
                        Circle circle = new Circle(turtle, location, borderColor, borderWidth);
                        circle.drawCircle(radius);

                        world.saveAs("output.png");

                        System.out.println("saved filed");
                    }
                    System.out.println("passed");

                    switch (chosenShape) {
                        case 1: {
                            Square square = new Square(turtle, location, borderColor, borderWidth);
                            square.paint(50);
                            break;
                        }
                        case 3: {
                            Triangle triangle = new Triangle(turtle, location, borderColor, borderWidth);
                            triangle.paint();
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    world.saveAs("saveCurrentScreen.png");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        }
    }

    public static Color getColor(String color) {
        switch (color) {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            case "blue":
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }
    private static Point readPointFromUserInput(Scanner scanner) {
        System.out.println("Enter the x-coordinate:");
        int x = scanner.nextInt();
        System.out.println("Enter the y-coordinate:");
        int y = scanner.nextInt();
        scanner.nextLine();
        return new Point(x, y);
    }
}