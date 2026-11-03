package com.myfinances.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_transacao", schema = "public")
@Getter @Setter
public class Transacao extends AbstractEntity{

    private String descricao;

    private BigDecimal valor;

    private LocalDate dia;

    @ManyToOne
    @JoinColumn(name = "cl_categoria_id")
    private Categoria categoria;
}
