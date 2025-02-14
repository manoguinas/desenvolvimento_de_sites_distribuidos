package com.pronomes.api_pronomes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PronounsController {

    @GetMapping("/saudacao")
    public String saudacao(
            @RequestParam(value = "tratamento", required = false, defaultValue = "Sr.") String tratamento,
            @RequestParam(value = "nome", required = false, defaultValue = "Usuário") String nome,
            @RequestParam(value = "sobrenome", required = false, defaultValue = "Desconhecido") String sobrenome
    ) {
        return String.format("(%s; %s, %s)", tratamento, sobrenome, nome);
    }
}
