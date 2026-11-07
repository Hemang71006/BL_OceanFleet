# OceanFleet – Vessel Performance Management System

## Project Overview

OceanFleet is a Java-based console application developed to manage vessel performance records. It allows users to store vessel details, search for vessels using their IDs, and identify vessels with the highest average speed.

This project is developed using Object-Oriented Programming (OOPS) concepts and Java Collections, following a use-case-driven development approach.

## Technologies Used

- **Programming Language:** Java
- **JDK Version:** Java 17
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5
- **IDE:** IntelliJ IDEA
- **Data Structure:** ArrayList

## Use Cases Implemented

| Use Case | Description |
|---|---|
| UC1 | Create Vessel Model |
| UC2 | Store Vessel Records Using List |
| UC3 | Retrieve Vessel by Vessel ID |
| UC4 | Identify High-Performance Vessels |
| UC5 | Integrate User Interaction (Console App) |
| UC6 | Refactor Using OOPS Principles |

## Project Structure

```text
BL_OceanFleet
│
├── pom.xml
├── .gitignore
│
└── src
    ├── main
    │   └── java
    │       └── oceanfleet
    │           ├── Vessel.java
    │           ├── VesselUtil.java
    │           └── UserInterface.java
    │
    └── test
        └── java
            └── oceanfleet
                ├── VesselTest.java
                ├── VesselUtilTest.java
                └── UserInterfaceTest.java
```

## Class Responsibilities

### 1. Vessel.java
- Represents a vessel.
- Stores vessel ID, vessel name, average speed, and vessel type.
- Provides constructors, getters, and setters.

### 2. VesselUtil.java
- Stores vessel records using an ArrayList.
- Adds new vessel records.
- Retrieves vessels using their IDs.
- Identifies all vessels having the highest average speed.

### 3. UserInterface.java
- Accepts vessel details through console input.
- Creates and stores vessel objects.
- Allows users to search for a vessel by ID.
- Displays high-performance vessels.
- Separates user interaction from vessel management logic.

## How to Run the Project

### Prerequisites
- Java JDK 17 or later
- Maven
- IntelliJ IDEA or any Java-compatible IDE

### Steps

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA.

3. Reload the Maven project.

4. Run the application by executing `UserInterface.java`.

## Input Format

Enter vessel details using the following format:

```text
vesselId:vesselName:averageSpeed:vesselType
```

Example:

```text
V001:Sea King:25.5:Cargo
V002:Ocean Star:20.0:Passenger
V003:Blue Wave:25.5:Cargo
```

Average speed is measured in knots.

## Sample Output

```text
Enter number of vessels: 3

Enter vessel details (vesselId:vesselName:averageSpeed:vesselType):
V001:Sea King:25.5:Cargo

Enter vessel details (vesselId:vesselName:averageSpeed:vesselType):
V002:Ocean Star:20.0:Passenger

Enter vessel details (vesselId:vesselName:averageSpeed:vesselType):
V003:Blue Wave:25.5:Cargo

Enter vessel ID to search: V002

Vessel Details:
V002 | Ocean Star | Passenger | 20.0 knots

High-Performance Vessels:
V001 | Sea King | Cargo | 25.5 knots
V003 | Blue Wave | Cargo | 25.5 knots
```

## Running Tests

The project uses JUnit 5 for automated testing.

Run all tests using Maven:

```bash
mvn clean test
```

The tests cover:

- Vessel constructors, getters, and setters.
- Vessel record storage.
- Vessel retrieval by ID.
- Identification of high-performance vessels.
- Console input and output.
- Refactored application functionality.

## Git Workflow

The project follows a feature-branch-based Git workflow.

- `main` – Project README.
- `develop` – Integrated application containing all completed use cases.
- `feature/*` – Individual branches for implementing each use case.

Each use case is developed, tested, and merged into the `develop` branch.

## Author

**Hemang**

## Project Name

**BL_OceanFleet**

Java Use Case-Driven OOPS & Data Structures Learning Project.