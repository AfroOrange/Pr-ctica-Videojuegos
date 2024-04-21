import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuarios  {
    String dni;
    String nombre;
    String apellidos;
    String telefono;
    String correo;

    Usuarios(String dni, String nombre, String apellidos, String telefono, String correo) {
        if (!dni.matches("\\d{8}[A-Z]")) {
            throw new IllegalArgumentException("Formato de DNI inválido");
        }
        if (!telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El número de teléfono introducido es inválido");
        }
        if (!correo.matches("^\\S+@\\S+\\.\\S+$")) {
            throw new IllegalArgumentException("Dirección de correo electrónico no válida");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    static void mostrarUsuarios() {
        try (Scanner scanner = new Scanner(new File("txtfiles/usuarios.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void agregarUsuarios() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("txtfiles/usuarios.txt", true))) {
            writer.println(dni + ", " + nombre + ", " + apellidos + ", " + telefono + ", " + correo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void buscarUsuario(String dni) {
        try (Scanner scanner = new Scanner(new File("txtfiles/usuarios.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(dni)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void eliminarUsuario(String dni) {
        List<String> datos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("txtfiles/usuarios.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.contains(dni)) {
                    datos.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("txtfiles/usuarios.txt"))) {
            for (String line : datos) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
