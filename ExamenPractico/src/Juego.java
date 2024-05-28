import java.util.*;
public class Juego { //Creamos la clase Juego
    //declaramos todas las variables a utilizar
    int modo=0;
    Scanner scanner = new Scanner(System.in);
    List<String> dados;
    List<String> dadosJugador;
    public void agregarPuntos(Jugador jugador){ //el método agregarPuntos
        //nos ayudará a ir sumando los puntos de cada jugador
        System.out.println("El jugador "+jugador.getNombre()+" ha ganado esta ronda!");
        int p=jugador.getPuntos()+1;
        jugador.setPuntos(p);
    }
    public void turno( List<Jugador> listaJugadores){ //el método turno
        //nos apoyará a administrar las acciones de cada turno
        for(Jugador jugadores: listaJugadores){ //según nuestra lista de jugadores, abrimos un ciclo for
            dadosJugador=new ArrayList<>();
            System.out.println("-Turno del jugador "+jugadores.getNombre()+":");
            System.out.print("| ");
            switch(getModo()){ //y dependiendo del modo
                case 1:
                    for(int i=0;i<5;i++){ //abriremos un ciclo for
                        DadoColor dado =new DadoColor(); //generaremos el objeto que le corresponda
                        String v=dado.tirar(); //tomaremos un valor al azar
                        System.out.print(v+" | "); //lo imprimiremos en consola
                        dadosJugador.add(v); //y lo agregaremos a la lista de dados del jugador
                    }
                    break;
                case 2:
                    for(int i=0;i<5;i++){
                        DadoColor dadoC =new DadoColor();
                        String valor= dadoC.tirar();
                        String color=dadoC.colores(valor);
                        System.out.print(color+valor+"\u001B[0m | ");
                        dadosJugador.add(valor);
                    }
                    break;
                case 3:
                    for(int i=0;i<5;i++){
                        DadoLetra dadoLetra=new DadoLetra();
                        dadoLetra.setValores(dados);
                        String vLetra =dadoLetra.tirar();
                        System.out.print(vLetra +" | ");
                        dadosJugador.add(vLetra);
                    }
                    break;
                case 4:
                    for(int i=0;i<5;i++){
                        DadoPalabra dadoPalabra=new DadoPalabra();
                        dadoPalabra.setValores(dados);
                        String vPalabra=dadoPalabra.tirar();
                        System.out.print(vPalabra+" | ");
                        dadosJugador.add(vPalabra);
                    }
                    break;
            }
            System.out.println("\n....");
            jugadores.setDados(dadosJugador); //guardamos sus dados en donde corresponde
            scanner.nextLine(); //pausamos el programa
        }
        comparar(listaJugadores); //y mandamos a hablar al método comparar una vez terminado el for
        scanner.nextLine();
    }

