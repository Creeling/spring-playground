package com.example.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public String myMethod() {
        return "3.141592653589793";
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
}
