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
import blackjack.util.ListaEncadeada;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da Classe MãoDeCarta.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class MaoDeCartaTest {
    
    private Carta a, b, c, d;
    private MaoDeCarta e;
    
    @Before
    public void setUp() {
        a = new Carta(1, 1);
        b = new Carta(7, 2);
        c = new Carta(12, 3);
        d = new Carta(10, 4);
        e = new MaoDeCarta(a, b);
    }

    @Test
    public void testCalcularMao() {
        System.out.println("calcularMao");
        assertEquals(18, e.calcularMao());
        e.adicionarCarta(c);
        assertEquals(18, e.calcularMao());
        e.adicionarCarta(d);
        assertEquals(28, e.calcularMao());
    }
    
    @Test
    public void testAdicionarCarta() {
        System.out.println("adicionarCarta");
        ListaEncadeada mao = e.getCartas();
        Iterador it = mao.iterador();
        Carta aux = (Carta)it.proximo();
        assertEquals(a, aux);
        aux = (Carta)it.proximo();
        assertEquals(b, aux);
        e.adicionarCarta(c);
        aux = (Carta)it.proximo();
        assertEquals(c, aux);
        e.adicionarCarta(d);
        aux = (Carta)it.proximo();
        assertEquals(d, aux);
    }
    
    @Test
    public void testGetCartas() {
        System.out.println("getCartas");
        e.adicionarCarta(c);
        e.adicionarCarta(d);
        ListaEncadeada mao = e.getCartas();
        Iterador it = mao.iterador();
        Carta aux = (Carta)it.proximo();
        assertEquals(a, aux);
        aux = (Carta)it.proximo();
        assertEquals(b, aux);
        aux = (Carta)it.proximo();
        assertEquals(c, aux);
        aux = (Carta)it.proximo();
        assertEquals(d, aux);
    }
    
}
