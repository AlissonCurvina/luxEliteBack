package com.example.luxeliteteste;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Integer id;

    @JsonProperty("nome")
    @Column(name = "package_name")
    private String nome;

    @JsonProperty("descricao")
    @Column(name = "package_description")
    private String descricao;

    @JsonProperty("preco")
    @Column(name = "package_price")
    private Double preco;

    @ManyToMany(mappedBy = "pacotes")
    private List<Produto> produtos;

    public Pacote() {}
    public Pacote(
        Integer id, String nome, String descricao, Double preco
    ) {

    }

    public void setId(Integer valor) {
        this.id = valor;
    }

    public Integer getId() {
        return this.id;
    }

    public void setNome(String valor) {
        this.nome = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDescricao(String valor) {
        this.descricao = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setPreco(Double valor) {
        this.preco = valor;
    }

    public Double getPreco() {
        return this.preco;
    }
    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }
}
