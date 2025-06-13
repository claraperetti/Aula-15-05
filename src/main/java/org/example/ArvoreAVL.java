package org.example;

public class ArvoreAVL {
    No noRaiz;


    public int altura(No node) {
        if (node == null)
            return 0;
        return node.altura;
    }

    public int fatorBalanceamento(No node) {
        if (node == null)
            return 0;
        return altura(node.esquerda) - altura(node.direita);
    }

    public void verificarBalanceamento(No node) {
        if (node != null) {
            verificarBalanceamento(node.esquerda);
            verificarBalanceamento(node.direita);

            int fator = fatorBalanceamento(node);
            System.out.println("Nó " + node.chave + " tem fator de balanceamento: " + fator);
        }
    }

    public int calcularAltura(No node) {
        if (node == null) return 0;

        int alturaEsquerda = calcularAltura(node.esquerda);
        int alturaDireita = calcularAltura(node.direita);

        node.altura = 1 + Math.max(alturaEsquerda, alturaDireita);
        return node.altura;
    }

    public No rotacaoDireita(No node) {
        No x = node.esquerda;
        No t2 = x.direita;

        x.direita = node;
        node.esquerda = t2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        node.altura = Math.max(altura(node.esquerda), altura(node.direita)) + 1;

        return node;
    }

    public No rotacaoEsquerda(No node) {
        No y = node.direita;
        No t2 = y.esquerda;

        y.esquerda = node;
        node.direita = t2;

        node.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        y.altura = Math.max(altura(node.esquerda), altura(node.direita)) + 1;

        return node;
    }

    public No inserir(No node, int chave) {
        if (node == null)
            return new No(chave);

        if (chave < node.chave)
            node.esquerda = inserir(node.esquerda, chave);
        else if (chave > node.chave)
            node.direita = inserir(node.direita, chave);
        else
            return node;

        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        int balanceamento = fatorBalanceamento(node);

        if (balanceamento > 1 && chave < node.esquerda.chave)
            return rotacaoDireita(node);

        if (balanceamento < -1 && chave > node.direita.chave)
            return rotacaoEsquerda(node);

        if (balanceamento > 1 && chave > node.esquerda.chave) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }

        if (balanceamento < -1 && chave < node.direita.chave) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    public No remover(No node, int chave) {
        if (node == null)
            return null;

        if (chave < node.chave) {
            node.esquerda = remover(node.esquerda, chave);

        } else if (chave > node.chave) {
            node.direita = remover(node.direita, chave);

        } else {
            if (node.esquerda == null || node.direita == null) {
                No temp = (node.esquerda != null) ? node.esquerda : node.direita;

                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                No temp = menorNo(node.direita);
                node.chave = temp.chave;
                node.direita = remover(node.direita, temp.chave);
            }
        }

        if (node == null)
            return null;

        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        int balanceamento = fatorBalanceamento(node);

        if (balanceamento > 1 && fatorBalanceamento(node.esquerda) >= 0);

        return node;
    }

    public No menorNo(No node) {
        No atual = node;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }
}