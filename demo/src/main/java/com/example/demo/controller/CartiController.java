package com.example.demo.controller;

import com.example.demo.model.Carte;
import com.example.demo.service.EdituriService;
import org.springframework.ui.Model;
import com.example.demo.service.CartiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.AutoriService;

@Controller
@RequestMapping("/carti")
public class CartiController {
    @Autowired
    private CartiService cartiService;
    @Autowired
    private EdituriService edituriService;
    @Autowired
    private AutoriService autoriService;

    @GetMapping
    public String getAll ( Model model )
    {
        model.addAttribute("carti", cartiService.getAll());
        return "carti";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("carte", new Carte());
        model.addAttribute("edituri", edituriService.getAll());
        model.addAttribute("totiAutorii", autoriService.findAll());
        return "carti-form";
    }

    @PostMapping("/add")
    public String save ( @ModelAttribute Carte carte )
    {
        cartiService.add(carte);
        return "redirect:/carti";
    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable int id )
    {
        cartiService.delete(id);
        return "redirect:/carti";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm ( @PathVariable int id, Model model )
    {
        Carte carte = cartiService.getById(id);
        model.addAttribute("carte", carte);
        model.addAttribute("edituri", edituriService.getAll());
        model.addAttribute("totiAutorii", autoriService.findAll());

        return "carti-form";
    }

    @PostMapping("/edit/{id}")
    public String update  ( @ModelAttribute Carte carte )
    {
        cartiService.update(carte);
        return "redirect:/carti";
    }
}
