package com.myfinances.api.controller;

import com.myfinances.api.entity.TipoTransacao;
import com.myfinances.api.entity.Transacao;
import com.myfinances.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/atualizar/{atualizar}")
    public ResponseEntity<List<Transacao>> findByDiaAtualizar(@PathVariable LocalDate atualizar){
        try {
            List<Transacao> transacaos = transacaoService.findaByDiaAtualizar(atualizar);
            if (!transacaos.isEmpty()){
                return ResponseEntity.ok(transacaos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Transacao>> findByTipoTransacao(@PathVariable TipoTransacao tipo){
       try {
           List<Transacao> transacaos = transacaoService.findByTipoTransacao(tipo);
           if (!transacaos.isEmpty()) {
                return ResponseEntity.ok(transacaos);
           } else {
               return ResponseEntity.notFound().build();
           }
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
    @GetMapping("/dia/{dia}")
    public ResponseEntity<List<Transacao>> findByDia(@PathVariable LocalDate dia){
        try {
            List<Transacao> transacaos = transacaoService.findByDia(dia);
            if (!transacaos.isEmpty()){
                return ResponseEntity.ok(transacaos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/valor/{valor}")
    public ResponseEntity<List<Transacao>> findByValor(@PathVariable BigDecimal valor) {
        try {
            List<Transacao> transacaos = transacaoService.findByValor(valor);
            if (!transacaos.isEmpty()){
                return ResponseEntity.ok(transacaos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrar (@RequestMapping Transacao transacao){
        try {
            transacaoService.cadastrar(transacao);
            return ResponseEntity.ok().body("Registro cadastrado com sucesso!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
