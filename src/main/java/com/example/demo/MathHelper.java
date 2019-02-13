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

        Iterator<String> mapIterator = queryString.keySet().iterator();

        while(mapIterator.hasNext()) {
            String key = mapIterator.next();
            Collection<String> values = queryString.get(key);

            for(String value : values) {
                sumResult += Integer.parseInt(value);
                stringJoiner.add(value);
            }
        }
        String result = stringJoiner.toString();
        result += " = " + Integer.toString(sumResult);

        return result;
    }

}
