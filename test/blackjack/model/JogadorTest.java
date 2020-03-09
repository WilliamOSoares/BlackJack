//Blackjack//
/*******************************************************************************
Autores: Samuel Ramos dos Santos e William Oliveira Soares
Componente Curricular: MI Programação
Concluido em: 24/05/2018
Declaro que este código foi elaborado por nós de forma coletiva e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não seja a nossa está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************/
package blackjack.model;

import blackjack.util.Iterador;
import blackjack.util.Pilha;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da Classe Jogador.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class JogadorTest {
    
    private Pilha p;
    private Baralho b;
    private Jogador j;
            
    @Before
    public void setUp() {
        b = new Baralho();
        p = b.embaralharCartas();
        j = new Jogador("Test", "Senha");
    }

    @Test
    public void testComecarPartida() {
        System.out.println("comecarPartida");
        assertEquals(null, j.getMao());
        j.comecarPartida(p);
        assertNotEquals(null, j.getMao());
        Iterador it = j.getMao().getCartas().iterador();
        Carta c = (Carta) it.proximo();
        assertNotEquals(null, c);
        c = (Carta) it.proximo();
        assertNotEquals(null, c);
        c = (Carta) it.proximo();
        assertEquals(null, c);
    }

    @Test
    public void testGetMao() {
        System.out.println("getMao");
        assertEquals(null, j.getMao());
        j.comecarPartida(p);
        assertNotEquals(null, j.getMao());
    }

    @Test
    public void testGetEscolha() {
        System.out.println("getEscolha");
        j.setEscolha(0);
        assertEquals(0, j.getEscolha());
        j.setEscolha(1);
        assertEquals(1, j.getEscolha());
        j.setEscolha(12345);
        assertEquals(12345, j.getEscolha());
        j.setEscolha(98765);
        assertEquals(98765, j.getEscolha());
        j.setEscolha(2);
        assertEquals(2, j.getEscolha());
        
    }

    @Test
    public void testSetEscolha() {
        System.out.println("setEscolha");
        j.setEscolha(1);
        assertNotEquals(0, j.getEscolha());
        assertEquals(1, j.getEscolha());
        j.setEscolha(0);
        assertNotEquals(1, j.getEscolha());
        assertEquals(0, j.getEscolha());
    }

    @Test
    public void testGetUser() {
        System.out.println("getUser");
        assertEquals("Test", j.getUser());
        j = new Jogador("NegoJack", "Senha");
        assertEquals("NegoJack", j.getUser());
    }

    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        assertNotEquals("Password", j.getSenha());
        assertEquals("Senha", j.getSenha());
        assertNotEquals("senha", j.getSenha());
        j = new Jogador("NegoJack", "12345");
        assertEquals("12345", j.getSenha());
    }

    @Test
    public void testGetPontuacaoGeral() {
        System.out.println("getPontuacaoGeral");
        j.setPontuacaoGeral(21);
        assertEquals(21, j.getPontuacaoGeral());
        j.setPontuacaoGeral(19);
        assertEquals(40, j.getPontuacaoGeral());
    }

    @Test
    public void testSetPontuacaoGeral() {
        System.out.println("setPontuacaoGeral");
        j.setPontuacaoGeral(42);
        assertNotEquals(21, j.getPontuacaoGeral());
        assertEquals(42, j.getPontuacaoGeral());
        j.setPontuacaoGeral(2121);
        assertNotEquals(21, j.getPontuacaoGeral());
        assertNotEquals(42, j.getPontuacaoGeral());
        assertEquals(2163, j.getPontuacaoGeral());
    }

    @Test
    public void testGetJogosVencidos() {
        System.out.println("getJogosVencidos");
        j.setJogosVencidos(1);
        assertEquals(1, j.getJogosVencidos());
        j.setJogosVencidos(2);
        assertEquals(3, j.getJogosVencidos());
    }

    @Test
    public void testSetJogosVencidos() {
        System.out.println("setJogosVencidos");
        j.setJogosVencidos(1);
        assertNotEquals(0, j.getJogosVencidos());
        assertEquals(1, j.getJogosVencidos());
        j.setJogosVencidos(3);
        assertNotEquals(0, j.getJogosVencidos());
        assertNotEquals(3, j.getJogosVencidos());
        assertEquals(4, j.getJogosVencidos());
        
    }

    @Test
    public void testSetMao() {
        System.out.println("comecarPartida");
        assertEquals(null, j.getMao());
        j.comecarPartida(p);
        assertNotEquals(null, j.getMao());
        j.setMao(null);
        assertEquals(null, j.getMao());
    }

    @Test
    public void testCompareTo() {
        Jogador test = new Jogador("test", "123");
        j.setPontuacaoGeral(20);
        test.setPontuacaoGeral(20);
        assertEquals(0, j.compareTo(test));
        j.setPontuacaoGeral(21);
        assertEquals(-1, j.compareTo(test));
        test.setPontuacaoGeral(22);
        assertEquals(1, j.compareTo(test));
    }
    
}
