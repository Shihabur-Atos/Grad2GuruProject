# Grad2GuruProject

## Table Design

### Tables
#### Product
  - ProductID
  - ProductName
  - Genre
  - Price
  - Quantity
  
#### Orders
  - OrderID
  - CustomerID
  - ProductID
  - Price
  - Quantity
  
#### Customer
  - CustomerID
  - CustomerName
  - Age
  - Email
  
Orders will link between Product and Customer and will be able to perform CRUD functions on all 3 tables


## Project Deliverable

A CRUD application that will have a console interface to allow users to manage a Game Shop's day to day activities e.g. customers details, finding their orders and looking at their inventory.

### Additional Features
 - Search functionality for each table by ID, name
 - Potentially find the highest priced order/ highest stock available
 - Potentially Front-End website if time allows
