package com.finview.back.mapper;

import com.finview.back.model.quote.Quote;
import com.finview.back.model.quote.raw.RawQuote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.StringUtils;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public abstract class QuotesMapper {

    @Mapping(target = "companyName", expression = "java( findCompanyName(result) )")
    @Mapping(target = "peg", source = "defaultKeyStatistics.pegRatio.raw")
    @Mapping(target = "pb", source = "defaultKeyStatistics.priceToBook.raw")
    @Mapping(target = "bookValue", source = "defaultKeyStatistics.bookValue.raw")
    @Mapping(target = "pe", source = "summaryDetail.trailingPE.raw")
    @Mapping(target = "low52Week", source = "summaryDetail.fiftyTwoWeekLow.raw")
    @Mapping(target = "high52Week", source = "summaryDetail.fiftyTwoWeekHigh.raw")
    @Mapping(target = "highDay", source = "summaryDetail.dayHigh.raw")
    @Mapping(target = "lowDay", source = "summaryDetail.dayLow.raw")
    @Mapping(target = "dividend", source = "summaryDetail.dividendRate.raw")
    @Mapping(target = "dividendPercent", source = "summaryDetail.dividendYield.raw")
    @Mapping(target = "ticker", source = "price.symbol")
    @Mapping(target = "type", source = "price.quoteType")
    @Mapping(target = "currency", source = "price.currency")
    @Mapping(target = "price", source = "price.regularMarketPrice.raw")
    @Mapping(target = "currencySymbol", source = "price.currencySymbol")
    public abstract Quote map(RawQuote.Result result);

    public Quote map(RawQuote rawQuote) {
        RawQuote.Result result = rawQuote.quoteSummary().result().get(0);
        return map(result);
    }

    //don't remove!
    protected String findCompanyName(RawQuote.Result result) {
        var price = result.price();
        if (price == null) return null;
        return StringUtils.hasText(price.shortName()) ?
                price.shortName() :
                price.longName();
    }
}
