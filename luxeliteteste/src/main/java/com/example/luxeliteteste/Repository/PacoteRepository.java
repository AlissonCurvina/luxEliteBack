package com.example.luxeliteteste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.luxeliteteste.Model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Integer> {
    
    Optional<Pacote> findById(Integer id);
}