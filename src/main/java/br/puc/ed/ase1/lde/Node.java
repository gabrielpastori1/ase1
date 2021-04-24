package br.puc.ed.ase1.lde;
import br.puc.ed.ase1.Contato;

public class Node {
    private Contato contato;
    private Node proximo;

    public Node(Contato contat, Node proxim) {
        contato = contat;
        proximo = proxim;
    }

    public Node(Contato contat){
        contato = contat;
    }

    public Node getProximo(){
        return proximo;
    }

    public Contato getContato(){
        return contato;
    }

    public void setProximo(Node proxim) {
        proximo = proxim;
    }
}