package com.pronounceai.backend.controller;

import com.pronounceai.backend.dto.SentenceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    @GetMapping("/api/sentence")
    public SentenceResponse getSentence() {

        return new SentenceResponse(
                "The quick brown fox jumps over the lazy dog."
        );
    }
}