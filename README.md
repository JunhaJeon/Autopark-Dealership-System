# Autopark
A Java program simulating an automated vehicle dealership using Abstract Data Types (ADTs), Object-Oriented Programming, and File I/O.

# Overview
This project models a dealership system where customers can register, browse and purchase vehicles, and their purchase history is tracked. The dealership manages its inventory dynamically using ADTs and allows saving/loading system data to and from files. It was developed for an academic assignment focused on practicing OOP principles and Java collections.

# Technologies Used
Java

Object-Oriented Programming (OOP)

Java Collections Framework (ArrayList, HashMap)

File I/O (BufferedReader, PrintWriter, etc.)

# Features
✅ Customer Management
Register customers (unique names only)

Track total spending and detailed purchase history

Prevent duplicate customer registration

✅ Inventory Management
Add vehicle and tire items without duplicates (based on toString())

Increase stock for existing items

Search items by keyword and optional price range

Get most popular (best-selling) items

✅ File Handling
Save AutoPark state (items + customers) to file

Load AutoPark state from file safely with validationg

✅ Analytics
Get top X popular items sold, sorted by quantity

Print purchase history per customer

# File I/O
Save state to file via saveToFile(String filename)

Load state from file via loadFromFile(String filename)

# Testing
Two test classes are provided for basic functionality. Additional custom tests are encouraged and included in this repo.

# Sample Output
=== Registered Customers ===
Alice has spent $64,000.00
2 x AWD SUV: 2021 Chevy Trailblazer (Red), $32,000.00 each

=== Popular Items ===
1. AWD SUV: 2021 Chevy Trailblazer (Red) - 2 units sold
2. All-Season Tire: Goodyear Wrangler - 1 unit sold


# Project Structure
```
AutoPark.java                 // Core dealership logic
AutoParkTester.java           // Main tester class with example functionality
AutoParkLoadTester.java       // Demonstrates loading/saving state from file
Customer.java                 // Manages customer info and purchase history

Item.java                     // Base class for all items
Tire.java                     // Tire item implementation

Vehicle.java                  // Base class for all vehicle types
  ├── CommercialVehicle.java
  ├── PersonalVehicle.java
        ├── Sedan.java
        ├── Minivan.java
        ├── SUV.java
  └── Truck.java              // Specific commercial vehicle subclass

```

# How to Run
Compile:
javac *.java

Run the test file:
java AutoParkTester

Run File I/O Test:
java AutoParkLoadTester


# Key Concepts Practiced
Object-Oriented Design (Inheritance, Encapsulation)

Abstract Data Types (Lists and Maps)

Defensive programming and validation

File I/O (persistence, serialization via text files)

Custom search and sort logic


# School Project
This project was part of my coursework for "COMP1406 Summer 2024" at Carleton Universiry.

# Contact
For any questions, feel free to reach out via GitHub issues or email.
