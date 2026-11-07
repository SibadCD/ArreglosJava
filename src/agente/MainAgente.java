package agente;

import java.util.Scanner;

public class MainAgente {
    public static void main(String[] args) {
        // VARIABLES
        String nombre, estado;
        int energia, opc, pos, cantidad, contador;
        boolean encontrado;

        // ARREGLO DE AGENTES
        // indice indica cuántos agentes hay registrados y también cuál es el próximo espacio libre
        final int MAX = 5;
        Agente agentes[] = new Agente[MAX];
        int indice = 0;
        Scanner sc = new Scanner(System.in);

        // MENÚ: se ingresa una cantidad de agentes a la vez y las demás opciones piden un índice o un nombre
        do {
            System.out.println();
            System.out.println("===== AGENTES =====");
            System.out.println("1. Ingresar una cantidad de agentes");
            System.out.println("2. Mostrar la información de un agente (por índice)");
            System.out.println("3. Cambiar la energía de un agente (por índice)");
            System.out.println("4. Cambiar el estado de un agente (por índice)");
            System.out.println("5. Buscar un agente por su nombre");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            // Si todavía no hay agentes, las opciones 2 a 5 no tienen nada que buscar
            if (opc >= 2 && opc <= 5 && indice == 0) {
                System.out.println("Todavía no hay agentes registrados.");
            } else {
                switch (opc) {
                    case 1:
                        System.out.print("¿Cuántos agentes desea ingresar? ");
                        cantidad = Integer.parseInt(sc.nextLine());
                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor que 0.");
                        } else if (indice + cantidad <= MAX) {
                            // Hay espacio para toda la cantidad pedida, así que se ingresan uno por uno
                            contador = 0;
                            while (contador < cantidad) {
                                System.out.println("--- Agente " + (indice + 1) + " ---");
                                System.out.print("Ingrese el nombre: ");
                                nombre = sc.nextLine();
                                System.out.print("Ingrese el nivel de energía (0 a 100): ");
                                energia = Integer.parseInt(sc.nextLine());
                                System.out.print("Ingrese el estado (activo o inactivo): ");
                                estado = sc.nextLine();
                                agentes[indice++] = new Agente(nombre, energia, estado);
                                contador++;
                            }
                        } else {
                            System.out.println("No hay espacio suficiente. Espacios libres: " + (MAX - indice));
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el índice del agente (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            agentes[pos].mostrarEstado();
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el índice del agente (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            System.out.print("Ingrese el nuevo nivel de energía (0 a 100): ");
                            energia = Integer.parseInt(sc.nextLine());
                            agentes[pos].setNivelEnergia(energia);
                            System.out.println("Energía actual: " + agentes[pos].getNivelEnergia() + "%");
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el índice del agente (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            System.out.print("Ingrese el nuevo estado (activo o inactivo): ");
                            estado = sc.nextLine();
                            agentes[pos].setEstado(estado);
                            System.out.println("Estado actual: " + agentes[pos].getEstado());
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 5:
                        // Se recorre solo la parte del arreglo que ya tiene agentes
                        System.out.print("Ingrese el nombre del agente a buscar: ");
                        nombre = sc.nextLine();
                        encontrado = false;
                        for (int i = 0; i < indice; i++) {
                            if (agentes[i].getNombre().equalsIgnoreCase(nombre)) {
                                System.out.println("Encontrado en el índice " + i);
                                agentes[i].mostrarEstado();
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No se encontró ningún agente con ese nombre.");
                        }
                        break;

                    case 0:
                        System.out.println("Programa terminado.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } while (opc != 0);
    }
}
