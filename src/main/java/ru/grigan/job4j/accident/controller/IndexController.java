package ru.grigan.job4j.accident.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.service.JpaService;

import java.util.List;

@Controller
public class IndexController {

    private JpaService service;

    public IndexController(JpaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidents = service.getAllAccident();
        model.addAttribute("accident", accidents);
        model.addAttribute("user", SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return "index";
    }
}
