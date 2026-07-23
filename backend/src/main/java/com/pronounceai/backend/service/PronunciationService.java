package com.pronounceai.backend.service;

import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.pronounceai.backend.azure.AzureSpeechService;
import com.pronounceai.backend.dto.PronunciationResponse;
import com.pronounceai.backend.dto.WordMistake;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;

@Service
public class PronunciationService {

    private final AzureSpeechService azureSpeechService;

    public PronunciationService(AzureSpeechService azureSpeechService) {
        this.azureSpeechService = azureSpeechService;
    }

    public PronunciationResponse analyzePronunciation(MultipartFile file) {

        try {

            // Save uploaded file temporarily
            File tempFile = File.createTempFile("audio-", ".wav");
            file.transferTo(tempFile);

            // Call Azure Speech
            SpeechRecognitionResult result =
                    azureSpeechService.recognizeSpeech(tempFile.getAbsolutePath());

            System.out.println("Recognized Text: " + result.getText());

            // Delete temporary file
            tempFile.delete();

            // Temporary response (we'll replace this with real Azure scores next)
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

        } catch (Exception e) {
            throw new RuntimeException("Speech analysis failed", e);
        }
    }
}