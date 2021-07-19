package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryDetail {
    private RawData bid;
    private RawData ask;
    private RawData marketCap;
    private RawData fiftyTwoWeekLow;
    private RawData fiftyTwoWeekHigh;
    private RawData previousClose;
    private RawData open;
    private RawData dayLow;
    private RawData dayHigh;
    private RawData dividendYield;
    private RawData exDividendDate;
    private RawData dividendRate;
    private RawData payoutRatio;
    private RawData fiveYearAvgDividendYield;
    private RawData trailingPE;
    private RawData forwardPE;
    private RawData volume;
    private RawData yield;
    private RawData ytdReturn;
    private RawData totalAssets;
}
