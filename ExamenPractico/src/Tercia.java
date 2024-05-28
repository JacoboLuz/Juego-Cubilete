import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tercia implements Combinacion {//implementando la interface Combinacion, tenemos la clase Poker
    //Esta clase comprobará si los dados otorgados poseen una Tercia
    @Override
    public boolean evaluar(List<String> dados) { //al igual que el resto de clases de dicha interfaz
        Map<String, Integer> contadorDados = new HashMap<>(); //tras generar un HashMap
        for (String dado : dados) {
            contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
        }
        for (int conteo : contadorDados.values()){
            if(conteo >= 3){ //se va a buscar algún número que se repita al menos 3 veces
                return true; //para poder retornar verdadero
            }
        }
        return false; //o falso en caso de que no exista
    }
    @Override
    public int puntos(List<String> dados,int modo) { //mientras que en el método de puntos
        Juego juego=new Juego();
        //al igual que el resto de métodos
        if (evaluar(dados)) {
            Map<String, Integer> contadorDados = new HashMap<>();
            for (String dado : dados) {
                contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
            }
            //tras conseguir los datos del HashMap
            for (Map.Entry<String, Integer> entry : contadorDados.entrySet()) {
                if (entry.getValue() == 3) { //se busca el valor que aparezca tres veces
                    String valorDado = entry.getKey(); //se guarda en una variable
                    int valor = juego.regresarValores(valorDado,modo,dados); //se busca su valor
                    return valor; //y se regresa
                }
            }
        }
        return 0;
    }
}

