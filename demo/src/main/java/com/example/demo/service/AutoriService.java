package com.example.demo.service;

import com.example.demo.model.Autor;
import com.example.demo.repository.CarteAutorRepository;
import com.example.demo.repository.AutoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoriService {
    @Autowired
    private AutoriRepository autoriRepository;
    @Autowired
    private CarteAutorRepository carteAutorRepository;

    public List<Autor> findAll(){
        return autoriRepository.findAll();
    }

    public void add ( Autor autor )
    {
        autoriRepository.save(autor);
    }

    public void delete ( int id )
    {
        carteAutorRepository.deleteByIdAutor(id);
        autoriRepository.deleteById(id);
    }

    public void update ( Autor autor )
    {
        autoriRepository.save(autor);
    }

    public Autor getById ( int id )
    {
        return autoriRepository.findById(id).orElse(null);
    }
}
