package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RawData(
        double raw, // example 29164707
        String fmt, //example 29.16M
        String longFmt //could be null, example 29,164,707
) {
}
