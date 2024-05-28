import java.util.HashMap;
import java.util.List;

public class DadoPalabra extends Dado{ //La clase DadoPalabra heredará de la clase Dado
    //Esta clase nos permitirá crear dados con palabras en vez de una simple letra
    //o los valores ya establecidos.
    public DadoPalabra(){
        super();
    } //generamos un constructor vacío con su super()
    public void setValores(List<String> palabras){ //y al igual que en DadoLetra
        HashMap<Integer,String> l =new HashMap<>(); //generamos un HashMap
        for(int i=0;i<palabras.size();i++){ //que permitirá editar los valores por medio de un for
            l.put(i+1,palabras.get(i));
        }
        setValores(l);
    }
}
