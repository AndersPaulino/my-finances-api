package com.myfinances.api.service;

import com.myfinances.api.entity.TipoTransacao;
import com.myfinances.api.entity.Transacao;
import com.myfinances.api.repository.CategoriaRepository;
import com.myfinances.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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

    @Transactional(readOnly = true)
    public List<Transacao> findAll(){
        return transacaoRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<Transacao> findByAtivo(boolean ativo){
        return transacaoRepository.findByAtivo(ativo);
    }

    @Transactional(readOnly = true)
    public List<Transacao> findByDiaRegistro(LocalDate registro){
        return transacaoRepository.findByDiaRegistro(registro);
    }

    @Transactional(readOnly = true)
    public List<Transacao> findaByDiaAtualizar(LocalDate atualizar){
        return transacaoRepository.findByDiaAtualizar(atualizar);
    }

    @Transactional(readOnly = true)
    public List<Transacao> findByTipoTransacao(TipoTransacao tipo){
        return transacaoRepository.findByTipoTransacao(tipo);
    }

    @Transactional(readOnly = true)
    public List<Transacao> findByDia(LocalDate dia){
        return transacaoRepository.findByDia(dia);
    }

    @Transactional(readOnly = true)
    public List<Transacao> findByValor(BigDecimal valor){
        return transacaoRepository.findByValor(valor);
    }
}
