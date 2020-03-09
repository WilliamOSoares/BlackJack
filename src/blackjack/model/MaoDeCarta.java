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

import blackjack.util.*;
import java.io.Serializable;

/**
 * Classe que representa a mão do jogador.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class MaoDeCarta implements Serializable{
    private ListaEncadeada cartas = new ListaEncadeada();
    
    /**
     * Cria a mão de carta com duas cartas do topo do baralho.
     * @param c1 Primeira carta.
     * @param c2 Segunda carta.
     */
    public MaoDeCarta(Carta c1, Carta c2) {
        cartas.insereInicio(c2);
        cartas.insereInicio(c1);
    }
    
    /**
     * Adiciona uma carta na mão.
     * 
     * @param carta Carta que será adicionada na mão.
     */
    public void adicionarCarta(Carta carta){
        cartas.insereFinal(carta);
    }
    
    /**
     * Cálculo de pontos na mão do jogador, verificando o valor dos ases.
     * 
     * @return Total de pontos.
     */
    public int calcularMao(){
        Iterador it = cartas.iterador();
        int soma = 0;
        Carta aux;
        boolean as = false;
        
        while(it.temProximo()){
            aux = (Carta) it.proximo();
            soma = soma + aux.getValor();
            if(aux.getId()==1)
                as = true;
        }
        
        if(as && soma<=11){
            soma = soma+10;
        }
        
        return soma;
    }
    
    /**
     * Pega todas as cartas da mão.
     * 
     * @return Lista encadeada com todas as cartas na mão.
     */
    public ListaEncadeada getCartas() {
        return cartas;
    }
}

