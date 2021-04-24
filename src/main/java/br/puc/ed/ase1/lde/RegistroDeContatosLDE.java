package br.puc.ed.ase1.lde;

import br.puc.ed.ase1.Contato;
import br.puc.ed.ase1.RegistroDeContatos;

public class RegistroDeContatosLDE implements RegistroDeContatos {

    private Node inicio;
    private int quantidade;

    public RegistroDeContatosLDE(){
        inicio = null;
        quantidade = 0;
    }

    public void inserir(Contato contato){
        Node novoNode = new Node(contato, inicio);
        inicio = novoNode;
        quantidade++;
    }

    public Contato excluirContato(String nomeContato){
        Node nodeAtual = inicio;
        if(nodeAtual == null) return null;
        if(nodeAtual.getContato().getNome().equals(nomeContato)){
            Node buffer = inicio;
            inicio = nodeAtual.getProximo();
            quantidade--;
            return buffer.getContato();
        }

        while(nodeAtual.getProximo() != null && nodeAtual.getProximo().getContato().getNome() != nomeContato){
            nodeAtual = nodeAtual.getProximo();
        }
        if(nodeAtual.getProximo() == null) return null;
        Node buffer = nodeAtual.getProximo();
        nodeAtual.setProximo(nodeAtual.getProximo().getProximo());
        quantidade--;
        return buffer.getContato();
    }

    public Contato buscarContato(String nomeContato){
        Node nodeAtual = inicio;
        while(nodeAtual != null && !nodeAtual.getContato().getNome().equals(nomeContato)){
            nodeAtual = nodeAtual.getProximo();
        }

        if(nodeAtual == null) return null;
        return nodeAtual.getContato();
    }

    public void imprimirLista(){
        Node nodeAtual = inicio;
        int i = 1;
        while(nodeAtual != null){
            System.out.println(i + ": " + nodeAtual.getContato().getNome() + " " + nodeAtual.getContato().getTelefone());
            nodeAtual = nodeAtual.getProximo();
            i++;
        }
    }

    public int getTamanho() {
        return quantidade;
    }
}
