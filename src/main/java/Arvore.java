import org.example.No;

import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No noRaiz;

    public int contarNosRecursivo(No node){
        if (node == null ) return 0;
        return 1 + contarNosRecursivo(node.esquerda) + contarNosRecursivo(node.direita);
    }

    public void buscarPreOrdemRecursivo(No node) {
        if ( node != null){
            System.out.println(node.valor + " ");
            buscarPreOrdemRecursivo(node.esquerda);
            buscarPreOrdemRecursivo(node.direita);
        }
    }

    public void buscarEmOrdemRecursivo(No node){
        if (node != null){
            System.out.println(node.valor + " ");
            buscarEmOrdemRecursivo(node.esquerda);
            buscarEmOrdemRecursivo(node.direita);
        }
    }

    public void buscarPosOrdemRecursivo(No node) {
        if (node != null) {
            buscarPosOrdemRecursivo(node.esquerda);
            buscarPosOrdemRecursivo(node.direita);
            System.out.println(node.valor + " ");
        }
    }

    public void buscarEmNivelRecursivo(No node){
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

    public int contarNosFolhas(No node){
        if (node == null) {
            return 0;
        }

        if (node.direita == null && node.esquerda == null){
            return 0;
        }

        return contarNosFolhas(node.esquerda) + contarNosFolhas(node.direita);
    }

}
