package com.example.demo;

import org.springframework.util.MultiValueMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.StringJoiner;

public class MathHelper {

    public String calculate(String operation, int x, int y) {
        String result = "";
        switch(operation) {
            case "add":
                result = add(x, y);
                break;
            case "subtract":
                result = subtract(x, y);
                break;
            case "multiply":
                result = multiply(x, y);
                break;
            case "divide":
                result = divide(x, y);
                break;
        }

        return result;
    }

    public String add(int x, int y) {
        int sum = x + y;
        return Integer.toString(x) + " + " + Integer.toString(y)  + " = " + Integer.toString(sum);
    }

    public String subtract(int x, int y) {
        int subtraction = x - y;
        return Integer.toString(x) + " - " + Integer.toString(y)  + " = " + Integer.toString(subtraction);
    }

    public String multiply(int x, int y) {
        int multiplication = x * y;
        return Integer.toString(x) + " * " + Integer.toString(y)  + " = " + Integer.toString(multiplication);
    }
    public String divide(int x, int y) {
        int divided = x / y;
        return Integer.toString(x) + " / " + Integer.toString(y)  + " = " + Integer.toString(divided);
    }

    public String sumMultipleNumbers(MultiValueMap<String,String> queryString) {
        StringJoiner stringJoiner = new StringJoiner(" + ","","");
        int sumResult = 0;
        
        Collection<String> values = queryString.get("n");

        for(String value : values) {
            sumResult += Integer.parseInt(value);
            stringJoiner.add(value);
        }

        String result = stringJoiner.toString();
        result += " = " + Integer.toString(sumResult);

        return result;
    }

    public String area(Shape shape) {
        String result = "";
        double pi = 3.141592653589793;
        if(shape.getType().equals("rectangle")) {
            if(shape.getWidth() == 0 || shape.getHeight() == 0){
                result = "Invalid";
            }
            else {
                String area = String.valueOf(shape.getHeight() * shape.getWidth());
                result = "Area of a " + Integer.toString(shape.getWidth()) + "x" + Integer.toString(shape.getHeight()) + " " + shape.getType() + " is " + area;
            }
        }
        else if (shape.getType().equals("circle")) {
            if (shape.getRadius() == 0) {
                result = "Invalid";
            }
            else {
                String radius = Integer.toString(shape.getRadius());
                String area = Double.toString((shape.getRadius() * shape.getRadius()) * pi);
                result = "Area of a circle with a radius of " + radius + " is " + area;
            }
        }
        return result;
    }
}
