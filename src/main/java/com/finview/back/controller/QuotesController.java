package com.finview.back.controller;

import com.finview.back.model.quote.Quote;
import com.finview.back.model.quote.RawQuote;
import com.finview.back.service.QuotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quotes")
public class QuotesController {

    private final QuotesService service;

    @GetMapping("{ticker}/raw")
    public Optional<RawQuote> getRawQuote(@PathVariable("ticker") String ticker) {
        return service.getRawQuote(ticker);
    }

    @GetMapping("{ticker}")
    public Optional<Quote> getQuote(@PathVariable("ticker") String ticker) {
        return service.getQuote(ticker);
    }

    @GetMapping
    public List<Quote> getQuotes(@RequestParam("quote") List<String> quoteTickers) {
        return service.getQuotes(quoteTickers);
    }
}
