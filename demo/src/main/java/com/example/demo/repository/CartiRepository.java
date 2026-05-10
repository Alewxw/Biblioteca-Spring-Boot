package com.example.demo.repository;

import com.example.demo.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartiRepository extends JpaRepository<Carte, Integer> {
}