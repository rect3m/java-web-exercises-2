package com.bobocode.mvc.controller;

import com.bobocode.mvc.data.Notes;
import com.bobocode.mvc.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final Notes notes;

    public NoteController(Notes notes) {
        this.notes = notes;
    }

    @GetMapping
    public String getNotes(Model model) {
        model.addAttribute("noteList", notes.getAll());
        return "notes";
    }

    @PostMapping
    public String addNote(@Validated Note note) {
        notes.add(note);
        return "redirect:/notes";
    }
}
