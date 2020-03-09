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

import blackjack.util.Pilha;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da Classe Croupier.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class CroupierTest {
    
    Pilha p;
    Carta a, b, x, y;
    Croupier c;
    
    @Before
    public void setUp() {
        c = new Croupier();
        a = new Carta(1, 1);
        b = new Carta(5, 2);
        x = new Carta(12, 3);
        y = new Carta(10, 4);
        p = new Pilha();
        p.push(y);
        p.push(x);
        p.push(b);
        p.push(a);
    }

    @Test
    public void testRevelarCarta() {
        System.out.println("revelarCarta");
        c.comecarPartida(p);
        assertNotEquals(null, c.revelarCarta());
    }

    @Test
    public void testJogando() {
        System.out.println("jogando");
        c.comecarPartida(p);
        assertTrue(c.getMao().calcularMao()<17);
        c.jogando(p);
        assertTrue(c.getMao().calcularMao()<17);
        c.jogando(p);
        assertFalse(c.getMao().calcularMao()<17);
    }

    @Test
    public void testSoft17() {
        System.out.println("soft17");
        c.comecarPartida(p);
        assertFalse(c.soft17());
        c.jogando(p);
        assertFalse(c.soft17());
        c.jogando(p);
        assertTrue(c.soft17());
    }
    
}
