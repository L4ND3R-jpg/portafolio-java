package Primitiva;

import java.util.Arrays;

public class Primitiva {

    public Primitiva() {
        // Generar 10 boletos
        int[][] boletos = new int[10][];
        for (int x = 0; x < boletos.length; x++)
            boletos[x] = generaAleatoriosSinRepeticion(6, 1, 49);

        // Sorteo
        int[] sorteo = generaAleatoriosSinRepeticion(6, 1, 49);
        System.out.println("COMBINACIÓN GANADORA: " + Arrays.toString(sorteo));
        System.out.println("─────────────────────────────────────");

        // Comprobar aciertos de cada boleto
        for (int[] boleto : boletos)
            System.out.println(Arrays.toString(boleto) + " : " + compruebaAciertos(sorteo, boleto) + " aciertos");

        System.out.println("─────────────────────────────────────");

        // Generar boletos hasta 6 aciertos
        int[] primi;
        int contador = 0;
        do {
            primi = generaAleatoriosSinRepeticion(6, 1, 49);
            contador++;
        } while (compruebaAciertos(sorteo, primi) != 6);

        System.out.println("Sorteo : " + Arrays.toString(sorteo));
        System.out.println("Boleto : " + Arrays.toString(primi));
        System.out.println("Boletos generados hasta acertar: " + contador);
    }

    private int compruebaAciertos(int[] sorteo, int[] boleto) {
        int aciertos = 0;
        for (int numero : sorteo)
            if (Arrays.binarySearch(boleto, numero) >= 0)
                aciertos++;
        return aciertos;
    }

    private static int[] generaAleatoriosSinRepeticion(int cantidad, int limInferior, int limSuperior) {
        if ((limSuperior - limInferior + 1) < cantidad) return null;
        int[] aleatorios = new int[cantidad];
        for (int x = 0; x < cantidad; x++) {
            int ale;
            do {
                ale = (int) (Math.random() * (limSuperior - limInferior + 1) + limInferior);
            } while (repetidos(aleatorios, ale));
            aleatorios[x] = ale;
        }
        Arrays.sort(aleatorios);
        return aleatorios;
    }

    private static boolean repetidos(int[] aleatorios, int ale) {
        for (int numero : aleatorios)
            if (numero == ale) return true;
        return false;
    }
}