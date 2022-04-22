package vn.techmaster.basicweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
public class BmiController {

    @PostMapping
    public double calculateBmi(@RequestParam("h") double height, @RequestParam("w") double weight) {
        double bmiIndex = weight / (height * height);
        return (Math.round(bmiIndex * 10.0)) / 10.0;
    }
}
