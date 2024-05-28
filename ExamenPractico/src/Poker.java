import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Poker implements Combinacion { //implementando la interface Combinacion, tenemos la clase Poker
    //Esta clase comprobará si los dados otorgados poseen un "Poker"
    @Override
    public boolean evaluar(List<String>dados){ //el método evaluar en esta clase
        //seguirá los mismos pasos de las clases del resto de las clases que utilizan dicha interface
        Map<String, Integer> contadorDados = new HashMap<>();
        for (String dado : dados) {
            contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
        }
        for (int conteo : contadorDados.values()) { //solo que en este caso, nos aseguraremos de
            if(conteo==4){ //que existan 4 valores exactamente iguales
                return true;
            }
        }
        return false;
    }

    @Override
    public int puntos(List<String> dados,int modo) { //en el método de puntos
        Juego juego=new Juego();
        if (evaluar(dados)) {
            Map<String, Integer> contadorDados = new HashMap<>();
            for (String dado : dados) {
                contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
            }
            //después de generar nuestro HashMap
            for (Map.Entry<String, Integer> entry : contadorDados.entrySet()) {
                if (entry.getValue() == 4) { //tan solo buscamos que valor se repite 4 veces
                    String valorDado=entry.getKey(); //buscamos su "key"
                    int valor=juego.regresarValores(valorDado,modo,dados); //buscamos el valor que le corresponde
                    return valor; //y lo regresamos
                }
            }
        }
        return 0;
    }
}


