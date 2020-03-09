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
package blackjack.view;

import blackjack.controller.ControllerBlackjack;
import blackjack.util.Pilha;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe onde há o menu principal e main do programa.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Game {
    public static void main(String[] args) throws ClassNotFoundException {
        
        Scanner input = new Scanner(System.in);
        Pilha restantes = null;
        int escolhaMenu = 0;
        ControllerBlackjack controlador = new ControllerBlackjack();
        
        controlador.criarDiretorios();
        controlador.getControlJogador().setJogadores(controlador.jogadoresSalvos());
        
        
        boolean flag;
        do{    
            System.out.println("------------------------------------------------\n"
                             + "[1] MANUTENÇÃO DE JOGADOR\n"
                             + "[2] INICIAR PARTIDA\n"
                             + "[3] LISTAR CARTAS\n"
                             + "[4] MOSTRAR PLACAR\n"
                             + "[5] REGRAS\n"
                             + "[6] SAIR\n"
                             + "------------------------------------------------");
            
            do{
                try{
                    escolhaMenu = input.nextInt();

                    System.out.println("------------------------------------------------");
                    flag = false;
                } catch(InputMismatchException ex){
                    flag = true;
                    System.out.println("################################################\n"
                                     + "Por favor utilize apenas o teclado numerico\n"
                                     + "################################################");
                    input = new Scanner(System.in);
                }
            }while(flag);
            
            
            switch(escolhaMenu){
                case 0: 
                    System.out.println("Menu principal");
                break;
                
                case 1:
                    escolhaMenu = controlador.manutencaoJogador();
                break;

                case 2:                    
                    escolhaMenu = controlador.iniciarPartida();                    
                    controlador.limparBaralho(); 
                    controlador.salvarBaralho();
                    controlador.salvarJogadores();
                break;

                case 3:
                    escolhaMenu = controlador.listarCartas();
                break;

                case 4:
                    escolhaMenu = controlador.mostrarPlacar();
                break;

                case 5:
                    escolhaMenu = controlador.regras();
                break;

                case 6:
                    System.out.println("Até logo!!");
                break;

                default:
                    System.out.println("Ops, escolha invalida\n"
                                     + "Tenta novamente ai");
                    escolhaMenu = 0;
                break;


            }
        }while(escolhaMenu == 0);
                
        controlador.salvarJogadores();        
        
    }
    
}
