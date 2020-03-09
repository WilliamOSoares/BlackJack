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
import java.util.Random;

/**
 * Classe onde é criado o baralho.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Baralho implements Serializable{
    private Carta[] baralho = new Carta[52];// cartas
    
    /**
     * Cria as 52 cartas do baralho.
     */
    public Baralho(){
        int k = 0;
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=13; j++){
                baralho[k] = new Carta(j, i);
                k++;
            }
        }
    }
    
    /**
     * Embaralha o baralho.
     * 
     * @return O baralho embaralhado em uma pilha.
     */
    public Pilha embaralharCartas(){
        Pilha monteCartas = new Pilha();
        int cartasNoBaralho = 52;
        Random sorteio = new Random();
        
        while(cartasNoBaralho>0){
            int num = sorteio.nextInt(cartasNoBaralho);
            monteCartas.push(baralho[num]);
            Carta aux = baralho[num];
            baralho[num] = baralho[cartasNoBaralho-1];
            baralho[cartasNoBaralho-1] = aux;
            cartasNoBaralho--;
        }       
        return monteCartas;
    }
}
