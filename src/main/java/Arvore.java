import org.example.No;

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
        if ((node != null)){
            System.out.println(node.valor + " ");
            buscarEmOrdem(node.esquerda);
            buscarEmOrdem(node.direita);
        }
    }
}
