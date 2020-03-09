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

import blackjack.model.Jogador;
import blackjack.model.Partida;
import blackjack.util.Pilha;

/**
 * Classe responsável por controlar a partida.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class ControllerPartida {
    
    private Pilha pilha = new Pilha();
    private Partida partida;
    
    public ControllerPartida(){}
    
    /**
     * Executa a partida de acordo com as regras.
     * 
     * @param j Array com os jogadores da partida.
     */
    public void iniciarPartida(Jogador[] j){
        partida = new Partida(j);
        partida.distribuirCartas();
        partida.maisCartas();
        partida.jogaCroupier();
        int i = partida.verificarGanhador();
        System.out.println("Quantidade de ganhadores: " + i);
        pilha = partida.BaralhoRestante();
    }
    
    /**
     * Mostra as regras da partida.
     */
    public void regrasPartida(){
        System.out.println(" Regras:\n"
                         + " 1 - Quando um jogador faz 21, nenhum jogador pode pedir carta;\n"
                         + " 2 - Sempre que o croupier fizer 21 ele ganha;\n"
                         + " 3 - Será utilizado um único baralho para cada partida;\n"
                         + " 4 - O jogador só poderá pedir uma carta por rodada;\n"
                         + " 5 - O jogador irá pontuar de acordo com o valor das cartas da sua mão;\n"
                         + " 6 - O croupier continua cavando enquanto tiver a mão menor que 17;\n"
                         + " 7 - Todos os jogadores jogam contra o croupier.");
    }
    
    /**
     * Pega o baralho restante.
     * @return Pilha com baralho restante
     */
    public Pilha getBaralhoRestante() {
        return !pilha.isEmpty() ? pilha : null;
    }
}
