package com.pronounceai.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SentenceService {

    private final List<String> passages = List.of(

            "Effective communication is one of the most valuable skills in both personal and professional life. Speaking clearly and confidently helps others understand your ideas while improving your ability to express yourself. Regular practice is the key to developing accurate pronunciation, better fluency, and greater confidence.",

            "Artificial intelligence is transforming the way people learn, work, and communicate. Modern applications can analyze speech, identify pronunciation mistakes, and provide personalized feedback. These technologies make language learning more engaging, interactive, and accessible for students around the world.",

            "Success is rarely achieved overnight. It is the result of consistent effort, continuous learning, and the determination to improve every single day. Even small steps taken regularly can lead to remarkable progress over time and help you achieve your long-term goals.",

            "Reading aloud is one of the most effective ways to improve English pronunciation. It strengthens your speaking confidence, increases fluency, and trains your mouth to produce sounds more accurately. Listening to your own voice also helps you recognize and correct mistakes.",

            "Technology has become an essential part of our daily lives. From smartphones to cloud computing and artificial intelligence, digital innovation continues to improve the way we communicate, solve problems, and access information from anywhere in the world.",

            "Learning a new language requires patience, dedication, and consistent practice. Building a strong vocabulary, improving pronunciation, and speaking confidently are all important steps toward becoming an effective communicator in everyday situations.",

            "Confidence is built through preparation and regular practice. Every challenge presents an opportunity to learn something new, develop valuable skills, and become better than you were yesterday. Persistence is often the key to long-term success.",

            "Public speaking is an important skill that improves with experience. Speaking at a comfortable pace, maintaining clear pronunciation, and expressing ideas confidently help create a positive impression on your audience and improve overall communication.",

            "Healthy habits contribute to both physical and mental well-being. Eating nutritious food, exercising regularly, staying hydrated, and getting enough sleep improve concentration, energy levels, and overall quality of life.",

            "Software development is a creative process that combines logical thinking with problem-solving skills. Developers design applications, write efficient code, test their solutions, and continuously improve software to provide better experiences for users."

    );

    private final Random random = new Random();

    private int lastIndex = -1;

    private String currentSentence = "";

    public String getRandomSentence() {

        int index;

        do {
            index = random.nextInt(passages.size());
        } while (index == lastIndex);

        lastIndex = index;

        currentSentence = passages.get(index);

        return currentSentence;
    }

    public String getCurrentSentence() {
        return currentSentence;
    }

}