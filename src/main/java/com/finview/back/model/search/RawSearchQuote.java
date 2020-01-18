package com.finview.back.model.search;

import lombok.Value;

@Value
public class RawSearchQuote {

    private String exchange;
    private String shortname;
    private String quoteType;
    private String symbol;
    private String longname;
}
