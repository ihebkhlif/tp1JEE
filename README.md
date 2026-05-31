# StockMasterPro

StockMasterPro is a Java web application designed to demonstrate a simple stock and inventory management system using the MVC (Model-View-Controller) architecture.

The project was developed using Jakarta Servlet technology, JSP pages, and Maven. It follows a layered architecture consisting of Controllers, Services, DAOs, Models, and Views.

---

## Features

- User authentication through a login system
- Protected pages using authentication filters
- Product catalogue display
- MVC architecture implementation
- DAO layer with mock data source
- Service layer for business logic separation
- JSP-based user interface

---

## Technologies Used

- Java
- Jakarta Servlet API
- JSP (JavaServer Pages)
- JSTL
- Maven
- Apache Tomcat (or any Jakarta EE compatible server)

---

## Project Structure

```text
StockMasterPro
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.stock
│   │   │       ├── controller
│   │   │       │   ├── LoginServlet.java
│   │   │       │   └── CatalogueServlet.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   └── ProduitService.java
│   │   │       │
│   │   │       ├── dao
│   │   │       │   └── ProduitDAO.java
│   │   │       │
│   │   │       ├── model
│   │   │       │   └── Produit.java
│   │   │       │
│   │   │       └── Filter
│   │   │           └── AuthenticationFilter.java
│   │   │
│   │   └── webapp
│   │       ├── index.jsp
│   │       └── WEB-INF
│   │           └── vues
│   │               └── catalogue.jsp
│
├── pom.xml
└── README.md
```

---

## Architecture

The application follows the MVC pattern:

### Model

Represents the application's data.

Example:

- `Produit.java`

Contains information about a product such as:

- Product ID
- Product name
- Product price

---

### DAO (Data Access Layer)

Responsible for retrieving data.

Example:

- `ProduitDAO.java`

Currently uses mock data:

```java
mockList.add(new Produit(1, "Clavier", 45.0));
mockList.add(new Produit(2, "Souris", 25.0));
mockList.add(new Produit(3, "Ecran", 150.0));
```

In a future version, this layer can be connected to a database.

---

### Service Layer

Responsible for business logic.

Example:

- `ProduitService.java`

Acts as an intermediary between controllers and the DAO layer.

---

### Controllers

Handle HTTP requests and responses.

Examples:

- `LoginServlet.java`
- `CatalogueServlet.java`

Flow:

```text
Browser
   ↓
Servlet
   ↓
Service
   ↓
DAO
   ↓
Model
   ↓
JSP View
```

---

### View Layer

Implemented using JSP pages.

Examples:

- `index.jsp`
- `catalogue.jsp`

Responsible for displaying information to users.

---

## Authentication

The application includes an authentication mechanism using:

```text
AuthenticationFilter
```

This filter restricts access to protected resources and ensures users are authenticated before accessing secured pages.

---

## How to Run

### Prerequisites

- Java JDK 24
- Maven
- Apache Tomcat 10+

### Clone the repository

```bash
git clone https://github.com/ihebkhlif/stock-inventory-management.git
cd stock-inventory-management
```

### Build the project

```bash
mvn clean package
```

This will generate a WAR file inside:

```text
target/
```

### Deploy

Deploy the generated WAR file to your Tomcat server.

Example:

```text
target/StockMasterPro-1.0-SNAPSHOT.war
```

Copy it to:

```text
tomcat/webapps/
```

Start Tomcat and open:

```text
http://localhost:8080/StockMasterPro
```

---

## Example Request Flow

When a user accesses:

```text
/catalogue
```

The following steps occur:

1. `CatalogueServlet` receives the request.
2. `ProduitService` is called.
3. `ProduitDAO` retrieves product data.
4. The product list is added to the request.
5. The request is forwarded to `catalogue.jsp`.
6. The JSP page displays the catalogue.

---

## Future Improvements

- Database integration (MySQL/PostgreSQL)
- Product CRUD operations
- User roles and permissions
- Search and filtering
- Stock quantity management
- Order management
- REST API support

---

## Author

**Iheb Khlif**

Computer Science and Networking Student interested in:

- Software Development
- Web Applications
- Networking
- Cybersecurity
- Java Technologies
