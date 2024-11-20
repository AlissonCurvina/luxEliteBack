package com.example.luxeliteteste.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.luxeliteteste.Model.Pacote;
import com.example.luxeliteteste.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
    Optional<Produto> findById(int id);

    void deleteById(int id);

    @Query("SELECT p FROM Produto p JOIN FETCH p.pacotes WHERE p.id = :id")
    Optional<Produto> findByIdWithPacotes(@Param("id") int id);

    @Query("SELECT p.id FROM Pacote p JOIN p.produtos prod WHERE prod.id = :id")
    List<Integer> findPacoteIdsByProdutoId(@Param("id") int produtoId);

    @Query("SELECT p FROM Pacote p JOIN p.produtos prod WHERE prod.id = :id")
    List<Pacote> findPacotesByProdutoId(@Param("id") int id);

    // Removido método relacionado à foto
}
