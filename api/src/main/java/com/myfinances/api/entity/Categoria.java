package com.myfinances.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Categoria extends AbstractEntity{
    @Getter @Setter
    private String nomeCategoria;

    @Getter @Setter
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;
}
