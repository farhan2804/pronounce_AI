package com.pronounceai.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SentenceService {

    private final List<String> sentences = List.of(

            "The quick brown fox jumps over the lazy dog.",
            "Practice makes perfect.",
            "Reading every day improves your pronunciation.",
            "Technology makes our lives easier.",
            "Artificial intelligence is transforming education.",
            "Communication is the key to success.",
            "Learning English requires patience and practice.",
            "She sells seashells by the seashore.",
            "The weather today is pleasant and sunny.",
            "Always believe in yourself.",

            "Success comes to those who work hard.",
            "Never stop learning new skills.",
            "Confidence grows with consistent practice.",
            "Programming is both creative and logical.",
            "Small improvements lead to big results.",
            "Every challenge is an opportunity to learn.",
            "The early bird catches the worm.",
            "Knowledge is power when applied correctly.",
            "Dream big and stay focused.",
            "Hard work always pays off."

    );

    private final Random random = new Random();

    private String currentSentence = "";

    public String getRandomSentence() {

        currentSentence =
                sentences.get(random.nextInt(sentences.size()));

        return currentSentence;
    }

    public String getCurrentSentence() {
        return currentSentence;
    }

}