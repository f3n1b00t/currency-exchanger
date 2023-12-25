# 🌐 Currency Exchanger

![GitHub stars](https://img.shields.io/github/stars/f3n1b00t/currency-exchanger?style=social)
![GitHub forks](https://img.shields.io/github/forks/f3n1b00t/currency-exchanger?style=social)
![GitHub issues](https://img.shields.io/github/issues/f3n1b00t/currency-exchanger)
![GitHub pull requests](https://img.shields.io/github/issues-pr/f3n1b00t/currency-exchanger)
![GitHub license](https://img.shields.io/github/license/f3n1b00t/currency-exchanger)

**This is a simple currency converter application built using Spring Boot, which utilizes a third-party free API for currency exchange rates.**

## 🚀 Key Features

- 🌟 **Convenient Currency Interaction:** Retrieve a list of currencies relative to a specified currency. Convert a certain amount of one currency to another.

- 🧩 **Modular Architecture:** The project utilizes Spring Boot and follows a modular architecture, making it easy to add new features and maintain.

- 🛠️ **Code Simplicity with Lombok:** Leveraging Lombok simplifies the project's code, making it more readable and maintainable.

- 🧪 **Unit Testing:** The project's code is equipped with unit tests, enhancing its reliability and ensuring stable performance.

- 🗃️ **Database Schema Management with Flyway**: The application leverages Flyway migration for seamless database schema management, ensuring consistency across different environments.

- 🌐 **JPA Bean Validation**: The application uses JPA Bean Validation for validating entities and their properties, ensuring data integrity within the database.

## 🛠️ Technology Stack
- [Spring Boot Validation](https://spring.io/guides/gs/validating-form-input/): Input validation.
- [Spring Boot Web](https://spring.io/guides/gs/serving-web-content/): Building web-based applications.
- [Spring Boot AOP](https://spring.io/guides/gs/aspect-oriented-programming/): Modularization and cross-cutting concerns.
- [Spring Boot Data](https://spring.io/guides/gs/accessing-data/): Simplified data access using Spring Data.
- [OpenFeign](https://github.com/OpenFeign/feign): Interacting with external services
- [Flyway](https://flywaydb.org/): Database migration management.
- [Lombok](https://projectlombok.org/): Code simplification.
## 🏁 Installation and Running

To run the project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/f3n1b00t/currency-exchanger.git
   cd currency-exchanger
   ```
2. Run service:
   ```bash
   export POSTGRES_URL=jdbc:postgresql://localhost:5432/currencies
   export POSTGRES_USERNAME=root
   export POSTGRES_PASSWORD=password
   ./gradlew bootRun 
   ```
3. Enjoy the project! 🎉

## 📄 License
Spring Boot is Open Source software released under the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).