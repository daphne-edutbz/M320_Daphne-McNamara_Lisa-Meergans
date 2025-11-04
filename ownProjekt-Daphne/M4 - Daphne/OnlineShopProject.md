# Online Shop Application

**Daphne McNamara**  
TBZ – Module 320, Level 4 Project  

---

## Project Description
A simplified **online shop application** where users can:
- Add products to a shopping cart
- Complete an order and process payment
- Generate and print a purchase receipt

The application demonstrates **object-oriented principles**, including **delegation**, **polymorphism**, and the use of **design patterns**.


## Project Goals
- Implement a modular, object-oriented shop simulation
- Show **delegation** (User -> CheckoutService)
- Apply **2+ design patterns** (Strategy, Decorator)
- Use **interfaces, inheritance, and generics**
- Apply **Clean Code** principles
- Include **exception handling** and **persistence layer**


## Use Cases

### 1. Add Product to Cart
**Actor:** User 


**Goal:** User wants to add a product to their shopping cart.


**Flow:**
1. User browses the product catalog.
2. User selects a product.
3. User adds the product to their cart.
4. System confirms the product was added and shows the updated cart contents.


### 2. Checkout Order
**Actor:** User  


**Goal:** User wants to purchase the items in the cart.


**Flow:**
1. User reviews the items in the cart.
2. User selects a payment option.
3. User confirms the order.
4. System processes the payment.
5. System confirms that the order has been completed.


### 3. View/Print Invoice
**Actor:** User


**Goal:** User wants a receipt for their order.


**Flow:**
1. After the order is completed, the system generates a receipt.
2. User can view or print the receipt.
3. Receipt shows the purchased products, total price and any applied discounts.



## Class Overview (UML Summary)

| Class | Responsibility |
|--------|----------------|
| **Product** | Base class for all products with id, name, and price |
| **ElectronicProduct / FoodProduct** | Subclasses specializing Product |
| **ProductDecorator / GiftWrapDecorator** | Adds gift wrapping functionality (Decorator Pattern) |
| **Cart** | Manages items added by User |
| **User** | Has a Cart, delegates checkout to CheckoutService |
| **Order** | Represents a completed purchase |
| **CheckoutService** | Handles the full checkout process |
| **DiscountStrategy (Interface)** | Strategy for applying discounts |
| **NoDiscount / FixedAmountDiscount / PercentageDiscount** | Implement discount strategies |
| **PaymentService** | Simulates payment processing |
| **OrderRepository / Repository<T>** | Store and retrieve completed orders |
| **PurchaseReceipt** | Prints formatted receipt |
| **EmptyCartException / PaymentFailedException** | Handle user and payment errors |


## Design Patterns

| Pattern | Purpose | Implementation |
|----------|----------|----------------|
| **Strategy Pattern** | Allows dynamic selection of discount type | `DiscountStrategy` interface + its implementations |
| **Decorator Pattern** | Adds gift wrapping without modifying Product | `GiftWrapDecorator` extends `ProductDecorator` |
| **Delegation** | Separates user logic from checkout logic | `User.checkout()` delegates to `CheckoutService.processOrder()` |


## Object-Oriented Principles

| Concept | Example |
|----------|----------|
| **Encapsulation** | Product data hidden behind getters/setters |
| **Inheritance** | `ElectronicProduct` and `FoodProduct` extend `Product` |
| **Polymorphism** | Different discount strategies implement one interface |
| **Composition** | `User` has-a `Cart`; `Order` has Products |
| **Generics** | `Repository<T>` supports saving any object type |
| **Exception Handling** | Custom exceptions for validation (EmptyCart, PaymentFailed) |


## Sequence Diagram – Use Case: Checkout Order

**Actors:**  
`User → Cart → CheckoutService → Order → DiscountStrategy → PaymentService → OrderRepository → PurchaseReceipt`

**Process Flow:**
1. User calls `checkout()`
2. `CheckoutService` creates an `Order`
3. Applies `DiscountStrategy`
4. Calls `PaymentService.pay()`
5. Saves order via `OrderRepository`
6. `PurchaseReceipt.printReceipt()` displays summary


## Clean Code Practices
- Clear naming: `calculateTotal()`, `processOrder()`, `applyDiscount()`
- SRP (Single Responsibility): each class has exactly one purpose
- No hardcoded literals -> constants or parameters used
- Comments only on complex methods
- Interface-based design for flexibility


## Reflection / Fazit

During this project I learned to:
- Structure a full OO project from design to code
- Apply **delegation, inheritance, and polymorphism** in practice
- Understand **Strategy** and **Decorator** patterns deeply
- Use **Generics** and **Exception Handling**
- Create and interpret **UML and Sequence Diagrams**
- Apply **Clean Code** principles for clarity and maintainability
