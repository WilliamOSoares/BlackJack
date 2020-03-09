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

import java.io.Serializable;

/**
 * Classe responsavel para auxiliar a manipulação de dados.
 * 
 * @author Samuel Ramos, William Oliveira
 */
public class Pilha implements IStack, Serializable{
    
    private Celula head;
    
    private class Celula{
        
        private Object info;
        private Celula prox;
        
        public Celula(Object info){
            this.info = info;
        }
        
        public Celula getProx(){
            return prox;
        }
        
        public void setProx(Celula prox){
            this.prox = prox;
        }
        
        public Object getInfo(){
            return info;
        }
        
        public void setInfo(Object info){
            this.info = info;
        }
        
    }

    @Override
    public void push(Object info) {
        Celula aux = head;
        head = new Celula(info); 
        head.setProx(aux);
    }

    @Override
    public Object pop() {
        if(! isEmpty()) {
            Celula temp = head; 
            head = head.getProx();
            return temp.getInfo();
        }
        return null; 
    }

    @Override
    public Object peek() {
        if(isEmpty()) {
            return null;
        }else{
            return head.getInfo();
        }        
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
}
