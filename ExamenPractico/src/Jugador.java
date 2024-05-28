import java.util.ArrayList;
import java.util.List;

public class Jugador { //dentro de la clase Jugador
    //almacenaremos todos los valores que le correspondan al usuario
    int puntos;
    String nombre;
    List<String> dados;

    public Jugador(String nombre) { //abrimos un constructor que pedirá el nombre
        this.nombre = nombre;
        puntos=0;
    }
    //Y solo agregamos métodos set y get para cada característica
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getDados() {
        return dados;
    }

    public void setDados(List<String> dados) {
        this.dados = dados;
    }


}
