package br.com.model;

import java.math.BigInteger;


public class Employee extends Data{
    
    // Construtor //
    public Employee(Long cpf, String foto,  String nome, Integer rg, String datanascimento, String sexo, String telefone, String celular, String email, String cep, String endereco, String bairro, String complemento, String uf, Integer nivel, Integer status, String cargo, Double salario, String dataadmissao, String datademissao, String senha) {
        super(cpf, nome, rg, datanascimento, sexo, telefone, celular, email, cep, endereco, bairro, complemento, uf, status);
        this.foto = foto;
        this.nivel = nivel;
        this.cargo = cargo;
        this.salario = salario;
        this.dataadmissao = dataadmissao;
        this.datademissao = datademissao;
        this.senha = senha;
    }

    public Employee(Long cpf, byte[] foto, String nome, Integer rg, String datanascimento, String sexo, String telefone, String celular, String email, String cep, String endereco, String bairro, String complemento, String uf, Integer nivel, Integer status, String senha) {
        super(cpf, nome, rg, datanascimento, sexo, telefone, celular, email, cep, endereco, bairro, complemento, uf, status);
        this.nivel = nivel;
        this.senha = senha;
        
    }
    
    

    // Getters e Setters //
    // Setters //
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setDataadmissao(String dataadmissao) {
        this.dataadmissao = dataadmissao;
    }

    public void setDatademissao(String datademissao) {
        this.datademissao = datademissao;
    }
    
    // Getters //
    public String getFoto() {
        return foto;
    }
    
    public String getSenha() {
        return senha;
    }

    public Integer getNivel() {
        return nivel;
    }

    public String getCargo() {
        return cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public String getDataadmissao() {
        return dataadmissao;
    }

    public String getDatademissao() {
        return datademissao;
    }
    
    // Declaração dos atributos //
    private String foto; 
    private String senha;
    private Integer nivel;
    
    private String cargo;
    private Double salario;
    private String dataadmissao;
    private String datademissao;
}
