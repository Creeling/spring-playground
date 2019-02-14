package com.example.demo;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathHelperTest {
    MathHelper mathHelper = new MathHelper();

    @Test
    public void calculateMethodWithAdd() {
        assertEquals("4 + 6 = 10", mathHelper.calculate("add", 4, 6));
    }

    @Test
    public void calculateMethodWithSubtract() {
        assertEquals("4 - 6 = -2", mathHelper.calculate("subtract", 4, 6));
    }

    @Test
    public void calculateMethodWithMultiply() {
        assertEquals("4 * 6 = 24", mathHelper.calculate("multiply", 4, 6));
    }

    @Test
    public void calculateMethodWithDivide() {
        assertEquals("30 / 5 = 6", mathHelper.calculate("divide", 30, 5));
    }

    @Test
    public void sumWithManyNumbers() {
        MultiValueMap<String, String> queryString = new LinkedMultiValueMap<>();
        queryString.put("n", Arrays.asList("4","5","6"));

        assertEquals("4 + 5 + 6 = 15", mathHelper.sumMultipleNumbers(queryString));
    }

    @Test
    public void areaWithValidCircle() {
        Shape circle = new Shape();
        circle.setType("circle");
        circle.setRadius(2);
        double pi = 3.141592653589793;
        String actual = mathHelper.area(circle);
        String expected = "Area of a circle with a radius of 2 is 12.566370614359172";

        assertEquals(expected, actual);
    }

    @Test
    public void areaWithValidRectangle() {
        Shape shape = new Shape();
        shape.setType("rectangle");
        shape.setHeight(5);
        shape.setWidth(5);
        String actual = mathHelper.area(shape);
        String expected = "Area of a 5x5 rectangle is 25";

        assertEquals(expected, actual);
    }

    @Test
    public void areaWithInvalidCircle() {
        Shape circle = new Shape();
        circle.setType("circle");
        circle.setWidth(3);
        String actual = mathHelper.area(circle);
        String expected = "Invalid";

        assertEquals(expected,actual);
    }

    @Test
    public void areaWithInvalidRect() {
        Shape rectangle = new Shape();
        rectangle.setType("rectangle");
        rectangle.setRadius(3);
        String actual = mathHelper.area(rectangle);
        String expected = "Invalid";

        assertEquals(expected,actual);
    }
}
