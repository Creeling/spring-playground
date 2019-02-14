package com.example.demo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    Shape shape = new Shape();

    @Test
    public void getRadiusWithOneReturnsRadius() {
        shape.setRadius(2);
        int actual = shape.getRadius();

        assertEquals(2, actual);
    }

    @Test
    public void getTypeWithOneReturnsShapeType() {
        shape.setType("circle");
        String actual = shape.getType();

        assertEquals("circle", actual);
    }

    @Test
    public void getWidthWithOneReturnsLength() {
        shape.setWidth(5);
        int actual = shape.getWidth();

        assertEquals(5, actual);
    }

    @Test
    public void getHeightWithOneReturnsHeight() {
        shape.setHeight(3);
        int actual = shape.getHeight();

        assertEquals(3, actual);
    }

}
