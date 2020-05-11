package com.finview.back.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finview.back.model.quote.RawQuote;
import com.finview.back.model.search.RawSearchQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestRepository {

    //history quotes
   // https://query1.finance.yahoo.com/v8/finance/chart/M?formatted=true&region=US&interval=1d&period1=1557478828&period2=1589101228&events=div|split

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public List<RawSearchQuote> search(String ticker) {
        String searchUrl = "https://query1.finance.yahoo.com/v1/finance/search?q={ticker}&quotesCount=6&newsCount=0";
        Map rawSearchDataResponse = restTemplate.getForObject(searchUrl, Map.class, ticker);
        Object rawQuotesObject = rawSearchDataResponse.get("quotes");
        return Arrays.asList(mapper.convertValue(rawQuotesObject, RawSearchQuote[].class));
    }

    public Optional<RawQuote> getQuote(String ticker) {
        String quoteUrl = "https://query2.finance.yahoo.com/v10/finance/quoteSummary/{ticker}?modules=price,summaryDetail,defaultKeyStatistics";
        try {
            return Optional.ofNullable(
                    restTemplate.getForObject(quoteUrl, RawQuote.class, ticker)
            );
        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();
        }
    }
}
