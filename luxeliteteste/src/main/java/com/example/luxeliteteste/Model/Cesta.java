package com.example.luxeliteteste.Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Cesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroPedido; // traduzido de "requestNumber"
    private Double valorTotal;   // traduzido de "totalAmount"

    @ElementCollection
    @CollectionTable(name = "itens_cesta", joinColumns = @JoinColumn(name = "cesta_id"))
    private List<CestaItem> itens; // traduzido de "items"

    public Cesta() {
        this.numeroPedido = UUID.randomUUID().toString();
    }

    // Getters e Setters
    public Long getId() { 
        return id; 
    }
    public String getNumeroPedido() { 
        return numeroPedido; 
    }
    public void setNumeroPedido(String numeroPedido) { 
        this.numeroPedido = numeroPedido; 
    }
    public Double getValorTotal() { 
        return valorTotal; 
    }
    public void setValorTotal(Double valorTotal) { 
        this.valorTotal = valorTotal; 
    }
    public List<CestaItem> getItens() { 
        return itens; 
    }
    public void setItens(List<CestaItem> itens) { 
        this.itens = itens; 
    }
}
