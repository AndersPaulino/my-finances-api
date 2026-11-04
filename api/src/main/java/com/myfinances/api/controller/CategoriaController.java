package com.myfinances.api.controller;

import com.myfinances.api.entity.Categoria;
import com.myfinances.api.service.CategoriaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findByID(@PathVariable Long id){
        return categoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/nome/{nomeCategoria}")
    public ResponseEntity<Categoria> findByNomeCategoria(@PathVariable String nomeCategoria){
        try {
            Categoria categoria = categoriaService.findByNomeCategoria(nomeCategoria);

            if (categoria != null){
                return ResponseEntity.ok(categoria);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
