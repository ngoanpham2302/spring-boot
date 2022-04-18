package vn.techmaster.basicweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private List<String> quoteList;

    public QuoteController() {
        quoteList = new ArrayList<>();
        quoteList.add("Kiến tha lâu đầy tổ");
        quoteList.add("Có công mài sắt, có ngày nên kim");
        quoteList.add("Không thầy đố mày làm nên");
        quoteList.add("Học thầy không tày học bạn");
    }

    @GetMapping
    public String getRandomQuote() {
        Random random = new Random();
        int randomNum = random.nextInt(quoteList.size());
        return quoteList.get(randomNum);
    }
}
