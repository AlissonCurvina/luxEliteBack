package com.example.luxeliteteste;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepository bd;

    @GetMapping("/api/produto/{id}")
    public Produto carregar(@PathVariable int id) {
        Optional<Produto> obj = bd.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/api/produto/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id) {
        Optional<Produto> obj = bd.findById(id);
        if(obj.isPresent()) {
            bd.deleteById(id);
            return ResponseEntity.ok("Produto deletado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
    }


}
