package mano.com.Practising.controller;



import mano.com.Practising.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/random")
    public Map<String, String> getRandomQuote() {
        String quote = quoteService.getRandomQuote();
        return Map.of("quote", quote);
    }
}
