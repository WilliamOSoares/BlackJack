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
 * Teste da Classe Partida.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PartidaTest {
    
    private Jogador[] jogadores;
    private Jogador jogador1;
    private Jogador jogador2;
    private Partida partida;
    
    @Before
    public void setUp() {
        jogadores = new Jogador[2];
        jogador1 = new Jogador("jogador1", "123");
        jogador2 = new Jogador("jogador2", "12345");
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;
        partida = new Partida(jogadores);
    }

    @Test
    public void testDistribuirCartas() {
        partida.distribuirCartas();
        assertNotEquals(null, jogador1.getMao().getCartas());
        assertTrue(jogador2.getMao().calcularMao()>1);
        assertTrue(jogador1.getMao().calcularMao()<22);
    }

    @Test
    public void testJogaCroupier() {
        partida.distribuirCartas();
        partida.jogaCroupier();

    }

    @Test
    public void testBaralhoRestante() {
        partida.distribuirCartas();
        Pilha p = partida.BaralhoRestante();
        assertNotEquals(null, p);
    }
    
}
