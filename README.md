# Thogakade-MVC (JavaFX · Hibernate ORM · MySQL)

**Thogakade-MVC** is a desktop application built with **JavaFX**, **Hibernate ORM**, and **MySQL**, following the **MVC (Model–View–Controller)** design pattern.  
The project demonstrates **end-to-end CRUD operations** with a modular structure, reusable transaction layer, and entity relationships.  

This repository highlights:
- Strong use of **JavaFX UI with multiple management windows** (Customer, Item, Order, Order Detail).  
- **Hibernate-powered persistence layer** with reusable transaction handling.  
- Clean **MVC structure** separating business logic, UI, and database operations.  

---

## ✨ Features
- **Customer Management**: Add, update, delete, and view customers.  
- **Item Management**: Manage items with stock and details.  
- **Order Management**: Create new orders and handle order processing.  
- **Order Detail Management**: Support for composite keys in order–item relationships.  
- **Reusable Transaction Layer**: Built using `TransactionInterface` and `TransactionImpl`.  
- **Hibernate ORM Integration**: Handles entity persistence and database transactions.  
- **JavaFX GUI**: User-friendly windows for managing data.  
- **Automatic DB Creation**: Configured with `hibernate.hbm2ddl.auto=update` to create/update schema automatically.  

---

## 🏗️ Project Design – MVC Architecture  

The application is structured around the **MVC pattern**:  

- **Model** → DTOs/entities (`CustomerDto`, `ItemDto`, `OrdersDto`, `OrderDetailDto`)  
- **View** → JavaFX FXML forms (Dashboard, Customer, Item, Order, Order Detail)  
- **Controller** → JavaFX controllers (`CustomerManagementFormController`, etc.)  
- **Persistence Layer** → Hibernate transaction utilities (`HibernateUtil`, `TransactionImpl`, `TransactionInterface`)  

### 📂 Folder Structure  

    Thogakade-MVC/
    │── src/main/java/edu/icet/ecom/
    │ ├── controller/                           # JavaFX controllers
    │ │ ├── CustomerManagement/                 # Same strcture for all controller packages
    │ │ │ ├── CustomerManagementFormController
    │ │ │ ├── CustomerManagementInterface
    │ │ │ └── CustomerManagementService
    │ │ ├── ItemManagement/
    │ │ ├── OrderManagement/
    │ │ └── OrderDetailManagement/
    │ │
    │ ├── dbConnection/                         # (Optional) singleton DB connection replaced with hibernate
    │ │
    │ ├── hibernateTransaction/                 # Hibernate session + transaction layer
    │ │ ├── HibernateUtil
    │ │ ├── TransactionInterface
    │ │ └── TransactionImpl
    │ │
    │ ├── model/                                # Entity/DTO classes
    │ │ ├── CustomerDto
    │ │ ├── ItemDto
    │ │ ├── OrdersDto
    │ │ └── OrderDetailDto
    │ │
    │ ├── starter/                              # Main application entry point
    │ │ └── Starter.java
    │ │
    │ └── util/                                 # Utility classes
    │ ├── AlertUtil
    │ ├── CommonStringFuncUtil
    │ ├── ExitUtil
    │ └── WindowSwitchUtil
    │
    │── src/main/resources/                     # FXML files, application resources
    │── hibernate.cfg.xml                       # Hibernate configuration file
    │── pom.xml                                 # Maven dependencies


## ⚙️ Dependencies (pom.xml)

This project is Maven-based. Key dependencies include:
 

```xml
<dependencies>
  - JavaFX (19)                   – UI controls & FXML support  
  - Lombok (1.18.40)              – Reduces boilerplate code  
  - MySQL Connector/J (9.4.0)     – JDBC driver  
  - Hibernate Core (7.1.0.Final)  – ORM framework
</dependencies>
```
---

### 📸 Screenshots

- **Dashboard**
  <p align="left">
    <img src="https://github.com/user-attachments/assets/058f7dfa-4624-4d5c-b808-9b7f337c2bc6" width="470" />
  </p>

- **Customer Management Window**
  <p align="left">
    <img src="https://github.com/user-attachments/assets/ab946496-5d47-4119-91c4-452f80653826" width="740" />
  </p>

- **Item Management Window**
  <p align="left">
    <img src="https://github.com/user-attachments/assets/e1bbc11e-d348-4e4d-967a-1b4d6af2448c" width="740" />
  </p>

- **Order Management Window**
  <p align="left">
    <img src="https://github.com/user-attachments/assets/3a774b93-fb32-479c-adfa-0d3c5c1f9ffe" width="670" />
  </p>

- **Order Detail Management Window**
  <p align="left">
    <img src="https://github.com/user-attachments/assets/f2e1f452-d483-42f1-a422-25f1b28b122a" width="670" />
  </p>

---

## ▶️ How to Run

**Prerequisites**

- Java 21 
- MySQL Server running locally
- IntelliJ IDEA (recommended) with Maven support

**Setup**

1. Clone this repository wiith bash/cmd:
    ```bash
        git clone https://github.com/rnshalinda/Thogakade-MVC.git
        cd Thogakade-MVC
    ```
  
3. Import the project into IntelliJ IDEA as a Maven project.
4. Open the Thogakade_MVC folder with IntelliJ
5. Check your MySQL DB credentials in hibernate.cfg.xml (Change if necessary)
   ```xml
       <property name="hibernate.connection.username">root</property>
       <property name="hibernate.connection.password">1234</property>
   ```

6. Run the application from Main.class
