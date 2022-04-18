package vn.techmaster.basicweb.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomController {
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphaUpperCase = alpha.toUpperCase();
    private static final String digits = "0123456789";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final int strLength = 8;

    // Trả về một chuỗi random string gồm 8 ký tự A-Z, a-z, 0-9
    @GetMapping
    public String getRandomString() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < strLength; i++) {
            int randomNum = random.nextInt(ALPHA_NUMERIC.length());
            sb.append(ALPHA_NUMERIC.charAt(randomNum));
        }

        return sb.toString();
    }
}
