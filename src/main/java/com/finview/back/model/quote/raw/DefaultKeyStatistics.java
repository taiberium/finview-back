package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DefaultKeyStatistics(
        RawData forwardPE,
        RawData profitMargins,
        RawData sharesOutstanding, // акции в обращении
        RawData bookValue,
        RawData priceToBook,
        RawData beta,
        RawData ytdReturn,
        RawData earningsQuarterlyGrowth,
        RawData mostRecentQuarter,
        RawData nextFiscalYearEnd,
        RawData trailingEps,
        RawData forwardEps,
        RawData pegRatio
) {
}
