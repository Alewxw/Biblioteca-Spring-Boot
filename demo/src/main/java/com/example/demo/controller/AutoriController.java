package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.model.Editura;
import org.springframework.ui.Model;
import com.example.demo.service.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/autori")
public class AutoriController {

    @Autowired
    private AutoriService autoriService;

    @GetMapping
    public String getAll ( Model model )
    {
        model.addAttribute("autori", autoriService.findAll());
        return "autori";
    }

    @GetMapping("/add")
    public String showForm ( Model model )
    {
        model.addAttribute("autor", new Autor());
        return "autori-form";
    }

    @PostMapping("/add")
    public String save ( @ModelAttribute Autor autor )
    {
        autoriService.add(autor);
        return "redirect:/autori";
    }

    @GetMapping("/delete/{id}")
    public String delete ( @PathVariable int id )
    {
        autoriService.delete(id);
        return "redirect:/autori";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm ( @PathVariable int id, Model model )
    {
        Autor autor = autoriService.getById(id);
        model.addAttribute("autor", autor);
        return "autori-form";
    }

    @PostMapping("/edit/{id}")
    public String update (@ModelAttribute Autor autor )
    {
        autoriService.update(autor);
        return "redirect:/autori";
    }
}
