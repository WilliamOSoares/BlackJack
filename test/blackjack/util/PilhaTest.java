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
package blackjack.util;

import blackjack.model.Carta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da Classe Pilha.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PilhaTest {
    
    private Pilha p;
    private Carta a, b, c;
    
    @Before
    public void setUp() {
        p = new Pilha();
        a = new Carta(1, 1);
        b = new Carta(13, 4);
        c = new Carta(7, 2);
    }

    @Test
    public void testPushAndPeek() {
        p.push(a);
        assertEquals(a, p.peek());
        p.push(b);
        assertEquals(b, p.peek());
        p.push(c);
        assertEquals(c, p.peek());
    }

    @Test
    public void testPop() {
        p.push(a);
        p.push(b);
        p.push(c);
        assertEquals(c, p.pop());
        assertEquals(b, p.pop());
        assertEquals(a, p.pop());

    }

    @Test
    public void testIsEmpty() {
        assertTrue(p.isEmpty());
        p.push(a);
        assertFalse(p.isEmpty());
        p.pop();
        assertTrue(p.isEmpty());

    }
    
}
