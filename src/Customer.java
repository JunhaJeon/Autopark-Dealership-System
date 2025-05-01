import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;
    private double totalSpent;
    private Map<Item, Integer> purchaseHistory;

    // Constructor to initialize the customer with the given name.
    public Customer(String name) {
        this.name = name;
        this.totalSpent = 0;
        this.purchaseHistory = new HashMap<>();
    }

    // Getter method for the customer's name.
    public String getName() {
        return name;
    }

    // Adds a purchase to the customer's history and updates the total amount spent.
    public void addPurchase(Item item, int quantity) {
        // Update the purchase history map with the item and quantity.
        purchaseHistory.put(item, purchaseHistory.getOrDefault(item, 0) + quantity);
        // Update the total amount spent by the customer.
        totalSpent += item.getPrice() * quantity;
    }

    // Prints the customer's purchase history.
    public void printPurchaseHistory() {
        // If the customer hasn't purchased anything, print a message.
        if (purchaseHistory.isEmpty()) {
            System.out.println("Customer didn't purchase anything");
            return;
        }

        // Print each item and the quantity purchased.
        for (Map.Entry<Item, Integer> entry : purchaseHistory.entrySet()) {
            System.out.println(entry.getValue() + " x " + entry.getKey().toString());
        }
    }

    // Returns a string representation of the customer and the total amount spent.
    @Override
    public String toString() {
        return name + " has spent $" + String.format("%,.2f", totalSpent);
    }
}
