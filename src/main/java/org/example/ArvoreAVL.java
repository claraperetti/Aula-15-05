package org.example;

public class ArvoreAVL {
    No noRaiz;

    public void verificarBalenceamento(No node) {
        if (node != null){
            verificarBalenceamento(node.direita);
            verificarBalenceamento(node.esquerda);

            // não finalizado
        }
    }

    public int calcularAltura(No node) {
        if (node == null) return 0;

        int alturaEsquerda = calcularAltura(node.esquerda);
        int alturaDireita = calcularAltura(node.direita);

        node.altura = 1 + Math.max(alturaEsquerda, alturaDireita);
        return node.altura;
    }
}
