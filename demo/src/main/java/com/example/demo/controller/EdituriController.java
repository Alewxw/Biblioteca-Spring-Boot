package com.example.demo.controller;

import com.example.demo.model.Editura;
import org.springframework.ui.Model;
import com.example.demo.service.EdituriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/edituri")
public class EdituriController {

    @Autowired
    private EdituriService edituriService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("edituri", edituriService.getAll());
        return "edituri";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("editura", new Editura());
        return "edituri-form";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Editura editura) {
        edituriService.add(editura);
        return "redirect:/edituri";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        edituriService.delete(id);
        return "redirect:/edituri";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Editura editura = edituriService.getById(id);
        model.addAttribute("editura", editura);
        return "edituri-form";
    }

    @PostMapping("/edit/{id}")
    public String update (@ModelAttribute Editura editura )
    {
        edituriService.update(editura);
        return "redirect:/edituri";
    }
}