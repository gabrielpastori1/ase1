package br.puc.ed.ase1;

import br.puc.ed.ase1.array.*;
import br.puc.ed.ase1.lde.*;
import java.util.Scanner;

public class MainApp {
    private static RegistroDeContatos registroDeContatos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        registroDeContatos = new RegistroDeContatosLDE();
        Integer input = 1;
        
        while(input != 0){
            input = showMenu(sc);
            switch(input){
                case 1:
                    registroDeContatos.inserir(cadastrarContato(sc));
                    System.out.println("Contato salvo com sucesso");
                    break;
                case 2:
                    registroDeContatos.excluirContato(excluirContato(sc));
                    break;
                case 3:
                    Contato contato = registroDeContatos.buscarContato(buscarTelefoneContato(sc));
                    if(contato != null) {
                        System.out.println(contato.getNome()+" - "+contato.getTelefone());
                    }else{
                        System.out.println("Contato não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("\nLista de contatos");
                    if(registroDeContatos.getTamanho() == 0) System.out.println("\nA sua agenda está vazia");
                    registroDeContatos.imprimirLista();
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("\nOpção Invalida!");
            }
            // limparTela();
        }
    }

    private static int showMenu(Scanner scanner){
        System.out.println("\n\nDigite uma opção: ");
        System.out.println("1: Cadastrar contato");
        System.out.println("2: Excluir contato");
        System.out.println("3: Buscar telefone contato");
        System.out.println("4: Imprimir lista de contatos");
        System.out.println("0: Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    private static void limparTela(){
        for(int i=0;i < 15; i++){
            System.out.println("");
        }
    }
    
    private static Contato cadastrarContato(Scanner scanner) {
        System.out.println("Digite o nome do contato:");
        String nome = scanner.next();
        System.out.println("Digite o telefone do contato:");
        String telefone = scanner.next();
        return new Contato(nome, telefone);
    }
    
    private static String excluirContato(Scanner scanner) {
        System.out.println("Digite o nome do contato que deseja excluir:");
        // String nome =
        return scanner.next();
        
    }
    
    private static String buscarTelefoneContato(Scanner scanner) {
        System.out.println("Digite o nome do contato que deseja buscar:");
        return scanner.next();

    }
}
    