# Stock Inventory Management System

A Java-based inventory management system for tracking stock, managing products, and monitoring inventory levels.

## 📋 Project Overview

This project provides a solution for managing inventory in a retail or warehouse environment. Built with Java, it includes database integration for persistent storage of inventory data.

## 🏗️ Project Structure

```
stock-inventory-management/
├── README.md
├── pom.xml                       # Maven configuration
├── mvnw & mvnw.cmd               # Maven wrapper scripts
├── src/
│   └── main/
│       ├── java/                 # Java source code
│       └── webapp/               # Web resources
├── .mvn/                         # Maven configuration directory
└── target/                       # Compiled output (generated)
```

## 🛠️ Technology Stack

- **Language**: Java 24
- **Build Tool**: Maven 3.x
- **Packaging**: WAR (Web Application Archive)
- **Testing**: JUnit 5.13.2
- **Servlets**: Jakarta Servlet API 6.1.0
- **JSP/JSTL**: Jakarta JSTL 3.0.x

## 📦 Core Components

### Dependencies

1. **Jakarta Servlet API** - Web application framework
2. **Jakarta Servlet JSP/JSTL** - Server-side templating
3. **JUnit 5** - Unit testing framework

## 🎯 Key Features

- Stock level management
- Product tracking
- Inventory database storage
- WAR deployment ready

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 24 or higher
- Maven 3.6+ or use included Maven wrapper

### Build the Project

Using Maven wrapper (Windows):
```bash
mvnw clean install
```

Using Maven wrapper (Linux/Mac):
```bash
./mvnw clean install
```

Using Maven directly:
```bash
maven clean install
```

## 📝 Notes

- Project uses Maven wrapper (`mvnw`) for platform-independent builds
- Outputs a WAR file for deployment on application servers (Tomcat, etc.)
- JUnit 5 configured for testing

---

**Last Updated**: 2026
