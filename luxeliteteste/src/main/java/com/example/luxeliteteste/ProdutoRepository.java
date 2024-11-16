package com.example.luxeliteteste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
    Optional<Produto> findById(int id);

    void deleteById(int id);
}