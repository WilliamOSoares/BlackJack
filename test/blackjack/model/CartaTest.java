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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da Classe Carta.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class CartaTest {
    
    private Carta c;
    private Carta d;
    private Carta e;
    
    @Before
    public void setUp() {
        c = new Carta(1, 1);
        d = new Carta(13, 4);
        e = new Carta(7, 2);    
    }

    @Test
    public void testGetId() {
        assertEquals(1, c.getId());
        assertEquals(13, d.getId());
        assertEquals(7, e.getId());
        c = e;
        assertEquals(7, c.getId());
    }

    @Test
    public void testGetNaipe() {
        assertEquals(1, c.getNaipe());
        assertEquals(4, d.getNaipe());
        assertEquals(2, e.getNaipe());
        c = e;
        assertEquals(2, c.getNaipe());
    }

    @Test
    public void testGetValor() {
        assertEquals(1, c.getValor());
        assertEquals(10, d.getValor());
        assertEquals(7, e.getValor());
        c = e;
        assertEquals(7, c.getValor());
    }

    @Test
    public void testToString() {
        assertEquals("Ás ♠" , c.toString());
        assertEquals("K ♦" , d.toString());
        assertEquals("7 ♥" , e.toString());
        c = e;
        assertEquals("7 ♥" , c.toString());
    }
    
}
