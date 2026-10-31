# Smart Ration Distribution System

A Java-based Smart Ration Distribution System designed to manage beneficiaries, automate ration allocation based on family size and card category, and track distribution history.

## Features
- **Admin Authentication**: Secure login system for ration shop administrators.
- **Beneficiary Registration**: Register beneficiaries with card number, name, family member count, and category (APL, BPL, AAY).
- **Automated Ration Calculation**: Calculates allocated rice, wheat, and sugar quantities according to government quota rules based on family size and card category.
- **Search & View**: Search beneficiary records by card number and view complete beneficiary list.
- **Distribution Tracking**: Logs transactions and distribution history.
- **Database Connectivity**: MySQL database integration via JDBC (`DBConnection.java`).

## Project Structure
```text
SmartRationSystem/
├── src/
│   ├── module-info.java
│   └── smartration/
│       ├── DBConnection.java
│       └── SmartRationSystem.java
├── .classpath
├── .project
└── README.md
```

## Prerequisites
- Java JDK 8 or higher (supports Java 17+)
- MySQL Server (optional, for persistent storage)
- MySQL Connector/J driver

## How to Run
1. Import the project into Eclipse or your favorite Java IDE as an existing Java project.
2. If connecting to a database, configure your MySQL credentials in `DBConnection.java` and ensure the `smart_ration` database is running.
3. Run `SmartRationSystem.java`.
4. Default admin password: `admin123`.
