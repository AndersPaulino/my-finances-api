package com.myfinances.api.controller;

import com.myfinances.api.entity.Transacao;
import com.myfinances.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

    @GetMapping("/ativo/{ativo")
    public ResponseEntity<List<Transacao>> findByAtivo(@PathVariable boolean ativo){
        try {
            List<Transacao> transacaos = transacaoService.findByAtivo(ativo);
            if (!transacaos.isEmpty()){
                return ResponseEntity.ok(transacaos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/registro/{registro}")
    public ResponseEntity<List<Transacao>> findByDiaRegistro(@PathVariable LocalDate registro){
        try {
            List<Transacao> transacaos = transacaoService.findByDiaRegistro(registro);
            if (!transacaos.isEmpty()){
                return ResponseEntity.ok(transacaos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
