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

    public No rotacaoDireita(No node){
        No x = node.esquerda;
        No t2 = x.direita;

        x.direita = node;
        node.esquerda = t2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        node.altura = Math.max(altura(node.esquerda), altura(node.direita)) + 1;

        return node;
    }

    public No rotacaoEsquerda(No node){
        No y = node.direita;
        No t2 = y.esquerda;

        y.esquerda =  node;
        node.direita =  t2;

        node.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(node.esquerda), altura(node.direita)) + 1;

    }

    public No inserir(No node, int chave){

        if (node == null)
            return new No(chave);

        if (chave < node.chave)
            node.esquerda =  inserir((node.esquerda, chave);
        else if (chave > node.chave)
            node.direita = inserir(node.direita, chave);
        else
            return node;

        node.altura = 1 + Math.max(altura(node.esquerda), calcularAltura(node.direita));

        int balanceamento = fatorBalanceamento(node);

        if balanceamento > 1 && chave < node.esquerda.chave)
            return rotacaoDireita(node);
    }
}
