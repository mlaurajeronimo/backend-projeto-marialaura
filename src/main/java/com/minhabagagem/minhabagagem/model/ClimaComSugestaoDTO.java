package com.minhabagagem.minhabagagem.model;

import java.util.List;

public class ClimaComSugestaoDTO {
    private String cidade;
    private double temperatura;
    private String descricao;
    private List<String> sugestoes;

    public ClimaComSugestaoDTO(String cidade, double temperatura, String descricao, String icone, List<String> sugestoes) {
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.descricao = descricao;
        this.sugestoes = sugestoes;
    }

    // Getters e Setters
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<String> getSugestoes() { return sugestoes; }
    public void setSugestoes(List<String> sugestoes) { this.sugestoes = sugestoes; }
}
