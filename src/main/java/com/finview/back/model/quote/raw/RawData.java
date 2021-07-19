package com.finview.back.model.quote.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawData {
    private double raw; // example 29164707
    private String fmt; //example 29.16M
    private String longFmt; //could be null, example 29,164,707
}
