package com.example.luxeliteteste;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClienteController {
    @Autowired
    ClienteRepository bd;

    @PostMapping("/api/cliente") //completo
    public ResponseEntity<Map<String, Object>> gravar(@RequestBody Cliente obj) {
    bd.save(obj); 
    Map<String, Object> response = new HashMap<>();
    response.put("message", "O cliente " + obj.getNome() + " foi salvo corretamente!");
    response.put("cliente", obj);
    return ResponseEntity.ok(response); 
    }


    @PutMapping("/api/cliente/{cpf}") //completo
    public ResponseEntity<String> alterar(@PathVariable String cpf, @RequestBody Cliente obj) {
    Optional<Cliente> clienteExistente = bd.findByCpf(cpf);

    if (!clienteExistente.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
    }

    Cliente clienteAtualizado = clienteExistente.get();
    clienteAtualizado.setNome(obj.getNome());
    clienteAtualizado.setSobrenome(obj.getSobrenome());
    clienteAtualizado.setTelefone(obj.getTelefone());
    clienteAtualizado.setEmail(obj.getEmail());
    clienteAtualizado.setCep(obj.getCep());
    clienteAtualizado.setRua(obj.getRua());
    clienteAtualizado.setCidade(obj.getCidade());
    clienteAtualizado.setEstado(obj.getEstado());
    clienteAtualizado.setComplemento(obj.getComplemento());

    bd.save(clienteAtualizado);

    return ResponseEntity.ok("Cliente atualizado com sucesso!");
}

    
    @GetMapping("/api/cliente/{cpf}") //completo
    public Cliente carregar(@PathVariable String cpf) {
    Optional<Cliente> obj = bd.findByCpf(cpf);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;  
        }
    }

    @DeleteMapping("/api/cliente/{cpf}") //completo
    public ResponseEntity<Map<String, String>> remover(@PathVariable String cpf) {
    Optional<Cliente> cliente = bd.findByCpf(cpf);
    Map<String, String> response = new HashMap<>();

        if (cliente.isPresent()) {
            bd.delete(cliente.get());
            response.put("message", "Cliente com CPF " + cpf + " removido com sucesso!");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Cliente com CPF " + cpf + " não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @GetMapping("/api/clientes")
    public List<Cliente> listar(){
        return bd.findAll();
    }

    @PostMapping("/api/cliente/login")
    public Cliente fazerLogin(@RequestBody Cliente obj){
        Optional<Cliente> retorno = 
            bd.login(obj.getEmail(), obj.getSenha());
        if(retorno.isPresent()){
            return retorno.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/cliente/recupera")
    public Cliente recuperarSenha(@RequestBody Cliente obj){
        Optional<Cliente> retorno = 
            bd.recuperaSenha(obj.getEmail());
        if(retorno.isPresent()){
            return retorno.get();
        } else {
            return null;
        }
    }

}
