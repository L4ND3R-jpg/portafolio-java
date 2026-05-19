package Notas;

import java.util.Arrays;
import java.util.Scanner;

public class EjNotas {

    public EjNotas() {
        int[][] notas = {
            { 5, 7, 8, 6, 9, 4, 7, 8, 5, 6, 7, 9, 8, 6, 5, 7, 8, 9, 9, 7 },
            { 6, 8, 8, 4, 4, 6, 8, 7, 9, 5, 6, 8, 7, 5, 6, 8, 9, 7, 8, 6 },
            { 7, 6, 3, 4, 7, 5, 6, 9, 8, 7, 5, 6, 9, 8, 7, 6, 5, 8, 4, 7 },
            { 8, 9, 6, 7, 8, 9, 5, 6, 7, 8, 9, 5, 6, 7, 8, 9, 6, 7, 9, 8 },
            { 9, 5, 8, 7, 6, 8, 9, 5, 6, 7, 8, 9, 5, 6, 7, 8, 5, 6, 7, 9 }
        };
        String[] alumnos = {
            "Juan García", "María López", "Carlos Ruiz", "Ana Martínez", "Pedro Sánchez",
            "Laura Fernández", "Diego Torres", "Sofía Romero", "Javier Díaz", "Carmen Muñoz",
            "Alberto Pérez", "Elena González", "Miguel Ángel", "Isabel Jiménez", "Francisco Gil",
            "Lucía Ramos", "Roberto Herrera", "Patricia Vega", "Daniel Moreno", "Cristina Silva"
        };
        String[] asignaturas = { "Programacion", "BBDD", "Sistemas", "LLMM", "Entornos" };

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n═════════════════════════════════════════");
            System.out.println("         MENÚ GESTIÓN DE NOTAS");
            System.out.println("═════════════════════════════════════════");
            System.out.println("1.  Mostrar notas de todos los alumnos en una asignatura");
            System.out.println("2.  Mostrar notas de un alumno");
            System.out.println("3.  Alumno con mejor expediente");
            System.out.println("4.  Alumnos con nota >=8 en Programación y suspenso en Sistemas");
            System.out.println("5.  Alumnos suspensos en BBDD o Sistemas (solo uno)");
            System.out.println("6.  Alumno con mejor nota media");
            System.out.println("7.  Asignatura con mejor nota media");
            System.out.println("8.  Alumnos aprobados en una asignatura");
            System.out.println("9.  Alumnos suspensos en una asignatura");
            System.out.println("10. Contar aprobados por asignatura");
            System.out.println("11. Contar suspensos por asignatura");
            System.out.println("12. Modificar nota de un alumno");
            System.out.println("13. Estadísticas generales");
            System.out.println("14. Salir");
            System.out.println("═════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n═══ MOSTRAR NOTAS POR ASIGNATURA ═══");
                    for (int i = 0; i < asignaturas.length; i++)
                        System.out.println((i + 1) + ". " + asignaturas[i]);
                    System.out.print("Opción: ");
                    int opcionAsig = sc.nextInt();
                    if (opcionAsig < 1 || opcionAsig > asignaturas.length) {
                        System.out.println("Asignatura no válida.");
                    } else {
                        int indexAsig = opcionAsig - 1;
                        System.out.println("\n═══ NOTAS DE " + asignaturas[indexAsig].toUpperCase() + " ═══");
                        System.out.println("─────────────────────────────────────");
                        for (int i = 0; i < alumnos.length; i++)
                            System.out.printf("%-25s : %2d%n", alumnos[i], notas[indexAsig][i]);
                        System.out.println("─────────────────────────────────────");
                    }
                    break;

                case 2:
                    System.out.println("\n═══ MOSTRAR NOTAS DE UN ALUMNO ═══");
                    for (int i = 0; i < alumnos.length; i++)
                        System.out.println((i + 1) + ". " + alumnos[i]);
                    System.out.print("Seleccione el alumno: ");
                    int opcionAlum = sc.nextInt();
                    if (opcionAlum < 1 || opcionAlum > alumnos.length) {
                        System.out.println("Alumno no válido.");
                    } else {
                        int indexAlum = opcionAlum - 1;
                        System.out.println("\n═══ NOTAS DE " + alumnos[indexAlum].toUpperCase() + " ═══");
                        System.out.println("─────────────────────────────────────");
                        for (int x = 0; x < asignaturas.length; x++)
                            System.out.printf("%-25s : %2d%n", asignaturas[x], notas[x][indexAlum]);
                        System.out.println("─────────────────────────────────────");
                    }
                    break;

                case 3:
                    System.out.println("\n═══ ALUMNO CON MEJOR EXPEDIENTE ═══");
                    double[] medias = new double[alumnos.length];
                    for (int y = 0; y < notas[0].length; y++) {
                        int suma = 0;
                        for (int x = 0; x < notas.length; x++) suma += notas[x][y];
                        medias[y] = suma / (double) asignaturas.length;
                    }
                    int alumnoMejor = 0;
                    for (int x = 1; x < medias.length; x++)
                        if (medias[x] > medias[alumnoMejor]) alumnoMejor = x;
                    System.out.println("Alumno: " + alumnos[alumnoMejor] + " | Media: " + String.format("%.2f", medias[alumnoMejor]));
                    System.out.println("─────────────────────────────────────");
                    for (int i = 0; i < asignaturas.length; i++)
                        System.out.printf("%-25s : %2d%n", asignaturas[i], notas[i][alumnoMejor]);
                    break;

                case 4:
                    System.out.println("\n═══ NOTA >=8 EN PROGRAMACIÓN Y SUSPENSO EN SISTEMAS ═══");
                    for (int y = 0; y < notas[0].length; y++)
                        if (notas[0][y] >= 8 && notas[2][y] < 5)
                            System.out.printf("%-25s | Programación: %2d | Sistemas: %2d%n",
                                alumnos[y], notas[0][y], notas[2][y]);
                    break;

                case 5:
                    System.out.println("\n═══ SUSPENSO EN BBDD O SISTEMAS (SOLO UNO) ═══");
                    for (int y = 0; y < notas[0].length; y++) {
                        boolean bbddSusp = notas[1][y] < 5;
                        boolean sistSusp = notas[2][y] < 5;
                        if ((bbddSusp || sistSusp) && !(bbddSusp && sistSusp))
                            System.out.printf("%-25s | BBDD: %2d | Sistemas: %2d%n",
                                alumnos[y], notas[1][y], notas[2][y]);
                    }
                    break;

                case 6:
                    System.out.println("\n═══ ALUMNO CON MEJOR NOTA MEDIA ═══");
                    double[] mediasAlumnos = new double[alumnos.length];
                    for (int y = 0; y < notas[0].length; y++) {
                        int suma = 0;
                        for (int x = 0; x < notas.length; x++) suma += notas[x][y];
                        mediasAlumnos[y] = suma / (double) asignaturas.length;
                    }
                    int mejorAlumno = 0;
                    for (int x = 1; x < mediasAlumnos.length; x++)
                        if (mediasAlumnos[x] > mediasAlumnos[mejorAlumno]) mejorAlumno = x;
                    System.out.printf("%-25s | Media: %.2f%n", alumnos[mejorAlumno], mediasAlumnos[mejorAlumno]);
                    break;

                case 7:
                    System.out.println("\n═══ ASIGNATURA CON MEJOR NOTA MEDIA ═══");
                    int mejorAsig = 0;
                    double mejorMediaAsig = -1;
                    for (int x = 0; x < notas.length; x++) {
                        int suma = 0;
                        for (int y = 0; y < notas[x].length; y++) suma += notas[x][y];
                        double mediaAsig = suma / (double) notas[x].length;
                        System.out.printf("%-25s | Media: %.2f%n", asignaturas[x], mediaAsig);
                        if (mediaAsig > mejorMediaAsig) { mejorMediaAsig = mediaAsig; mejorAsig = x; }
                    }
                    System.out.println("─────────────────────────────────────");
                    System.out.printf("Mejor asignatura: %s con %.2f%n", asignaturas[mejorAsig], mejorMediaAsig);
                    break;

                case 8:
                    System.out.println("\n═══ ALUMNOS APROBADOS EN UNA ASIGNATURA ═══");
                    for (int i = 0; i < asignaturas.length; i++)
                        System.out.println((i + 1) + ". " + asignaturas[i]);
                    System.out.print("Opción: ");
                    int asigApro = sc.nextInt() - 1;
                    System.out.println("─────────────────────────────────────");
                    for (int y = 0; y < notas[0].length; y++)
                        if (notas[asigApro][y] >= 5)
                            System.out.printf("%-25s : %2d%n", alumnos[y], notas[asigApro][y]);
                    break;

                case 9:
                    System.out.println("\n═══ ALUMNOS SUSPENSOS EN UNA ASIGNATURA ═══");
                    for (int i = 0; i < asignaturas.length; i++)
                        System.out.println((i + 1) + ". " + asignaturas[i]);
                    System.out.print("Opción: ");
                    int asigSusp = sc.nextInt() - 1;
                    System.out.println("─────────────────────────────────────");
                    for (int y = 0; y < notas[0].length; y++)
                        if (notas[asigSusp][y] < 5)
                            System.out.printf("%-25s : %2d%n", alumnos[y], notas[asigSusp][y]);
                    break;

                case 10:
                    System.out.println("\n═══ APROBADOS POR ASIGNATURA ═══");
                    for (int x = 0; x < notas.length; x++) {
                        int cont = 0;
                        for (int y = 0; y < notas[x].length; y++)
                            if (notas[x][y] >= 5) cont++;
                        System.out.printf("%-25s : %2d aprobados%n", asignaturas[x], cont);
                    }
                    break;

                case 11:
                    System.out.println("\n═══ SUSPENSOS POR ASIGNATURA ═══");
                    for (int x = 0; x < notas.length; x++) {
                        int cont = 0;
                        for (int y = 0; y < notas[x].length; y++)
                            if (notas[x][y] < 5) cont++;
                        System.out.printf("%-25s : %2d suspensos%n", asignaturas[x], cont);
                    }
                    break;

                case 12:
                    System.out.println("\n═══ MODIFICAR NOTA DE UN ALUMNO ═══");
                    for (int i = 0; i < alumnos.length; i++)
                        System.out.println((i + 1) + ". " + alumnos[i]);
                    System.out.print("Seleccione el alumno: ");
                    int alumMod = sc.nextInt() - 1;
                    for (int i = 0; i < asignaturas.length; i++)
                        System.out.println((i + 1) + ". " + asignaturas[i]);
                    System.out.print("Seleccione la asignatura: ");
                    int asigMod = sc.nextInt() - 1;
                    System.out.println("Nota actual: " + notas[asigMod][alumMod]);
                    System.out.print("Nueva nota: ");
                    int nuevaNota = sc.nextInt();
                    notas[asigMod][alumMod] = nuevaNota;
                    System.out.println("Nota actualizada correctamente.");
                    break;

                case 13:
                    System.out.println("\n═══ ESTADÍSTICAS GENERALES ═══");
                    int notaMax = Integer.MIN_VALUE, notaMin = Integer.MAX_VALUE;
                    double sumaTotal = 0;
                    int totalNotas = 0;
                    for (int x = 0; x < notas.length; x++) {
                        for (int y = 0; y < notas[x].length; y++) {
                            sumaTotal += notas[x][y];
                            totalNotas++;
                            if (notas[x][y] > notaMax) notaMax = notas[x][y];
                            if (notas[x][y] < notaMin) notaMin = notas[x][y];
                        }
                    }
                    System.out.printf("Media general    : %.2f%n", sumaTotal / totalNotas);
                    System.out.println("Nota más alta    : " + notaMax);
                    System.out.println("Nota más baja    : " + notaMin);
                    System.out.println("Total de notas   : " + totalNotas);
                    break;

                case 14:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 14);

        sc.close();
    }
}