package com.myfinances.api.service;

import com.myfinances.api.entity.Transacao;
import com.myfinances.api.repository.CategoriaRepository;
import com.myfinances.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransacaoService {

    private final CategoriaRepository categoriaRepository;
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(CategoriaRepository categoriaRepository, TransacaoRepository transacaoRepository){
        this.categoriaRepository = categoriaRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Transacao> findById(Long id){
        return transacaoRepository.findById(id);
    }

}
