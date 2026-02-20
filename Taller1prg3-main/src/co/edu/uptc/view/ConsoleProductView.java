package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.interfaces.IProductView;
import co.edu.uptc.pojo.Product;

public class ConsoleProductView implements IProductView {
    private final Scanner scanner;

    public ConsoleProductView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int displayMenu() {
System.out.println("\n=== Administrador de Productos ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Listar productos ordenados por descripción");
        System.out.println("4. Eliminar productos por descripción");
        System.out.println("0. Salir");
        return readInteger("Seleccione una opción: ");
    }

    @Override
    public Product requestProduct() {
String description = requestText("Descripción: ");
        double price = readDouble("Precio: ");
        String unit = requestText("Unidad de medida: ");
        return new Product(description, price, unit);
    }

    @Override
    public void displayProducts(Product[] products, String title) {
        System.out.println("\n" + title + ":");
        if (products == null || products.length == 0) {
            System.out.println("No hay registro de productos.");
            return;
        }
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String requestText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("El texto no puede estar vacío.");
        }
    }

    private int readInteger(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    }

    private double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    }
}
