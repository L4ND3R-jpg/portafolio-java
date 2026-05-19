package OperacionesBasicas;

import java.util.Scanner;

public class TiposDatosYOperacionesBasicas {

    public TiposDatosYOperacionesBasicas() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Selecciona un ejercicio ===");
        System.out.println("1. Variables y operaciones básicas");
        System.out.println("2. Euros a pesetas");
        System.out.println("3. Pesetas a euros");
        System.out.println("4. Factura con IVA");
        System.out.println("5. Área de un triángulo");
        System.out.println("6. Salario semanal");
        System.out.println("7. Nota necesaria en el segundo examen");
        System.out.print("\nElige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                int x = 144;
                int y = 999;
                System.out.println("X: " + x);
                System.out.println("Y: " + y);
                System.out.println("Suma: " + (x + y));
                System.out.println("Resta: " + (x - y));
                System.out.println("División: " + (x / y));
                System.out.println("Multiplicación: " + (x * y));
                break;

            case 2:
                System.out.print("Introduce los euros: ");
                double euros = sc.nextDouble();
                System.out.println(euros + " euros son " + (euros * 166.386) + " pesetas");
                break;

            case 3:
                System.out.print("Introduce las pesetas: ");
                double pesetas = sc.nextDouble();
                System.out.println(pesetas + " pesetas son " + (pesetas / 166.386) + " euros");
                break;

            case 4:
                System.out.print("Introduce la base imponible: ");
                double base = sc.nextDouble();
                System.out.print("Introduce el IVA (%): ");
                double iva = sc.nextDouble();
                System.out.println("Total factura: " + (base + (base * iva / 100)) + " euros");
                break;

            case 5:
                System.out.print("Introduce la base del triángulo: ");
                double baseT = sc.nextDouble();
                System.out.print("Introduce la altura: ");
                double altura = sc.nextDouble();
                System.out.println("El área del triángulo es: " + (baseT * altura) / 2);
                break;

            case 6:
                System.out.print("Introduce las horas trabajadas: ");
                int horas = sc.nextInt();
                System.out.println("Salario semanal: " + (horas * 12) + " euros");
                break;

            case 7:
                System.out.print("Introduce la nota del primer examen: ");
                double nota1 = sc.nextDouble();
                System.out.print("Introduce la media deseada: ");
                double mediaDeseada = sc.nextDouble();
                System.out.println("Necesitas sacar un " + ((mediaDeseada - (nota1 * 0.4)) / 0.6) + " en el segundo examen");
                break;

            default:
                System.out.println("Opción no válida");
        }

        sc.close();
    }
}


