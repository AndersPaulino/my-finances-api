package com.myfinances.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_categoria", schema = "public")
public class Categoria extends AbstractEntity{
    @Getter @Setter
    @Column(name = "cl_nome_categoria",length = 55)
    private String nomeCategoria;

    @Getter @Setter
    @Column(name = "cl_descricao",length = 255)
    private String descricao;
}
