package com.example.demo.repository;

import com.example.demo.model.CarteAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CarteAutorRepository extends JpaRepository<CarteAutor, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM CarteAutor c WHERE c.id_autor = :idAutor")
    void deleteByIdAutor(@Param("idAutor") int idAutor);

    @Modifying
    @Transactional
    @Query("DELETE FROM CarteAutor c WHERE c.id_carte = :idCarte")
    void deleteByIdCarte(@Param("idCarte") int idCarte);

}
