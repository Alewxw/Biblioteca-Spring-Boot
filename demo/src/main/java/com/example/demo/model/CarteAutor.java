package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "carte_autor")
public class CarteAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private int id_carte;
    private int id_autor;


    public int getId_carte() {
        return id_carte;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}