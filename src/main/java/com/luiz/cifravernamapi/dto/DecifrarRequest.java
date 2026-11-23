package com.luiz.cifravernamapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DecifrarRequest {

    @NotBlank(message = "O texto cifrado não pode estar vazio.")
    private String textoCifrado;

    @NotNull(message = "O deslocamento deve ser informado.")
    private Integer deslocamento;

    public String getTextoCifrado() {
        return textoCifrado;
    }

    public void setTextoCifrado(String textoCifrado) {
        this.textoCifrado = textoCifrado;
    }

    public Integer getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Integer deslocamento) {
        this.deslocamento = deslocamento;
    }
}