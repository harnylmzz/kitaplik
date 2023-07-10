package com.example.kitaplikDemo.business.abstracts;

import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.dto.requests.languageRequests.CreateLanguageRequests;
import com.example.kitaplikDemo.dto.requests.languageRequests.DeleteLanguageRequests;
import com.example.kitaplikDemo.dto.requests.languageRequests.UpdateLanguageRequests;
import com.example.kitaplikDemo.dto.responses.language.GetAllLanguageResponses;
import com.example.kitaplikDemo.model.Language;

import java.util.List;

public interface LanguageService {

    DataResult<List<GetAllLanguageResponses>> getAll();
    DataResult<Language> getOneLanguage(Long languageId);
    Result add(CreateLanguageRequests createLanguageRequests);
    Result delete(DeleteLanguageRequests deleteLanguageRequests);
    Result update(UpdateLanguageRequests updateLanguageRequests);
}
