package com.example.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public void create(Note note) {
        noteRepository.save(note);
    }

    public void edit(Note note){
        getById(note.getId());
        noteRepository.save(note);
    }

    public Note getById(long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        }
        throw new NoSuchElementException("Note with id " + id + " doesn't exist.");
    }

    public void deleteById(long id) {
        noteRepository.delete(getById(id));
    }

    public List<Note> listAll() {
        return (List<Note>) noteRepository.findAll();
    }
}

