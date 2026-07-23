package com.pronounceai.backend.service;

import com.pronounceai.backend.dto.PronunciationResponse;
import com.pronounceai.backend.dto.WordMistake;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Service
public class PronunciationService {

    public PronunciationResponse analyzePronunciation(MultipartFile file) {

        // Azure Speech SDK integration will go here

        return new PronunciationResponse(
                86,
                90,
                82,
                88,
                Arrays.asList(
                        new WordMistake(
                                "comfortable",
                                "Stress incorrect"
                        ),
                        new WordMistake(
                                "development",
                                "Unclear pronunciation"
                        )
                )
        );
    }
}