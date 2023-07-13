package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        NoteService noteService = new NoteService();

        Note newNote = new Note();
        newNote.setTitle("Note!1");
        newNote.setContent("some content");
        Note addedNote1 = noteService.add(newNote);
        System.out.println("Added new note: " + addedNote1);

        Note note2 = new Note();
        note2.setTitle("Note_2");
        note2.setContent("some other content");
        Note addedNote2 = noteService.add(note2);
        System.out.println("Added note 2: " + addedNote2);

        Note note3 = new Note();
        note3.setTitle("Note_3");
        note3.setContent("the other content");
        Note addedNote3 = noteService.add(note3);
        System.out.println("Added note 2: " + addedNote3);

        System.out.println("All notes: " + noteService.listAll());

        long id = addedNote1.getId();
        Note retrievedNote = noteService.getById(id);
        System.out.println("Retrieved note with id " + id + ": " + retrievedNote);

        Note updatedNote = new Note();
        updatedNote.setId(id);
        updatedNote.setTitle("Updated note");
        updatedNote.setContent("Updated content");
        noteService.update(updatedNote);
        System.out.println("Updated note with id " + id + ": " + noteService.getById(id));

        noteService.deleteById(id);
        System.out.println("All notes after deleting: " + noteService.listAll());
    }
}