package com.myfinances.api.service;

import com.myfinances.api.entity.Categoria;
import com.myfinances.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.PortUnreachableException;
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
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
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

    @Transactional(readOnly = true)
    public List<Categoria> findByDiaAtualziar(LocalDate atualziar){
        return categoriaRepository.findByDiaAtualizar(atualziar);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cadastar(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizar(Long id, Categoria categoria) {
        Optional<Categoria> categoria1 = categoriaRepository.findById(id);

        if (categoria1.isPresent()){
            Categoria categoria2 = categoria1.get();

            if (categoria.getDescricao() != null){
                categoria2.setDescricao(categoria.getDescricao());
            }
            if (categoria.getNomeCategoria() != null){
                categoria2.setNomeCategoria(categoria.getNomeCategoria());
            }
            categoria2.setAtualizar(LocalDate.now());

            categoriaRepository.save(categoria2);
        } else {
            throw new IllegalArgumentException("ID de categoria inválido!");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void deletar(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            Categoria categoria1 = categoria.get();
            categoria1.setAtivo(false);
            categoria1.setAtualizar(LocalDate.now());
        } else {
            throw new IllegalArgumentException("ID de categoria inválido!");
        }
    }
}
