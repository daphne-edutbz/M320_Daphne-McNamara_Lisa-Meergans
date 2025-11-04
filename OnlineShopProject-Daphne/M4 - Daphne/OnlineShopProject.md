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


## Use Cases (User Perspective)

### 1. Add Product to Cart
**Actor:** Shopper  

**Goal:** Add a product to your shopping cart.

**Flow:**
1. Browse the available products in the shop.
2. Select a product you want to buy.
3. Choose if you want the product gift wrapped.
4. Add the product to your shopping cart.
5. See a confirmation and check that your cart is updated.


### 2. Remove Product from Cart
**Actor:** Shopper  

**Goal:** Remove a product from your shopping cart.

**Flow:**
1. Open your shopping cart to see what’s inside.
2. Select the product you no longer want and specify how many to remove.
3. The system updates your cart and confirms the removal.



### 3. View Cart
**Actor:** Shopper  

**Goal:** Check which products are in your cart and the total cost.

**Flow:**
1. Click “Show cart” to see your items.
2. The system displays each product, quantity, and the total cost.


### 4. Checkout Order
**Actor:** Shopper  

**Goal:** Purchase all items in your shopping cart.

**Flow:**
1. Review all items in your cart.
2. Select a discount if available (like 10% off or fixed amount off).
3. Confirm your purchase.
4. The system processes your payment.
5. Your order is completed, and you receive a confirmation.
6. A receipt is generated for your purchase.


### 5. View / Print Receipt
**Actor:** Shopper  

**Goal:** Get a receipt for your purchase.

**Flow:**
1. After completing your order, view the receipt.
2. See all items you bought, their prices, discounts applied, and the final total.
3. Keep the receipt for your records or print it.


### 6. Persistent Order Storage
**Actor:** System  

**Goal:** Keep a record of completed orders.

**Flow:**
1. After checkout, your order is saved automatically.
2. All past orders are stored so you can track your purchases.
3. Each order is numbered so you can easily refer to it later.


### 7. Demo Mode
**Actor:** Shopper / Visitor  

**Goal:** See how the online shop works without manually adding items.

**Flow:**
1. The system creates a sample shopping experience with example products.
2. Items are added to the cart automatically, including gift-wrapped items.
3. Orders are processed with different discounts.
4. You can see the completed cart, receipts, and saved orders.
5. This allows you to explore the system quickly and understand how shopping works.


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
