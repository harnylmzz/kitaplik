package com.example.kitaplikDemo.controller;

import com.example.kitaplikDemo.business.abstracts.LanguageService;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.dto.requests.languageRequests.CreateLanguageRequests;
import com.example.kitaplikDemo.dto.requests.languageRequests.DeleteLanguageRequests;
import com.example.kitaplikDemo.dto.requests.languageRequests.UpdateLanguageRequests;
import com.example.kitaplikDemo.dto.responses.language.GetAllLanguageResponses;
import com.example.kitaplikDemo.model.Language;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {

    private LanguageService languageService;

    @GetMapping("/getall")
    public DataResult<List<GetAllLanguageResponses>> getAll() {
        return this.languageService.getAll();
    }

    @GetMapping("/{languageId}")
    public DataResult<Language> getOneLanguage(@PathVariable Long languageId){
        return this.languageService.getOneLanguage(languageId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateLanguageRequests createLanguageRequests) {
        return this.languageService.add(createLanguageRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteLanguageRequests deleteLanguageRequests){
        return this.languageService.delete(deleteLanguageRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateLanguageRequests updateLanguageRequests) {
        return this.languageService.update(updateLanguageRequests);
    }
}