    public void comparar(List<Jugador> listaJugadores){ //en el método de comparar
        int valores[]=new int[listaJugadores.size()]; int i=0;
        int total[]=new int[listaJugadores.size()];
        int im=0;
        for(Jugador jugadores: listaJugadores){ //según los jugadores que tenemos, abrimos un ciclo for
            //System.out.println("Jugador "+jugadores.getNombre()+": "+jugadores.getDados());
            //y generamos un objeto para cada una de las posibles combinaciones
            Quintilla quintilla=new Quintilla();
            Poker poker=new Poker();
            Full full=new Full();
            Tercia tercia=new Tercia();
            DosPares dosPares=new DosPares();
            UnPar unPar=new UnPar();
            //los acomodamos en orden de mayor a menor por comodidad
            if(quintilla.evaluar(jugadores.getDados())==true){ //y en caso de de que sea verdadero
                total[i]=quintilla.puntos(jugadores.getDados(),getModo()); //guardamos el valor más alto de
                //dicha combinacion
                valores[i]=6; //así como el valor que le corresponde
            }else if(poker.evaluar(jugadores.getDados())==true){
                total[i]=poker.puntos(jugadores.getDados(),getModo());
                valores[i]=5;
            }else if(full.evaluar(jugadores.getDados())==true){
                total[i]=full.puntos(jugadores.getDados(),getModo());
                valores[i]=4;
            }else if(tercia.evaluar(jugadores.getDados())==true){
                total[i]=tercia.puntos(jugadores.getDados(),getModo());
                valores[i]=3;
            }else if(dosPares.evaluar(jugadores.getDados())==true){
                total[i]=dosPares.puntos(jugadores.getDados(),getModo());
                valores[i]=2;
            }else if(unPar.evaluar(jugadores.getDados())==true){
                total[i]=unPar.puntos(jugadores.getDados(),getModo());
                valores[i]=1;
            }else{ //en caso de que no haya existido ninguna combinación
                total[i]=0; //dejamos en cero ambos valores
                valores[i]=0;
            }
            //System.out.println(valores[i]); System.out.println(total[i]);
            i++; //mantenemos sumando el contador de nuestras matrices
        }
        //declaramos como puntos máximos los primeros valores antes de empezar
        int puntosMax=valores[0];
        int totalMax =total[0];
        for(int j=1;j<valores.length;j++){ //abriendo un ciclo for
            if(valores[j]>puntosMax){ //empezamos a comparar que puntos son los mayores
                puntosMax=valores[j];//e iremos editando las variables ya mencionadas
                totalMax=total[j];
                im=j; //además de un índice que guardará donde se encuentra dicho valor
            }else if(valores[j]==puntosMax){ //aunque en caso de que se encuentre un valor exactamente igual
                if(total[j]>totalMax){ //se comparará con el valor mayor
                    totalMax=total[j]; //y se guardará en las variables ya mencionadas
                    im=j;
                }
            }
        }
        agregarPuntos(listaJugadores.get(im)); //al finalizar, solo se le hablará al método para agregar puntos
    }
    public int regresarValores(String valor,int modo,List<String> dados){ //el método de regresarValores
        //es bastante simple. En base a el valor otorgado, el modo de juego y la lista de dados, generará
        //el valor que le corresponde.
        switch(modo){
            case 1:
                switch (valor){
                    case "9":
                        return 1;
                    case "10":
                        return 2;
                    case "J":
                        return 3;
                    case "Q":
                        return 4;
                    case "K":
                        return 5;
                    case "As":
                        return 6;
                }
                break;
            case 2:
                switch (valor){
                    case "9":
                        return 1;
                    case "10":
                        return 2;
                    case "J":
                        return 3;
                    case "Q":
                        return 4;
                    case "K":
                        return 5;
                    case "As":
                        return 6;
                }
                break;
            case 3:
                for(int i=0;i<dados.size();i++){
                    if(valor.equals(dados.get(i))){
                        switch(i){
                            case 0:
                                return 1;
                            case 1:
                                return 2;
                            case 2:
                                return 3;
                            case 3:
                                return 4;
                            case 4:
                                return 5;
                            case 5:
                                return 6;
                        }
                    }
                }
                break;
            case 4:
                for(int i=0;i<dados.size();i++){
                    if(valor.equals(dados.get(i))){
                        switch(i){
                            case 0:
                                return 1;
                            case 1:
                                return 2;
                            case 2:
                                return 3;
                            case 3:
                                return 4;
                            case 4:
                                return 5;
                            case 5:
                                return 6;
                        }
                    }
                }
                break;
        }
        return 0;
    }
    public void determinarGanador(List<Jugador> listaJugadores){ //el método de determinar ganador
        Jugador ganador=listaJugadores.get(0); //tomará el primer jugador
        for(Jugador jugador:listaJugadores){ //para luego, dentro de un ciclo for
            if(jugador.getPuntos()>ganador.getPuntos()){ //compararlo con el resto de puntos de los jugadores
                ganador=jugador; //guardando el jugador con mayor puntaje
            }
        }
        System.out.println("El jugador "+ganador.getNombre()+" ha ganado!"); //al finalizar, solo muestra el ganador
    }
    //métodos get y set para las variables de la clase
    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public List<String> getDados() {
        return dados;
    }

    public void setDados(List<String> dados) {
        this.dados = dados;

    }
}
