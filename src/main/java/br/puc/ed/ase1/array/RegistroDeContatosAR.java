package br.puc.ed.ase1.array;

import br.puc.ed.ase1.Contato;
import br.puc.ed.ase1.RegistroDeContatos;

public class RegistroDeContatosAR implements RegistroDeContatos {

    private Contato[] contatos;
    private int quantidade;
    private int capacity;

    public RegistroDeContatosAR(int capacidade){
        contatos = new Contato[capacidade];
        capacity = capacidade;
        quantidade = 0;
    }

    public void inserir(Contato contato){
        if(quantidade >= capacity) return;
        contatos[quantidade] = contato;
        quantidade++;
    }

    public Contato excluirContato(String nomeContato){
        Contato[] novoContatos = new Contato[capacity];
        Integer index = buscarIndiceContato(nomeContato);

        //Verifica se o contato foi encontrado
        if(index != null){
            Contato buffer = contatos[index];
            contatos[index] = null;
            int count = 0;
            for(int i=0;i < capacity; i++) {
                if(contatos[i] != null){
                    novoContatos[count] = contatos[i];
                    count++;
                }
            }
            quantidade--;
            contatos = novoContatos;
            return buffer;
        }else{
            return null;
        }
    }

    private Integer buscarIndiceContato(String nomeContato){
        for(int i = 0; i < quantidade; i++){
            if(contatos[i].getNome() == nomeContato){
                return i;
            }
        }
        return null;
    }
    
    public Contato buscarContato(String nomeContato){
        Integer index = buscarIndiceContato(nomeContato);
        if(index != null){
            return contatos[index];
        }
        return null;
    }
    
    public void imprimirLista(){
        for(int i = 0; i < quantidade; i++){
            System.out.println(i + 1 + ": " + contatos[i].getNome() + " " + contatos[i].getTelefone());
        }  
    }

    public int getTamanho() {
        return quantidade;
    }
}
