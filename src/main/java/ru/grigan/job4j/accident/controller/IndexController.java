package ru.grigan.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        List<String> strings = List.of("First", "Second", "Third", "Fourth", "Fifth");
        model.addAttribute("strings", strings);
        return "index";
    }
}
