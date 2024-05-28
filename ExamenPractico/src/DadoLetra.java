import java.util.HashMap;
import java.util.List;
public class DadoLetra extends Dado{ //DadoLetra heredará de Dado
    //Esta clase se encargará de crear un dado que aceptará solamente una letra.
    public DadoLetra(){
        super();
    }//generamos un constructor vacío junto su super
    public void setValores(List<String> letras){ //creamos un método que permitirá editar los valores
        HashMap<Integer,String> let =new HashMap<>(); //usando un nuevo HashMap llamado "let"
        for(int i=0;i<letras.size();i++){ //abrimos un ciclo for
            let.put(i+1,letras.get(i));//el cual permitirá guardar uno por uno los valores
            //agregados por el usuario
        }
        setValores(let); //usando el método "setValores" de Dado, editamos los valores
    }
}
