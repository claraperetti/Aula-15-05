package org.example;

public class ArvoreRubroNegra {
    private NoArvRubroNegra node;

    public ArvoreRubroNegra() {
    }

    public void inserir(int valor) {
        node = inserir(node, valor);
        node.cores = Cores.black;
    }

    private NoArvRubroNegra inserir(NoArvRubroNegra raiz, NoArvRubroNegra novo) {
        if (raiz == null) return novo;

        if (novo.valor < raiz.valor) {
            raiz.esquerda = inserir(raiz.esquerda, novo);
            raiz.esquerda.pai = raiz;
        } else if (novo.valor > raiz.valor) {
            raiz.direita = inserir(raiz.direita, novo);
            raiz.direita.pai = raiz;
        }
        return raiz;
    }

    private void rodarEsquerda(NoArvRubroNegra x) {
        NoArvRubroNegra y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != NIL) y.esquerda.pai = x;

        y.pai = x.pai;

        if (x.pai == null) node = y;
        else if (x == x.pai.esquerda) x.pai.esquerda = y;
        else x.pai.direita = y;

        y.esquerda = x;
        x.pai = y;
    }

    private void rodarDireita(NoArvRubroNegra x) {
        NoArvRubroNegra y = x.esquerda;
        x.esquerda = y.direita;
        if (y.direita != NIL) y.direita.pai = x;

        y.pai = x.pai;

        if (x.pai == null) node = y;
        else if (x == x.pai.direita) x.pai.direita = y;
        else x.pai.esquerda = y;

        y.direita = x;
        x.pai = y;
    }


    public void inserir(int key) {
        NoArvRubroNegra node = new NoArvRubroNegra(chave);
        node.esquerda = node.direita = node.pai = NIL;

        NoArvRubroNegra y = null;
        NoArvRubroNegra x = node;

        while (x != NIL) {
            y = x;
            if (node.chave < x.chave) x = x.esquerda;
            else x = x.direita;
        }

        node.pai = y;
        if (y == null) node = node;
        else if (node.chave < y.chave) y.esquerda = node;

        node.esquerda = NIL;
        node.direita = NIL;
        node.cores = cores.red;

        insertFix(node);
    }

    private void insertFix(NoArvRubroNegra k) {
        while (k.pai != null && k.pai.cores == Cores.red) {
            if (k.pai == k.pai.pai.esquerda) {
                NoArvRubroNegra u = k.pai.pai.direita;
                if (u.cores == Cores.red) {
                    k.pai.cores = Cores.black;
                    u.cores = Cores.black;
                    k.pai.pai.cores = Cores.red;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.direita) {
                        k = k.pai;
                        rodarEsquerda(k);
                    }
                    k.pai.cores = Cores.black;
                    k.pai.pai.cores = Cores.red;
                    rodarDireita(k.pai.pai);
                }
                k.pai.cores = Cores.black;
                k.pai.pai.cores = Cores.red;
                rodarEsquerda(k.pai.pai);
            }
            if (k == node) break;
        }
        node.cores = Cores.black;
    }

    private NoArvRubroNegra minimum(NoArvRubroNegra node) {
        while (node.esquerda != NIL) node = node.esquerda;
        return node;
    }

    private void transplant(NoArvRubroNegra u, NoArvRubroNegra v) {
        if (u.pai == null) node = v;
        else if (u == u.pai.esquerda) u.pai.esquerda = v;
        else u.pai.direita = v;
        v.pai = u.pai;
    }


    public void deletar(int chave) {
        NoArvRubroNegra z = buscarArvore(node, chave);
        if (z == NIL) return;

        NoArvRubroNegra y = z;
        Cores yOriginalColor = y.cores;
        NoArvRubroNegra x;

        if (z.esquerda == NIL) {
            x = z.direita;
            transplant(z, z.direita);
        } else if (z.direita == NIL) {
            x = z.esquerda;
            transplant(z, z.esquerda);
        } else {
            y = minimum(z.direita);
            yOriginalColor = y.cores;
            x = y.direita;
            if (y.pai == z) x.pai = y;
            else {
                transplant(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }
            transplant(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cores = z.cores;
        }

        if (yOriginalColor == Cores.black) deleteFix(x)
    }

    private void deleteFix(NoArvRubroNegra x) {
        NoArvRubroNegra w;
        while (x != node && x.cores == Cores.black) {
            if (x == x.pai.esquerda) {
                w = x.pai.direita;
                if (w.cores == Cores.red) {
                    w.cores = Cores.black;
                    x.pai.cores = Cores.red;
                    rodarEsquerda(x.pai);
                    w = x.pai.direita
                }

                if (w.esquerda.cores == Cores.black && w.direita.cores == Cores.black) {
                    w.cores == Cores.red;
                    x = x.pai;
                } else {
                    if (w.direita.cores == Cores.black) {
                        w.esquerda.cores == Cores.black;
                        w.cores = Cores.red;
                        rodarDireita(w);
                        w = x.pai.direita;
                    }
                    w.cores = x.pai.cores;
                    x.pai.cores = Cores.black;
                    w.direita.cores = Cores.black;
                    rodarEsquerda(x.pai);
                    x = node;
                }
            } else {
                w = x.pai.esquerda;
                if (w.cores == Cores.red) {
                    w.cores = Cores.black;
                    x.pai.cores = Cores.red;
                    rodarDireita(x.pai);
                    w = x.pai.esquerda;
                }
                if (w.direita.cores == Cores.black && w.esquerda.cores == Cores.black) {
                    w.cores == Cores.red;
                    x = x.pai;
                } else {
                    if (w.direita.cores == Cores.black) {
                        w.esquerda.cores = Cores.black;
                        w.cores = Cores.red;
                        rodarDireita(w);
                        w = x.pai.direita;
                    }
                    w.cores = x.pai.cores;
                    x.pai.cores = Cores.black;
                    w.direita.cores = Cores.black;
                    rodarEsquerda(x.pai);
                    x = node;
                }
            }
        }
    }
    private NoArvRubroNegra buscarArvore(NoArvRubroNegra node, int chave){
        if (node == NIL || chave == node.chave) return node;
        if (chave < node.chave) return buscarArvore(node.esquerda, chave);
        return buscarArvore(node.direita, chave);
    }

    public void emOrdem(){
        emOrdemHelper(node);
        System.out.println();
    }

    private void emOrdemHelper(NoArvRubroNegra node){
        if (node != NIL){
            emOrdemHelper(node.esquerda);
            String colorSuffix = (node.cores == Cores.red) ? "R" : "B";
            System.out.println(node.chave + colorSuffix + " ");
            emOrdemHelper(node.direita);
        }
    }
}
