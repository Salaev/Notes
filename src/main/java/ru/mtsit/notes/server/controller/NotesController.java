package ru.mtsit.notes.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.mtsit.notes.server.entity.Note;
import ru.mtsit.notes.server.repository.NoteRepository;
import ru.mtsit.notes.server.servis.NoteServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class NotesController {
    @Autowired
    private NoteServiceImpl service;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public  List<Note> getAllNotes() {
             return service.getAll();
    }
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public Note getNote(@PathVariable("id") long noteID) {
        return service.getNote(noteID);
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public Note saveNote(@RequestBody Note note) {
        return service.save(note);
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable("id") long noteID) {
        service.NoteDelete(noteID);
    }
    
}
