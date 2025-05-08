package com.minhabagagem.minhabagagem.model;

public class ClimaDTO {
    private String cidade;
    private double temperatura;
    private String descricao;
    private String icone;

    public ClimaDTO(String cidade, double temperatura, String descricao, String icone) {
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.descricao = descricao;
        this.icone = icone;
    }

    // Getters e Setters
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getIcone() { return icone; }
    public void setIcone(String icone) { this.icone = icone; }
}
