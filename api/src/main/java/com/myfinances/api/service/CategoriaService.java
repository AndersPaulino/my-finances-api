package com.myfinances.api.service;

import com.myfinances.api.entity.Categoria;
import com.myfinances.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Categoria> findById(Long id){
        return categoriaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Categoria findByNomeCategoria(String nomeCategoria){
        return categoriaRepository.findByNomeCategoria(nomeCategoria);
    }

    @Transactional(readOnly = true)
    public List<Categoria> findByAtivo(boolean ativo){
        return categoriaRepository.findByAtivo(ativo);
    }

    @Transactional(readOnly = true)
    public List<Categoria> findByDiaRegistro(LocalDate registro){
        return categoriaRepository.findByDiaRegistro(registro);
    }
}
