package br.com.model;

import java.math.BigInteger;

public class Data {
    // Construtor //
    public Data(Long cpf, String nome, Integer rg, String datanascimento, String sexo, String telefone, String celular, String email, String cep, String endereco, String bairro, String complemento, String uf, Integer status) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.complemento = complemento;
        this.uf = uf;
        this.status = status;
    }

    // Setters e Getters //
    // Setters //
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    
    // Getters // 
    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getRg() {
        return rg;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getUf() {
        return uf;
    }

    public Integer getStatus() {
        return status;
    }

    
    // Declaração dos atributos //
    private Long cpf;
    private String nome;    
    private Integer rg;
    private String datanascimento; 
    private String sexo; 
    
    private String telefone;
    private String celular;
    private String email;
    
    private String cep;
    private String endereco;
    private String bairro;
    private String complemento;
    private String uf;
    private Integer status;
    
}
