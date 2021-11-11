package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record SummaryDetail(
        RawData bid,
        RawData ask,
        RawData marketCap,
        RawData fiftyTwoWeekLow,
        RawData fiftyTwoWeekHigh,
        RawData previousClose,
        RawData open,
        RawData dayLow,
        RawData dayHigh,
        RawData dividendYield,
        RawData exDividendDate,
        RawData dividendRate,
        RawData payoutRatio,
        RawData fiveYearAvgDividendYield,
        RawData trailingPE,
        RawData forwardPE,
        RawData volume,
        RawData yield,
        RawData ytdReturn,
        RawData totalAssets
) {
}
