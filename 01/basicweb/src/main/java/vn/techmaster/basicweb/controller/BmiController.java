package vn.techmaster.basicweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.basicweb.model.Bmi;

@RestController
@RequestMapping("/bmi")
public class BmiController {

    @PostMapping
    public double calculateBmi(@RequestBody Bmi bodyInfo) {
        double height = bodyInfo.getHeight();
        double weight = bodyInfo.getWeight();
        double bmiIndex = weight / (height * height);
        return (Math.round(bmiIndex * 10.0)) / 10.0;
    }
}
