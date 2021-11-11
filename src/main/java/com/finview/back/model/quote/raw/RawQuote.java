package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RawQuote(
        QuoteSummary quoteSummary
) {


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record QuoteSummary(
            List<Result> result,
            String error // most time is null
    ) {
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record Result(
            SummaryDetail summaryDetail,
            DefaultKeyStatistics defaultKeyStatistics,
            Price price
    ) {
    }

}
