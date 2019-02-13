package com.example.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.StringJoiner;

@RestController
@RequestMapping("/math")
public class MathController {
    double pi = 3.141592653589793;

    @GetMapping("/pi")
    public String myMethod() {
        return Double.toString(pi);
    }

    @GetMapping("/calculate")
    public String calculateMethod(@RequestParam(defaultValue = "add") String operation, @RequestParam String x, @RequestParam String y) {
        MathHelper mathHelper = new MathHelper();
        String result = mathHelper.calculate(operation, Integer.parseInt(x), Integer.parseInt(y));

        return result;
    }

    @GetMapping("/sum")
    public String sumMethod(@RequestParam MultiValueMap<String, String> queryString) {
        MathHelper mathHelper = new MathHelper();
        String result = mathHelper.sumMultipleNumbers(queryString);

        return result;
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public String volumeMethod(@PathVariable int length, @PathVariable int width, @PathVariable int height) {

        int result = length * width * height;
        StringJoiner rectangle = new StringJoiner("x","","");
        rectangle.add(Integer.toString(length)).add(Integer.toString(width)).add(Integer.toString(height));

        return "The volume of a " + rectangle.toString() + " rectangle is " + result;
    }

    @PostMapping(value = "/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String areaMethod(Shape shape) {
        MathHelper mathHelper = new MathHelper();

        String result = mathHelper.area(shape);


        return result;
    }
}
