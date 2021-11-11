package com.finview.back.model.search;

public record RawSearchQuote(
        String exchange,
        String shortname,
        String quoteType,
        String symbol,
        String longname
) {
}
