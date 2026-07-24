package com.pronounceai.backend.azure;

import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AzureSpeechService {

    private final SpeechConfig speechConfig;

    public AzureSpeechService(SpeechConfig speechConfig) {
        this.speechConfig = speechConfig;
    }

    public SpeechRecognitionResult recognizeSpeech(
            String audioFilePath,
            String referenceSentence)
            throws ExecutionException, InterruptedException {

        AudioConfig audioConfig =
                AudioConfig.fromWavFileInput(audioFilePath);

        SpeechRecognizer recognizer =
                new SpeechRecognizer(speechConfig, audioConfig);

        PronunciationAssessmentConfig pronunciationConfig =
                new PronunciationAssessmentConfig(
                        referenceSentence,
                        PronunciationAssessmentGradingSystem.HundredMark,
                        PronunciationAssessmentGranularity.Phoneme,
                        true
                );

        pronunciationConfig.applyTo(recognizer);

        SpeechRecognitionResult result =
                recognizer.recognizeOnceAsync().get();

        recognizer.close();
        audioConfig.close();
        pronunciationConfig.close();

        return result;
    }

}