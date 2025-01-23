package pack7a;

import java.util.ArrayList;
import java.util.Map;

public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"), 22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        // duplicate won't update
        catalog.add(new Noodles("mama", "duplicate"), 11);
        showCatalog();
    }

    private void showCatalog() {
        System.out.println("Welcome to " + name);
        catalog.showCatalog();
    }

    public Basket newCustomerArrives() {
        return new Basket();
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        return new LineItem(catalog.getProduct(pName), q, catalog.getPrice(pName));
    }

    public LineItem generateBuyNowItem(String pName) {
        Basket b = new Basket();
        LineItem item = new LineItem(catalog.getProduct(pName), 1, catalog.getPrice(pName));
        b.putInBasket(item);
        ordersToday.add(b);
        return item;
    }

    public void getPayment(Basket b) {
        System.out.println("I am cashier");
        b.printInvoice();
        ordersToday.add(b);
    }

    public void dailySalesReport() {
        int grandTotal = 0;
        for (Basket b : ordersToday) {
            int total = b.getTotal();
            System.out.println("Basket total: " + total);
            grandTotal += total;
        }
        System.out.println("Grand total: " + grandTotal);
    }
}
