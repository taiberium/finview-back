package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawQuote {
    private QuoteSummary quoteSummary;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QuoteSummary {
        private List<Result> result;
        private String error; // most time is null
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private SummaryDetail summaryDetail;
        private DefaultKeyStatistics defaultKeyStatistics;
        private Price price;
    }


}
