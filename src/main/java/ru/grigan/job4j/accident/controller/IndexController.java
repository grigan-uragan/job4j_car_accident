package ru.grigan.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.service.AccidentService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private AccidentService service;

    @RequestMapping("/")
    public String index(Model model) {
        List<Accident> accidents = service.getAllAccident();
        if (accidents.isEmpty()) {
            service.addAccident(new Accident(1, "First accident",
                    "speed limit over", "Lenin street"));
            service.addAccident(new Accident(2, "Second accident",
                    "driving to a stoplight signal", "Gagarin street"));
        }
        model.addAttribute("accident", accidents);
        return "index";
    }
}
