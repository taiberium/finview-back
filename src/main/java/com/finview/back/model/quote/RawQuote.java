package com.finview.back.model.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawQuote {
    private QuoteSummary quoteSummary;


    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QuoteSummary {
        private List<Result> result;
        private String error; // most time is null
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private SummaryDetail summaryDetail;
        private DefaultKeyStatistics defaultKeyStatistics;
        private Price price;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private double raw; // example 29164707
        private String fmt; //example 29.16M
        private String longFmt; //could be null, example 29,164,707
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SummaryDetail {
        private Data bid;
        private Data ask;
        private Data marketCap;
        private Data fiftyTwoWeekLow;
        private Data fiftyTwoWeekHigh;
        private Data previousClose;
        private Data open;
        private Data dayLow;
        private Data dayHigh;
        private Data dividendYield;
        private Data exDividendDate;
        private Data dividendRate;
        private Data payoutRatio;
        private Data fiveYearAvgDividendYield;
        private Data trailingPE;
        private Data forwardPE;
        private Data volume;
        private Data yield;
        private Data ytdReturn;
        private Data totalAssets;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DefaultKeyStatistics {
        private Data forwardPE;
        private Data profitMargins;
        private Data sharesOutstanding; // акции в обращении
        private Data bookValue;
        private Data priceToBook;
        private Data beta;
        private Data ytdReturn;
        private Data earningsQuarterlyGrowth;
        private Data mostRecentQuarter;
        private Data nextFiscalYearEnd;
        private Data trailingEps;
        private Data forwardEps;
        private Data pegRatio;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Price {
        private Data regularMarketDayLow;//raw	38.89 fmt	"38.89"
        private Data regularMarketVolume;//raw	40793408 fmt	"40.79M" longFmt	"40,793,408.00"
        private Data averageDailyVolume10Day; //raw	28458987 fmt	"28.46M" longFmt	"28,458,987"
        private Data averageDailyVolume3Month;//raw	28074295 fmt	"28.07M" longFmt	"28,074,295"
        private Data regularMarketPreviousClose; // raw	38.93 fmt	"38.93"
        private Data regularMarketPrice;
        private Data regularMarketOpen; //raw	39.21 fmt	"39.21"
        private String exchange;//	"NYQ"
        private String exchangeName;//	"NYSE"
        private String marketState;//	"CLOSED"
        private String quoteType;//	"EQUITY"
        private String symbol; //	"T"
        private String shortName; //	"AT&T Inc."
        private String longName; //	"AT&T Inc."
        private String currency; //"USD"
        private String currencySymbol; //"$"
        private Data marketCap;
    }
}
