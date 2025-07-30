# CodSoft
Java Mini Projects – CodSoft Internship
This document contains descriptions of four Java-based mini projects developed as part of the CodSoft Internship. Each task demonstrates core Java concepts and is stored in separate folders.
🧩 Project Tasks
🔹 Task 1 – Number Guessing Game
A console-based game where the user tries to guess a randomly generated number.
File: task1/NumberGame.java
🔹 Task 2 – Student Marks Calculator
Takes subject marks as input and calculates total, average, and percentage.
File: task2/MarksCalculator.java
🔹 Task 3 – ATM Interface
Simulates basic ATM operations like balance check, withdrawal, and deposit.
File: task3/ATMInterface.java
🔹 Task 4 – Currency Converter (Real-Time)
Uses real-time exchange rates from an API and converts currency values using the Gson library.
File: task4/CurrencyConverter.java
Dependency: gson-2.10.1.jar
🛠️ How to Run (Example for Task 4)
Run the following commands in the terminal:
javac -cp gson-2.10.1.jar CurrencyConverter.java
java -cp ".;gson-2.10.1.jar" CurrencyConverter
> On Unix/Linux, use ':' instead of ';' in the classpath.
🔗 Tools Used
- Java
- Gson Library (for JSON parsing)
- ExchangeRate API (for currency data)
📁 Folder Structure

codsoft/
├── task1/NumberGame.java
├── task2/MarksCalculator.java
├── task3/ATMInterface.java
├── task4/
│   ├── CurrencyConverter.java
│   └── gson-2.10.1.jar

