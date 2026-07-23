package com.pronounceai.backend.azure;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import org.springframework.stereotype.Service;

@Service
public class AzureSpeechService {

    private final SpeechConfig speechConfig;

    public AzureSpeechService(SpeechConfig speechConfig) {
        this.speechConfig = speechConfig;
    }

    public SpeechConfig getSpeechConfig() {
        return speechConfig;
    }
}