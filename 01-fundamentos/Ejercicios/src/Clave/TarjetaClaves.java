package Clave;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Simulación de una tarjeta de claves bancaria.
 * Genera una tarjeta 5x5 con números aleatorios únicos entre 100 y 200.
 */
public class TarjetaClaves {

    private static final String[] LETRAS   = { "A", "B", "C", "D", "E" };
    private static final int      FILAS    = 5;
    private static final int      COLUMNAS = 5;
    private static final int      LIM_INF  = 100;
    private static final int      LIM_SUP  = 200;

    public TarjetaClaves() {
        System.out.println("=== Tarjeta de Claves ===\n");

        int[][] tarjeta = generarTarjeta();
        mostrarTarjeta(tarjeta);
        pedirYValidarClave(tarjeta);
    }

    /**
     * Genera la tarjeta 5x5 con valores aleatorios únicos.
     */
    private int[][] generarTarjeta() {
        int[] aleatorios = generaAleatoriosSinRepeticion(FILAS * COLUMNAS, LIM_INF, LIM_SUP);
        int[][] tarjeta  = new int[FILAS][COLUMNAS];
        int cont = 0;

        for (int x = 0; x < FILAS; x++) {
            for (int y = 0; y < COLUMNAS; y++) {
                tarjeta[x][y] = aleatorios[cont++];
            }
        }
        return tarjeta;
    }

    /**
     * Muestra la tarjeta con formato tabular alineado.
     */
    private void mostrarTarjeta(int[][] tarjeta) {
        System.out.print("     ");
        for (int col = 1; col <= COLUMNAS; col++) {
            System.out.printf("%6d", col);
        }
        System.out.println("\n     " + "──────".repeat(COLUMNAS));

        for (int x = 0; x < FILAS; x++) {
            System.out.printf("  %s  |", LETRAS[x]);
            for (int y = 0; y < COLUMNAS; y++) {
                System.out.printf("%6d", tarjeta[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Solicita la clave de una posición aleatoria y valida la respuesta.
     */
    private void pedirYValidarClave(int[][] tarjeta) {
        int fila    = aleatorio(0, FILAS - 1);
        int columna = aleatorio(0, COLUMNAS - 1);

        System.out.println("Introduzca la clave en la posición: "
                + LETRAS[fila] + "-" + (columna + 1));
        System.out.print("Clave: ");

        Scanner sc = new Scanner(System.in);
        int claveIntroducida = sc.nextInt();
        sc.close();

        if (claveIntroducida == tarjeta[fila][columna]) {
            System.out.println(":D Clave correcta.");
        } else {
            System.out.println(":( Clave incorrecta. Era: " + tarjeta[fila][columna]);
        }
    }

    private static int[] generaAleatoriosSinRepeticion(int cantidad, int limInf, int limSup) {
        if ((limSup - limInf + 1) < cantidad) return new int[cantidad];

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

    private static boolean repetidos(int[] array, int valor) {
        for (int n : array) {
            if (n == valor) return true;
        }
        return false;
    }

    private static int aleatorio(int limInf, int limSup) {
        return (int) Math.floor(Math.random() * (limSup - limInf + 1) + limInf);
    }
}