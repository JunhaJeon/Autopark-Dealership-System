import java.io.*;
import java.util.*;

public class AutoPark {
    private String name;
    private double revenue;
    private List<Item> items; // List to store items available in the auto park.
    private List<Customer> customers; // List to store registered customers.

    // Constructor to initialize the auto park with the given name.
    public AutoPark(String name) {
        this.name = name;
        this.revenue = 0;
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Adds an item to the auto park if it doesn't already exist.
    public boolean addItem(Item item) {
        // Check for duplicate items based on their string representation.
        for (Item existingItem : items) {
            if (existingItem.toString().equals(item.toString())) {
                return false;
            }
        }
        items.add(item);
        return true;
    }

    // Registers a customer if their name is unique.
    public boolean registerCustomer(Customer customer) {
        // Check for duplicate customer names.
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getName().equals(customer.getName())) {
                return false;
            }
        }
        customers.add(customer);
        return true;
    }

    // Returns a list of registered customers.
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    // Returns a list of items available in the auto park.
    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    // Searches for items containing the given string (case-insensitive).
    public List<Item> searchItems(String x) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.toString().toLowerCase().contains(x.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    // Searches for items containing the given string and within the specified price range.
    public List<Item> searchItems(String x, double minPrice, double maxPrice) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            double price = item.getPrice();
            if (item.toString().toLowerCase().contains(x.toLowerCase()) &&
                    (minPrice < 0 || price >= minPrice) &&
                    (maxPrice < 0 || price <= maxPrice)) {
                result.add(item);
            }
        }
        return result;
    }

    // Adds stock to an existing item in the auto park.
    public boolean addStock(Item anItem, int amount) {
        for (Item item : items) {
            if (item.toString().equals(anItem.toString())) {
                item.setInvQuantity(item.getInvQuantity() + amount);
                return true;
            }
        }
        return false;
    }

    // Sells an item to a customer and updates the stock and customer's purchase history.
    public boolean sellItem(Item anItem, Customer c, int amount) {
        // Check if the customer is registered.
        if (!customers.contains(c)) {
            return false;
        }

        for (Item item : items) {
            // Check if the item exists and if there's enough stock.
            if (item.toString().equals(anItem.toString()) && item.getInvQuantity() >= amount) {
                // Update the stock and sold quantity.
                item.setInvQuantity(item.getInvQuantity() - amount);
                item.setSoldQuantity(item.getSoldQuantity() + amount);
                // Add the purchase to the customer's history.
                c.addPurchase(item, amount);
                // Update the revenue.
                revenue += item.getPrice() * amount;
                return true;
            }
        }
        return false;
    }

    // Returns a list of the top x most popular items based on sales.
    public List<Item> getXPopularItems(int x) {
        if (x <= 0) {
            return new ArrayList<>();
        }

        // Sort items by sold quantity in descending order.
        List<Item> sortedItems = new ArrayList<>(items);
        sortedItems.sort((item1, item2) -> Integer.compare(item2.getSoldQuantity(), item1.getSoldQuantity()));
        return sortedItems.subList(0, Math.min(x, sortedItems.size()));
    }

    // Saves the auto park state to a file.
    public boolean saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Loads the auto park state from a file.
    public static AutoPark loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (AutoPark) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
