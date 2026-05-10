package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="edituri")
public class Editura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String nume;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
