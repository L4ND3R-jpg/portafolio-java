package EstructurasCondicionales;

import java.util.Scanner;

public class EjEstructurasCondicionales {

    public EjEstructurasCondicionales() {
        Scanner leer = new Scanner(System.in);

        // Ejercicio 1 - Asignatura según el día de la semana
        System.out.print("Introduzca un día de la semana (en minúscula): ");
        String diaSemana = leer.next();
        switch (diaSemana) {
            case "lunes":
            case "martes":
            case "miercoles":
                System.out.println("Programación");
                break;
            case "jueves":
                System.out.println("Sistemas Informáticos");
                break;
            case "viernes":
                System.out.println("Bases de Datos");
                break;
            case "sábado":
            case "domingo":
                System.out.println("¡Ese día no hay clase!");
                break;
            default:
                System.out.println("El día introducido no es correcto.");
        }

        // Ejercicio 2 - Buenos días, tardes o noches
        System.out.print("Introduzca una hora del día (0-23): ");
        int hora = leer.nextInt();
        if (hora >= 6 && hora <= 12) {
            System.out.println("Buenos días");
        } else if (hora >= 13 && hora <= 20) {
            System.out.println("Buenas tardes");
        } else if ((hora >= 21 && hora < 24) || (hora >= 0 && hora <= 5)) {
            System.out.println("Buenas noches");
        } else {
            System.out.println("La hora introducida no es correcta.");
        }

        // Ejercicio 3 - Salario semanal con horas extra
        System.out.print("Introduzca el número de horas trabajadas: ");
        int horasTrabajadas = leer.nextInt();
        int sueldoSemanal;
        if (horasTrabajadas <= 40) {
            sueldoSemanal = 12 * horasTrabajadas;
        } else {
            sueldoSemanal = (40 * 12) + ((horasTrabajadas - 40) * 16);
        }
        System.out.println("El sueldo semanal es de " + sueldoSemanal + " euros");

        // Ejercicio 4 - Horóscopo
        System.out.print("Introduzca el mes de nacimiento (1-12): ");
        int mes = leer.nextInt();
        System.out.print("Introduzca el día: ");
        int dia = leer.nextInt();
        String horoscopo = "";
        switch (mes) {
            case 1:  horoscopo = dia < 20 ? "capricornio" : "acuario";   break;
            case 2:  horoscopo = dia < 19 ? "acuario"    : "piscis";     break;
            case 3:  horoscopo = dia < 21 ? "piscis"     : "aries";      break;
            case 4:  horoscopo = dia < 21 ? "aries"      : "tauro";      break;
            case 5:  horoscopo = dia < 20 ? "tauro"      : "géminis";    break;
            case 6:  horoscopo = dia < 22 ? "géminis"    : "cáncer";     break;
            case 7:  horoscopo = dia < 22 ? "cáncer"     : "leo";        break;
            case 8:  horoscopo = dia < 24 ? "leo"        : "virgo";      break;
            case 9:  horoscopo = dia < 23 ? "virgo"      : "libra";      break;
            case 10: horoscopo = dia < 23 ? "libra"      : "escorpio";   break;
            case 11: horoscopo = dia < 23 ? "escorpio"   : "sagitario";  break;
            case 12: horoscopo = dia < 21 ? "sagitario"  : "capricornio";break;
            default: System.out.println("Mes no válido.");
        }
        System.out.println("Su horóscopo es " + horoscopo);

        // Ejercicio 5 - Segundos hasta medianoche
        System.out.print("Introduzca la hora: ");
        hora = leer.nextInt();
        System.out.print("Introduzca los minutos: ");
        int minuto = leer.nextInt();
        int segundosHastaMedianoche = (24 * 3600) - (hora * 3600) - (minuto * 60);
        System.out.println("Desde las " + hora + ":" + minuto + " hasta la medianoche faltan " + segundosHastaMedianoche + " segundos.");

        // Ejercicio 6 - Ordenar tres números
        System.out.println("Introduzca tres números enteros:");
        int a = leer.nextInt();
        int b = leer.nextInt();
        int c = leer.nextInt();
        int aux;
        if (a > b) { aux = a; a = b; b = aux; }
        if (b > c) { aux = b; b = c; c = aux; }
        if (a > b) { aux = a; a = b; b = aux; }
        System.out.println("Ordenados de menor a mayor: " + a + ", " + b + " y " + c);

        // Ejercicio 7 - Última cifra de un número
        System.out.print("Introduzca un número entero: ");
        int n = leer.nextInt();
        System.out.println("La última cifra es " + (n % 10));

        // Ejercicio 8 - Primera cifra de un número (hasta 5 cifras)
        System.out.print("Introduzca un número entero (máximo 5 cifras): ");
        n = leer.nextInt();
        int primera = 0;
        if      (n < 10)    primera = n;
        else if (n < 100)   primera = n / 10;
        else if (n < 1000)  primera = n / 100;
        else if (n < 10000) primera = n / 1000;
        else                primera = n / 10000;
        System.out.println("La primera cifra es " + primera);

        // Ejercicio 9 - Número de dígitos
        System.out.print("Introduzca un número entero: ");
        int num = leer.nextInt();
        int copiaNum = num;
        int dig = 0;
        if (num < 0) num *= -1;
        while (num > 9) { dig++; num /= 10; }
        dig++;
        System.out.println("El número " + copiaNum + " tiene " + dig + " dígitos");

        // Ejercicio 10 - Número capicúa (hasta 5 cifras)
        System.out.print("Introduzca un número entero (máximo 5 cifras): ");
        n = leer.nextInt();
        boolean capicua = false;
        if (n < 10) {
            capicua = true;
        } else if (n < 100) {
            capicua = (n / 10) == (n % 10);
        } else if (n < 1000) {
            capicua = (n / 100) == (n % 10);
        } else if (n < 10000) {
            capicua = ((n / 1000) == (n % 10)) && (((n / 100) % 10) == ((n / 10) % 10));
        } else {
            capicua = ((n / 10000) == (n % 10)) && (((n / 1000) % 10) == ((n / 10) % 10));
        }
        System.out.println(capicua ? "El número es capicúa." : "El número no es capicúa.");

        // Ejercicio 11 - Precio final con IVA y código promocional
        System.out.print("Introduzca la base imponible: ");
        double baseImponible = leer.nextDouble();
        System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido): ");
        String tipoIVA = leer.next();
        System.out.print("Introduzca el código promocional (nopro, mitad, meno5 o 5porc): ");
        String codigoPromocional = leer.next();

