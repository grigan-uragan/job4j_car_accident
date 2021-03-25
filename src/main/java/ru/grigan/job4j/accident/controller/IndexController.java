package ru.grigan.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
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
            AccidentType bikeAndCar = new AccidentType("bike and car");
            AccidentType twoCars = new AccidentType("two cars");
            service.addType(bikeAndCar);
            service.addType(twoCars);
            List<AccidentType> types = service.allType();
            service.addAccident(new Accident("First accident",
                    "speed limit over", "Lenin street", types.get(0)));
            service.addAccident(new Accident("Second accident",
                    "driving to a stoplight signal", "Gagarin street", types.get(1)));
        }
        model.addAttribute("accident", accidents);
        return "index";
    }
}
