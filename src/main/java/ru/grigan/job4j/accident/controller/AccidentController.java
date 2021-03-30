package ru.grigan.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;
import ru.grigan.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AccidentController {
    @Autowired
    private AccidentService service;

    @GetMapping("/save")
    public String saveAccident(Model model) {
        List<AccidentType> types = service.allType();
        List<Rule> rules = service.getAllRule();
        model.addAttribute("accident", new Accident());
        model.addAttribute("types", types);
        model.addAttribute("rules", rules);
        return "create";
    }

    @PostMapping("/create")
    public String createAccident(@ModelAttribute("accident") Accident accident,
                                 @RequestParam("type.id") int id, HttpServletRequest reg) {
        String[] rIds = reg.getParameterValues("rIds");
        Set<Rule> rules = new HashSet<>();
        for (String ruleId : rIds) {
            Rule byId = service.getRuleById(Integer.parseInt(ruleId));
            rules.add(byId);
        }
        AccidentType typeById = service.getTypeById(id);
        accident.setType(typeById);
        accident.setRules(rules);
        service.addAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editAccident(@RequestParam("accidentId") int id, Model model) {
        Accident accidentById = service.getAccidentById(id);
        List<AccidentType> types = service.allType();
        List<Rule> rules = service.getAllRule();
        model.addAttribute("accident", accidentById);
        model.addAttribute("types", types);
        model.addAttribute("rules", rules);
        return "create";
    }

}
