package com.example.note;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")

public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView allNote() {
        ModelAndView res = new ModelAndView("list");
        res.addObject("notes", noteService.listAll());
        return res;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView res = new ModelAndView("create");
        res.addObject("note", new Note());
        return res;
    }
    @PostMapping("/create")
    public ModelAndView add(@ModelAttribute("note") Note note) {
        noteService.create(note);
        ModelAndView res = new ModelAndView("redirect:/note/list");
        res.addObject("notes", noteService.listAll());
        return res;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") long id){
        noteService.deleteById(id);
        ModelAndView res = new ModelAndView("redirect:/note/list");
        res.addObject("notes",noteService.listAll());
        return res;
    }

    @GetMapping("/edit")
    public ModelAndView editPage(@RequestParam("id") long id) {
        ModelAndView res = new ModelAndView("edit");
        res.addObject("note", noteService.getById(id));
        return res;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("note") Note note) {
        noteService.edit(note);
        ModelAndView res = new ModelAndView("redirect:/note/list");
        res.addObject("notes", noteService.listAll());
        return res;
    }
}