package com.example.note;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String content;

    public Note() {

    }
}