package com.example.note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private  static final Map<Long, Note> notes = new HashMap<>();

    public void create(Note note) {
        long id = generateUniqueId();
        note.setId(id);
        notes.put(id, note);
    }
    public void edit(Note note){
        if(!notes.containsKey(note.getId())){
            throw new NoSuchElementException("Note with id " + note.getId() + " does not exist.");
        }else{
            notes.put(note.getId(), note);
            note.setTitle(note.getTitle());
            note.setContent(note.getContent());
        }
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note with id " + id + " doesn't exist.");
        }
        return notes.get(id);
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note with id " + id + " doesn't exist.");
        }
        notes.remove(id);
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    private long generateUniqueId() {
        Random random = new Random();
        long id;
        do {
            id = random.nextLong();
        } while (id < 0 || notes.containsKey(id));
        return id;
    }
}

