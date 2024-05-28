import java.util.List;

class Quintilla implements Combinacion {//implementando la interface Combinacion, tenemos la clase Quintilla
    //Esta clase comprobará si los dados otorgados poseen una Quintilla
    @Override
    public boolean evaluar(List<String> dados){ //en este caso, el método evaluar será diferente al resto de las clases
        //que implementan una interface
        String primerDado = dados.get(0); //puesto que tomaremos el primer dado
        for (String dado : dados) {
            if (!dado.equals(primerDado)) { //y luego buscaremos si coincide con el resto de los dados
                return false; //en caso de que no sea así, solo retornamos false
            }
        }
        return true; //pero si logra terminar el ciclo, entonces enviaremos un true
    }

    @Override
    public int puntos(List<String> dados,int modo) { //dentro del método de puntos
        Juego juego=new Juego();
        if (evaluar(dados)) {
            String primerDado = dados.get(0); //solo conseguimos el primer dado
            int valor = juego.regresarValores(primerDado,modo,dados); //conseguimos el valor que le corresponde
                return valor; //y regresamos su valor
        }
        return 0;
    }
}

