package com.pronounceai.backend.controller;

import com.pronounceai.backend.dto.PracticeParagraph;
import com.pronounceai.backend.service.PracticeParagraphService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paragraphs")
@CrossOrigin(origins = "*")
public class PracticeParagraphController {

    private final PracticeParagraphService service;

    public PracticeParagraphController(PracticeParagraphService service) {
        this.service = service;
    }

    @GetMapping
    public List<PracticeParagraph> getParagraphs() {
        return service.getParagraphs();
    }

}