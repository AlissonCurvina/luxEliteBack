package com.example.luxeliteteste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/cesta")
@CrossOrigin(origins = "http://localhost:4200")
public class CestaController {

    @Autowired
    private CestaRepository cestaRepository;

    @PostMapping("/finalizar-compra")
    public Cesta finalizarCompra(@RequestBody Cesta cesta) {
        cesta.setNumeroPedido(UUID.randomUUID().toString());
        return cestaRepository.save(cesta);
    }
}
