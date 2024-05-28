import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DosPares implements Combinacion{ //implementando la interface Combinacion, tenemos la clase DosPares
    //Esta clase comprobará si los dados otorgados poseen dos pares
    @Override
    public boolean evaluar(List<String> dados) { //en el método de evaluar
        Map<String,Integer>contadorDados=new HashMap<>(); //generamos un nuevo HashMap
        for(String dado:dados){ //según todos los dados en la lista
            //iremos analizando los datos otorgados
            contadorDados.put(dado, contadorDados.getOrDefault(dado, 0)+1);
        }
        for(int conteo:contadorDados.values()){//en otro ciclo for, con todos los datos ya adquiridos
            if(conteo>=2){ //tan solo buscamos si existen dos pares
                return true;//y regresamos verdadero
            }
        }
        return false; //en caso de que no sea así, retornamos falso
    }

    @Override
    public int puntos(List<String> dados,int modo){ //en el método de puntos
        Juego juego=new Juego(); //creamos un nuevo objeto "Juego"
        if(evaluar(dados)){ //en caso de que hayan existido dos pares
            Map<String, Integer> contadorDados = new HashMap<>(); //creamos otro HashMap
            for (String dado:dados){ //que realizará lo mismo que el anterior
                contadorDados.put(dado,contadorDados.getOrDefault(dado,0)+1);
            }
            //creamos una variable para revisar cual es el par mayor
            String parMayor=null;
            int m=0;

            for(Map.Entry<String,Integer>entry:contadorDados.entrySet()){ //en base a nuestro contador
                if(entry.getValue()>=m){ //buscamos aquellos que se repiten y que son mas grandes
                    parMayor=entry.getKey(); //para luego almacenarlos en variables
                    m=entry.getValue();
                }
            }
            int valor=juego.regresarValores(parMayor, modo,dados); //una vez hecho,
            // solo conseguimos el valor que le corresponde
            return valor; //y retornamos el valor
        }
        return 0;
    }
}

