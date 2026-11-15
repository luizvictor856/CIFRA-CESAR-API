package com.luiz.cifravernamapi.dto;
import jakarta.validation.constraints.NotBlank;


public class VernamRequest {


    @NotBlank(message = "A mensagem não pode estar vazia.")
    private String mensagem;

    @NotBlank(message = "A chave não pode estar vazia.")
    private String chave;


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getChave() {
        return chave;
    }

    public void setChave() {
        this.chave = chave;
    }   
}
