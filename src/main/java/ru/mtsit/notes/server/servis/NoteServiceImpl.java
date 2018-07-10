package ru.mtsit.notes.server.servis;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mtsit.notes.server.entity.Note;
import ru.mtsit.notes.server.repository.NoteRepository;

import java.util.List;

public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNote(Long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void NoteDelete(Long id) {
        noteRepository.deleteById(id);
    }
}

