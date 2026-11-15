package com.luiz.cifravernamapi.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.stereotype.Service;

@Service 
public class VernamService {
    public String criptografar(String mensagem, String chave) {

        byte[] mensagemBytes = mensagem.getBytes(StandardCharsets.UTF_8);

        byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);

        
        if (mensagemBytes.length != chaveBytes.length) {
            throw new IllegalArgumentException(
                "A chave deve possuir o mesmo tamanho da mensagem em bytes"
            );

        }

        byte[] resultado = new byte[mensagemBytes.length];

        for (int i = 0; i < mensagemBytes.length; i++ ) {
            resultado [i] = (byte) (mensagemBytes[i] ^ chaveBytes[i]);
        }

        return Base64.getEncoder().encodeToString(resultado);

    }



    
    public String descriptografar(String mensagemCriptografada, String chave) {

        byte[] mensagemBytes = Base64.getDecoder().decode(mensagemCriptografada);

        byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);

         if (mensagemBytes.length != chaveBytes.length) {
            throw new IllegalArgumentException(
                "A chave deve possuir o mesmo tamanho da mensagem criptografada em bytes."
             );
    }

         byte[] resultado = new byte[mensagemBytes.length];

         for (int i = 0; i < mensagemBytes.length; i++) {
             resultado[i] = (byte) (mensagemBytes[i] ^ chaveBytes[i]);
        }

        return new String(resultado, StandardCharsets.UTF_8);
}

}
