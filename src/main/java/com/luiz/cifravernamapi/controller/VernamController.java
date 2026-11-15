package com.luiz.cifravernamapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.cifravernamapi.dto.VernamRequest;
import com.luiz.cifravernamapi.dto.VernamResponse;
import com.luiz.cifravernamapi.service.VernamService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vernam")
public class VernamController {

    private final VernamService vernamService;

    public VernamController(VernamService vernamService) {
        this.vernamService = vernamService;
    }


@PostMapping("/criptografar")
public VernamResponse criptografar(@Valid @RequestBody VernamRequest request) {

    String resultado = vernamService.criptografar(
        request.getMensagem(),
        request.getChave()
    );

    VernamResponse response = new VernamResponse();
    response.setResultado(resultado);

    return response;
}


@PostMapping ("/descriptografar")

public VernamResponse descroptografar(@Valid @RequestBody VernamRequest request) {

    String resultado = vernamService.descriptografar (
        request.getMensagem(),
        request.getChave()
    );

    VernamResponse response = new VernamResponse();
    response.setResultado(resultado);

    return response;
}

}