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
    public ResponseEntity<?> uploadAudio(
            @RequestParam("audio") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded.");
        }

        if (file.getSize() > 20 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("File size exceeds 20 MB.");
        }

        PronunciationResponse response =
                pronunciationService.analyzePronunciation(file);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public String health() {
        return "Audio Service Running";
    }
}