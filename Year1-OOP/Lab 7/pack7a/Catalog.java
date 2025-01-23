package pack7a;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, Product> productList;
    private Map<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }

    public void add(Product product, int price) {
        productList.putIfAbsent(product.pName, product);
        priceList.putIfAbsent(product.pName, price);
    }

    public void showCatalog() {
        for (Map.Entry<String, Integer> entry : priceList.entrySet()) {
            String productName = entry.getKey();
            int price = entry.getValue();
            System.out.printf("%s @ %d%n", productName, price);
        }
    }

    public int getPrice(String productName) {
        return priceList.get(productName);
    }

    public Product getProduct(String productName) {
        return productList.get(productName);
    }
}
