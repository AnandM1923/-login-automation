# Login Automation Project

This project contains a simple Login Web UI and a Selenium Automation Framework to test it.

## Project Structure
- `src/main/resources/static`: Contains the Web UI (HTML, CSS, JS).
- `src/test/java`: Contains the Selenium Automation code.

## Prerequisites
- Java 11+
- Maven
- Chrome Browser (or others if configured)

## Running the Validations
The tests are designed to run against the local file system for the login page (`src/main/resources/static/login.html`).

### Command Line
Run the following command in the project root:
```sh
mvn clean test
```

### Jenkins
This project includes a `Jenkinsfile` for CI/CD integration.
- Ensure the "GitHub" plugin is installed.
- Configure credentials if using private repo.
- **Headless Mode**: The project supports headless execution (recommended for Jenkins agents without UI).
  - Add `-Dheadless=true` to the Maven options.
  - Example: `mvn clean test -Dheadless=true`
