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
 * Teste da Classe Baralho.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class BaralhoTest {
    
    private Baralho b;
    private Pilha p;
    
    @Before
    public void setUp() {
        b = new Baralho();
        p = new Pilha();
    }

    @Test
    public void testEmbaralharCartas() {
        p = b.embaralharCartas();
        int igual = 0, diferente = 0;
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 13; j++){
                Carta c = new Carta(j, i);
                Carta d = (Carta) p.pop();
                if(c.getNaipe() == d.getNaipe() && c.getId() == d.getId()){
                    igual++;
                }
                else{
                    diferente++;
                }
            }
        }
        assertNotEquals(52, igual);
        assertNotEquals(0, diferente);
    }
    
}
