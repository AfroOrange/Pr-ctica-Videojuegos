import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.println("\n------------ Inicio de sesión ------------");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Mostrar lista de videojuegos");
            System.out.println("2. Añadir nuevo videojuego");
            System.out.println("3. Mostrar lista de usuarios");
            System.out.println("4. Añadir nuevo usuario");
            System.out.println("5. Comprar videojuego");
            System.out.println("6. Cerrar sesión");

            System.out.print("Introducir opción (1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Videojuegos.mostrarVideojuegos();
                    break;
                case "2":
                    addNewGameMenu();
                    break;
                case "3":
                    Usuarios.mostrarUsuarios();
                    break;
                case "4":
                    addNewUserMenu();
                    break;
                case "5":
                    buyGameMenu();
                    break;
                case "6":
                    System.out.println("Sesión finalizada");
                    return;
                default:
                    System.out.println("Opción no válida. Introduce un nuevo número del (1-6)");
            }
        }
    }

    static void addNewGameMenu() {
        try {
            System.out.print("Introducir nombre del videojuego: ");
            String nombre = scanner.nextLine();
            System.out.print("Introducir nombre de la consola: ");
            String consola = scanner.nextLine();

            if (!Videojuegos.nombresValidos.contains(consola)) {
                throw new IllegalArgumentException("Los nombres válidos son: " + String.join(", ", Videojuegos.nombresValidos));
            }
            System.out.print("Introducir estado del videojuego (En venta, Agotado, Obsoleto): ");
            String estado = scanner.nextLine();
            if (!Videojuegos.estadosValidos.contains(estado)) {
                throw new IllegalArgumentException("Los valores válidos son: " + String.join(", ", Videojuegos.estadosValidos));
            }
            System.out.print("Introducir Stock: ");
            int stock = Integer.parseInt(scanner.nextLine());

            Videojuegos newGame = new Videojuegos(nombre, consola, estado, stock);
            newGame.añadirVideojuego();

            System.out.println("Videojuego añadido a la lista");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void addNewUserMenu() {
        try {
            System.out.print("Introducir DNI del usuario: ");
            String dni = scanner.nextLine();
            System.out.print("Introducir nombre de usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Introducir apellido de usuario: ");
            String apellidos = scanner.nextLine();
            System.out.print("Introducir número de teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Introducir el email: ");
            String correo = scanner.nextLine();

            Usuarios newUser = new Usuarios(dni, nombre, apellidos, telefono, correo);
            newUser.agregarUsuarios();

            System.out.println("Usuario añadido con éxito");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void buyGameMenu() {
        try {
            System.out.print("Introducir DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Introducir el número de serie: ");
            int serial = Integer.parseInt(scanner.nextLine());

            GestorCompras.comprarJuegos(dni, serial);
        } catch (NumberFormatException e) {
            System.out.println("Número de serie inválido");
        }
    }
}
