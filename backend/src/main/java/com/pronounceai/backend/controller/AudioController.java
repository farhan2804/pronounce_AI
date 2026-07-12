package com.pronounceai.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/audio")
public class AudioController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAudio(
            @RequestParam("audio") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded.");
        }

        return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
    }
}