package com.luiz.cifravernamapi.dto;

import jakarta.validation.constraints.NotBlank;

public class DecifrarForcaBrutaRequest {

    @NotBlank(message = "O texto cifrado não pode estar vazio.")
    private String textoCifrado;

    public String getTextoCifrado() {
        return textoCifrado;
    }

    public void setTextoCifrado(String textoCifrado) {
        this.textoCifrado = textoCifrado;
    }
}