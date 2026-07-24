package com.pronounceai.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.pronounceai.backend.azure.AzureSpeechService;
import com.pronounceai.backend.dto.PronunciationResponse;
import com.pronounceai.backend.dto.WordMistake;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
// import com.pronounceai.backend.service.SentenceService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PronunciationService {

        private final AzureSpeechService azureSpeechService;
        private final SentenceService sentenceService;

        public PronunciationService(
                        AzureSpeechService azureSpeechService,
                        SentenceService sentenceService) {

                this.azureSpeechService = azureSpeechService;
                this.sentenceService = sentenceService;

        }

        public PronunciationResponse analyzePronunciation(MultipartFile file) {

                try {

                        File tempFile = File.createTempFile("audio-", ".wav");
                        file.transferTo(tempFile);

                        String referenceSentence = sentenceService.getCurrentSentence();

                        SpeechRecognitionResult result = azureSpeechService.recognizeSpeech(
                                        tempFile.getAbsolutePath(),
                                        referenceSentence);

                        String json = result.getProperties()
                                        .getProperty(PropertyId.SpeechServiceResponse_JsonResult);

                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode root = mapper.readTree(json);

                        JsonNode pronunciation = root.path("NBest")
                                        .get(0)
                                        .path("PronunciationAssessment");

                        int score = (int) Math.round(
                                        pronunciation.path("PronScore").asDouble());

                        int accuracy = (int) Math.round(
                                        pronunciation.path("AccuracyScore").asDouble());

                        int fluency = (int) Math.round(
                                        pronunciation.path("FluencyScore").asDouble());

                        int completeness = (int) Math.round(
                                        pronunciation.path("CompletenessScore").asDouble());

                        List<WordMistake> mistakes = new ArrayList<>();

                        JsonNode words = root.path("NBest")
                                        .get(0)
                                        .path("Words");

                        for (JsonNode word : words) {

                                String wordText = word.path("Word").asText();

                                double wordAccuracy = word
                                                .path("PronunciationAssessment")
                                                .path("AccuracyScore")
                                                .asDouble();

                                if (wordAccuracy < 85) {

                                        mistakes.add(
                                                        new WordMistake(
                                                                        wordText,
                                                                        "Low pronunciation accuracy ("
                                                                                        + Math.round(wordAccuracy)
                                                                                        + "%)"));
                                }
                        }

                        tempFile.delete();

                        return new PronunciationResponse(
                                        score,
                                        accuracy,
                                        fluency,
                                        completeness,
                                        mistakes);

                } catch (Exception e) {
                        throw new RuntimeException("Speech analysis failed", e);
                }
        }
}