package com.calculadora.api_calculadora.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CalculadoraService {

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida.");
        }
        return a / b;
    }

    public double raiz(double a) {
        if (a < 0) {
            throw new ArithmeticException("Não é possível calcular raiz de número negativo.");
        }
        return Math.sqrt(a);
    }

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double inverso(double a) {
        if (a == 0) {
            throw new ArithmeticException("Não é possível calcular o inverso de zero.");
        }
        return 1 / a;
    }

    public double modulo(double a) {
        return Math.abs(a);
    }

    public long fatorial(int a) {
        if (a < 0) {
            throw new ArithmeticException("Fatorial de número negativo não é permitido.");
        }
        long resultado = 1;
        for (int i = 2; i <= a; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public double media(List<Double> valores) {
        if (valores.size() != 5) {
            throw new IllegalArgumentException("A média deve ser calculada para exatamente 5 valores.");
        }
        return valores.stream().mapToDouble(Double::doubleValue).sum() / valores.size();
    }

    public double mediana(List<Double> valores) {
        if (valores.size() != 5) {
            throw new IllegalArgumentException("A mediana deve ser calculada para exatamente 5 valores.");
        }
        Collections.sort(valores);
        return valores.get(2); // O terceiro valor é a mediana para uma lista de 5 números ordenados
    }
}
