package org.launchcode.hellothymeleaf.controllers;

import org.launchcode.hellothymeleaf.data.EventData;
import org.launchcode.hellothymeleaf.models.EventType;
import org.launchcode.hellothymeleaf.models.Events;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

//lives at /events
@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //Lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title", "Create Events");
        model.addAttribute(new Events());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Events newEvent, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Events");
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect:";
    }

    //Displays the delete form
    @GetMapping("delete")
    public String displaysDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }
}
