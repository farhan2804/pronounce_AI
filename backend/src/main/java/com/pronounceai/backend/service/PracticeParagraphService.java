package com.pronounceai.backend.service;

import com.pronounceai.backend.dto.PracticeParagraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeParagraphService {

    public List<PracticeParagraph> getParagraphs() {

        return List.of(

                new PracticeParagraph(
                        1L,
                        "Easy",
                        "Artificial intelligence is transforming the world every day."
                ),

                new PracticeParagraph(
                        2L,
                        "Medium",
                        "Technology continues to improve healthcare education and communication across the globe."
                ),

                new PracticeParagraph(
                        3L,
                        "Hard",
                        "Continuous practice and consistent dedication are essential for mastering pronunciation and achieving communication excellence."
                )

        );
    }
}