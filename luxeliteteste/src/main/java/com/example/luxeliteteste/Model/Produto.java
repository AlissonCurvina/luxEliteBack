package com.example.luxeliteteste.Model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

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

    @ManyToMany
    @JoinTable(
        name = "pacote_produto",
        joinColumns = @JoinColumn(name = "package_product_product_id"), // Coluna que referencia a tabela Produto
        inverseJoinColumns = @JoinColumn(name = "package_product_package_id") // Coluna que referencia a tabela Pacote
    )
    private List<Pacote> pacotes;

    @OneToOne(mappedBy = "produto", fetch = FetchType.EAGER)
    private ProdutoFoto produtoFoto;

    public Produto() {}

    public Produto(
        Integer id, String nome, String categoria, String descricao, String marca, Double preco
    ) {
        this.setNome(nome);
        this.setCategoria(categoria);
        this.setMarca(marca);
        this.setDescricao(descricao);
        this.setPreco(preco);
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

    @JsonProperty("listaPacotes")
    public List<String> getPacotesNomes() {
        if (pacotes != null) {
            return pacotes.stream().map(Pacote::getNome).toList();
        }

        return List.of();
    }

    @JsonProperty("foto_url")
    public String getFotoUrl() {
        if (produtoFoto != null) {
            return produtoFoto.getFotoUrl();
        }
        else {
            return null;
        }
    }
}
