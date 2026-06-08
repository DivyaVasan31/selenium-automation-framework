# Selenium Automation Framework

UI Test Automation Framework built using Selenium WebDriver, 
Java, TestNG and Page Object Model.

## Tech Stack
- Selenium WebDriver 4.x
- Java 11
- TestNG
- Maven
- GitHub Actions CI/CD
- SauceLabs Cross Browser Testing
- Page Object Model (POM)

## Framework Structure
src/
  main/java/pages/        → Page Object classes
  test/java/tests/        → Test classes
  test/resources/testdata → Test data files

## How to Run
mvn test
mvn test -Dkarate.options="--tags @smoke"

## CI/CD
Integrated with GitHub Actions — triggers on every push to main.
