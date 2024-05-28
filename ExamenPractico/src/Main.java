import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

public class Main { //dentro de nuestra clase main
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //abriremos un scanner
        //y luego agregaremos todas las variables que usaremos
        Set<String> palabras = new HashSet<>();
        Juego juego;
        List<Jugador> listaJugadores= new ArrayList<>();
        int rondas=0; int modo=0; int jugadores=0;
        String[] caras = {"9", "10", "J", "Q", "K", "As"};

        //Empezamos explicando al usuario los modos que existen
        System.out.println("Bienvenido a el juego del cubilete. Ingrese el modo en el que desea jugar: ");
        System.out.println("1.-Modo normal");
        System.out.println("2.-Modo con colores");
        System.out.println("3.-Modo con letras");
        System.out.println("4.-Modo con palabras");
        System.out.println("5.-Salir");
        do{ //Para no llenar la consola, opté por cerrar el programa una vez el usuario haya jugado una
            //vez o haya seleccionado la opción para salir
            System.out.print(">>");
            if (s.hasNextInt()) { //si el usuario escribió un número
                modo = s.nextInt();
                if(modo<1 || modo>5){ //se buscará si se encuentra en el rango establecido
                    System.out.println("Opción incorrecta.");
                }
            }else{ //de lo contrario, se le indicará al usuario
                System.out.println("Verifique su respuesta.");
                s.next(); modo=0;
            }
        }while(modo<1 || modo>5);

        if(modo!=5) { //siempre y cuando el usuario no haya seleccionado la opción para salir
            System.out.print("Ingrese la cantidad de jugadores a jugar (2-4): "); //se le preguntará la
            // cantidad de jugadores
            do {
                if (s.hasNextInt()) { //verificando una vez más los datos ingresados
                    jugadores = s.nextInt();
                    if (jugadores < 2 || jugadores > 4) {
                        System.out.println("Opción incorrecta.");
                        System.out.print(">>");
                    }
                } else {
                    System.out.println("Verifique su respuesta.");
                    System.out.print(">>");
                    s.next();
                    jugadores = 0;
                }
            } while (jugadores < 2 || jugadores > 4);
            for(int i=0;i<jugadores;i++){ //los nombres de cada jugador
                System.out.print("Ingrese el nombre para el jugador "+ (i+1)+ ": ");
                String nombre=s.next();
                listaJugadores.add(new Jugador(nombre));
            }

            System.out.print("Ingrese la cantidad de rondas: "); //y la cantidad de rondas
            do {
                if (s.hasNextInt()) { //para volver más "entretenido" el programa, opté por agregar un
                    //mensaje diferente en cada situación
                    rondas = s.nextInt();
                    if (rondas<=0){
                        System.out.println("Por chistosito el juego ha terminado.");
                        modo=5; rondas=1;
                        abrirEnlace("https://youtu.be/NNv2RHR62Rs?si=tcJJGZiU3EM2Jad4");
                        //así como una pequeña sorpresa en caso de que alguien deseara escribir un número
                        //menor a 1
                    }
                    else if (rondas==1){
                        System.out.println("¿Solo una ronda? De acuerdo.");
                    }
                    else if(rondas==15){
                        System.out.println("¿No tienen nada mejor que hacer? De acuerdo.");
                    }
                    else if(rondas>30){ //he establecido como límite el 30, para que no sea posible
                        //ingresar números gigantescos
                        System.out.println("¿Tan aburridos se encuentran?");
                        System.out.print(">>");
                    }
                }else{
                    System.out.println("Verifique su respuesta.");
                    System.out.print(">>");
                    s.next();
                    rondas = 0;
                }
            }while (rondas < 1 || rondas>30);

            System.out.println("------------");
        }

