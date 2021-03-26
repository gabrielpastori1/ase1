package br.puc.ed.ase1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.puc.ed.ase1.array.RegistroDeContatosAR;
import br.puc.ed.ase1.lde.RegistroDeContatosLDE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistroDeContatosTest {

    @Test
    void testeListaEncadeada(){
        RegistroDeContatosLDE registroDeContatosLDE = new RegistroDeContatosLDE();
        testeLista(registroDeContatosLDE);
    }

    @Test
    void testeArray(){
        RegistroDeContatosAR registroDeContatosAR = new RegistroDeContatosAR(17);
        testeLista(registroDeContatosAR);
    }

    @Test
    void testeArrayOutOfBoundException(){
        RegistroDeContatosAR registroDeContatosAR = new RegistroDeContatosAR(16);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> testeLista(registroDeContatosAR));
    }

    void testeLista(RegistroDeContatos registroDeContatos) {
        assertEquals(registroDeContatos.getTamanho(), 0);
        cadastrarContatos(registroDeContatos);
        registroDeContatos.imprimirLista();
        assertEquals(17, registroDeContatos.getTamanho());
        Contato contato = registroDeContatos.buscarContato("Renier");
        assertEquals("Renier", contato.getNome());
        assertEquals("0006", contato.getTelefone());
        contato = registroDeContatos.excluirContato("Matthew");
        assertNotNull(contato);
        assertEquals("Matthew", contato.getNome());
        assertEquals("0013", contato.getTelefone());
        assertEquals(16, registroDeContatos.getTamanho());
        excluirContatos(registroDeContatos);
        assertEquals(registroDeContatos.getTamanho(), 0);
        registroDeContatos.imprimirLista();
    }

    private void cadastrarContatos(RegistroDeContatos registroDeContatos){
        registroDeContatos.inserir(new Contato("Briannon", "0001"));
        registroDeContatos.inserir(new Contato("Jamez", "0002"));
        registroDeContatos.inserir(new Contato("Keyra", "0003"));
        registroDeContatos.inserir(new Contato("Laysa", "0004"));
        registroDeContatos.inserir(new Contato("Melannie", "0005"));
        registroDeContatos.inserir(new Contato("Renier", "0006"));
        registroDeContatos.inserir(new Contato("Samuell", "0007"));
        registroDeContatos.inserir(new Contato("Wessley", "0008"));
        registroDeContatos.inserir(new Contato("William", "0009"));
        registroDeContatos.inserir(new Contato("Alanah", "0010"));
        registroDeContatos.inserir(new Contato("Dexton", "0011"));
        registroDeContatos.inserir(new Contato("Maddison", "0012"));
        registroDeContatos.inserir(new Contato("Matthew", "0013"));
        registroDeContatos.inserir(new Contato("Rachell", "0014"));
        registroDeContatos.inserir(new Contato("Rigel", "0015"));
        registroDeContatos.inserir(new Contato("Scarlett", "0016"));
        registroDeContatos.inserir(new Contato("Colyn", "0017"));
    }

    private void excluirContatos(RegistroDeContatos registroDeContatos){
        registroDeContatos.excluirContato("Briannon");
        registroDeContatos.excluirContato("Jamez");
        registroDeContatos.excluirContato("Keyra");
        registroDeContatos.excluirContato("Laysa");
        registroDeContatos.excluirContato("Melannie");
        registroDeContatos.excluirContato("Renier");
        registroDeContatos.excluirContato("Samuell");
        registroDeContatos.excluirContato("Wessley");
        registroDeContatos.excluirContato("William");
        registroDeContatos.excluirContato("Alanah");
        registroDeContatos.excluirContato("Dexton");
        registroDeContatos.excluirContato("Maddison");
        registroDeContatos.excluirContato("Matthew");
        registroDeContatos.excluirContato("Rachell");
        registroDeContatos.excluirContato("Rigel");
        registroDeContatos.excluirContato("Scarlett");
        registroDeContatos.excluirContato("Colyn");
    }

}
