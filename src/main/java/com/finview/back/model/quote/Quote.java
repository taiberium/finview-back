package com.finview.back.model.quote;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Quote {

    // ключевые кпоказатели
    private double pe; // отношение цены актива к чистой прибыли актива (за какой период?)
    private double peg;
    private double pb;
    private double bookValue;
    private String name;
    private String ticker;
    private String type;
    private String currency;
    private double price;
    private double low52Week;
    private double high52Week;
    private double highDay;
    private double lowDay;
    private double dividend;
    private double dividendPercent;
}
