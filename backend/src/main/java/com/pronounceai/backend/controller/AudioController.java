package com.pronounceai.backend.controller;

import com.pronounceai.backend.dto.PronunciationResponse;
import com.pronounceai.backend.service.PronunciationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/audio")
public class AudioController {

    private final PronunciationService pronunciationService;

    public AudioController(PronunciationService pronunciationService) {
        this.pronunciationService = pronunciationService;
    }

    @PostMapping("/upload")
    public ResponseEntity<PronunciationResponse> uploadAudio(
            @RequestParam("audio") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        PronunciationResponse response =
                pronunciationService.analyzePronunciation(file.getOriginalFilename());

        return ResponseEntity.ok(response);
    }
}