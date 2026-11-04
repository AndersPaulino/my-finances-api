package com.myfinances.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_transacao", schema = "public")
@Getter @Setter
public class Transacao extends AbstractEntity{
    @Column(name = "cl_descricao", length = 255)
    private String descricao;
    @Column(name = "cl_valor")
    private BigDecimal valor;
    @Column(name = "cl_dia_transacao")
    private LocalDate dia;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @ManyToOne
    @JoinColumn(name = "cl_categoria_id")
    private Categoria categoria;
}
