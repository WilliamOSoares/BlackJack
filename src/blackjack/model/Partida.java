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

import blackjack.util.Iterador;
import blackjack.util.Pilha;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * classe onde a partida é manipulada.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Partida implements Serializable{
    
    private Jogador[] jogadores;
    private Croupier croupier = new Croupier();
    private Baralho b = new Baralho();
    private Pilha baralho = b.embaralharCartas();
    Scanner input = new Scanner(System.in);
    private boolean flag;
    
    /**
     * Cria a partida com uma certa quantidade de jogadores.
     * @param j Jogares que irão jogar a partida.
     */
    public Partida(Jogador[] j){
        jogadores = new Jogador[j.length];
        for(int i = 0; i<j.length; i++)
            jogadores[i] = j[i];
    }
    
    /**
     * Distribui as cartas para todos os jogadores e por ultimo para o croupier.
     */
    public void distribuirCartas(){
        for(int i = 0; i<jogadores.length; i++){
            if(jogadores[i] != null)
                jogadores[i].comecarPartida(baralho);
        }
        croupier.comecarPartida(baralho);
    }
    
    /**
     * Executa as rodadas da partida de acordo com as regras da patida.
     */
    public void maisCartas(){
        int escolha = 0;
        Carta aux;
        int ninguemJogou = 0;
        while(ninguemJogou < jogadores.length){
            ninguemJogou = 0;
            for(int i=0; i < jogadores.length; i++){
                if(jogadores[i].getEscolha() == 1 ) {
                    System.out.println(jogadores[i].getUser() + "\n"
                                     + "------------------------------------------------\n"
                                     + "Suas cartas:");
                    Iterador it = jogadores[i].getMao().getCartas().iterador();
                    while(it.temProximo()){
                        aux = (Carta) it.proximo();
                        System.out.println(aux.toString());
                    }
                    System.out.println("Valor da mão: " + jogadores[i].getMao().calcularMao() + "\n"
                                     + "------------------------------------------------\n"
                                     + "Carta do Croupier: " + croupier.revelarCarta().toString() + "\n"
                                     + "------------------------------------------------");
                    do{
                        System.out.println("------------------------------------------------\n"
                                         + "[1] Pedir mais?\n"
                                         + "[2] Parar\n"
                                         + "------------------------------------------------");
                        do{
                            try{
                                escolha = input.nextInt();
                                flag = false;
                            } catch(InputMismatchException ex){
                                flag = true;
                                System.out.println("################################################\n"
                                                 + "Por favor utilize apenas o teclado numerico\n"
                                                 + "################################################\n");
                                input = new Scanner(System.in);
                            }
                            }while(flag);
                    }while(!(escolha == 1 || escolha == 2));
                    jogadores[i].setEscolha(escolha);                
                    if(escolha == 1){
                        aux = (Carta) baralho.peek();
                        System.out.println("------------------------------------------------\n"
                                         + "Carta retirada: " + aux.toString() + "\n"
                                         + "------------------------------------------------");
                        jogadores[i].getMao().adicionarCarta((Carta) baralho.pop());
                    }
                    if(jogadores[i].getMao().calcularMao() > 21){
                        System.out.println("################################################\n"
                                         + "Estourou\n"
                                         + "################################################");
                        jogadores[i].setEscolha(2);
                    }
                    if(jogadores[i].getMao().calcularMao() == 21){
                        redefinirEscolha(2);
                    }
                } else ninguemJogou++;
            }
        }
        redefinirEscolha(1);
    }
    /**
     * Verfica e atualiza a estatistica dos jogadores.
     * @return O numero de ganhadores.
     */
    public int verificarGanhador(){
        int numeroDeGanhadores = 0;
        
        if(croupier.croupierFez21()){
            this.redefinirMaoDosJogadores();
            System.out.println("Croupier ganhou");
            return numeroDeGanhadores;
        }else if(jogadorFez21()){
            this.redefinirMaoDosJogadores();
            numeroDeGanhadores++;
        } else {
            for(int i = 0; i<jogadores.length; i++){            
                if(croupier.croupierPassou21() && jogadores[i].getMao().calcularMao() < 22){
                    jogadores[i].setJogosVencidos(1);
                    jogadores[i].setPontuacaoGeral(jogadores[i].getMao().calcularMao());
                    System.out.println(jogadores[i].getUser() +  " ganhou");
                    numeroDeGanhadores++;
                } else if (croupier.getMao().calcularMao() < jogadores[i].getMao().calcularMao()
                           && jogadores[i].getMao().calcularMao() < 22){
                    jogadores[i].setJogosVencidos(1);
                    jogadores[i].setPontuacaoGeral(jogadores[i].getMao().calcularMao());
                    System.out.println(jogadores[i].getUser() +  " ganhou");
                    numeroDeGanhadores++;
                }
                jogadores[i].setMao(null);
            }
        }
        return numeroDeGanhadores;
    }
    
    /**
     * Executa a jogada do coupier de acordo com as regras da partida.
     */
    public void jogaCroupier(){
        Carta aux;
        Iterador it = croupier.getMao().getCartas().iterador();
        System.out.println("------------------------------------------------\n"
                         + "Cartas do Croupier:");
        while(it.temProximo()){
            aux = (Carta) it.proximo();
            System.out.print(aux.toString());
        }
        System.out.println("\n------------------------------------------------");
        while(!croupier.soft17()){
            aux = (Carta) baralho.peek();
            croupier.jogando(baralho);
            System.out.println("Carta retirada pelo Croupier: " + aux.toString());
        }
        System.out.println("------------------------------------------------");
    }
    
    /**
     * A escolha dos jogadores mudarão para a escolha recebida por parâmetro.
     * 
     * @param escolha Numero que será a escolha de todos os jogadores.
     */
    private void redefinirEscolha(int escolha){
        for(int i = 0; i< jogadores.length; i++){
            if(jogadores[i] != null)
                jogadores[i].setEscolha(escolha);
        }
    }
    
    /**
     * Devolve o resto do baralho da partida.
     * 
     * @return Retorna o baralho da partida. 
     */
    public Pilha BaralhoRestante(){
        return baralho;
    }
    
    /**
     * Verifica se algum jogador fez 21.
     * @return Verdade se há um jogador com 21, senão retorna false.
     */
    private boolean jogadorFez21() {
        for(int i = 0; i<jogadores.length; i++){
            if(jogadores[i].getMao().calcularMao() == 21){
                jogadores[i].setJogosVencidos(1);
                jogadores[i].setPontuacaoGeral(jogadores[i].getMao().calcularMao());
                System.out.println(jogadores[i].getUser() + " ganhou");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Redefine as mãos de todos os jogadores. 
     */
    private void redefinirMaoDosJogadores(){
        for(int i = 0; i<jogadores.length; i++){
                jogadores[i].setMao(null);
        }
    }
}
