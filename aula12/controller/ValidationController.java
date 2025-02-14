package com.validacao.validar.controller;

import com.validacao.validar.service.ValidationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validar")
public class ValidationController {

    private final ValidationService validationService;

    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @GetMapping("/CPF/{cpf}")
    public String validateCPF(@PathVariable String cpf) {
        return validationService.validateCPF(cpf);
    }

    @GetMapping("/CNPJ/{cnpj}")
    public String validateCNPJ(@PathVariable String cnpj) {
        return validationService.validateCNPJ(cnpj);
    }
}