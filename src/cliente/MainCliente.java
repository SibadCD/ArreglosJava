package cliente;

import java.util.Scanner;

public class MainCliente {
    public static void main(String[] args) {
        // VARIABLES
        String nombre, tipo;
        double total, suma;
        int opc, premium, estandar, posMayor;
        boolean lleno = false;

        // ARREGLO DE CLIENTES
        final int MAX = 3;
        Cliente clientes[] = new Cliente[MAX];
        Scanner sc = new Scanner(System.in);

        // MENÚ: todas las opciones trabajan con el arreglo completo
        do {
            System.out.println();
            System.out.println("===== CLIENTES =====");
            System.out.println("1. Llenar todo el arreglo");
            System.out.println("2. Mostrar el resumen de todos los clientes");
            System.out.println("3. Calcular el total que se debe cobrar");
            System.out.println("4. Contar clientes premium y estándar");
            System.out.println("5. Mostrar al cliente con la compra más alta");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            // Si el arreglo está vacío no se puede mostrar ni calcular nada
            if (opc >= 2 && opc <= 5 && !lleno) {
                System.out.println("Primero debe llenar el arreglo (opción 1).");
            } else {
                switch (opc) {
                    case 1:
                        // Se pide un cliente por cada espacio del arreglo
                        for (int i = 0; i < clientes.length; i++) {
                            System.out.println("--- Cliente " + (i + 1) + " ---");
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el tipo de cliente (premium o estandar): ");
                            tipo = sc.nextLine();
                            System.out.print("Ingrese el total de la compra: ");
                            total = Double.parseDouble(sc.nextLine());
                            clientes[i] = new Cliente(nombre, tipo, total);
                        }
                        lleno = true;
                        break;

                    case 2:
                        // Se recorre todo el arreglo mostrando el resumen de cada cliente
                        for (int i = 0; i < clientes.length; i++) {
                            System.out.println("--- Cliente " + (i + 1) + " ---");
                            clientes[i].mostrarResumen();
                        }
                        break;

                    case 3:
                        // Se suma el monto final (compra menos descuento) de todos los clientes
                        suma = 0;
                        for (int i = 0; i < clientes.length; i++) {
                            suma += clientes[i].getTotalCompra() - clientes[i].calcularDescuento();
                        }
                        System.out.println("Total a cobrar: $" + Math.round(suma * 100.0) / 100.0);
                        break;

                    case 4:
                        // Se cuenta cuántos clientes hay de cada tipo
                        premium = 0;
                        estandar = 0;
                        for (int i = 0; i < clientes.length; i++) {
                            if (clientes[i].getTipoCliente().equals("premium")) {
                                premium++;
                            } else {
                                estandar++;
                            }
                        }
                        System.out.println("Clientes premium: " + premium);
                        System.out.println("Clientes estándar: " + estandar);
                        break;

                    case 5:
                        // Se busca la posición del cliente que más compró
                        posMayor = 0;
                        for (int i = 1; i < clientes.length; i++) {
                            if (clientes[i].getTotalCompra() > clientes[posMayor].getTotalCompra()) {
                                posMayor = i;
                            }
                        }
                        System.out.println("El cliente con la compra más alta es:");
                        clientes[posMayor].mostrarResumen();
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
