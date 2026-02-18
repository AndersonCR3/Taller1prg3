package co.edu.uptc.view;

import java.util.List;
import java.util.Scanner;

import co.edu.uptc.interfaces.IProductView;
import co.edu.uptc.pojo.Producto;

public class ConsoleProductView implements IProductView {
    private final Scanner scanner;

    public ConsoleProductView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int mostrarMenu() {
        System.out.println("\n=== Administrador de productos ===");
        System.out.println("1. Adicionar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Listar productos ordenados por nombre");
        System.out.println("4. Borrar productos por nombre");
        System.out.println("0. Salir");
        return leerEntero("Seleccione una opcion: ");
    }

    @Override
    public Producto solicitarProducto() {
        String descripcion = solicitarTexto("Descripcion: ");
        double precio = leerDouble("Precio: ");
        String unidad = solicitarTexto("Unidad de medida: ");
        return new Producto(descripcion, precio, unidad);
    }

    @Override
    public void mostrarProductos(List<Producto> productos, String titulo) {
        System.out.println("\n" + titulo + ":");
        if (productos == null || productos.isEmpty()) {
            System.out.println("Sin productos.");
            return;
        }
        int index = 1;
        for (Producto producto : productos) {
            System.out.println(index + ". " + producto);
            index++;
        }
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public String solicitarTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("El texto no puede estar vacio.");
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}
