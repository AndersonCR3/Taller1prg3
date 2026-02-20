package co.edu.uptc.model;

import co.edu.uptc.pojo.Product;

public class ProductListAdapter {
    private static final String SEPARATOR = "|";
    private final ManagerList list;
    private MyList<Product> productsList;

    public ProductListAdapter() {
        this.list = new ManagerList();
        this.productsList = new MyList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        list.addEnd(serialize(product));
    }

    public Product[] toArray() {
        int count = 0;
        Node current = list.header;
        while (current != null) {
            count++;
            current = current.next;
        }

        Product[] products = new Product[count];
        current = list.header;
        int index = 0;
        while (current != null) {
            Product product = deserialize(current.value);
            if (product != null) {
                products[index++] = product;
            }
            current = current.next;
        }
        return products;
    }

    // --- MODIFIED METHOD ---
    public Product[] sortedByDescription() {
        if (list.header == null) {
            return new Product[0];
        }

        // 1. Clear and initialize the temporary MyList
        productsList = new MyList<>(); 
        
        // 2. Extract all products from the linked list (ManagerList) to MyList
        Node current = list.header;
        while (current != null) {
            Product product = deserialize(current.value);
            if (product != null) {
                productsList.add(product);
            }
            current = current.next;
        }

        // 3. Sort using the sort method and a Comparator (Lambda Expression)
        productsList.sort((p1, p2) -> p1.getDescription().compareToIgnoreCase(p2.getDescription()));

        // 4. Convert the sorted MyList to an array
        Product[] result = new Product[productsList.size()];
        for (int i = 0; i < productsList.size(); i++) {
            result[i] = productsList.get(i);
        }
        
        return result;
    }

    public int removeByDescriptionContains(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String criteria = text.trim().toLowerCase();
        int removed = 0;
        Node prev = null;
        Node current = list.header;
        while (current != null) {
            Product product = deserialize(current.value);
            boolean match = product != null && product.getDescription().toLowerCase().contains(criteria);
            if (match) {
                removed++;
                if (prev == null) {
                    list.header = current.next;
                    current = list.header;
                } else {
                    prev.next = current.next;
                    current = prev.next;
                }
                continue;
            }
            prev = current;
            current = current.next;
        }
        return removed;
    }

    private String serialize(Product product) {
        return product.getDescription() + SEPARATOR
                + product.getPrice() + SEPARATOR
                + product.getUnity();
    }

    private Product deserialize(String value) {
        if (value == null) {
            return null;
        }
        String[] parts = value.split("\\|", 3);
        if (parts.length < 3) {
            return null;
        }
        try {
            double price = Double.parseDouble(parts[1]);
            return new Product(parts[0], price, parts[2]);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}