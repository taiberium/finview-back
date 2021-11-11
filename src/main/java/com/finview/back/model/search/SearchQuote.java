package com.finview.back.model.search;


public record SearchQuote(
        String exchange,
        String companyName,
        String quoteType,
        String ticker
) {
}
