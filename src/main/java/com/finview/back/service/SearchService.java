package com.finview.back.service;


import com.finview.back.model.search.RawSearchQuote;
import com.finview.back.model.search.SearchQuote;
import com.finview.back.repository.RestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MapperService mapperService;
    private final RestRepository repository;

    public List<RawSearchQuote> searchRaw(String ticker) {
        return repository.search(ticker);
    }

    public List<SearchQuote> search(String ticker) {
        if (StringUtils.isEmpty(ticker)){
            return Collections.emptyList();
        }
        List<RawSearchQuote> rawSearchQuotes = repository.search(ticker);
        return mapperService.map(rawSearchQuotes);
    }
}
