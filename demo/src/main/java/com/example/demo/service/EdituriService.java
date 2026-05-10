package com.example.demo.service;

import com.example.demo.model.Editura;
import com.example.demo.repository.EdituriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EdituriService {

    @Autowired
    private EdituriRepository edituriRepository;

    public List<Editura> getAll() {
        return edituriRepository.findAll();
    }

    public void add (Editura editura) {
        edituriRepository.save(editura);
    }

    public void delete ( int id )
    {
        edituriRepository.deleteById(id);
    }

    public void update ( Editura editura )
    {
        edituriRepository.save(editura);
    }

    public Editura getById( int id )
    {
        return edituriRepository.findById(id).orElse(null);
    }


}