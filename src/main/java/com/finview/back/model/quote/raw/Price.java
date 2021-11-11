package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Price(
        RawData regularMarketDayLow,//raw	38.89 fmt	"38.89"
        RawData regularMarketVolume,//raw	40793408 fmt	"40.79M" longFmt	"40,793,408.00"
        RawData averageDailyVolume10Day, //raw	28458987 fmt	"28.46M" longFmt	"28,458,987"
        RawData averageDailyVolume3Month,//raw	28074295 fmt	"28.07M" longFmt	"28,074,295"
        RawData regularMarketPreviousClose, // raw	38.93 fmt	"38.93"
        RawData regularMarketPrice,
        RawData regularMarketOpen, //raw	39.21 fmt	"39.21"
        String exchange,//	"NYQ"
        String exchangeName,//	"NYSE"
        String marketState,//	"CLOSED"
        String quoteType,//	"EQUITY"
        String symbol, //	"T"
        String shortName, //	"AT&T Inc."
        String longName, //	"AT&T Inc."
        String currency, //"USD"
        String currencySymbol, //"$"
        RawData marketCap
) {
}
