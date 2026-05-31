# Stock Inventory Management System

A comprehensive inventory management system built with Java for tracking stock, managing products, and monitoring inventory levels across multiple warehouses.

## 📋 Project Overview

This project provides a robust solution for managing stock inventory in retail, manufacturing, or distribution environments. It enables businesses to track products, monitor stock levels, manage suppliers, and generate inventory reports.

## 🏗️ Project Structure

```
stock-inventory-management/
├── README.md
├── src/
│   ├── main/
│   │   ├── java/com/inventory/
│   │   │   ├── models/                    # Data models
│   │   │   │   ├── Product.java          # Product information
│   │   │   │   ├── Inventory.java        # Inventory details
│   │   │   │   ├── Warehouse.java        # Warehouse management
│   │   │   │   ├── Supplier.java         # Supplier information
│   │   │   │   └── Transaction.java      # Transaction records
│   │   │   ├── services/                 # Business logic
│   │   │   │   ├── InventoryService.java # Core inventory operations
│   │   │   │   ├── ProductService.java   # Product management
│   │   │   │   ├── WarehouseService.java # Warehouse operations
│   │   │   │   └── ReportService.java    # Report generation
│   │   │   ├── repository/               # Data persistence
│   │   │   │   ├── ProductRepository.java
│   │   │   │   ├── InventoryRepository.java
│   │   │   │   └── WarehouseRepository.java
│   │   │   ├── ui/                       # User interface
│   │   │   │   ├── MainWindow.java       # Main application window
│   │   │   │   ├── InventoryPanel.java   # Inventory UI
│   │   │   │   └── ReportPanel.java      # Reports UI
│   │   │   └── Main.java                 # Application entry point
│   │   └── resources/
│   │       ├── config.properties         # Configuration file
│   │       └── database.xml              # Database configuration
│   └── test/
│       └── java/com/inventory/
│           ├── services/
│           │   └── InventoryServiceTest.java
│           └── models/
│               └── ProductTest.java
├── lib/                                   # External dependencies
├── database/                              # Database files/scripts
│   ├── schema.sql                        # Database schema
│   └── sample_data.sql                   # Sample data
├── docs/                                 # Documentation
│   ├── API.md
│   └── USER_GUIDE.md
└── build.xml                             # Ant build configuration (if used)
```

## 🛠️ Technology Stack

- **Language**: Java 8+
- **Architecture Pattern**: MVC (Model-View-Controller) / Layered Architecture
- **Database**: SQL (MySQL, PostgreSQL, or SQLite)
- **UI Framework**: Swing (optional) or JavaFX
- **Build Tool**: Maven or Gradle
- **Testing**: JUnit 4/5
- **Logging**: SLF4J / Log4j

## 📦 Core Components

### 1. **Models**
- **Product**: Product master data (ID, name, SKU, price, category)
- **Inventory**: Stock levels per product per warehouse
- **Warehouse**: Warehouse/storage location information
- **Supplier**: Supplier details and contact information
- **Transaction**: Historical records of stock movements

### 2. **Services**
- **InventoryService**: 
  - Add/update stock
  - Check stock levels
  - Low stock alerts
  - Stock transfers between warehouses

- **ProductService**:
  - Add/edit/delete products
  - Product categorization
  - SKU management

- **WarehouseService**:
  - Manage warehouse locations
  - Warehouse capacity tracking
  - Multi-warehouse inventory

- **ReportService**:
  - Generate inventory reports
  - Stock movement reports
  - Low stock reports
  - Warehouse utilization reports

### 3. **Repository Layer**
- Database abstraction layer
- CRUD operations for all entities
- Query optimization

### 4. **UI Layer**
- User-friendly interface for inventory operations
- Real-time stock monitoring
- Reporting dashboards

## 🎯 Key Features

### Inventory Management
- ✅ Track stock levels across multiple warehouses
- ✅ Real-time inventory updates
- ✅ Low stock alerts and notifications
- ✅ Stock transfers between warehouses
- ✅ Inventory adjustments (damaged goods, theft)

### Product Management
- ✅ Maintain product master data
- ✅ SKU generation and tracking
- ✅ Product categorization
- ✅ Pricing information

### Warehouse Management
- ✅ Multi-warehouse support
- ✅ Warehouse capacity tracking
- ✅ Location-based inventory

### Reporting
- ✅ Inventory reports
- ✅ Stock movement history
- ✅ Low stock alerts
- ✅ Warehouse utilization reports
- ✅ Export to CSV/PDF

### Supplier Management
- ✅ Supplier information
- ✅ Purchase order tracking
- ✅ Supplier performance metrics

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven 3.6+ or Gradle 6.0+ (build tool)
- MySQL/PostgreSQL/SQLite database
- Git

### Installation

1. **Clone the repository**:
```bash
git clone https://github.com/ihebkhlif/stock-inventory-management.git
cd stock-inventory-management
```

2. **Build the project** (using Maven):
```bash
mvn clean install
```

Or using Gradle:
```bash
gradle clean build
```

3. **Configure database**:
   - Edit `src/main/resources/config.properties`
   - Set database URL, username, and password

4. **Initialize database**:
```bash
mysql -u root -p < database/schema.sql
mysql -u root -p < database/sample_data.sql
```

5. **Run the application**:
```bash
mvn spring-boot:run
```

Or:
```bash
java -jar target/stock-inventory-management.jar
```

## 💻 Usage Examples

### Adding a New Product
```java
Product product = new Product();
product.setName("Laptop");
product.setSku("LAP-001");
product.setPrice(999.99);
product.setCategory("Electronics");

ProductService productService = new ProductService();
productService.addProduct(product);
```

### Managing Inventory
```java
InventoryService inventoryService = new InventoryService();

// Add stock
inventoryService.addStock("LAP-001", "WAREHOUSE-A", 50);

// Check stock
int quantity = inventoryService.getStockLevel("LAP-001", "WAREHOUSE-A");

// Transfer stock
inventoryService.transferStock("LAP-001", "WAREHOUSE-A", "WAREHOUSE-B", 20);

// Check for low stock
List<Product> lowStockProducts = inventoryService.getLowStockProducts(10);
```

### Generating Reports
```java
ReportService reportService = new ReportService();

// Generate inventory report
Report report = reportService.generateInventoryReport(new Date());

// Generate low stock report
Report lowStockReport = reportService.generateLowStockReport();

// Export to CSV
reportService.exportToCSV(report, "inventory_report.csv");
```

## 🏛️ Architecture Patterns

### Layered Architecture
- **Presentation Layer**: UI components (Swing/JavaFX)
- **Service Layer**: Business logic and operations
- **Repository Layer**: Data access and persistence
- **Model Layer**: Data objects and entities

### Design Patterns Used
- **MVC Pattern**: Separation of concerns
- **Repository Pattern**: Data access abstraction
- **Service Pattern**: Business logic encapsulation
- **Singleton Pattern**: Single instances of services
- **Factory Pattern**: Object creation

## 🧪 Testing

Run unit tests:
```bash
mvn test
```

View test coverage:
```bash
mvn jacoco:report
```

## 📊 Database Schema

### Key Tables
- **products**: Product master data
- **inventory**: Stock levels
- **warehouses**: Warehouse information
- **suppliers**: Supplier details
- **transactions**: Stock movement history
- **categories**: Product categories

## 📖 API Documentation

See [API.md](docs/API.md) for detailed API endpoints and usage.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see LICENSE file for details.

## 📞 Support

For issues and questions, please create an issue on GitHub.

## 👨‍💻 Author

**ihebkhlif**

---

**Last Updated**: 2026
