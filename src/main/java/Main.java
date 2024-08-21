import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] mazo1 = crearMatrizCartas();
        String[][] mazo2 = crearMatrizCartas();
    }

    public static void ejecutarMenu(String vinilos[][]) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, vinilos);
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú del juego de cartas:");
        System.out.println("1. Agregar vinilo");
        System.out.println("2. Mostrar total de vinilos");
        System.out.println("3. Mostrar espacios disponibles");
        System.out.println("4. Borrar un vinilo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
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

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion, String[][] vinilos) {
        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static String[][] crearMatrizCartas() {
        String[][] mazo = new String[12][2];
        return mazo;
    }

    public static void inicializarCartasJuego(String[][] mazo) {
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
}