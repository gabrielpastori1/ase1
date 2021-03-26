package br.puc.ed.ase1;

public interface RegistroDeContatos {
    void inserir(Contato contato);
    Contato excluirContato(String nomeContato);
    Contato buscarContato(String nomeContato);
    void imprimirLista();
    int getTamanho();
}
