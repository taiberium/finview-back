package com.finview.back.model.search;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SearchQuote {

    private String exchange;
    private String companyName;
    private String quoteType;
    private String ticker;
}
