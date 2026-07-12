package com.pronounceai.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "PronounceAI Backend Running";
    }

    @GetMapping("/api/health")
    public String health() {
        return "Backend is Healthy";
    }
}