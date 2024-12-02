package com.example.luxeliteteste.Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Cesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroPedido; 
    private Double valorTotal;
    private Integer clientId;

    @ElementCollection
    @CollectionTable(name = "itens_cesta", joinColumns = @JoinColumn(name = "cesta_id"))
    private List<CestaItem> itens; 

    public Cesta() {
        this.numeroPedido = UUID.randomUUID().toString();
    }

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

    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
