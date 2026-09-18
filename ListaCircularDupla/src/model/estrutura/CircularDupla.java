package model.estrutura;
import model.estrutura.No;
public class CircularDupla <T> {
    private No<T> ultimo_elemento=null;
    public void adicionar (String elemento){
        No<String> novo =new No<String>(elemento);
        if(this.ultimo_elemento ==null){
            this.ultimo_elemento =novo;
            novo.setProximo(novo);
            novo.setAnterior(novo);
        }else{
            No<T> buffer_ultimo =this.ultimo_elemento;
            No<T> buffer_proximo =this.ultimo_elemento.
                    getProximo();
            novo.setAnterior(buffer_ultimo);
            novo.setProximo( buffer_ultimo);
            buffer_proximo.setAnterior(novo);
            buffer_ultimo.setProximo(novo);
            this.ultimo_elemento=novo;
        }
    }
}
