package br.com.model;


public class Client {

    // Construtor //
    public Client(String cpf, String nome, String rg, String sexo, String telefone, String celular, String email, String cep, String uf, String endereco, String bairro, String complemento, Integer status) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.cep = cep;
        this.uf = uf;
        this.endereco = endereco;
        this.bairro = bairro;
        this.complemento = complemento;
        this.status = status;
    }   

    // Getters e Setters //
    // Setters //
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public void setUf(String uf) {
        this.uf = uf;
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
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    // Getters //
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
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

    public String getUf() {
        return uf;
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
    
    public Integer getStatus() {
        return status;
    }
        
    // Declaração dos atributos //
    private String cpf;
    private String nome;    
    private String rg;
    private String sexo;    
    private String telefone;
    private String celular;
    private String email;
    private String cep;
    private String uf;
    private String endereco;
    private String bairro;
    private String complemento;
    private Integer status;
}
