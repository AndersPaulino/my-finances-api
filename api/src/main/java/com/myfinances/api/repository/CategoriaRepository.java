package com.myfinances.api.repository;

import com.myfinances.api.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT e FROM Categoria e WHERE e.nomeCategoria = :nomeCategoria")
    Categoria findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

}
