package com.finview.back.model.search;

import lombok.Data;

@Data
public class SearchQuote {

    private String exchange;
    private String companyName;
    private String quoteType;
    private String ticker;
}