        int iva = 0;
        switch (tipoIVA) {
            case "general":      iva = 21; break;
            case "reducido":     iva = 10; break;
            case "superreducido":iva = 4;  break;
            default: System.out.println("Tipo de IVA no válido.");
        }
        double ivaProducto = baseImponible * iva / 100;
        double precioSinDescuento = baseImponible + ivaProducto;

        double descuento = 0;
        switch (codigoPromocional) {
            case "nopro":  break;
            case "mitad":  descuento = precioSinDescuento / 2;        break;
            case "meno5":  descuento = 5;                              break;
            case "5porc":  descuento = precioSinDescuento * 0.05;     break;
            default: System.out.println("Código promocional no válido.");
        }
        System.out.printf("Base imponible       %6.2f%n", baseImponible);
        System.out.printf("IVA (%2d%%)            %6.2f%n", iva, ivaProducto);
        System.out.printf("Precio con IVA       %6.2f%n", precioSinDescuento);
        System.out.printf("Descuento (%-5s)    -%6.2f%n", codigoPromocional, descuento);
        System.out.printf("TOTAL                %6.2f%n", precioSinDescuento - descuento);

        // Ejercicio 12 - Nómina del empleado
        System.out.println("1 - Programador junior\n2 - Programador senior\n3 - Jefe de proyecto");
        System.out.print("Introduzca el cargo (1-3): ");
        int cargo = leer.nextInt();
        System.out.print("Días de viaje visitando clientes: ");
        int diasVisita = leer.nextInt();
        System.out.print("Estado civil (1 - Soltero, 2 - Casado): ");
        int estadoCivil = leer.nextInt();

        double sueldoBase = 0;
        switch (cargo) {
            case 1: sueldoBase = 950;  break;
            case 2: sueldoBase = 1200; break;
            case 3: sueldoBase = 1600; break;
            default: System.out.println("Cargo no válido.");
        }
        double dietas = diasVisita * 30;
        double sueldoBruto = sueldoBase + dietas;
        double irpf = (estadoCivil == 1) ? 25 : 20;
        double cuantiaIrpf = sueldoBruto * irpf / 100;

        System.out.println("***********************************");
        System.out.printf("* Sueldo base          %7.2f   *%n", sueldoBase);
        System.out.printf("* Dietas (%2d viajes)   %7.2f   *%n", diasVisita, dietas);
        System.out.println("***********************************");
        System.out.printf("* Sueldo bruto         %7.2f   *%n", sueldoBruto);
        System.out.printf("* Retención IRPF (%.0f%%) %7.2f   *%n", irpf, cuantiaIrpf);
        System.out.println("***********************************");
        System.out.printf("* Sueldo neto          %7.2f   *%n", sueldoBruto - cuantiaIrpf);
        System.out.println("***********************************");

        leer.close();
    }
}