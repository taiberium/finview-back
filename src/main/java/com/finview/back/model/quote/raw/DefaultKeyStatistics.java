package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultKeyStatistics {
    private RawData forwardPE;
    private RawData profitMargins;
    private RawData sharesOutstanding; // акции в обращении
    private RawData bookValue;
    private RawData priceToBook;
    private RawData beta;
    private RawData ytdReturn;
    private RawData earningsQuarterlyGrowth;
    private RawData mostRecentQuarter;
    private RawData nextFiscalYearEnd;
    private RawData trailingEps;
    private RawData forwardEps;
    private RawData pegRatio;
}
