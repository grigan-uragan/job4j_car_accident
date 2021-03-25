package ru.grigan.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.service.AccidentService;

@Controller
public class AccidentController {
    @Autowired
    private AccidentService service;

    @RequestMapping("/save")
    public String saveAccident(Model model) {
        model.addAttribute("accident", new Accident());
        return "create";
    }

    @RequestMapping("/create")
    public String createAccident(@ModelAttribute("accident") Accident accident) {
        service.addAccident(accident);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String editAccident(@RequestParam("accidentId") int id, Model model) {
        Accident accidentById = service.getAccidentById(id);
        model.addAttribute("accident", accidentById);
        return "create";
    }

}
