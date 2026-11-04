package com.myfinances.api.repository;

import com.myfinances.api.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT e FROM Categoria e WHERE e.nomeCategoria = :nomeCategoria")
    Categoria findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

    @Query("SELECT e FROM Categoria e WHERE e.ativo = :ativo")
    List<Categoria> findByAtivo(@Param("ativo") boolean ativo);

    @Query("SELECT e FROM Categoria e WHERE e.registro = :registro")
    List<Categoria> findByDiaRegistro(@Param("registro")LocalDate registro);

}
