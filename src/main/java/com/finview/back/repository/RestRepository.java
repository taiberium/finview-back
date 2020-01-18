package com.finview.back.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finview.back.model.quote.RawQuoteResponse;
import com.finview.back.model.search.RawSearchQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RestRepository {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public List<RawSearchQuote> search(String ticker) {
        String searchUrl = "https://query1.finance.yahoo.com/v1/finance/search?q={ticker}&quotesCount=6&newsCount=0";
        Map rawSearchDataResponse = restTemplate.getForObject(searchUrl, Map.class, ticker);
        Object rawQuotesObject = rawSearchDataResponse.get("quotes");
        return Arrays.asList(mapper.convertValue(rawQuotesObject, RawSearchQuote[].class));
    }

    public RawQuoteResponse getQuote(String ticker) {
        String quoteUrl = "https://query2.finance.yahoo.com/v10/finance/quoteSummary/{ticker}?modules=price,summaryDetail,defaultKeyStatistics";
        return restTemplate.getForObject(quoteUrl, RawQuoteResponse.class, ticker);
    }
}
