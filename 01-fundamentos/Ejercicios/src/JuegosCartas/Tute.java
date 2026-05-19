package JuegosCartas;

import java.util.Arrays;

/**
 * Simulación del juego de cartas "Tute" con la baraja española.
 *
 * <p>Se reparten 40 cartas entre 4 jugadores (10 cada uno).
 * Se determina un palo ganador y se comprueba si algún jugador
 * puede cantar (tiene Caballo y Rey del mismo palo).</p>
 */
public class Tute {

    // ─── CONSTANTES ──────────────────────────────────────────────────────────────

    private static final String[] BARAJA = {
        "1o",  "2o",  "3o",  "4o",  "5o",  "6o",  "7o",  "10o", "11o", "12o",
        "1c",  "2c",  "3c",  "4c",  "5c",  "6c",  "7c",  "10c", "11c", "12c",
        "1e",  "2e",  "3e",  "4e",  "5e",  "6e",  "7e",  "10e", "11e", "12e",
        "1b",  "2b",  "3b",  "4b",  "5b",  "6b",  "7b",  "10b", "11b", "12b"
    };

    private static final String[] PALOS = { "Oros", "Copas", "Espadas", "Bastos" };

    // Caballo (11) y Rey (12) de cada palo — necesarios para cantar
    private static final String[][] CARTAS_CANTE = {
        { "11o", "12o" },
        { "11c", "12c" },
        { "11e", "12e" },
        { "11b", "12b" }
    };

    private static final int NUM_JUGADORES     = 4;
    private static final int CARTAS_POR_JUGADOR = 10;

    // ─── CONSTRUCTOR ─────────────────────────────────────────────────────────────

    /**
     * Constructor: ejecuta la simulación completa del Tute.
     */
    public Tute() {
        System.out.println("=== TUTE ===\n");

        // 1. Repartir cartas
        int[]    reparto         = generaAleatoriosSinRepeticion(BARAJA.length, 0, BARAJA.length - 1);
        String[] cartasJugadores = repartirCartas(reparto);

        // 2. Mostrar manos
        mostrarManos(cartasJugadores);

        // 3. Determinar palo ganador
        int paloGanador = aleatorio(0, PALOS.length - 1);
        System.out.println("Palo Ganador: " + PALOS[paloGanador] + "\n");

        // 4. Comprobar cantes
        comprobarCantes(cartasJugadores, paloGanador);
    }

    // ─── MÉTODOS PRIVADOS ────────────────────────────────────────────────────────

    /**
     * Reparte las 40 cartas entre 4 jugadores (10 cartas cada uno).
     *
     * @param reparto Array con los índices de las cartas barajadas
     * @return Array de strings con las cartas de cada jugador concatenadas
     */
    private String[] repartirCartas(int[] reparto) {
        String[] manos = new String[NUM_JUGADORES];
        Arrays.fill(manos, "");

        for (int jug = 0; jug < NUM_JUGADORES; jug++) {
            StringBuilder mano = new StringBuilder();
            int inicio = jug * CARTAS_POR_JUGADOR;
            for (int i = inicio; i < inicio + CARTAS_POR_JUGADOR; i++) {
                mano.append(BARAJA[reparto[i]]).append(" ");
            }
            manos[jug] = mano.toString().trim();
        }

        return manos;
    }

    /**
     * Muestra por consola las cartas de cada jugador.
     *
     * @param manos Cartas de cada jugador
     */
    private void mostrarManos(String[] manos) {
        System.out.println("── Manos repartidas ──");
        for (int i = 0; i < manos.length; i++) {
            System.out.printf("Jugador %d: %s%n", i + 1, manos[i]);
        }
        System.out.println();
    }

    /**
     * Comprueba si algún jugador puede cantar (tiene Caballo y Rey del mismo palo).
     * Cantar en el palo ganador vale 40 puntos; en otro palo, 20 puntos.
     *
     * @param manos       Cartas de cada jugador
     * @param paloGanador Índice del palo ganador
     */
    private void comprobarCantes(String[] manos, int paloGanador) {
        System.out.println("── Cantes ──");
        boolean alguienCanta = false;

        for (int jug = 0; jug < manos.length; jug++) {
            int[] cantes = detectarCantes(manos[jug]);

            for (int palo = 0; palo < cantes.length; palo++) {
                if (cantes[palo] == 2) {
                    int puntos = (palo == paloGanador) ? 40 : 20;
                    System.out.printf("Jugador %d: canta %d en %s%n", jug + 1, puntos, PALOS[palo]);
                    alguienCanta = true;
                }
            }
        }

        if (!alguienCanta) {
            System.out.println("Nadie puede cantar.");
        }
    }

    /**
     * Detecta en qué palos puede cantar un jugador contando cuántas
     * cartas de cante (Caballo y Rey) tiene de cada palo.
     *
     * @param mano Cartas del jugador como string
     * @return Array con el conteo de cartas de cante por palo (0, 1 o 2)
     */
    private int[] detectarCantes(String mano) {
        int[] conteo = new int[PALOS.length];
        for (int palo = 0; palo < CARTAS_CANTE.length; palo++) {
            for (String carta : CARTAS_CANTE[palo]) {
                if (mano.contains(carta)) {
                    conteo[palo]++;
                }
            }
        }
        return conteo;
    }

    /**
     * Genera un array de enteros aleatorios únicos dentro de un rango.
     *
     * @param cantidad  Cantidad de números a generar
     * @param limInf    Límite inferior (inclusive)
     * @param limSup    Límite superior (inclusive)
     * @return Array con números aleatorios sin repetición, o null si el rango es insuficiente
     */
    private static int[] generaAleatoriosSinRepeticion(int cantidad, int limInf, int limSup) {
        if ((limSup - limInf + 1) < cantidad) return null;

        int[] resultado = new int[cantidad];
        Arrays.fill(resultado, -1);

        for (int i = 0; i < cantidad; i++) {
            int ale;
            do {
                ale = aleatorio(limInf, limSup);
            } while (repetidos(resultado, ale));
            resultado[i] = ale;
        }

        return resultado;
    }

    /**
     * Comprueba si un valor ya existe en el array.
     *
     * @param array Array donde buscar
     * @param valor Valor a comprobar
     * @return true si el valor ya está en el array
     */
    private static boolean repetidos(int[] array, int valor) {
        for (int n : array) {
            if (n == valor) return true;
        }
        return false;
    }

    /**
     * Genera un número entero aleatorio entre limInf y limSup (ambos inclusive).
     *
     * @param limInf Límite inferior
     * @param limSup Límite superior
     * @return Número aleatorio
     */
    private static int aleatorio(int limInf, int limSup) {
        return (int) (Math.random() * (limSup - limInf + 1) + limInf);
    }
}