        switch (modo){ //según el modo establecido
            case 1: //se determinará si los valores se mantienen igual
                System.out.println("1.-Modo normal");
                juego=new Juego();
                juego.setModo(1);
                for(int i=0;i<rondas;i++){
                    juego.turno(listaJugadores); //llamando a la función de turnos en "Juego"
                } //dentro de un for
                juego.determinarGanador(listaJugadores); //así como a la función que mostrará el ganador
                break;
            case 2:
                System.out.println("2.-Modo con colores");
                juego=new Juego();
                juego.setModo(2);
                for(int i=0;i<rondas;i++){
                    juego.turno(listaJugadores);
                }
                juego.determinarGanador(listaJugadores);
                break;
            case 3: //o si se modificaran los datos
                System.out.println("3.- Modo con letras");
                System.out.println("A continuación ingresará las letras con las que jugará:");
                //en el caso 3, por ejemplo, pediremos cada una de las letras
                for (int i = 0; i < 6; i++) {
                    System.out.print(caras[i] + " será representado con la letra: ");
                    while (true) {
                        String caracter = s.next();
                        //está validado para descubrir si la letra ya fue ingresada o si realmente es una letra
                        //y no un número o palabra
                        if(caracter.length()==1 && Character.isLetter(caracter.charAt(0))) {
                            String letra=caracter.toLowerCase();
                            if(!palabras.contains(letra)){
                                palabras.add(letra);
                                break;
                            } else {
                                System.out.println("La letra ya fue utilizada.");
                                System.out.print(">>");
                            }
                        } else {
                            System.out.println("Solo se permite una letra.");
                            System.out.print(">>");
                        }
                    }
                }
                //dichas letras se almacenarán
                List<String> listaLetras =new ArrayList<>(palabras);
                DadoLetra dadoLetra=new DadoLetra();
                dadoLetra.setValores(listaLetras);
                juego=new Juego();
                juego.setModo(3);
                juego.setDados(listaLetras); //se enviaran a el juego respectivo
                for(int i=0;i<rondas;i++){ //y continuará con normalidad
                    juego.turno(listaJugadores);
                }
                juego.determinarGanador(listaJugadores);
                break;
            case 4:
                System.out.println("4.-Modo con palabras");
                System.out.println("A continuación ingresará las palabras con las que jugará: ");
                //mientras que en el caso 4
                for (int i=0;i<6;i++) {
                    System.out.print(caras[i] + " será representado con la palabra: ");
                    while (true) {
                        String palabra = s.next();
                        //se le pedirá al usuario una palabra
                        //Este ciclo también está validado, pero solo para saber si la palabra ya fue utilizada.
                        //Es posible ingresar números o un solo caracter
                        if (!palabras.contains(palabra)) {
                            palabras.add(palabra);
                            break;
                        } else {
                            System.out.println("La palabra ya fue utilizada.");
                            System.out.print(">>");
                        }
                    }
                }
                List<String> listaPalabras=new ArrayList<>(palabras);
                //DadoPalabra dadoPalabra=new DadoPalabra();
                //dadoPalabra.setValores(listaPalabras);
                juego=new Juego();
                juego.setModo(4);
                juego.setDados(listaPalabras); //también se le enviará a su respectivo juego
                for(int i=0;i<rondas;i++){ //y continuará con normalidad
                    juego.turno(listaJugadores);
                }
                juego.determinarGanador(listaJugadores);
                break;
            case 5:
                System.out.println("Gracias por su tiempo."); //en caso de que el programa termine,
                //se despedirá del usuario
                break;
            default:
                System.out.println("Si ves esto es porque hiciste algo mal, Luz."); //y como default,
                // dejé un mensaje para asegurarme de que estuviera haciendo todo correctamente
                break;
        }
    }



    //Para un pequeño easter-egg, he decidido agregar la siguiente función
    public static void abrirEnlace(String url) {
        if (Desktop.isDesktopSupported()) { //investiga si es posible abrir una url
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url)); //para luego abrirla
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Te salvaste."); //en caso de que no sea posible, soltará un mensaje
        }
    }
}