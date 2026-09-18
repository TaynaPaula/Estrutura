package model.estrutura;
import model.estrutura.No;
import java.lang.Exception;

public class Pagina<P> {

    private String script = "/umscript.py";
    private String input = "{}";
    private String id = "";
    // construtor + GET e SET de todos os atributos
    public Pagina(String script,String input,String id ) {
        this.script =script;
        this.input=null;
        this.id=null;
    }
    public String getScript(){
        return  script;
    }
    public  void setScript(){
        this.script=script;
    }

    public P getinput(){
        return input;
    }



}
