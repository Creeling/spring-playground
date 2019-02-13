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
}
