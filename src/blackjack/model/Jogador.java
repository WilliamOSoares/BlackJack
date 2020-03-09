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
 * Classe que cria os jogadores.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Jogador implements Serializable, Comparable{
    private String user;
    private String senha;
    private int escolha = 1;
    private int pontuacaoGeral;
    private int jogosVencidos;
    private MaoDeCarta mao;
    
    /**
     * Cria o jogador com o nome senha, pontuações zeradas.
     * @param user Nome do usuário.
     * @param senha Senha do usuário.
     */
    public Jogador(String user, String senha){
        this.user = user;
        this.senha = senha;
        pontuacaoGeral = 0;
        jogosVencidos = 0;
        mao = null;
    }
    
    /**
     * Adiciona duas cartas na mão do jogador.
     * 
     * @param p Baralho da partida.
     */
    public void comecarPartida(Pilha p){                
        mao = new MaoDeCarta((Carta) p.pop(), (Carta) p.pop());
    }
    
    /**
     * Pega a mão do jogador.
     * 
     * @return A mão do jogador. 
     */
    public MaoDeCarta getMao() {
        return mao;
    }

    /**
     * Esse metodo serve somente para transformar a mao do jogador em null apos a partida.
     * 
     * @param mao A mão que será a do jogador.
     */
    public void setMao(MaoDeCarta mao) {
        this.mao = mao;
    }    
    
    /**
     * Pega a escolha do jogador.
     * 
     * @return A escolha do jogador.
     */
    public int getEscolha() {
        return escolha;
    }
    
    /**
     * Altera a escolha doo jogador.
     * 
     * @param escolha Numero que será a escolha do jogador.
     */
    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }
    
    /**
     * Pega o nome de usuário do jogador.
     * 
     * @return Nome do jogador. 
     */
    public String getUser() {
        return user;
    }

    /**
     * Pega a senha do jogador.
     * 
     * @return A senha do jogador.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Pega a pontuação geral do jogador.
     * 
     * @return Pontuação geral.
     */
    public int getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    /**
     * Altera a pontuação geral, somando a antiga com a passada por parâmetro.
     * 
     * @param pontuacaoGeral Pontuação que o jogador fez na partida.
     */
    public void setPontuacaoGeral(int pontuacaoGeral) {
        this.pontuacaoGeral = this.pontuacaoGeral + pontuacaoGeral;
    }

    /**
     * Pega o numero de partidas vencidas pelo jogador.
     * 
     * @return Numero de partidas vencidas pelo jogador.
     */
    public int getJogosVencidos() {
        return jogosVencidos;
    }
    
    /**
     * Altera o numero de partidas vencidas pelo jogador, somando o numero
     * antigo com o que foi passado por parâmetro.
     * 
     * @param jogosVencidos Numero de partidas vencidas pelo jogador na 
     * execução do programa.
     */
    public void setJogosVencidos(int jogosVencidos) {
        this.jogosVencidos = this.jogosVencidos + jogosVencidos;
    }
    
    /**
     * Compara os jogadores pela pontuação geral.
     * @param o Jogador que será comparado.
     * @return 1 se for maior, -1 se for menor, 0 se for igual.
     */
    @Override
    public int compareTo(Object o){
        Jogador j = (Jogador) o;
        if(this.getPontuacaoGeral() > j.getPontuacaoGeral()){
            return -1;
        }
        if(this.getPontuacaoGeral() < j.getPontuacaoGeral()){
            return 1;
        }
        return 0;
    }
    
}
