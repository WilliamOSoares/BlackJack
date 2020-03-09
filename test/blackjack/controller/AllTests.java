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
package blackjack.controller;

import blackjack.model.*;
import blackjack.util.*;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PilhaTest.class,	
        ListaEncadeadaTest.class,
	PartidaTest.class,
	MaoDeCartaTest.class,
	JogadorTest.class,
	CroupierTest.class,
        CartaTest.class,
        BaralhoTest.class,
})

/**
 * Todos os testes executados.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class AllTests { }
