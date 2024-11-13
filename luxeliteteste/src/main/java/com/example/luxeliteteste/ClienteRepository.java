package com.example.luxeliteteste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends
JpaRepository<Cliente,Integer> {
    
    @Query(value = "select * from cliente where email=?1 and senha=?2", nativeQuery = true)
    Optional<Cliente> login(String email, String senha);

    @Query(value = "select * from cliente where email=?1", nativeQuery = true)
    Optional<Cliente> recuperaSenha(String email);

    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByNome(String nome);

    @Query("SELECT c FROM Cliente c WHERE c.email = :email AND c.senha = :senha")
    Optional<Cliente> findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);



}
