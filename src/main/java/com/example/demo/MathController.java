package com.example.demo;

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
    public String calculateMethod(@RequestParam String operation, @RequestParam String x, @RequestParam String y) {
        String result = "";
        if (operation.equals("add")) {
            int addResult = Integer.parseInt(x) + Integer.parseInt(y);
            result = x + " + " + y  + " = " + Integer.toString(addResult);
        }
        else if (operation.equals("subtract")) {
            int subtractResult = Integer.parseInt(x) - Integer.parseInt(y);
            result = x + " - " + y  + " = " + Integer.toString(subtractResult);
        }
        else if (operation.equals("multiply")) {
            int multiplyResult = Integer.parseInt(x) * Integer.parseInt(y);
            result = x + " * " + y  + " = " + Integer.toString(multiplyResult);
        }
        else if (operation.equals("divide")) {
            int divideResult = Integer.parseInt(x) / Integer.parseInt(y);
            result = x + " / " + y  + " = " + Integer.toString(divideResult);
        }
        return result;
    }
}
