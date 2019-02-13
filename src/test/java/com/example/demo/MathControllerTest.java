package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.StringJoiner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)

public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPiEndpoint() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testCalculateEndpointWithAdd() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testCalculateEndpointWithSubtract() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testCalculateEndpointWithMultiply() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    public void testCalculateEndpointWithDivide() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testCalculateEndpointWithDefaultParam() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testSumEndpoint() throws Exception {
        this.mvc.perform(get("/math/sum?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolumeEndpoint() throws Exception {
        int length = 3;
        int width = 4;
        int height = 5;
        int result = length * width * height;
        StringJoiner stringJoiner = new StringJoiner("x","","");
        stringJoiner.add(Integer.toString(length)).add(Integer.toString(width)).add(Integer.toString(height));
        String rectangle = stringJoiner.toString();


        this.mvc.perform(post(String.format("/math/volume/%d/%d/%d",3,4,5)).accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("The volume of a %s rectangle is %s",rectangle,Integer.toString(result))));
    }

    @Test
    public void testAreaEndpointValidCircle() throws Exception {
        int radius = 2;
        double PI = 3.141592653589793;
        double area = radius * (PI * PI);

        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "2");


        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Area of a circle with a radius of %d is %s",radius,Double.toString(area))));
    }

    @Test
    public void testAreaEndpointValidRectangle() throws Exception {
        int width = 4;
        int height = 7;
        int area = width * height;

        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height","7");


        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Area of a 4x7 rectangle is %d", area)));
    }

    @Test
    public void testAreaEndpointInvalidRectangle() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "5");


        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

    }

    @Test
    public void testAreaEndpointInvalidCircle() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("length", "5")
                .param("height","3");


        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }
}
