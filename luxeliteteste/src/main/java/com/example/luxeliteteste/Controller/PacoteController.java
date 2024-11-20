package com.example.luxeliteteste.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.luxeliteteste.Model.Pacote;
import com.example.luxeliteteste.Repository.PacoteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PacoteController {
    @Autowired
    PacoteRepository bd;

    @GetMapping("/api/pacote/{id}")
    public Pacote carregar(@PathVariable int id) {
        Optional<Pacote> obj = bd.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }
}
