package com.example.luxeliteteste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
    Optional<Produto> findById(int id);

    void deleteById(int id);

    @Query("SELECT p FROM Produto p JOIN FETCH p.pacotes WHERE p.id = :id")
    Optional<Produto> findByIdWithPacotes(@Param("id") int id);

    @Query("SELECT p FROM Produto p LEFT JOIN FETCH p.photo WHERE p.id = :id")
    Optional<Produto> findByIdWithPhoto(@Param("id") int id);
}