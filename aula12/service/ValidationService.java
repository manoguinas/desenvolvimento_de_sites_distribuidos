package com.validacao.validar.service;

import com.validacao.validar.exception.InvalidCPFException;
import com.validacao.validar.exception.InvalidCNPJException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public String validateCPF(String cpf) {
        // Remove todos os caracteres não numéricos
        String cleanedCPF = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (!cleanedCPF.matches("\\d{11}")) {
            throw new InvalidCPFException("CPF inválido: deve conter 11 dígitos numéricos.");
        }

        return "CPF válido";
    }

    public String validateCNPJ(String cnpj) {
        // Remove todos os caracteres não numéricos
        String cleanedCNPJ = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ tem exatamente 14 dígitos
        if (!cleanedCNPJ.matches("\\d{14}")) {
            throw new InvalidCNPJException("CNPJ inválido: deve conter 14 dígitos numéricos.");
        }

        return "CNPJ válido";
    }
}