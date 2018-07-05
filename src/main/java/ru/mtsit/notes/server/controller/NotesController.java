package ru.mtsit.notes.server.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NotesController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getSurvey(ModelMap model) {
        return "Get";
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
