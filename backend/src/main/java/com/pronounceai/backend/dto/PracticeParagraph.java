package com.pronounceai.backend.dto;

public class PracticeParagraph {

    private Long id;
    private String level;
    private String text;

    public PracticeParagraph(Long id, String level, String text) {
        this.id = id;
        this.level = level;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public String getText() {
        return text;
    }
}