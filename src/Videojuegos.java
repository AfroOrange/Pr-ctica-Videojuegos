import java.io.*;
import java.util.*;

class Videojuegos {
    static Random random = new Random();
    static int idVideojuego = random.nextInt(100000) + 1;
    static List<String> estadosValidos = Arrays.asList("En venta", "Agotado", "Obsoleto");
    static List<String> nombresValidos = Arrays.asList("PlayStation", "PS4", "PS5", "XBOX", "XBOX ONE", "Nintendo", "Switch", "PC", "Todas");

    String nombre;
    String consola;
    String estado;
    int stock;
    int serial;

    Videojuegos(String nombre, String consola, String estado, int stock) {
        if (!nombresValidos.contains(consola)) {
            throw new IllegalArgumentException("Los nombres válidos son: " + String.join(", ", nombresValidos));
        }
        if (!estadosValidos.contains(estado)) {
            throw new IllegalArgumentException("Los valores válidos son: " + String.join(", ", estadosValidos));
        }
        if (stock <= 0) {
            estado = "Agotado";
        }
        this.nombre = nombre;
        this.consola = consola;
        this.estado = estado;
        this.stock = stock;
    }

    static void mostrarVideojuegos() {
        try (Scanner scanner = new Scanner(new File("txtfiles/juegos.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void añadirVideojuego() {
        Set<Integer> numerosSeriales = new HashSet<>();
        try (Scanner scanner = new Scanner(new File("txtfiles/juegos.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(", ");
                numerosSeriales.add(Integer.parseInt(parts[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (numerosSeriales.contains(idVideojuego)) {
            idVideojuego = random.nextInt(100000) + 1;
        }
        serial = idVideojuego;

        try (PrintWriter writer = new PrintWriter(new FileWriter("txtfiles/juegos.txt", true))) {
            writer.println(nombre + ", " + consola + ", " + estado + ", " + stock + ", " + serial);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void actualizarStock(int serial, String nuevoEstado, int nuevoStock) {
        List<String> datos = new ArrayList<>();
        String gameName = "";
        try (Scanner scanner = new Scanner(new File("txtfiles/juegos.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(String.valueOf(serial))) {
                    String[] splitLine = line.split(", ");
                    gameName = splitLine[0];
                    splitLine[3] = String.valueOf(nuevoStock);
                    splitLine[2] = nuevoEstado;
                    line = String.join(", ", splitLine);
                }
                datos.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("El juego " + gameName + " se ha actualizado con " + nuevoStock + " unidades");

        try (PrintWriter writer = new PrintWriter(new FileWriter("txtfiles/juegos.txt"))) {
            for (String line : datos) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}