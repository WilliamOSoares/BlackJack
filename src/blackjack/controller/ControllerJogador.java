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
import blackjack.util.Iterador;
import blackjack.util.ListaEncadeada;

/**
 * Classe responsável pelo armazenamento de jogadores. 
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class ControllerJogador {
    private ListaEncadeada jogadores = new ListaEncadeada();

    /**
     * Pega todos os jogadores do programa.
     * 
     * @return Retorna uma lista encadeada com todos os jogadores.
     */
    public ListaEncadeada getJogadores() {
        return jogadores;
    }

    /**
     * Faz a modificação da lista de jogadores pelos jogadores que foram lidos no arquivo.
     * @param jogadores Lista de jogadores.
     */
    public void setJogadores(ListaEncadeada jogadores) {
        this.jogadores = jogadores;
    }
    
    /**
     * Pega um jogador do banco de dados.
     * 
     * @param user Nome do jogador.
     * @param password Senha do jogador.
     * @return Jogador se o encontrá-lo, senão null.
     */
    public Jogador getJogador(String user, String password){
        Iterador it = jogadores.iterador();
        while(it.temProximo()){
            Jogador aux = (Jogador) it.proximo();
            if(user.equals(aux.getUser())){
                if(password.equals(aux.getSenha())){
                    return aux;
                }
            }
        }
        return null;
    }
    
    /**
     * Cadastra o jogador no banco de dados.
     * 
     * @param user Nome do usuário.
     * @param senha Senha do usuário.
     * @return True se cadastrar jogador e false se ja existe o jogador.
     */
    public boolean cadastrarJogador(String user, String senha){
        if(!existeJogador(user)){            
            Jogador j = new Jogador(user, senha);
            jogadores.insereFinal(j);
            return true;
        }
        return false;
    }
    
    /**
     * Verifica a existência do jogador no banco de dados.
     * 
     * @param user Nome do usuário.
     * @return Verdadeiro se existe e falso se não existe.
     */
    public boolean existeJogador(String user){
        Iterador it = jogadores.iterador();
        while(it.temProximo()){
            Jogador aux = (Jogador) it.proximo();
            if(user.equals(aux.getUser())){
                return true;
            }
        }
        return false;
    }
}
