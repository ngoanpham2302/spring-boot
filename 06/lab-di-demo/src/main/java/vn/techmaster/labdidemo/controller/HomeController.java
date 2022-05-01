package vn.techmaster.labdidemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.techmaster.labdidemo.bean.Car;

@Controller
@ResponseBody
public class HomeController {
    @Autowired
    Car myCar;

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return myCar.toString();
    }

    @GetMapping(value = "/route", produces = MediaType.TEXT_HTML_VALUE)
    public String getRoute() {
        return myCar.navigate();
    }
}
