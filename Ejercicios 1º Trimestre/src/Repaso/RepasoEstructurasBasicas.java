package Repaso;

import java.util.Scanner;

public class RepasoEstructurasBasicas {

    public RepasoEstructurasBasicas() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Selecciona un ejercicio ===");
        System.out.println("1.  Días del mes anterior");
        System.out.println("2.  Año bisiesto");
        System.out.println("3.  Calendario enero");
        System.out.println("4.  Mayor y menor sueldo");
        System.out.println("5.  Tabla ASCII");
        System.out.println("6.  Ecuación de segundo grado");
        System.out.println("7.  Mínimo común múltiplo");
        System.out.println("8.  Algoritmo ruso del producto");
        System.out.println("9.  Desglose en billetes y monedas");
        System.out.println("10. Números primos entre dos dados");
        System.out.println("11. Número perfecto");
        System.out.println("12. Número capicúa");
        System.out.println("13. Conversión a binario");
        System.out.println("14. Adivina el número");
        System.out.println("15. MCD algoritmo de Euclides");
        System.out.println("16. Factorización en primos");
        System.out.println("17. Número Armstrong");
        System.out.println("18. Dibujar un rombo");
        System.out.println("19. Números amigos");
        System.out.print("\nElige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                System.out.print("Introduzca un mes (1-12): ");
                int mes = sc.nextInt();
                int diasMesAnterior = 0;
                switch (mes) {
                    case 1:  diasMesAnterior = 31; break; // diciembre
                    case 2:  diasMesAnterior = 31; break; // enero
                    case 3:  diasMesAnterior = 28; break; // febrero (sin bisiesto)
                    case 4:  diasMesAnterior = 31; break; // marzo
                    case 5:  diasMesAnterior = 30; break; // abril
                    case 6:  diasMesAnterior = 31; break; // mayo
                    case 7:  diasMesAnterior = 30; break; // junio
                    case 8:  diasMesAnterior = 31; break; // julio
                    case 9:  diasMesAnterior = 31; break; // agosto
                    case 10: diasMesAnterior = 30; break; // septiembre
                    case 11: diasMesAnterior = 31; break; // octubre
                    case 12: diasMesAnterior = 30; break; // noviembre
                    default: System.out.println("Mes no válido.");
                }
                if (mes >= 1 && mes <= 12)
                    System.out.println("El mes anterior tiene " + diasMesAnterior + " días.");
                break;

            case 2:
                System.out.print("Introduzca un año: ");
                int anio = sc.nextInt();
                if (anio % 400 == 0)
                    System.out.println("Es bisiesto por ser múltiplo de 400.");
                else if (anio % 100 == 0)
                    System.out.println("No es bisiesto por ser múltiplo de 100.");
                else if (anio % 4 == 0)
                    System.out.println("Es bisiesto por ser múltiplo de 4 y no de 100.");
                else
                    System.out.println("No es bisiesto.");
                break;

            case 3:
                System.out.print("Introduzca el día de la semana del 1 de enero (0=Domingo, 6=Sábado): ");
                int diaSemana = sc.nextInt();
                String[] diasNombre = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
                for (int dia = 1; dia <= 31; dia++) {
                    System.out.println("Enero " + dia + " - " + diasNombre[diaSemana % 7]);
                    diaSemana++;
                }
                break;

            case 4:
                String nombreMax = "", nombreMin = "";
                double sueldoMax = Double.MIN_VALUE, sueldoMin = Double.MAX_VALUE;
                for (int i = 0; i < 10; i++) {
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Sueldo: ");
                    double sueldo = sc.nextDouble();
                    if (sueldo > sueldoMax) { sueldoMax = sueldo; nombreMax = nombre; }
                    if (sueldo < sueldoMin) { sueldoMin = sueldo; nombreMin = nombre; }
                }
                System.out.printf("Mayor sueldo: %s con %.2f€%n", nombreMax, sueldoMax);
                System.out.printf("Menor sueldo: %s con %.2f€%n", nombreMin, sueldoMin);
                break;

            case 5:
                int col = 0;
                for (int codigo = 32; codigo <= 131; codigo++) {
                    System.out.printf("%4d:%-4c", codigo, (char) codigo);
                    col++;
                    if (col % 10 == 0) System.out.println();
                }
                break;

            case 6:
                System.out.print("Introduce a: ");
                double a = sc.nextDouble();
                System.out.print("Introduce b: ");
                double b = sc.nextDouble();
                System.out.print("Introduce c: ");
                double c = sc.nextDouble();
                double discriminante = (b * b) - (4 * a * c);
                if (discriminante < 0) {
                    System.out.println("La ecuación no tiene solución real.");
                } else if (discriminante == 0) {
                    System.out.printf("Solución única: x = %.2f%n", -b / (2 * a));
                } else {
                    System.out.printf("x1 = %.2f%n", (-b + Math.sqrt(discriminante)) / (2 * a));
                    System.out.printf("x2 = %.2f%n", (-b - Math.sqrt(discriminante)) / (2 * a));
                }
                break;

            case 7:
                System.out.print("Introduce el primer número: ");
                int n1 = sc.nextInt();
                System.out.print("Introduce el segundo número: ");
                int n2 = sc.nextInt();
                int mayor = Math.max(n1, n2);
                int menor = Math.min(n1, n2);
                int mcm = mayor;
                while (mcm % menor != 0) mcm += mayor;
                System.out.println("El MCM de " + n1 + " y " + n2 + " es " + mcm);
                break;

            case 8:
                System.out.print("Introduce el primer factor: ");
                int factor1 = sc.nextInt();
                System.out.print("Introduce el segundo factor: ");
                int factor2 = sc.nextInt();
                int acumulador = 0;
                System.out.printf("%-12s %-12s %-12s%n", "1º factor", "2º factor", "Acumulador");
                while (factor2 > 0) {
                    System.out.printf("%-12d %-12d %-12d%n", factor1, factor2, acumulador);
                    if (factor2 % 2 != 0) acumulador += factor1;
                    factor1 *= 2;
                    factor2 /= 2;
                }
                System.out.println("Resultado: " + acumulador);
                break;

            case 9:
                System.out.print("Introduce una cantidad en euros: ");
                int cantidad = sc.nextInt();
                int[] billetes = {500, 200, 100, 50, 20, 10, 5};
                double[] monedas = {2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
                System.out.println("Desglose:");
                for (int bil : billetes) {
                    if (cantidad >= bil) {
                        System.out.println("  Billetes de " + bil + "€: " + cantidad / bil);
                        cantidad %= bil;
                    }
                }
                int centimos = (int) Math.round(cantidad * 100);
                for (double mon : monedas) {
                    int centMon = (int) Math.round(mon * 100);
                    if (centimos >= centMon) {
                        System.out.println("  Monedas de " + mon + "€: " + centimos / centMon);
                        centimos %= centMon;
                    }
                }
                break;

            case 10:
                System.out.print("Introduce el primer número: ");
                int desde = sc.nextInt();
                System.out.print("Introduce el segundo número: ");
                int hasta = sc.nextInt();
                int contPrimos = 0;
                for (int num = desde; num <= hasta; num++) {
                    if (num < 2) continue;
                    boolean esPrimo = true;
                    for (int j = 2; j <= Math.sqrt(num); j++) {
                        if (num % j == 0) { esPrimo = false; break; }
                    }
                    if (esPrimo) { System.out.print(num + " "); contPrimos++; }
                }
                System.out.println("\nSe han encontrado " + contPrimos + " números primos.");
                break;

            case 11:
                System.out.print("Introduce un número: ");
                int numPerfecto = sc.nextInt();
                int sumaDivisores = 0;
                for (int j = 1; j < numPerfecto; j++)
                    if (numPerfecto % j == 0) sumaDivisores += j;
                System.out.println(numPerfecto + (sumaDivisores == numPerfecto ? " es perfecto." : " no es perfecto."));
                break;

            case 12:
                System.out.print("Introduce un número: ");
                String numStr = sc.next();
                String numRev = new StringBuilder(numStr).reverse().toString();
                System.out.println(numStr + (numStr.equals(numRev) ? " es capicúa." : " no es capicúa."));
                break;

            case 13:
                System.out.print("Introduce un número entero: ");
                int numBin = sc.nextInt();
                String binario = "";
                int copia = numBin;
                while (copia > 0) { binario = (copia % 2) + binario; copia /= 2; }
                System.out.println(numBin + " en binario: " + binario);
                System.out.printf("%s en 8 bits: %8s%n", numBin, binario.replace(' ', '0'));
                // Versión 2.0 con 8 bits
                System.out.printf("Versión 8 bits: %08d%n", Integer.parseInt(binario));
                break;

            case 14:
                int numAleatorio = (int) (Math.random() * 100) + 1;
                int intentos = 0;
                boolean adivinado = false;
                System.out.println("Adivina el número (1-100). Tienes 5 intentos.");
                while (intentos < 5 && !adivinado) {
                    System.out.print("Intento " + (intentos + 1) + ": ");
                    int intento = sc.nextInt();
                    intentos++;
                    if (intento == numAleatorio) {
                        System.out.println("¡Correcto! Lo adivinaste en " + intentos + " intentos.");
                        adivinado = true;
                    } else if (intento < numAleatorio) {
                        System.out.println("El número es mayor.");
                    } else {
                        System.out.println("El número es menor.");
                    }
                }
                if (!adivinado) System.out.println("Has agotado los intentos. Era el " + numAleatorio);
                break;

            case 15:
                System.out.print("Introduce el primer número: ");
                int mcd1 = sc.nextInt();
                System.out.print("Introduce el segundo número: ");
                int mcd2 = sc.nextInt();
                int a2 = Math.max(mcd1, mcd2);
                int b2 = Math.min(mcd1, mcd2);
                System.out.printf("%-6s %-10s %-10s %-10s %-6s%n", "Paso", "Dividendo", "Divisor", "Cociente", "Resto");
                int paso = 1;
                while (b2 != 0) {
                    int resto = a2 % b2;
                    System.out.printf("%-6d %-10d %-10d %-10d %-6d%n", paso++, a2, b2, a2 / b2, resto);
                    a2 = b2;
                    b2 = resto;
                }
                System.out.println("MCD = " + a2);
                break;

            case 16:
                System.out.print("Introduce un número entero: ");
                int numFact = sc.nextInt();
                System.out.print(numFact + " = ");
                int divisor = 2;
                boolean primero = true;
                while (numFact > 1) {
                    while (numFact % divisor == 0) {
                        if (!primero) System.out.print(" × ");
                        System.out.print(divisor);
                        numFact /= divisor;
                        primero = false;
                    }
                    divisor++;
                }
                System.out.println();
                break;

            case 17:
                System.out.print("Introduce un número: ");
                int numArm = sc.nextInt();
                String digitos = String.valueOf(numArm);
                int numCifras = digitos.length();
                int sumaArm = 0;
                for (char d : digitos.toCharArray())
                    sumaArm += (int) Math.pow(Character.getNumericValue(d), numCifras);
                System.out.println(numArm + (sumaArm == numArm ? " es un número Armstrong." : " no es un número Armstrong."));
                System.out.println("\nNúmeros Armstrong entre 10 y 10000:");
                for (int num = 10; num <= 10000; num++) {
                    String d2 = String.valueOf(num);
                    int nc = d2.length(), sa = 0;
                    for (char ch : d2.toCharArray()) sa += (int) Math.pow(Character.getNumericValue(ch), nc);
                    if (sa == num) System.out.print(num + " ");
                }
                System.out.println();
                break;

            case 18:
                System.out.print("Introduce un número impar para el rombo: ");
                int n = sc.nextInt();
                int mitad = n / 2;
                for (int fila = 0; fila < n; fila++) {
                    int asteriscos = fila <= mitad ? (fila * 2 + 1) : ((n - fila - 1) * 2 + 1);
                    int espacios = (n - asteriscos) / 2;
                    for (int s = 0; s < espacios; s++) System.out.print(" ");
                    for (int s = 0; s < asteriscos; s++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 19:
                System.out.print("Introduce el primer número: ");
                int num1 = sc.nextInt();
                System.out.print("Introduce el segundo número: ");
                int num2 = sc.nextInt();
                int suma1 = 0, suma2 = 0;
                for (int j = 1; j < num1; j++) if (num1 % j == 0) suma1 += j;
                for (int j = 1; j < num2; j++) if (num2 % j == 0) suma2 += j;
                if (suma1 == num2 && suma2 == num1)
                    System.out.println(num1 + " y " + num2 + " son números amigos.");
                else
                    System.out.println(num1 + " y " + num2 + " no son números amigos.");
                break;

            default:
                System.out.println("Opción no válida.");
        }

        sc.close();
    }
}