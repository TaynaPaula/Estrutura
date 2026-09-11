package model.estrutura;
/*append: adiciona um novo elemento após o último adicionado;
 GETLAST: retorna a referência do último elemento adicionado;
 REMOVE: remove um elemento; tem uma sobrecarga de métodos na qual
 um dos métodos pode remover qualquer elemento e outro remove
 sempre o último adicionado;
 total: um contador de elementos adicionados.*/
import java.lang.Exception;
import model.estrutura.No;
public class CircularDupla <T> {
    private No<T> ultimo_elemento =null;
    public No<T> total_nos=null;//

    public void append(T elemento){
        No<T> novo=new No<>(elemento);
        if (this.ultimo_elemento== null) {
            this.ultimo_elemento = novo;
            novo.setProximo(novo);
            novo.setAnterior(novo);
        } else {
            No<T> buffer_ultimo = this.ultimo_elemento;
            No<T> buffer_proximo = this.ultimo_elemento.getProximo();
            novo.setAnterior(buffer_ultimo);
            novo.setProximo(buffer_proximo);
            buffer_proximo.setAnterior(novo);
            buffer_ultimo.setProximo(novo);
            this.ultimo_elemento = novo;

        }
        this.total_nos++;//
    }
    public No<T> getLast() throws IllegalArgumentException{
        if(this.ultimo_elemento == null)// se a lista esta vazia ele
            throw new IllegalArgumentException("Nao existe item na lista");
        return this.ultimo_elemento;
    }
    public void remove(No<T> remover){
        No<T> anterior = remover.getAnterior();
        No<T> proximo = remover.getProximo();
        if (this.ultimo_elemento == remover && anterior == remover && proximo == remover){
            //somente 1 elemento da lista
            this.ultimo_elemento=null;
            return;
        }
        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
        if (this.ultimo_elemento == remover){
            this.ultimo_elemento = anterior;
        }
        remover.setProximo( null );
        remover.setAnterior( null );
        remover.setValor( null );
        this.total_nos--;//
    }
    public void remove() throws IllegalArgumentException
    {
        remove( getLast() );
    }
    public int total() {
        if (this.ultimo_elemento == null)
            return 0;
        No<T> buffer = this.ultimo_elemento;
        int total_elementos = 0;
        do{
            total_elementos++;
            buffer = buffer.getProximo();
        } while( buffer != this.ultimo_elemento );
        return total_elementos;
    }
    @Override
    public String toString() {
        if ( this.ultimo_elemento == null ) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.ultimo_elemento;
        builder.append(buffer.getValor());
        while( buffer.getProximo() != this.ultimo_elemento){
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }

}







