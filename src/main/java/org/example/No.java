package org.example;

public class No {
    public String valor;
    public No esquerda, direita;
    public int altura;

    public No (String valor) {
    this.valor = valor;
    esquerda = direita = null;
    this.altura = 1;
    }


}