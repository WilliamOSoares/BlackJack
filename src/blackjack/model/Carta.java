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

import java.io.Serializable;

/**
 * Classe que cria as cartas.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Carta implements Serializable, Comparable{
    private int id;
    private int naipe; 
    private int valor;   
    
    /**
     * Cria uma carta apartir do id e do naipe.
     * 
     * @param id Identificação da carta, de 1 a 13.
     * @param naipe Identificação do naipe, de 1 a 4.
     */
    public Carta(int id, int naipe){
        this.id = id;
        this.naipe = naipe;
        if(id < 10)
            valor = id;
        else
            valor = 10;
    }

    /**
     * Pega a identificação da carta.
     * 
     * @return O identificador da carta.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Pega o naipe da carta.
     * 
     * @return O identificador do naipe.
     */
    public int getNaipe() {
        return naipe;
    }
    
    /**
     * Pega o valor da carta.
     * 
     * @return O valor da carta. 
     */
    public int getValor() {
        return valor;
    }
    
    /**
     * Imprime o nome e o naipe da carta.
     * 
     * @return O nome e o naipe da carta.
     */
    @Override
    public String toString() {
        if(id == 1){
            switch (naipe) {
                case 1:
                    return "Ás ♠";
                case 2:
                    return "Ás ♥";
                case 3:
                    return "Ás ♣";
                case 4:
                    return "Ás ♦";
                default:
                    break;
            }
        } else if(id <= 10){
            switch (naipe) {
                case 1:
                    return id + " ♠";
                case 2:
                    return id + " ♥";
                case 3:
                    return id + " ♣";
                case 4:
                    return id + " ♦";
                default:
                    break;
            }
        } else if(id == 11){
            switch (naipe) {
                case 1:
                    return "J ♠";
                case 2:
                    return "J ♥";
                case 3:
                    return "J ♣";
                case 4:
                    return "J ♦";
                default:
                    break;
            }
        } else if(id == 12){
            switch (naipe) {
                case 1:
                    return "Q ♠";
                case 2:
                    return "Q ♥";
                case 3:
                    return "Q ♣";
                case 4:
                    return "Q ♦";
                default:
                    break;
            }
        } else {
            switch (naipe) {
                case 1:
                    return "K ♠";
                case 2:
                    return "K ♥";
                case 3:
                    return "K ♣";
                case 4:
                    return "K ♦";
                default:
                    break;
            }
        } 
        return null;
    }

    @Override
    public int compareTo(Object t) {
        Carta c = (Carta) t;
        if(this.id < c.getId()){
            if(this.naipe < c.getNaipe())
                return -1;
            else if(this.naipe > c.getNaipe())
                return 1;
            else
                return -1;
        } else if(this.id > c.getId()){
            if(this.naipe < c.getNaipe())
                return -1;
            else if(this.naipe > c.getNaipe())
                return 1;
            else
                return 1;
        } else {
            if(this.naipe < c.getNaipe())
                return -1;
            else if(this.naipe > c.getNaipe())
                return 1;
            else
                return 0;
        }
    }
    
}
