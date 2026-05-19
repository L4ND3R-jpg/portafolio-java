import java.util.Scanner;

import Bucles.EjBucles;
import Clave.TarjetaClaves;
import EstructurasCondicionales.EjEstructurasCondicionales;
import JuegosCartas.ReparteCartas;
import JuegosCartas.Tute;
import LeyDhont.LeyDhont;
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
        System.out.println("7. Reparte Cartas");
        System.out.println("8. Tute");
        System.out.println("9. Ley Dhont");
        System.out.println("10.Tarjeta de Claves");
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
            case 7:
                new ReparteCartas();
                break;
            case 8:
                new Tute();
                break;
            case 9:
                new LeyDhont();
                break;
            case 10:
                new TarjetaClaves();
                break;
            default:
                System.out.println("Opción no válida");
        }

        sc.close();
    }
}