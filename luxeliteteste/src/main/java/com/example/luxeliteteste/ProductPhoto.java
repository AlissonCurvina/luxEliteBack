package com.example.luxeliteteste;

import jakarta.persistence.*;

@Entity
public class ProductPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_photo_id")
    private Integer id;

    @Column(name = "product_photo_url")
    private String productPhotoUrl;

    @OneToOne
    @JoinColumn(name = "product_photo_product_id")  // Relacionamento com produto
    private Produto produto;  // Relacionamento com o produto

    // Getters e Setters
    public String getProductPhotoUrl() {
        return this.productPhotoUrl;
    }

    public void setProductPhotoUrl(String productPhotoUrl) {
        this.productPhotoUrl = productPhotoUrl;
    }
}

