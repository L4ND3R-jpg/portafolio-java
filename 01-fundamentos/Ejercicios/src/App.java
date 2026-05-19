import java.util.Scanner;

import Bucles.EjBucles;
import EstructurasCondicionales.EjEstructurasCondicionales;
import Notas.EjNotas;
import OperacionesBasicas.TiposDatosYOperacionesBasicas;
import Primitiva.Primitiva;
import Repaso.RepasoEstructurasBasicas;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Selecciona una clase ===");
        System.out.println("1. Tipos de datos y operaciones básicas");
        System.out.println("2. Estructuras condicionales");
        System.out.println("3. Bucles");
        System.out.println("4. Repaso de Estructuras Basicas");
        System.out.println("5. Notas");
        System.out.println("6. Primitiva");
        System.out.print("\nElige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                new TiposDatosYOperacionesBasicas();
                break;
            case 2:
                new EjEstructurasCondicionales();
                break;
            case 3:
                new EjBucles();
                break;
            case 4: 
                new RepasoEstructurasBasicas();
                break;
            case 5:
                new EjNotas();
                break;
            case 6:
                new Primitiva();
                break;
            default:
                System.out.println("Opción no válida");
        }

        sc.close();
    }
}