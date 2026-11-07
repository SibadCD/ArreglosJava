package motor;

import java.util.Scanner;

public class MainMotor {
    public static void main(String[] args) {
        // VARIABLES
        int opc, pos, velocidad;

        // ARREGLO DE MOTORES
        final int MAX = 3;
        Motor motores[] = new Motor[MAX];
        Scanner sc = new Scanner(System.in);

        // LLENAR TODO EL ARREGLO
        // Cada espacio necesita su propio motor, si no el espacio queda vacío (null) y el programa falla
        for (int i = 0; i < motores.length; i++) {
            motores[i] = new Motor();
        }
        System.out.println("Se crearon " + motores.length + " motores apagados.");

        // MENÚ: las opciones piden el índice del motor con el que se quiere trabajar
        do {
            System.out.println();
            System.out.println("===== MOTORES =====");
            System.out.println("1. Encender un motor");
            System.out.println("2. Apagar un motor");
            System.out.println("3. Ajustar la velocidad de un motor");
            System.out.println("4. Mostrar el estado de un motor");
            System.out.println("5. Mostrar el estado de todos los motores");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el índice del motor (0 a " + (motores.length - 1) + "): ");
                    pos = Integer.parseInt(sc.nextLine());
                    if (pos >= 0 && pos < motores.length) {
                        motores[pos].encender();
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el índice del motor (0 a " + (motores.length - 1) + "): ");
                    pos = Integer.parseInt(sc.nextLine());
                    if (pos >= 0 && pos < motores.length) {
                        motores[pos].apagar();
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el índice del motor (0 a " + (motores.length - 1) + "): ");
                    pos = Integer.parseInt(sc.nextLine());
                    if (pos >= 0 && pos < motores.length) {
                        System.out.print("Ingrese la nueva velocidad (0 a 100): ");
                        velocidad = Integer.parseInt(sc.nextLine());
                        motores[pos].ajustarVelocidad(velocidad);
                        System.out.println("Velocidad actual: " + motores[pos].getVelocidad());
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el índice del motor (0 a " + (motores.length - 1) + "): ");
                    pos = Integer.parseInt(sc.nextLine());
                    if (pos >= 0 && pos < motores.length) {
                        motores[pos].mostrarEstado();
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 5:
                    for (int i = 0; i < motores.length; i++) {
                        System.out.print("Motor " + i + ": ");
                        motores[i].mostrarEstado();
                    }
                    break;

                case 0:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opc != 0);
    }
}
