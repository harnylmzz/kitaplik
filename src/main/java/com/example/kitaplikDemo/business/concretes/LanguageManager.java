package com.example.kitaplikDemo.business.concretes;

import com.example.kitaplikDemo.business.abstracts.LanguageService;
import com.example.kitaplikDemo.business.rules.LanguageBusinessRules;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.Result.DataResult;
import com.example.kitaplikDemo.core.Result.Result;
import com.example.kitaplikDemo.core.Result.SuccessResult;
import com.example.kitaplikDemo.core.exceptions.DataNotFoundException;
import com.example.kitaplikDemo.dto.requests.languageRequests.CreateLanguageRequests;
import com.example.kitaplikDemo.dto.requests.languageRequests.DeleteLanguageRequests;
import com.example.kitaplikDemo.dto.requests.languageRequests.UpdateLanguageRequests;
import com.example.kitaplikDemo.dto.responses.language.GetAllLanguageResponses;
import com.example.kitaplikDemo.model.Language;
import com.example.kitaplikDemo.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;
    private LanguageBusinessRules languageBusinessRules;

    @Override
    public DataResult<List<GetAllLanguageResponses>> getAll() {

        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguageResponses> getAllLanguageResponses = languages.stream()
                .map(language -> this.modelMapperService.forResponse()
                        .map(language, GetAllLanguageResponses.class))
                .collect(Collectors.toList());

        return new DataResult<List<GetAllLanguageResponses>>(getAllLanguageResponses, true,
                "All languages were brought.");
    }

    @Override
    public DataResult<Language> getOneLanguage(Long languageId) {

        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new DataNotFoundException("Language not found!"));
        return new DataResult<Language>(language, true, "Language brought.");
    }

    @Override
    public Result add(CreateLanguageRequests createLanguageRequests) {

        this.languageBusinessRules.checkIfLanguageName(createLanguageRequests.getLanguage());

        Language language = modelMapperService.forRequest()
                .map(createLanguageRequests, Language.class);
        this.languageRepository.save(language);
        return new SuccessResult("New language added.");
    }

    @Override
    public Result delete(DeleteLanguageRequests deleteLanguageRequests) {
        Language language = modelMapperService.forRequest()
                .map(deleteLanguageRequests, Language.class);
        this.languageRepository.delete(language);
        return new SuccessResult("The language deleted.");
    }

    @Override
    public Result update(UpdateLanguageRequests updateLanguageRequests) {

        Optional<Language> inDbLanguage = languageRepository.findById(updateLanguageRequests.getId());
        if (inDbLanguage.isPresent()) {
            Language language = inDbLanguage.get();
            language.setId(updateLanguageRequests.getId());
            language.setLanguage(updateLanguageRequests.getLanguage());
            this.languageRepository.save(language);
        } else {

        }
        return new SuccessResult("The language updated.");
    }
}
