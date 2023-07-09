package com.example.kitaplikDemo.business.abstracts;

import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.dto.responses.language.GetAllLanguageResponses;

import java.util.List;

public interface LanguageService {

    DataResult<List<GetAllLanguageResponses>> getAll();
}
