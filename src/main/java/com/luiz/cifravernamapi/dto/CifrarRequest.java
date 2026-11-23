package com.luiz.cifravernamapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CifrarRequest {

    @NotBlank(message = "O texto claro não pode estar vazio.")
    private String textoClaro;

    @NotNull(message = "O deslocamento deve ser informado.")
    private Integer deslocamento;

    public String getTextoClaro() {
        return textoClaro;
    }

    public void setTextoClaro(String textoClaro) {
        this.textoClaro = textoClaro;
    }

    public Integer getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Integer deslocamento) {
        this.deslocamento = deslocamento;
    }
}