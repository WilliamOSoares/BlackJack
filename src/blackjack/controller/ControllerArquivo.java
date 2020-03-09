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
import blackjack.util.Arquivo;
import blackjack.util.Iterador;
import blackjack.util.ListaEncadeada;
import blackjack.util.Pilha;
import java.io.File;

/**
 * Classe responsável por controlar os arquivos.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class ControllerArquivo {
    private Arquivo file = new Arquivo();
    
    
    /**
     * Usar em outras classes os metodos da classe arquivo.
     * @return file
     */
    public Arquivo getFile() {
        return file;
    }    
    
    /**
     * Cria os diretórios Players e Baralho.
     */
    public void criarDiretorio(){
        file.criarDiretorio("Players");
        file.criarDiretorio("Baralho");
    }
    
    /**
     * Atualiza o baralho salvo deletando os arquivos no diretório.
     */
    public void atualizarBaralho(){
        File f = new File("Baralho");
        if(f.exists() && f.isDirectory()){
            File[] arquivos = f.listFiles();
            for(int i = 0; i<arquivos.length; i++){
                arquivos[i].delete();
            }
        }
    }
    
    /**
     * Pega o baralho da ultima partida, direto do diretório.
     * @return Um array com as cartas.
     * @throws ClassNotFoundException
     */
    public Carta[] baralhoUltimaPartida() throws ClassNotFoundException{
        Carta[] c = new Carta[52];
        int i = 0;
        File arqB = new File("Baralho");
        if(arqB.exists()){
            if(arqB.isDirectory()){
                String listar[] = arqB.list();
                for(String b: listar){
                    Object carta = file.lerArquivo("Baralho", b);
                    if(carta instanceof Carta){
                        c[i++] = (Carta) carta;
                    }                    
                }                                
            }            
        }                
        return c;
    }
    
    /**
     * Salva o baralho no disco rígido.
     * @param p Baralho da partida.
     */
    public void salvarBaralho(Pilha p){        
        for(int i = 0; !p.isEmpty(); i++){
            Carta c = (Carta) p.pop();
            file.salvarArquivo(c, "Baralho", Integer.toString(i+1), "brlh");            
        }        
    }
    
    /**
     * Recupera os jogadores salvos no disco rígido.
     * @return Lista encadeada de jogadores.
     * @throws ClassNotFoundException
     */
    public ListaEncadeada jogadoresSalvos() throws ClassNotFoundException{
        ListaEncadeada list = new ListaEncadeada();
        File arq = new File("Players");
        if(arq.exists()){
            if(arq.isDirectory()){
                String listarDiretorio[] = arq.list();
                for(String diret: listarDiretorio){    
                    Object o = file.lerArquivo("Players", diret);
                    if(o instanceof Jogador){
                        list.insereInicio(o);
                    }                             
                }
            }
        }        
        return list;
    }
    
    /**
     * Salva os jogadores no disco rígido.
     * @param players Lista encadeada de jogadores.
     */
    public void salvarJogadores(ListaEncadeada players){
        ListaEncadeada aux = players;
        Iterador it = aux.iterador();
        while(it.temProximo()){
            Jogador j = (Jogador) it.proximo();
            file.salvarArquivo(j, "Players", j.getUser(), "player");
        }
    }

    
}