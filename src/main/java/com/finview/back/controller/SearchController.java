package com.finview.back.controller;

import com.finview.back.model.search.RawSearchQuote;
import com.finview.back.model.search.SearchQuote;
import com.finview.back.service.QuotesService;
import com.finview.back.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public record SearchController(
        SearchService searchService
) {

    @GetMapping("{ticker}/raw")
    public List<RawSearchQuote> searchRaw(@PathVariable("ticker") String ticker) {
        return searchService.searchRaw(ticker);
    }

    @GetMapping("{ticker}")
    public List<SearchQuote> search(@PathVariable("ticker") String ticker) {
        return searchService.search(ticker);
    }
}
