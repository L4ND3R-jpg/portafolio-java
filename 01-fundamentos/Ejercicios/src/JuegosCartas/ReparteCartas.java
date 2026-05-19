package JuegosCartas;

import java.util.Arrays;
/**
 * Clase que simula un reparto de cartas de la baraja española entre dos jugadores.
 * Se realizan 10 jugadas, repartiendo 4 cartas a cada jugador por jugada.
 * Al final se determina un ganador según una carta aleatoria ganadora.
 */
public class ReparteCartas {

    // Baraja española completa (40 cartas)
    // O=Oros, C=Copas, E=Espadas, B=Bastos | S=Sota, C=Caballo, R=Rey
    private static final String[] CARTAS = {
        "1O", "2O", "3O", "4O", "5O", "6O", "7O", "SO", "CO", "RO",
        "1C", "2C", "3C", "4C", "5C", "6C", "7C", "SC", "CC", "RC",
        "1E", "2E", "3E", "4E", "5E", "6E", "7E", "SE", "CE", "RE",
        "1B", "2B", "3B", "4B", "5B", "6B", "7B", "SB", "CB", "RB"
    };

    private static final int TOTAL_CARTAS = CARTAS.length - 1; // 0-39
    private static final int NUM_JUGADAS  = 10;
    private static final int CARTAS_POR_JUGADOR = 4;

    /**
     * Constructor: ejecuta la lógica completa del juego.
     */
    public ReparteCartas() {
        int[][] jugadas = generarJugadas();
        mostrarJugadas(jugadas);

        int cartaGanadora = aleatorio(0, TOTAL_CARTAS);
        System.out.println("\nCARTA GANADORA: [" + cartaGanadora + "] " + CARTAS[cartaGanadora]);

        determinarGanador(jugadas, cartaGanadora);
    }

    // ─── MÉTODOS PRIVADOS ────────────────────────────────────────────────────────

    /**
     * Genera las jugadas: 10 rondas con 8 cartas únicas cada una (4 por jugador).
     *
     * @return Matriz de jugadas [10][8]
     */
    private int[][] generarJugadas() {
        int[][] jugadas = new int[NUM_JUGADAS][];
        for (int i = 0; i < NUM_JUGADAS; i++) {
            jugadas[i] = generaAleatoriosSinRepeticion(CARTAS_POR_JUGADOR * 2, 0, TOTAL_CARTAS);
        }
        return jugadas;
    }

    /**
     * Muestra por consola las cartas repartidas en cada jugada,
     * separando las cartas del Jugador 1 y Jugador 2.
     *
     * @param jugadas Matriz de jugadas
     */
    private void mostrarJugadas(int[][] jugadas) {
        System.out.printf("%-20s %s%n", "JUGADOR 1", "JUGADOR 2");
        System.out.println("-".repeat(40));

        for (int[] jugada : jugadas) {
            StringBuilder j1 = new StringBuilder();
            StringBuilder j2 = new StringBuilder();

            for (int y = 0; y < jugada.length; y++) {
                if (y < CARTAS_POR_JUGADOR)
                    j1.append(CARTAS[jugada[y]]).append(" ");
                else
                    j2.append(CARTAS[jugada[y]]).append(" ");
            }

            System.out.printf("%-20s %s%n", j1.toString().trim(), j2.toString().trim());
        }
    }

    /**
     * Compara cuántas veces aparece la carta ganadora en las manos
     * de cada jugador y muestra el resultado.
     *
     * @param jugadas      Matriz de jugadas
     * @param cartaGanadora Índice de la carta ganadora
     */
    private void determinarGanador(int[][] jugadas, int cartaGanadora) {
        int puntosJ1 = 0, puntosJ2 = 0;

        for (int[] jugada : jugadas) {
            for (int y = 0; y < jugada.length; y++) {
                if (jugada[y] == cartaGanadora) {
                    if (y < CARTAS_POR_JUGADOR) puntosJ1++;
                    else                         puntosJ2++;
                }
            }
        }

        System.out.println("Jugador 1: " + puntosJ1 + " aciertos");
        System.out.println("Jugador 2: " + puntosJ2 + " aciertos");

        if      (puntosJ1 > puntosJ2) System.out.println("¡Gana el Jugador 1!");
        else if (puntosJ2 > puntosJ1) System.out.println("¡Gana el Jugador 2!");
        else                           System.out.println("¡Empate!");
    }

    /**
     * Genera un array de números aleatorios únicos dentro de un rango.
     *
     * @param cantidad Cantidad de números a generar
     * @param limInf   Límite inferior (inclusive)
     * @param limSup   Límite superior (inclusive)
     * @return Array con los números aleatorios sin repetición
     */
    private int[] generaAleatoriosSinRepeticion(int cantidad, int limInf, int limSup) {
        int[] resultado = new int[cantidad];
        Arrays.fill(resultado, -1);

        for (int i = 0; i < cantidad; i++) {
            int ale;
            do {
                ale = aleatorio(limInf, limSup);
            } while (repetido(ale, resultado));
            resultado[i] = ale;
        }

        return resultado;
    }

    /**
     * Comprueba si un número ya existe en el array.
     *
     * @param valor  Número a comprobar
     * @param array  Array donde buscar
     * @return true si el número ya está en el array
     */
    private boolean repetido(int valor, int[] array) {
        for (int n : array) {
            if (n == valor) return true;
        }
        return false;
    }

    /**
     * Genera un número aleatorio entre limInf y limSup (ambos inclusive).
     *
     * @param limInf Límite inferior
     * @param limSup Límite superior
     * @return Número aleatorio
     */
    private int aleatorio(int limInf, int limSup) {
        return (int) (Math.random() * (limSup - limInf + 1) + limInf);
    }
}