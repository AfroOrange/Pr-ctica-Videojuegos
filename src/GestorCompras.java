import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorCompras {
    static void mostrarCompra() {
        try (Scanner scanner = new Scanner(new File("txtfiles/compras.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void comprarJuegos(String dni, int serial) {
        boolean dniExists = false;
        try (Scanner scanner = new Scanner(new File("txtfiles/usuarios.txt"))) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().contains(dni)) {
                    dniExists = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!dniExists) {
            System.out.println("DNI no encontrado. No se puede completar la compra.");
            return;
        }

        String gameName = null;
        boolean stockJuego = false;
        List<String> datos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("txtfiles/juegos.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(String.valueOf(serial))) {
                    stockJuego = true;
                    String[] splitLine = line.split(", ");
                    gameName = splitLine[0];
                    int stock = Integer.parseInt(splitLine[3]);
                    if (stock > 0) {
                        stock--;
                        splitLine[3] = String.valueOf(stock);
                        if (stock == 1) {
                            System.out.println("Última existencia");
                        }
                        if (stock == 0) {
                            splitLine[2] = "Agotado";
                        }

                        try (PrintWriter writer = new PrintWriter(new FileWriter("txtfiles/compras.txt", true))) {
                            writer.println(dni + ", " + gameName + ", " + serial);
                            System.out.println("Compra realizada con éxito");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("El juego está agotado.");
                    }
                    line = String.join(", ", splitLine);
                }
                datos.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!stockJuego) {
            System.out.println("Juego sin stock");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("txtfiles/juegos.txt"))) {
            for (String line : datos) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
