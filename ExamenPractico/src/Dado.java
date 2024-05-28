import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

abstract class Dado { //creamos una clase abstracta
    protected HashMap<Integer,String>valores; //creamos un HashMap para los valores

    public Dado() { //creamos un constructor
        valores=new HashMap<Integer, String>(); //el cual generará todos los valores dentro de un HashMap
        valores.put(1,"9");
        valores.put(2,"10");
        valores.put(3,"J");
        valores.put(4,"Q");
        valores.put(5,"K");
        valores.put(6,"As");
    }

    //métodos get y set para los valores
    public HashMap<Integer, String> getValores() {
        return valores;
    }
    public void setValores(HashMap<Integer, String> valores) {
        this.valores = valores;
    }

    public String tirar(){ //método String que nos permitirá tirar el dado
        List<Integer> key=new ArrayList<>(valores.keySet()); //creamos un ArrayList con las "key" del HashMap
        //es decir, el primer valor que vemos en el HashMap
        Random rand=new Random(); //generamos un nuevo objeto random
        int randInd=rand.nextInt(key.size()); //usando como base las "key" del HashMap, generamos un número aleatorio
        int randKey=key.get(randInd); //tomamos dicho número
        return valores.get(randKey); //y lo buscamos en nuestro arreglo de valores para retornarlo
    }
}
