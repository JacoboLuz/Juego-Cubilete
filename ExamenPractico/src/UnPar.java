import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnPar implements Combinacion{//implementando la interface Combinacion, tenemos la clase UnPar
    //Esta clase comprobará si los dados otorgados poseen un par

    //aprovechandonos de que la clase "DosPares" está acomodada antes de esta, podemos re-utilizar
    //el código de evaluar para determinar si existe al menos un par
    @Override
    public boolean evaluar(List<String> dados) {
        Map<String, Integer> contadorDados = new HashMap<>();
        for (String dado : dados) {
            contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
        }
        for (int conteo:contadorDados.values()) {
            if (conteo>= 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int puntos(List<String> dados,int modo) { //aunque la forma en la que se conseguirá
        //el valor que le corresponde al par es diferente
        Juego juego=new Juego();
        if (evaluar(dados)) {
            Map<String, Integer> contadorDados = new HashMap<>();
            for (String dado : dados) {
                contadorDados.put(dado, contadorDados.getOrDefault(dado, 0) + 1);
            }
            //ya que, después de seguir las mismas instrucciones
            for (Map.Entry<String, Integer> entry : contadorDados.entrySet()) {
                if (entry.getValue() == 2) { //buscaremos aquel valor que se repita dos veces
                    String valorDado = entry.getKey();
                    int valor = juego.regresarValores(valorDado,modo,dados);
                    return valor; //y tras conseguir su valor, lo retornamos
                }
            }
        }
        return 0;
    }
}
