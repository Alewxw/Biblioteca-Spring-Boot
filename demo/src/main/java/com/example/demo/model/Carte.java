package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="carti")
public class Carte {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String nume;
    private int an_publicare;
    private int editura_id;

    @ManyToOne
    @JoinColumn(name = "editura_id", insertable = false, updatable = false)
    private Editura editura;

    @ManyToMany
    @JoinTable(
            name = "carte_autor",
            joinColumns = @JoinColumn(name = "id_carte"),
            inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autori;

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

    public int getAn_publicare() {
        return an_publicare;
    }

    public void setAn_publicare(int an_publicare) {
        this.an_publicare = an_publicare;
    }


    public int getEditura_id() {
        return editura_id;
    }

    public void setEditura_id(int editura_id) {
        this.editura_id = editura_id;
    }

    public Editura getEditura() {
        return editura;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public List<Autor> getAutori() {
        return autori;
    }

    public void setAutori(List<Autor> autori) {
        this.autori = autori;
    }
}
