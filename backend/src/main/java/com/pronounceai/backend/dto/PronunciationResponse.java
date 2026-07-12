package com.pronounceai.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PronunciationResponse {

    private int score;
    private int accuracy;
    private int fluency;
    private int completeness;
    private List<WordMistake> mistakes;

}