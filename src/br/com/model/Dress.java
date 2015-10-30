package br.com.model;

public class Dress {

    public Dress(){}
    
    public Dress(String vestido, String cor, String tamanho, String modelo, Integer quantidade, String valor) {
        this.vestido = vestido;
        this.cor = cor;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valor = valor;
    }    

    // Setters e Getters //
    // Setters //
    public void setVestido(String vestido) {
        this.vestido = vestido;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }

    // Getters //
    public String getVestido() {
        return vestido;
    }

    public String getCor() {
        return cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    
    public String getValor() {
        return valor;
    }
    
    private String vestido;
    private String cor;
    private String tamanho;
    private String modelo;
    private Integer quantidade;
    private String valor;
    
}
