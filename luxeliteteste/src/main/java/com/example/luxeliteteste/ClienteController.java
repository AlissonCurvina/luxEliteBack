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

@CrossOrigin(origins = "*") 
@RestController
public class ClienteController {
    @Autowired
    ClienteRepository bd;

    @PostMapping("/api/cliente") //completo
    public ResponseEntity<Map<String, Object>> gravar(@RequestBody Cliente obj) {
    bd.save(obj); //salva o cliente no banco de dados
    Map<String, Object> response = new HashMap<>();
    response.put("message", "O cliente " + obj.getNome() + " foi salvo corretamente!");
    response.put("cliente", obj);  //retorna também os dados do cliente salvo
    return ResponseEntity.ok(response);  //retorna a resposta com status 200 OK
    }


    @PutMapping("/api/cliente")  //incompleto, deu erro de cors
    public ResponseEntity<String> alterar(@RequestBody Cliente obj){
        Optional<Cliente> clienteExistente = bd.findByCpf(obj.getCpf());  // Procurando o cliente pelo CPF
    
        if (!clienteExistente.isPresent()) {
            // Se o cliente não for encontrado, retornamos erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
    
        // Atualizando os campos do cliente com os dados recebidos
        Cliente clienteAtualizado = clienteExistente.get();
        clienteAtualizado.setNome(obj.getNome());
        clienteAtualizado.setSobrenome(obj.getSobrenome());
        clienteAtualizado.setCpf(obj.getCpf());  // Em geral, o CPF não é alterado, mas se for o caso
        clienteAtualizado.setTelefone(obj.getTelefone());
        clienteAtualizado.setEmail(obj.getEmail());
        clienteAtualizado.setSenha(obj.getSenha());
        clienteAtualizado.setCep(obj.getCep());
        clienteAtualizado.setRua(obj.getRua());
        clienteAtualizado.setCidade(obj.getCidade());
        clienteAtualizado.setEstado(obj.getEstado());
        clienteAtualizado.setComplemento(obj.getComplemento());
        
        // Salvando as alterações no banco de dados
        bd.save(clienteAtualizado);
    
        // Retornando uma resposta de sucesso
        return ResponseEntity.ok("O cliente " + clienteAtualizado.getNome() + " foi alterado corretamente!");
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

    @DeleteMapping("/api/cliente/{codigo}")
    public String remover(@PathVariable int codigo){
        bd.deleteById(codigo);
        return "Registro "+ codigo + " removido com suceso!";
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
