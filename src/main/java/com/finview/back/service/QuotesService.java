package com.finview.back.service;

import com.finview.back.mapper.QuotesMapper;
import com.finview.back.model.quote.Quote;
import com.finview.back.model.quote.raw.RawQuote;
import com.finview.back.repository.RestRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public record QuotesService(
        RestRepository repository,
        QuotesMapper mapper
) {

    public List<Quote> getQuotes(List<String> quoteTickers) {
        if (CollectionUtils.isEmpty(quoteTickers)) return Collections.emptyList();
        return quoteTickers.parallelStream()
                .map(this::getQuote)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Optional<Quote> getQuote(String ticker) {
        return repository.getQuote(ticker)
                .map(mapper::map);
    }

    public Optional<RawQuote> getRawQuote(String ticker) {
        return repository.getQuote(ticker);
    }
}
