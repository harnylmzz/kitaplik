package com.example.kitaplikDemo.business.concretes;

import com.example.kitaplikDemo.business.abstracts.LanguageService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.dto.responses.language.GetAllLanguageResponses;
import com.example.kitaplikDemo.model.Language;
import com.example.kitaplikDemo.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService  {

    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllLanguageResponses>> getAll() {

        List<Language> languages = languageRepository.findAll();

        return null;
    }
}
