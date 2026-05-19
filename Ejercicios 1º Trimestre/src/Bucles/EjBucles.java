package Bucles;

import java.util.Scanner;

public class EjBucles {

    public EjBucles() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Selecciona un ejercicio ===");
        System.out.println("1.  Múltiplos de 5 de 0 a 100");
        System.out.println("2.  Del 320 al 160 hacia atrás");
        System.out.println("3.  Control de acceso caja fuerte");
        System.out.println("4.  Número de dígitos");
        System.out.println("5.  Media de números positivos");
        System.out.println("6.  Serie de Fibonacci");
        System.out.println("7.  Número primo");
        System.out.println("8.  Números entre dos enteros de 7 en 7");
        System.out.println("9.  Estadísticas de números");
        System.out.println("10. Número al revés");
        System.out.println("11. Posición de un dígito");
        System.out.println("12. Factorial");
        System.out.print("\nElige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("--- for ---");
                for (int i = 0; i <= 100; i += 5) System.out.print(i + " ");
                System.out.println("\n--- while ---");
                int i = 0;
                while (i <= 100) { System.out.print(i + " "); i += 5; }
                System.out.println("\n--- do-while ---");
                i = 0;
                do { System.out.print(i + " "); i += 5; } while (i <= 100);
                break;

            case 2:
                int n = 320;
                while (n >= 160) { System.out.print(n + " "); n -= 20; }
                break;

            case 3:
                final int COMBINACION = 1234;
                int intentos = 0;
                boolean abierta = false;
                do {
                    System.out.print("Introduzca la combinación: ");
                    int intento = sc.nextInt();
                    intentos++;
                    if (intento == COMBINACION) {
                        System.out.println("La caja fuerte se ha abierto satisfactoriamente.");
                        abierta = true;
                    } else {
                        System.out.println("Lo siento, esa no es la combinación. Intentos restantes: " + (4 - intentos));
                    }
                } while (!abierta && intentos < 4);
                if (!abierta) System.out.println("Has agotado los intentos. La caja permanece cerrada.");
                break;

            case 4:
                System.out.print("Introduzca un número entero: ");
                long num = sc.nextLong();
                long copia = num;
                int digitos = 0;
                if (num < 0) num *= -1;
                if (num == 0) { digitos = 1; }
                else { while (num > 0) { digitos++; num /= 10; } }
                System.out.println("El número " + copia + " tiene " + digitos + " dígitos.");
                break;

            case 5:
                System.out.println("Introduzca números positivos (negativo para terminar):");
                double suma = 0;
                int cantidad = 0;
                double numero = sc.nextDouble();
                while (numero >= 0) { suma += numero; cantidad++; numero = sc.nextDouble(); }
                System.out.println(cantidad > 0 ? "La media es: " + (suma / cantidad) : "No se introdujo ningún número.");
                break;

            case 6:
                System.out.print("Introduzca cuántos términos quiere ver: ");
                int terms = sc.nextInt();
                long fib1 = 0, fib2 = 1;
                for (int j = 0; j < terms; j++) {
                    System.out.print(fib1 + " ");
                    long siguiente = fib1 + fib2;
                    fib1 = fib2;
                    fib2 = siguiente;
                }
                break;

            case 7:
                System.out.print("Introduzca un número entero: ");
                int primo = sc.nextInt();
                boolean esPrimo = primo > 1;
                for (int j = 2; j <= Math.sqrt(primo); j++) {
                    if (primo % j == 0) { esPrimo = false; break; }
                }
                System.out.println(primo + (esPrimo ? " es primo." : " no es primo."));
                break;

            case 8:
                System.out.print("Introduzca el primer número: ");
                int num1 = sc.nextInt();
                System.out.print("Introduzca el segundo número: ");
                int num2 = sc.nextInt();
                int menor = Math.min(num1, num2);
                int mayor = Math.max(num1, num2);
                for (int j = menor; j <= mayor; j += 7) System.out.print(j + " ");
                break;

            case 9:
                System.out.println("Introduzca números (negativo para terminar):");
                int totalNums = 0, sumaImpares = 0, contImpares = 0;
                int mayorPar = Integer.MIN_VALUE;
                boolean hayPar = false;
                int entrada = sc.nextInt();
                while (entrada >= 0) {
                    totalNums++;
                    if (entrada % 2 != 0) { sumaImpares += entrada; contImpares++; }
                    else if (entrada > mayorPar) { mayorPar = entrada; hayPar = true; }
                    entrada = sc.nextInt();
                }
                System.out.println("Números introducidos: " + totalNums);
                System.out.println("Media de impares: " + (contImpares > 0 ? (double) sumaImpares / contImpares : "No hay impares"));
                System.out.println("Mayor par: " + (hayPar ? mayorPar : "No hay pares"));
                break;

            case 10:
                System.out.print("Introduzca un número entero: ");
                int numReves = sc.nextInt();
                int copia2 = numReves;
                if (numReves < 0) numReves *= -1;
                int revertido = 0;
                while (numReves > 0) { revertido = revertido * 10 + numReves % 10; numReves /= 10; }
                System.out.println("El número " + copia2 + " al revés es " + (copia2 < 0 ? -revertido : revertido));
                break;

            case 11:
                System.out.print("Introduzca un número: ");
                String numStr = sc.next();
                System.out.print("Introduzca el dígito a buscar: ");
                char digito = sc.next().charAt(0);
                boolean encontrado = false;
                for (int j = 0; j < numStr.length(); j++) {
                    if (numStr.charAt(j) == digito) {
                        System.out.println("El dígito " + digito + " aparece en la posición " + (j + 1));
                        encontrado = true;
                    }
                }
                if (!encontrado) System.out.println("El dígito " + digito + " no aparece en el número.");
                break;

            case 12:
                System.out.print("Introduzca un número entero: ");
                int factNum = sc.nextInt();
                long factorial = 1;
                for (int j = 1; j <= factNum; j++) factorial *= j;
                System.out.println(factNum + "! = " + factorial);
                break;

            default:
                System.out.println("Opción no válida");
        }

        sc.close();
    }
}