package com.example.luxeliteteste;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    private Long id;

    @JsonProperty("nome")
    @Column(name = "product_name")
    private String nome;

    @JsonProperty("categoria")
    @Column(name = "product_category")
    private String categoria;

    @JsonProperty("descricao")
    @Column(name = "product_description")
    private String descricao;

    @JsonProperty("marca")
    @Column(name = "product_brand")
    private String marca;

    @JsonProperty("preco")
    @Column(name = "product_price")
    private Double preco;

    public Produto() {}
    public Produto(
        int id, String nome, String categoria, String descricao, String marca, Double preco
    ) {
        this.setNome(nome);
        this.setCategoria(categoria);
        this.setCategoria(marca);
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String valor) {
        this.nome = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCategoria(String valor) {
        this.categoria = valor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setDescricao(String valor) {
        this.descricao = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setMarca(String valor) {
        this.marca = valor;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setPreco(Double valor) {
        this.preco = valor;
    }

    public Double getPreco() {
        return this.preco;
    }
}
