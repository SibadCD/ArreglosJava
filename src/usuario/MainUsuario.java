package usuario;

import java.util.Scanner;

public class MainUsuario {
    public static void main(String[] args) {
        // VARIABLES
        String nombre, correo, contrasena;
        int opc, pos;
        boolean encontrado;

        // ARREGLO DE USUARIOS
        // indice indica cuántos usuarios hay registrados y también cuál es el próximo espacio libre
        final int MAX = 3;
        Usuario usuarios[] = new Usuario[MAX];
        int indice = 0;
        Scanner sc = new Scanner(System.in);

        // MENÚ: los usuarios se ingresan de uno en uno y las demás opciones piden un índice o un nombre
        do {
            System.out.println();
            System.out.println("===== USUARIOS =====");
            System.out.println("1. Registrar un usuario");
            System.out.println("2. Mostrar los datos de un usuario (por índice)");
            System.out.println("3. Cambiar la contraseña de un usuario (por índice)");
            System.out.println("4. Buscar un usuario por su nombre");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            // Si todavía no hay usuarios, las opciones 2, 3 y 4 no tienen nada que buscar
            if (opc >= 2 && opc <= 4 && indice == 0) {
                System.out.println("Todavía no hay usuarios registrados.");
            } else {
                switch (opc) {
                    case 1:
                        // Solo se registra si queda espacio libre en el arreglo
                        if (indice < MAX) {
                            System.out.print("Ingrese el nombre de usuario: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el correo: ");
                            correo = sc.nextLine();
                            System.out.print("Ingrese la contraseña (mínimo 8 caracteres): ");
                            contrasena = sc.nextLine();
                            usuarios[indice++] = new Usuario(nombre, correo, contrasena);
                        } else {
                            System.out.println("No hay más espacio en el arreglo.");
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el índice del usuario (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            usuarios[pos].mostrarDatos();
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el índice del usuario (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            System.out.print("Ingrese la nueva contraseña: ");
                            contrasena = sc.nextLine();
                            usuarios[pos].setContrasena(contrasena);
                            // Se comprueba con el get si la contraseña realmente cambió
                            if (usuarios[pos].getContrasena().equals(contrasena)) {
                                System.out.println("La contraseña fue actualizada.");
                            }
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 4:
                        // Se recorre solo la parte del arreglo que ya tiene usuarios
                        System.out.print("Ingrese el nombre de usuario a buscar: ");
                        nombre = sc.nextLine();
                        encontrado = false;
                        for (int i = 0; i < indice; i++) {
                            if (usuarios[i].getNombreUsuario().equalsIgnoreCase(nombre)) {
                                System.out.println("Encontrado en el índice " + i);
                                usuarios[i].mostrarDatos();
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No se encontró ningún usuario con ese nombre.");
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
