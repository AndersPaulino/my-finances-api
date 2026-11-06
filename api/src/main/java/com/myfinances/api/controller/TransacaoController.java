package com.myfinances.api.controller;

import com.myfinances.api.entity.Transacao;
import com.myfinances.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {
    private TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> findById(@PathVariable Long id) {
        return transacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> findAll(){
        List<Transacao> transacaos = transacaoService.findAll();
        return ResponseEntity.ok(transacaos);
    }
}
