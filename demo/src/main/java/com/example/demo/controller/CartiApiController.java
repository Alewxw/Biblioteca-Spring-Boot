package com.example.demo.controller;


import com.example.demo.model.Carte;
import com.example.demo.service.CartiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carti")
public class CartiApiController {
    @Autowired
    private CartiService cartiService;

    @GetMapping
    public List<Carte> getAll()
    {
        return cartiService.getAll();
    }

    @GetMapping("/{id}")
    public Carte getById(@PathVariable int id )
    {
        return cartiService.getById(id);
    }

    @PostMapping
    public void add (@RequestBody Carte carte )
    {
        cartiService.add(carte);
    }

    @PutMapping("/{id}")
    public void modify ( @PathVariable int id , @RequestBody Carte carte )
    {
        cartiService.update(carte);
    }

    @DeleteMapping("/{id}")
    public void delete ( @PathVariable int id )
    {
        cartiService.delete(id);
    }


}
