package com.example.luxeliteteste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Integer> {
    
    Optional<Pacote> findById(Integer id);
}