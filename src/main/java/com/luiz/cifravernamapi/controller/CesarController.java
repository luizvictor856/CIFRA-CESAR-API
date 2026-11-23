package com.luiz.cifravernamapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luiz.cifravernamapi.dto.CifrarRequest;
import com.luiz.cifravernamapi.dto.CifrarResponse;
import com.luiz.cifravernamapi.dto.DecifrarRequest;
import com.luiz.cifravernamapi.dto.DecifrarResponse;
import com.luiz.cifravernamapi.dto.DecifrarForcaBrutaRequest;
import com.luiz.cifravernamapi.service.CesarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class CesarController {

    private final CesarService cesarService;

    public CesarController(CesarService cesarService) {
        this.cesarService = cesarService;
    }

    @PostMapping("/cifrar")
    public CifrarResponse cifrar(@Valid @RequestBody CifrarRequest request) {

        String resultado = cesarService.cifrar(
                request.getTextoClaro(),
                request.getDeslocamento()
        );

        CifrarResponse response = new CifrarResponse();
        response.setTextoCifrado(resultado);

        return response;
    }

    @PostMapping("/decifrar")
    public DecifrarResponse decifrar(@Valid @RequestBody DecifrarRequest request) {

        String resultado = cesarService.decifrar(
                request.getTextoCifrado(),
                request.getDeslocamento()
        );

        DecifrarResponse response = new DecifrarResponse();
        response.setTextoClaro(resultado);

        return response;
    }

    @PostMapping("/decifrarForcaBruta")
    public DecifrarResponse decifrarForcaBruta(
            @Valid @RequestBody DecifrarForcaBrutaRequest request) {

        String resultado = cesarService.decifrarForcaBruta(
                request.getTextoCifrado()
        );

        DecifrarResponse response = new DecifrarResponse();
        response.setTextoClaro(resultado);

        return response;
    }
}