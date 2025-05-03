# Autopark
A Java program that simulates an automated dealership system using Object-Oriented Programming, Abstract Data Types (ADTs), and File I/O.

# Overview
This project builds upon a basic AutoPark system and enhances it by introducing dynamic data structures and new functionality such as customer tracking, item searches, stock management, and file persistence. This version supports registering customers, managing inventory dynamically, searching/filtering items, selling to customers, and saving/loading state from files.

# Technologies Used
Java

Object-Oriented Programming (OOP)

Abstract Data Types (List, Map)

File I/O

# Features
✅ Customer Management
Register customers with unique names

Track individual purchase histories

Generate reports of customer spending and purchased items

✅ Inventory Management
Add items without duplication (based on toString())

Add stock to existing items

Sell items with quantity validation

Get top X popular items by number sold

✅ Search and Filtering
Search items by keyword (case-insensitive)

Advanced search with price filtering

✅ Persistence
Save entire AutoPark (items + customers) to a file

Load AutoPark data from file

# Class Highlights
AutoPark
Handles inventory and customer management using expandable ADTs (List, Map).

Customer
Tracks purchase history and calculates total spending.

Item & Subclasses
Represents various sellable items (e.g., cars). Includes pricing, stock tracking, and sales data.

# File I/O
Save state to file via saveToFile(String filename)

Load state from file via loadFromFile(String filename)

# Testing
Two test classes are provided for basic functionality. Additional custom tests are encouraged and included in this repo.

# Sample Output
John has spent $64,000.00
2 x AWD SUV: 2021 Chevy, Trailblazer (Red), price $32,000.00 each (8 in stock, 2 sold)

# Project Structure
```
/src
  ├── AutoPark.java
  ├── Customer.java
  ├── Item.java
  ├── [Other Item subclasses].java
/tests
  ├── AutoParkTest1.java
  ├── AutoParkTest2.java
```

# How to Run
Compile the Java files:
javac src/*.java tests/*.java

Run the test files:
java tests.AutoParkTest1
java tests.AutoParkTest2

# School Project
This project was part of my coursework for "COMP1406 Summer 2024" at Carleton Universiry.

# Contact
For any questions, feel free to reach out via GitHub issues or email.
