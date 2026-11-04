package com.myfinances.api.repository;

import com.myfinances.api.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query("SELECT e FROM Transacao e WHERE e.ativo = :ativo")
    List<Transacao> findByAtivo(@Param("ativo")boolean ativo);

}
