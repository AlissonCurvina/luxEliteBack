package com.example.luxeliteteste;

import jakarta.persistence.Embeddable;

@Embeddable
public class CestaItem {
    private Long id;
    private String nome;
    private Double preco;
    private int quantidade;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreço() {
        return preco;
    }
    public void setPreço(Double preço) {
        this.preco = preço;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
