import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] mazo = crearMatrizCartas();
        ejecutarMenu(mazo);
    }

    public static void ejecutarMenu(String[][] mazo) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, mazo);
        } while (opcion != 4);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú del juego de cartas:");
        System.out.println("1. Agregar cartas al mazo");
        System.out.println("2. Usar un mazo predeterminado");
        System.out.println("3. Jugar el juego");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 4) { // Fix range check
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }
    public static String leerString(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion, String[][] mazo) {
        switch (opcion) {
            case 1:
                String nombreCarta = leerString("Ingrese el nombre de la carta: ");
                String puntaje = leerString("Ingrese el puntaje de la carta: ");
                agregarCartas(mazo,nombreCarta,puntaje);
                break;
            case 2:
                inicializarCartasJuego(mazo);
                break;
            case 3:
                jugar(mazo);
                break;
            case 4:
                imprimirMatriz(mazo);
                salir();
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static String[][] crearMatrizCartas() {
        String[][] mazo = new String[12][2];
        return mazo;
    }

    public static String[][] inicializarCartasJuego(String[][] mazo) {
        String[][] mazoTest = {
                {"Carta 2", "2"},
                {"Carta 3", "3"},
                {"Carta 4", "4"},
                {"Carta 5", "5"},
                {"Carta 6", "6"},
                {"Carta 7", "7"},
                {"Carta 8", "8"},
                {"Carta 9", "9"},
                {"Carta A", "11"},
                {"Carta J", "10"},
                {"Carta Q", "10"},
                {"Carta K", "10"}
        };
        for (String[] carta : mazoTest) {
            agregarCartas(mazo, carta[0], carta[1]);
        }
        return mazo;
    }

    public static void agregarCartas(String[][] mazo, String nombreCarta, String puntaje) {
        for (int i = 0; i < mazo.length; i++) {
            if (mazo[i][0] == null) {
                mazo[i][0] = nombreCarta;
                mazo[i][1] = puntaje;
                System.out.println("Carta agregada: " + nombreCarta + " con puntaje " + puntaje);
                return;
            }
        }
        System.out.println("El mazo está lleno. No se puede agregar más cartas.");
    }

    public static String[] sacarCartaAleatoria(String[][] mazo) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(mazo.length);
        return mazo[indiceAleatorio];
    }
    public static void jugar(String[][] mazo) {
        int puntajeJugador1 = obtenerCartas(mazo);
        int puntajeJugador2 = obtenerCartas(mazo);
        System.out.println("Puntaje jugador 1: " + puntajeJugador1);
        System.out.println("Puntaje jugador 2: " + puntajeJugador2);
        decidirGanador();
    }
    public static void decidirGanador(){

    }
    public static void salir(){
        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        System.exit(0);
    }
    public static int obtenerCartas(String[][] mazo) {
        int puntaje = 0;
        for (int i = 0; i < 3; i++) {
            String valorCarta = mazo[sacarNumeroAleatorio()][1];
            puntaje += Integer.parseInt(valorCarta);
        }
        return puntaje;
    }
    public static int sacarNumeroAleatorio() { //Generar un número aleatorio entre 0 y 11
        Random random = new Random();
        return random.nextInt(12);
    }
    public static void imprimirMatriz(String[][] matriz) {
        for (String[] fila : matriz) {
            for (String elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}