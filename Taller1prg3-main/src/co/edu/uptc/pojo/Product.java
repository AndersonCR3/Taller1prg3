package co.edu.uptc.pojo;

public class Product {
    private final String description;
    private final double price;
    private final String unity;

    public Product(String description, double price, String unity) {
        this.description = description;
        this.price = price;
        this.unity = unity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getUnity() {
        return unity;
    }

    @Override
    public String toString() {
        return "Description: " + description + " | Price: " + price + " | Unit: " + unity;
    }
}
