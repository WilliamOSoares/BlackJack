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
import java.io.Serializable;

/**
 * Classe onde há um jogador que representa a casa onde acontece a partida, que
 * joga com regras especiais.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Croupier extends Jogador implements Serializable{
    
    /**
     * Cria um jogador sem nome e senha, operado pelo programa.
     */
    public Croupier() {
        super(null, null);
    }
    
    /**
     * Revela uma carta do croupier.
     * 
     * @return Uma das duas cartas do croupier.
     */
    public Carta revelarCarta(){
        return (Carta) this.getMao().getCartas().iterador().proximo();
    }
    
    /**
     * É quando o croupier começa a jogar.
     * 
     * @param p Baraalho da partida.
     */
    public void jogando(Pilha p){
        if(this.getMao().calcularMao() < 17)
            this.getMao().adicionarCarta((Carta)p.pop());    
    }
    
    /**
     * Verifica se a mão do croupier passou ou é igual a 17.
     * 
     * @return Verdade se passou ou é igual, se não passou retorna falso. 
     */
    public boolean soft17(){
        return this.getMao().calcularMao() >= 17;
    }
    
    /**
     * Verifica se o croupier fez 21.
     * 
     * @return Verdade se fez, falso se não fez. 
     */
    public boolean croupierFez21(){
        return this.getMao().calcularMao() == 21;
    }
    
    /**
     * Verifica se o croupier passou de 21.
     * 
     * @return Verdade se passou, falso se não passou.
     */
    public boolean croupierPassou21(){
        return this.getMao().calcularMao() > 21;
    }
}
