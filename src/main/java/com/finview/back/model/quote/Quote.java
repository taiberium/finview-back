package com.finview.back.model.quote;

// ключевые кпоказатели
public record Quote(
        double pe, // отношение цены актива к чистой прибыли актива (за какой период?)
        double peg,
        double pb,
        double bookValue,
        double price,
        double low52Week,
        double high52Week,
        double highDay,
        double lowDay,
        double dividend,
        double dividendPercent,

        String companyName,
        String ticker,
        String type,
        String currency,
        String currencySymbol
) {
}
