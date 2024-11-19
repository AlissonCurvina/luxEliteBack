package com.example.luxeliteteste;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProdutoFoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("produto_foto_id")
    @Column(name = "product_photo_id")
    private Integer id;

    @JsonProperty("url_foto")
    @Column(name = "product_photo_url")
    private String fotoUrl;

    @OneToOne
    @JoinColumn(name = "product_photo_product_id")
    private Produto produto;

    // Getter e Setter para url_foto
    public String getFotoUrl() {
        return this.fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    // Getter e Setter para produto
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}