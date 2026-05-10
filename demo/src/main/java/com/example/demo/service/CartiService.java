package com.example.demo.service;

import com.example.demo.model.Carte;
import com.example.demo.repository.CarteAutorRepository;
import com.example.demo.repository.CartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartiService {
    @Autowired
    private CartiRepository cartiRepository;
    @Autowired
    private CarteAutorRepository carteAutorRepository;

    public List<Carte> getAll(){
        return cartiRepository.findAll();
    }

    public void add ( Carte carte )
    {
        cartiRepository.save(carte);
    }

    public void delete ( int id )
    {
        carteAutorRepository.deleteByIdCarte(id);
        cartiRepository.deleteById(id);
    }

    public void update(Carte carte )
    {
        cartiRepository.save(carte);
    }

    public Carte getById ( int id )
    {
        return cartiRepository.findById(id).orElse(null);
    }
}
