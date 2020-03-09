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
package blackjack.util;

/**
 * Interface que auxilia no armazenamento de dados em forma de pilha.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public interface IStack {
    
    /**
     * Adiciciona um objeto a pilha.
     * 
     * @param data Objeto que será inserido.
     */
    public void push(Object data);
    
    /**
     * Remove o ultimo objeto adicionado.
     * 
     * @return Objeto removido.
     */
    public Object pop();
    
    /**
     * Pega o ultimo inserido.
     * 
     * @return Primeiro objeto da pilha.
     */
    public Object peek();
    
    /**
     * Verifica se a lista está vazia.
     * 
     * @return True se está vazia, senão, retorna false.
     */
    public boolean isEmpty();
 
}
