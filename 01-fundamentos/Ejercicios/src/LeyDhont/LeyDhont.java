package LeyDhont;
import java.util.Arrays;

/**
 * Implementación de la Ley D'Hondt para el reparto proporcional de escaños
 * entre partidos políticos según sus votos obtenidos.
 *
 * <p>El método divide los votos de cada partido entre divisores sucesivos (1, 2, 3...)
 * generando una matriz de cocientes. Los escaños se asignan al mayor cociente
 * disponible en cada ronda.</p>
 */
public class LeyDhont {

    // ─── DATOS DE EJEMPLO ────────────────────────────────────────────────────────
    private static final int[]    VOTOS    = { 40000, 60000, 20000 };
    private static final String[] PARTIDOS = { "P1", "P2", "P3" };
    private static final int      ESCANOS  = 12;

    /**
     * Constructor: ejecuta la simulación completa de la Ley D'Hondt.
     */
    public LeyDhont() {
        System.out.println("=== Ley D'Hondt ===\n");

        double[][] cocientes = generarCocientes(VOTOS, ESCANOS);
        mostrarMatrizCocientes(cocientes, PARTIDOS, ESCANOS);

        int[] resultado = reparteEscanos(cocientes, PARTIDOS.length, ESCANOS, VOTOS);
        mostrarResultado(resultado, PARTIDOS);
    }

    // ─── MÉTODOS PRIVADOS ────────────────────────────────────────────────────────

    /**
     * Genera la matriz de cocientes dividiendo los votos de cada partido
     * entre los divisores sucesivos (1, 2, 3, ..., escaños).
     *
     * @param votos   Votos obtenidos por cada partido
     * @param escanos Número total de escaños a repartir
     * @return Matriz de cocientes [partidos][escaños]
     */
    private double[][] generarCocientes(int[] votos, int escanos) {
        double[][] cocientes = new double[votos.length][escanos];
        for (int x = 0; x < cocientes.length; x++) {
            for (int y = 0; y < escanos; y++) {
                cocientes[x][y] = (double) votos[x] / (y + 1);
            }
        }
        return cocientes;
    }

    /**
     * Muestra por consola la matriz de cocientes con formato tabular alineado.
     *
     * @param cocientes Matriz de cocientes
     * @param partidos  Nombres de los partidos
     * @param escanos   Número de escaños (columnas)
     */
    private void mostrarMatrizCocientes(double[][] cocientes, String[] partidos, int escanos) {
        System.out.println("Matriz de Cocientes:");

        // Cabecera con los divisores
        System.out.print(String.format("%-6s", ""));
        for (int i = 1; i <= escanos; i++) {
            System.out.print(String.format("%-10d", i));
        }
        System.out.println();

        // Filas por partido
        for (int x = 0; x < cocientes.length; x++) {
            System.out.print(String.format("%-6s", partidos[x]));
            for (double cociente : cocientes[x]) {
                System.out.print(String.format("%-10.2f", cociente > 0 ? cociente : 0));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Reparte los escaños asignando cada uno al partido con el mayor cociente
     * disponible. En caso de empate en cociente se resuelve por votos totales,
     * y si persiste el empate, por sorteo aleatorio.
     *
     * @param cocientes    Matriz de cocientes (se modifica internamente)
     * @param numPartidos  Número de partidos
     * @param escanos      Número de escaños a repartir
     * @param votos        Votos de cada partido (para desempate)
     * @return Array con los escaños asignados a cada partido
     */
    private int[] reparteEscanos(double[][] cocientes, int numPartidos, int escanos, int[] votos) {
        int[] escanosAsignados = new int[numPartidos];

        for (int k = 0; k < escanos; k++) {
            double maxValor      = -1;
            int    ganador       = -1;
            int    divisorGanador = -1;

            for (int x = 0; x < cocientes.length; x++) {
                for (int y = 0; y < cocientes[x].length; y++) {
                    double valor = cocientes[x][y];
                    if (valor <= 0) continue; // celda ya usada

                    if (valor > maxValor) {
                        // Nuevo máximo claro
                        maxValor       = valor;
                        ganador        = x;
                        divisorGanador = y;
                    } else if (valor == maxValor) {
                        // Desempate 1: mayor número de votos totales
                        if (votos[x] > votos[ganador]) {
                            ganador        = x;
                            divisorGanador = y;
                        }
                        // Desempate 2: sorteo aleatorio si los votos también empatan
                        else if (votos[x] == votos[ganador] && Math.random() < 0.5) {
                            ganador        = x;
                            divisorGanador = y;
                        }
                    }
                }
            }

            // Asignamos el escaño y marcamos la celda como usada
            escanosAsignados[ganador]++;
            cocientes[ganador][divisorGanador] = -1;
        }

        return escanosAsignados;
    }

    /**
     * Muestra el resultado final del reparto de escaños por partido.
     *
     * @param escanosAsignados Escaños obtenidos por cada partido
     * @param partidos         Nombres de los partidos
     */
    private void mostrarResultado(int[] escanosAsignados, String[] partidos) {
        System.out.println("=== Resultado Final ===");
        for (int i = 0; i < partidos.length; i++) {
            System.out.printf("%-4s -> %d escaños%n", partidos[i], escanosAsignados[i]);
        }
        System.out.println("\nDistribución: " + Arrays.toString(escanosAsignados));
    }
}