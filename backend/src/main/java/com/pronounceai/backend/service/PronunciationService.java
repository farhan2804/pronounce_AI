package com.pronounceai.backend.service;

import com.pronounceai.backend.dto.PronunciationResponse;
import com.pronounceai.backend.dto.WordMistake;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PronunciationService {

    public PronunciationResponse analyzePronunciation(String fileName) {

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