package com.example.luxeliteteste.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int codigo;
    
    @JsonProperty("name")
    public String nome;
    
    @JsonProperty("lastname")
    public String sobrenome;
    
    @JsonProperty("cpf")
    public String cpf;
    
    @JsonProperty("cellphone")
    public String telefone;
    
    @JsonProperty("email")
    public String email;
    
    @JsonProperty("password")
    public String senha;
    
    @JsonProperty("password2")
    public String senha2;
    
    @JsonProperty("cep")
    public String cep;
    
    @JsonProperty("street_name")
    public String rua;
    
    @JsonProperty("city")
    public String cidade;
    
    @JsonProperty("state")
    public String estado;
    
    @JsonProperty("additional_info")
    public String complemento;
    
    public Cliente(){}
    public Cliente(int codigo, String nome, String sobrenome, String cpf, String senha2, String email, String senha, String telefone, String rua,
            String cidade, String cep, String estado, String complemento) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.senha2 = senha2;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha2() {
        return senha2;
    }
    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    

    
}
