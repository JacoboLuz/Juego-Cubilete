public class DadoColor extends Dado{ //la clase DadoColor heredará de Dado
    //En esta clase mostraremos los dados pero, en vez de que el texto sea blanco,
    //se mostrarán a color en la consola.

    //generamos todos los colores, declarandolos como CONSTANTES, por lo que serán
    //declaradas en mayúsculas.
    public static final String BLANCO = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String TURQUESA = "\u001B[36m";
    public String valor; //y generaremos una variable para el valor

    public DadoColor(){
        super();
    } //declaramos su constructor vació con super()

    public DadoColor(String valor) { //y declaramos otro que pedirá el valor
        super();
        this.valor = valor;
    }

    public String colores(String valor){ //creamos un método para los colores
        //Este método se encargará de retornar la constante con el color que le corresponde
        switch(valor){ //por lo que usaremos un "switch"
            case "9": //y dependiendo del caso
                return ROJO; //regresaremos la constante
            case "10":
                return VERDE;
            case "J":
                return AMARILLO;
            case "Q":
                return AZUL;
            case "K":
                return MORADO;
            case "As":
                return TURQUESA;
            default: //agregamos un default a nuestro switch
                return BLANCO; //el cual nos dará el color blanco normal de la consola
        }
    }
}
