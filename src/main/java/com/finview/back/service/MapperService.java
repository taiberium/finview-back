package com.finview.back.service;


import com.finview.back.model.quote.Quote;
import com.finview.back.model.quote.RawQuoteResponse;
import com.finview.back.model.search.RawSearchQuote;
import com.finview.back.model.search.SearchQuote;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperService {

    public List<SearchQuote> map(List<RawSearchQuote> rawSearchQuotes) {
        return rawSearchQuotes.stream().map(this::map).collect(Collectors.toList());
    }

    public SearchQuote map(RawSearchQuote rawSearchQuote) {
        String companyName = StringUtils.isEmpty(rawSearchQuote.getLongname()) ?
                rawSearchQuote.getShortname() :
                rawSearchQuote.getLongname();

        return SearchQuote.builder()
                .exchange(rawSearchQuote.getExchange())
                .companyName(companyName)
                .quoteType(rawSearchQuote.getQuoteType())
                .ticker(rawSearchQuote.getSymbol())
                .build();
    }

    public Quote map(RawQuoteResponse rawQuoteResponse) {
        RawQuoteResponse.Result result = rawQuoteResponse.getQuoteSummary().getResult().get(0);
        RawQuoteResponse.Price price = result.getPrice();
        RawQuoteResponse.SummaryDetail summaryDetail = result.getSummaryDetail();
        RawQuoteResponse.DefaultKeyStatistics defaultKeyStatistics = result.getDefaultKeyStatistics();

        String companyName = StringUtils.isEmpty(price.getLongName()) ?
                price.getShortName() :
                price.getLongName();

        return Quote.builder()
                .pe(summaryDetail.getTrailingPE().getRaw())
                .peg(defaultKeyStatistics.getPegRatio().getRaw())
                .pb(defaultKeyStatistics.getPriceToBook().getRaw())
                .bookValue(defaultKeyStatistics.getBookValue().getRaw())
                .name(companyName)
                .ticker(price.getSymbol())
                .type(price.getQuoteType())
                .currency(price.getCurrency())
                .price(price.getRegularMarketPrice().getRaw())
                .low52Week(summaryDetail.getFiftyTwoWeekLow().getRaw())
                .high52Week(summaryDetail.getFiftyTwoWeekHigh().getRaw())
                .highDay(summaryDetail.getDayHigh().getRaw())
                .lowDay(summaryDetail.getDayLow().getRaw())
                .dividend(summaryDetail.getDividendRate().getRaw())
                .dividendPercent(summaryDetail.getDividendYield().getRaw())
                .build();
    }
}
