import org.example.No;

import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No noRaiz;

    public int contarNos(No node){
        if (node == null ) return 0;
        return 1 + contarNos (node.esquerda) + contarNos(node.direita);
    }

    public void buscarPreOrdem(No node) {
        if ( node != null){
            System.out.println(node.valor + " ");
            buscarPreOrdem(node.esquerda);
            buscarPreOrdem(node.direita);
        }
    }

    public void buscarEmOrdem (No node){
        if (node != null){
            System.out.println(node.valor + " ");
            buscarEmOrdem(node.esquerda);
            buscarEmOrdem(node.direita);
        }
    }

    public void buscarPosOrdem (No node) {
        if (node != null) {
            buscarPosOrdem(node.esquerda);
            buscarPosOrdem(node.direita);
            System.out.println(node.valor + " ");
        }
    }

    public void buscarEmNivel (No node){
        if (noRaiz ==  null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(noRaiz);

        while (!fila.isEmpty()){
            No atual = fila.poll();
            System.out.println(atual.valor + " ");

            if (atual.esquerda != null ) fila.add(atual.esquerda);
            if (atual.direita != null ) fila.add(atual.direita);

        }
    }
}
