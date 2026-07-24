package com.pronounceai.backend.controller;

import com.pronounceai.backend.dto.SentenceResponse;
import com.pronounceai.backend.service.SentenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    private final SentenceService sentenceService;

    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @GetMapping("/api/sentence")
    public SentenceResponse getSentence() {

        return new SentenceResponse(
                sentenceService.getRandomSentence());

    }

}