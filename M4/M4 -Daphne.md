# M4 – Online Shop Application

## Project Description
A simplified online shop where users can add products to a shopping cart, complete orders, and generate invoices.


## Learning Objectives

* I can sketch and interpret UML class diagrams.
* I can show how to use hierarchies and/or interfaces in my design.
* I can create a sequence diagram for one use case.
* After completing the project, I can present a detailed UML class diagram and sequence diagram.
* I can apply object-oriented principles such as **delegation**, **polymorphism**, and **design patterns**.


## Project Goal

Create an **object-oriented application** that:
* Demonstrates **delegation** and **polymorphism**
* Applies **at least two design patterns**
* Uses a **clean, modular architecture**
* Includes **exception handling**, **data persistence**, and **interface-based design**


## Requirements
* The application must be **object-oriented** (preferably Java/JVM-based).
* Minimum **8 self-written classes** (~800 lines of code).
* Use of **AI assistance is allowed**, but must be declared in comments.
* Must include:
  * **User Interface layer**
  * **Business Logic layer**
  * **Persistence layer** (e.g. database, file, or JSON storage)
* Must validate user input (**exception handling** required).
* Must implement **2+ design patterns**, explained and justified.
* Must use **interfaces and inheritance** where appropriate.
* Must follow **Clean Code principles** and document where applied.
* Optional: **Spring Boot** framework (if familiar).

---

## Use Cases

### 1. Add Product to Cart
**Actor:** User
**Flow:**
1. User selects a product.
2. Adds product to the shopping cart.
3. System updates and displays the cart contents.


### 2. Complete Order
**Actor:** User
**Flow:**
1. User reviews cart.
2. Chooses payment method.
3. System creates an order.
4. `PaymentService` processes the payment.
5. Order is saved to repository.


### 3. Generate Invoice
**Actor:** System/User
**Flow:**
1. After the order is completed, the system generates an invoice.
2. Invoice is stored or displayed.

## Classes (UML Klassendiagramm)

| Class                       | Responsibility |
| --------------------------   | ----------------------------------------------- |
| **Product**                  | Represents a product with `id`, `name`, `price` and provides methods `getPrice()` and `getDescription()`.|
| **Cart**                  | Manages a list of `Product` items. Allows users to add and remove Products and get Total.  |
| **User**                    | Represents a registered or guest user with `id`, `name`, and a `cart`. Lets users add Products to cart and checkout. |
| **Order**                  | Represents a completed purchase. Calcilates the total price and applies Discount. |
| **PaymentService**        | Handles payment logic. Provides methods `calculateDiscount(Order)` and `pay(Order, PaymentMethod)`. |
| **OrderRepository**        | Stores and retrieves orders. |
| **DiscountStrategy (interface)** | Defines discount calculation behavior, used by `Order` to apply different discount strategies. |


## Design Patterns

| Pattern               | Purpose                                                                | Example in Project                                       |
| --------------------- | ---------------------------------------------------------------------- | -------------------------------------------------------- |
| **Strategy Pattern**  | Allows different discount or payment logic to be selected dynamically. | Different discount strategies (percentage, fixed, none). |
| **Decorator Pattern** | Adds extra features to a product without changing its base class.      | Adding gift wrapping or express shipping options.        |


## Reflection

