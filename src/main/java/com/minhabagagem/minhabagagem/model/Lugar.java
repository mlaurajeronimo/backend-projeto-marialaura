package com.minhabagagem.minhabagagem.model;

public class Lugar {
    private Long id;
    private String nomeCidade;
    private String pais;
    private String descricao;


    public Lugar() {}

    public Lugar(Long id, String nome, String pais, String descricao, String imagemUrl) {
        this.id = id;
        this.nomeCidade = nome;
        this.pais = pais;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nomeCidade;
    }

    public void setNome(String nome) {
        this.nomeCidade = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
