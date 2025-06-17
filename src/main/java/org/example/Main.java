package org.example;

public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();

        int[] chaves = {10, 20, 30, 15, 5, 25};
        for (int chave : chaves){
            arvore.inserir(chave);
        }

        arvore.emOrdem();

        arvore.deletar(15);
        arvore.deletar(10);

        arvore.emOrdem();
    }

}