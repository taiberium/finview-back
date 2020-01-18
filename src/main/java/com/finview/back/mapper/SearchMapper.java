package com.finview.back.mapper;

import com.finview.back.model.search.RawSearchQuote;
import com.finview.back.model.search.SearchQuote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public abstract class SearchMapper {

    @Mapping(target = "companyName", expression = "java( findCompanyName(rawSearchQuote) )")
    @Mapping(target = "exchange", source = "rawSearchQuote.exchange")
    @Mapping(target = "quoteType", source = "rawSearchQuote.quoteType")
    @Mapping(target = "ticker", source = "rawSearchQuote.symbol")
    public abstract SearchQuote map(RawSearchQuote rawSearchQuote);

    public abstract List<SearchQuote> map(List<RawSearchQuote> rawSearchQuotes);

    //don't remove!
    protected String findCompanyName(RawSearchQuote rawSearchQuote) {
        return StringUtils.isEmpty(rawSearchQuote.getShortname()) ?
                rawSearchQuote.getShortname() :
                rawSearchQuote.getLongname();
    }
}
