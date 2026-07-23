package com.pronounceai.backend.azure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

    public SpeechRecognitionResult recognizeSpeech(String audioFilePath)
            throws ExecutionException, InterruptedException {

        AudioConfig audioConfig = AudioConfig.fromWavFileInput(audioFilePath);

        SpeechRecognizer recognizer =
                new SpeechRecognizer(speechConfig, audioConfig);

        PronunciationAssessmentConfig pronunciationConfig =
                new PronunciationAssessmentConfig(
                        "",
                        PronunciationAssessmentGradingSystem.HundredMark,
                        PronunciationAssessmentGranularity.Phoneme,
                        true
                );

        pronunciationConfig.applyTo(recognizer);

        SpeechRecognitionResult result =
                recognizer.recognizeOnceAsync().get();

        String jsonResult = result.getProperties().getProperty(
                PropertyId.SpeechServiceResponse_JsonResult);

        System.out.println("========== AZURE JSON ==========");

        try {
            ObjectMapper mapper = new ObjectMapper();

            Object jsonObject = mapper.readValue(jsonResult, Object.class);

            String prettyJson = mapper
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .writeValueAsString(jsonObject);

            System.out.println(prettyJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("================================");

        recognizer.close();
        audioConfig.close();
        pronunciationConfig.close();

        return result;
    }
}