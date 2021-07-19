package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    private RawData regularMarketDayLow;//raw	38.89 fmt	"38.89"
    private RawData regularMarketVolume;//raw	40793408 fmt	"40.79M" longFmt	"40,793,408.00"
    private RawData averageDailyVolume10Day; //raw	28458987 fmt	"28.46M" longFmt	"28,458,987"
    private RawData averageDailyVolume3Month;//raw	28074295 fmt	"28.07M" longFmt	"28,074,295"
    private RawData regularMarketPreviousClose; // raw	38.93 fmt	"38.93"
    private RawData regularMarketPrice;
    private RawData regularMarketOpen; //raw	39.21 fmt	"39.21"
    private String exchange;//	"NYQ"
    private String exchangeName;//	"NYSE"
    private String marketState;//	"CLOSED"
    private String quoteType;//	"EQUITY"
    private String symbol; //	"T"
    private String shortName; //	"AT&T Inc."
    private String longName; //	"AT&T Inc."
    private String currency; //"USD"
    private String currencySymbol; //"$"
    private RawData marketCap;
}
