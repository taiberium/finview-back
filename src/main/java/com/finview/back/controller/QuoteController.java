package com.finview.back.controller;

import com.finview.back.model.quote.Quote;
import com.finview.back.model.quote.RawQuoteResponse;
import com.finview.back.repository.RestRepository;
import com.finview.back.service.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quotes")
public class QuoteController {

    private final RestRepository restRepository;
    private final MapperService mapperService;

    @GetMapping("{ticker}/raw")
    public RawQuoteResponse searchRaw(@PathVariable("ticker") String ticker) {
        return restRepository.getQuote(ticker);
    }

    @GetMapping("{ticker}")
    public Quote search(@PathVariable("ticker") String ticker) {
        RawQuoteResponse rawQuoteResponse = restRepository.getQuote(ticker);
        return mapperService.map(rawQuoteResponse);
    }
}
