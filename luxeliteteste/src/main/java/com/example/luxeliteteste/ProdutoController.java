package com.example.luxeliteteste;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepository bd;

    @GetMapping("api/produtos/")
    public List<Produto> listarTodos() {
        return bd.findAll();
    }

    @GetMapping("/api/produto/{id}")
    public ResponseEntity<Produto> carregar(@PathVariable int id) {
        Optional<Produto> obj = bd.findById(id);
        if (obj.isPresent()) {
            Produto produto = obj.get();
            // Foto foi removida, então esta parte foi eliminada
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/api/produto/{id}/pacote-ids")
    public ResponseEntity<List<Integer>> listarPacoteIdsPorProduto(@PathVariable int id) {
        List<Integer> pacoteIds = bd.findPacoteIdsByProdutoId(id);
        if (pacoteIds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(pacoteIds);
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
