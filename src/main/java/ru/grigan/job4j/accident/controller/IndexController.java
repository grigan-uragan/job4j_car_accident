package ru.grigan.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.service.AccidentService;
import ru.grigan.job4j.accident.service.JdbcService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private JdbcService service;

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidents = service.getAllAccident();
        model.addAttribute("accident", accidents);
        return "index";
    }
}
