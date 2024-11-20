package com.example.luxeliteteste.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.luxeliteteste.Model.Pacote;
import com.example.luxeliteteste.Model.Produto;
import com.example.luxeliteteste.Repository.ProdutoRepository;

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
    public ResponseEntity<Map<String, Object>> obterPrimeiroPacotePorProduto(@PathVariable int id) {
        List<Pacote> pacotes = bd.findPacotesByProdutoId(id);
        if (pacotes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Obtém o primeiro pacote encontrado
        Pacote primeiroPacote = pacotes.get(0);

        // Cria um mapa para enviar as informações desejadas
        Map<String, Object> pacoteInfo = new HashMap<>();
        pacoteInfo.put("id", primeiroPacote.getId());
        pacoteInfo.put("nome", primeiroPacote.getNome());
        pacoteInfo.put("preco", primeiroPacote.getPreco());

        return ResponseEntity.ok(pacoteInfo);
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
