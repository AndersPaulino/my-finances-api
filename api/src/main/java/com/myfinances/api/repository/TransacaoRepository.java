package com.myfinances.api.repository;

import com.myfinances.api.entity.TipoTransacao;
import com.myfinances.api.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query("SELECT e FROM Transacao e WHERE e.ativo = :ativo")
    List<Transacao> findByAtivo(@Param("ativo")boolean ativo);

    @Query("SELECT e FROM Transacao e WHERE e.registro = :registro")
    List<Transacao> findByDiaRegistro(@Param("registro")LocalDate registro);

    @Query("SELECT e FROM Transacao e WHERE e.atualizar = :atualizar")
    List<Transacao> findByDiaAtualizar(@Param("atualziar")LocalDate atualizar);

    @Query("SELECT e FROM Transacao e WHERE e.tipo = :tipo")
    List<Transacao> findByTipoTransacao(@Param("tipo")TipoTransacao tipo);

    @Query("SELECT e FROM Transacao e WHERE e.dia = :dia")
    List<Transacao> findByDia(@Param("dia")LocalDate dia);

    @Query("SELECT e FROM Transacao e WHERE e.valor = :valor")
    List<Transacao> fiindByValor(@Param("valor")BigDecimal valor);


}
