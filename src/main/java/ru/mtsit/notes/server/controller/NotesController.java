package ru.mtsit.notes.server.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mtsit.notes.server.entity.Note;
import ru.mtsit.notes.server.repository.NoteRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private NoteRepository noteRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Note getNote() {
        List<Note> list = noteRepository.findAll();
        return createMockNote();
    }

    private Note createMockNote() {
        Note note = new Note();
        note.setId(1);
        note.setTitle("первое примечание");
        note.setNoteData(new Date());
        return note;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String postSurvey(ModelMap model) {
        return "Post";
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String putSurvey(ModelMap model) {
        return "Put";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteSurvey(ModelMap model) {
        return "Delete";
    }

}
