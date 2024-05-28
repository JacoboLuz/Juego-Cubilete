import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Full implements Combinacion {//implementando la interface Combinacion, tenemos la clase Full
    //Esta clase comprobará si los dados otorgados poseen un "Full"
    @Override
    public boolean evaluar(List<String>dados){ //usando el método de evaluar
        Map<String,Integer>contadorDados=new HashMap<>();//generamos un nuevo HashMap
        for(String dado:dados){//según todos los dados en la lista
            //iremos analizando los datos otorgados
            contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
        }
        //declaramos dos variables booleanas para confirmar si existen 3 y 2 iguales
        boolean tres=false;
        boolean dos=false;

        for(int conteo:contadorDados.values()){//en otro ciclo for, con todos los datos ya adquiridos
            if(conteo==3){ //comprobaremos si existen 3 valores iguales
                tres=true; //para declarar como verdadera dicha variables
            }else if(conteo==2){ //y comprobaremos si existen otros 2 valores iguales
                dos=true;
            }
        }
        return tres && dos; //y, utilizando el término and, comprobaremos si tenemos un full
    }

    @Override
    public int puntos(List<String> dados,int modo){ //en el método de puntos
        int valor=0; //declaramos la variable de valor
        Juego juego=new Juego(); //creamos un objeto "Juego"
        if (evaluar(dados)){ //en caso de que hayan existido dos pares
            Map<String, Integer> contadorDados=new HashMap<>(); //creamos otro HashMap
            for(String dado:dados){ //que realizará lo mismo que el anterior
                contadorDados.put(dado,contadorDados.getOrDefault(dado, 0)+1);
            }
            //en este método enviaremos el valor de la tercia
            String tercia=null; //por lo que generamos una variable
            for(Map.Entry<String,Integer>entry:contadorDados.entrySet()){
                if(entry.getValue()==3){ //y buscamos el valor que se repite tres veces
                    tercia=entry.getKey();
                }
            }
            valor=juego.regresarValores(tercia,modo,dados); //una vez hecho,
            // solo conseguimos el valor que le corresponde
        }
        return valor; //y retornamos el valor
    }
}
