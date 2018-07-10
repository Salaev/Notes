package ru.mtsit.notes.server.servis;

import ru.mtsit.notes.server.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAll();
    Note save(Note note);
    Note getNote(Long id);
    void NoteDelete(Long id);

}
