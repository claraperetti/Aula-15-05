import org.example.No;

public class Arvore {
    No noRaiz;

    public int contarNo(No node){
        if (node == null ) return 0;
        return 1 + contarNo (node.esquerda) + contarNo(node.direita);
    }
}
