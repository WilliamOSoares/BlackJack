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

import blackjack.model.Carta;
import blackjack.model.Jogador;
import blackjack.util.Iterador;
import blackjack.util.ListaEncadeada;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável para intermediar o pedido do usuário com o resto do programa.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class ControllerBlackjack {
    
    private ControllerJogador controlJogador = new ControllerJogador();
    private Scanner input = new Scanner(System.in);
    private ControllerPartida controlPartida = new ControllerPartida();
    private ControllerArquivo controlArquivo = new ControllerArquivo();
    
    
    /**
     * Metodo que chama o metodo da classe arquivo para criar um diretorio.
     */
    public void criarDiretorios(){
        controlArquivo.criarDiretorio();
    }
    
    /**
     * Pega o controllerJogador.
     * @return ControllerJogador.
     */
    public ControllerJogador getControlJogador() {
        return controlJogador;
    }    
    
    /**
     * Salva os jogadores.
     */
    public void salvarJogadores(){
        controlArquivo.salvarJogadores(controlJogador.getJogadores());
    }
    
    /**
     * Pega os jogadores salvos.
     * @return Lista encadeada de jogadores.
     * @throws ClassNotFoundException 
     */
    public ListaEncadeada jogadoresSalvos() throws ClassNotFoundException{
        controlJogador.setJogadores(controlArquivo.jogadoresSalvos());
        return controlArquivo.jogadoresSalvos();
    }
    
    /**
     * Salva os jogadores.
     */
    public void salvarBaralho(){
        if(controlPartida.getBaralhoRestante()!= null){
            controlArquivo.salvarBaralho(controlPartida.getBaralhoRestante());            
        }        
    }
    
    /**
     * Deleta todas as cartas do ultimo baralho do disco rígido.
     */
    public void limparBaralho(){
        controlArquivo.atualizarBaralho();
    }
    
    /**
     * Faz a manutenção do jogador, faz o cadastro de um novo jogador,
     * caso ja exista o usuario, uma mensagem de erro é retornado para o
     * usuário e o cadastro se repete. 
     * 
     * @return Retorna um inteiro para notificar o final da função.
     */
    public int manutencaoJogador(){ 
        boolean condicaoSaida;
        String user, senha;
        int voltar = 10;
        boolean flag;
        
        do{
            System.out.println("------------------------------------------------\n"
                             + "\tCADASTRANDO JOGADOR");
            do{
                System.out.println("Informe um nome de usuario:");
                input = new Scanner(System.in);
                user = input.nextLine();
                input = new Scanner(System.in);
                System.out.println("Informe uma senha:");
                senha = input.nextLine();

                if(controlJogador.cadastrarJogador(user, senha)){
                    System.out.println(user + " cadastrado com sucesso\n"
                                     + "------------------------------------------------");
                    condicaoSaida = false;
                }else{
                    System.out.println("Nome de usuario ja existe");
                    condicaoSaida = true;
                }
            }while(condicaoSaida);
            do{
                System.out.println("------------------------------------------------\n"
                                 + "Fazer novo cadastro - Digite 1\n"
                                 + "Voltar para o menu - Digite 0\n"
                                 + "------------------------------------------------");
                do{
                    try{
                        voltar = input.nextInt();
                        flag = false;
                    } catch(InputMismatchException ex){
                        flag = true;
                        System.out.println("################################################\n"
                                         + "Por favor utilize apenas o teclado numerico\n"
                                         + "################################################");
                        input = new Scanner(System.in);
                    }
                }while(flag);
            }while(!(voltar == 1 || voltar == 0));
        } while(voltar==1);
        
        return 0;
    }
    
    /**
     * Insere no maximo 5 jogadores na partida e executa a partida.
     * 
     * @return Retorna um inteiro para notificar o final da função.
     */
    public int iniciarPartida(){
            String user, senha;
            int contarJogador = 0, escolha = 0;
            boolean flag;
            Jogador jogadoresQueJogaram[];
            jogadoresQueJogaram = new Jogador[5];
            
            System.out.println("------------------------------------------------\n"
                             + "\tInsira até 5 jogadores");
            do{
                do{
                    System.out.println("Jogador "+ (contarJogador+1) + "\n"
                                     + "Informe o nome de usuario: ");                        
                    input = new Scanner(System.in);
                    user = input.nextLine();
                    input = new Scanner(System.in);
                    System.out.println("Informe a senha: ");
                    senha = input.nextLine();
                    
                    if(controlJogador.existeJogador(user)){
                        if(controlJogador.getJogador(user, senha)!=null){
                            jogadoresQueJogaram[contarJogador] = controlJogador.getJogador(user, senha);
                            System.out.println("Jogador aguardando início da partida\n"
                                             + "------------------------------------------------");
                            flag = false;
                        }
                        else {
                            System.out.println("################################################\n"
                                             + "\tSenha incorreta\n"
                                             + "\tTente novamente\n"
                                             + "################################################\n");
                            flag = true;
                        }
                    } else {
                        System.out.println("################################################\n"
                                          + "\tNome de usuario incorreto\n"
                                          + "\tTente novamente\n"
                                          + "################################################\n");
                        flag = true;
                    }
                }while(flag);
                do{
                    System.out.println("------------------------------------------------\n"
                                     + "Inserir mais jogadores - Digite 1\n"
                                     + "Começar partida - Digite 2\n"
                                     + "------------------------------------------------");
                    do{
                        try{
                            escolha = input.nextInt();
                            flag = false;
                        } catch(InputMismatchException ex){
                            flag = true;
                            System.out.println("################################################\n"
                                             + "Por favor utilize apenas o teclado numerico\n"
                                             + "################################################");
                            input = new Scanner(System.in);
                        }
                    }while(flag);
                }while(escolha != 1 && escolha != 2);
                System.out.println("------------------------------------------------");
                contarJogador++;
            }while(contarJogador<5 && escolha == 1);
            
            Jogador[] paraPartida = new Jogador[contarJogador];
            for(int i = 0; i < contarJogador; i++){
                paraPartida[i] = jogadoresQueJogaram[i];
            }
            controlPartida.iniciarPartida(paraPartida);
        return 0;
    }
    
    /**
     * Lista as cartas do baralho da ultima partida, ordenadas ou não, ou volta 
     * para o menu.
     * 
     * @return Retorna um inteiro para notificar o final da função.
     * @throws java.lang.ClassNotFoundException
     */
    public int listarCartas() throws ClassNotFoundException{

        Carta[] array = controlArquivo.baralhoUltimaPartida();
        boolean flag;
        int opc = 0;
        System.out.println("------------------------------------------------\n"
                         + "Listar baralho restante do ultimo jogo: \n"
                         + "[1] Da forma que as cartas sairiam\n"
                         + "[2] Cartas Ordenadas\n"
                         + "[3] Voltar ao menu\n"
                         + "------------------------------------------------");
        do{
            try{
                opc = input.nextInt();
                flag = false;
            } catch(InputMismatchException ex){
                flag = true;
                System.out.println("################################################\n"
                                 + "Por favor utilize apenas o teclado numerico\n"
                                 + "################################################");
                input = new Scanner(System.in);
            }
        }while(flag);

        switch(opc){
            case 1:
                System.out.println("------------------------------------------------");
                for(int i = 0; i<array.length; i++){
                    if(array[i]!= null){
                        System.out.println(array[i].toString());
                    }
                }
                System.out.println("------------------------------------------------");
            break;

            case 2: 
                Carta[] cartasOrdenadas = new Carta[array.length];
                System.arraycopy(array, 0, cartasOrdenadas, 0, array.length);
                for(int i = 1; i < cartasOrdenadas.length; i++){
                    int j = i;
                    if(cartasOrdenadas[i]!= null){
                        while(j>0 && cartasOrdenadas[j].compareTo(cartasOrdenadas[j-1]) < 0){
                            troca(cartasOrdenadas, j, j-1);
                            j--;
                        }
                    }
                }
                for(int i = 0; i <cartasOrdenadas.length;i++){
                    if(cartasOrdenadas[i]!= null){
                        System.out.println(cartasOrdenadas[i].toString());
                    }
                }
                
            break;

            case 3: 
                System.out.println("Voltando para o menu...");
            break;

            default:
                System.out.println("Ops, escolha invalida!");
            break;
        }
        return 0;
    }
    
    /**
     * Mostra as regras das partidas com auxilio do ControllerPartida.
     * 
     * @return Retorna um inteiro para notificar o final da função.
     */
    public int regras(){
        controlPartida.regrasPartida();
        return 0;
    }
    
    /**
     * Faz e mostra o placar .
     * 
     * @return Retorna um inteiro para notificar o final da função.
     */
    public int mostrarPlacar() {
        ListaEncadeada l = controlJogador.getJogadores();
        int tamanho = l.tamanho();
        int i = 0;
        Jogador[] j = new Jogador[tamanho];
        Iterador it = l.iterador();
        while(it.temProximo()){            
            j[i++] = (Jogador) it.proximo();
        }
        for(int x = 1; x < j.length; x++){
            int y = x;
            while(y>0 && j[y].compareTo(j[y-1]) < 0){
                troca(j, y, y-1);
                y--;
            }           
        }
        for(int a = 0; a<j.length;a++){
            System.out.println(a+1 + "."+ j[a].getUser()+ " -> Pontuação Geral: " 
                             + j[a].getPontuacaoGeral() + " - Jogos vencidos: " 
                             + j[a].getJogosVencidos());
        }
        
        exportarPlacar(j);
        
        return 0;
    }
    
    /**
     * Recebe o array de jogadores ordenados por pontuação, gera e exporta o arquivo txt para a 
     * pasta Placar.
     * 
     * @param j Lista de jogadores.
     */
    private void exportarPlacar(Jogador[] j){
        try{
            controlArquivo.getFile().criarDiretorio("Placar");
            FileWriter f = new FileWriter("Placar//Placar Atualizado.txt");
            PrintWriter p = new PrintWriter(f);

            p.println("+--------- PLACAR ---------+");
            
            for(int i = 0; i< j.length; i++){
                p.println(i+1+". " + j[i].getUser()+ ", " + j[i].getPontuacaoGeral()+ ", "+ j[i].getJogosVencidos());               
            }
            p.close();
        }catch(IOException x){
            System.out.println("Erro ao exportar o arquivo 'Placar.txt' ");
        }
        
    }
    
    /**
     * Auxilia na troca.
     * 
     * @param array Array de jogadores.
     * @param pos1 Posição atual no array.
     * @param pos2 Posição anterior no array.
     */
    private void troca(Object[] array, int pos1, int pos2){
        Object temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
        
    }
    
}
