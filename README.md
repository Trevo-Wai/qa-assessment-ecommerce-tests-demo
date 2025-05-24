# QA Assessment: E-commerce Payment Flow Tests (Demo)

This repository is a demonstration project for a QA assessment focused on testing the payment flow of an e-commerce platform (inspired by Lazada/Amazon), including **automated tests** using **Selenium (Java with TestNG)** and **Cypress (JavaScript with Mock API support)**.

---

## 📁 Project Structure

### **Cypress**

- Test files for the automated payment flow are located in  
  `Cypress-paymentflow-with-mock-api-test/cypress/e2e/Payment/`.

- Mock API responses (like successful payment data) are stored in  
  `Cypress-paymentflow-with-mock-api-test/cypress/fixtures/`.

---

### **Selenium**

- Java Page Object classes for Selenium-based automation are located in  
  `selenium-paymentflow-tests/src/test/java/pages`.

- TestNG test scripts are located in  
  `selenium-paymentflow-tests/src/test/java/tests`.

---

### Automated Testing

#### ✅ Selenium (Java + TestNG)
- Follows Page Object Model (POM) structure.
- Tests payment flow including coupon application and confirmation.
- Uses TestNG as the test runner.

#### ✅ Cypress (JavaScript + Mock API)
- Simulates real user flow with mocked API responses.
- Making payment (success & failure)
- Uses `.json` fixtures to simulate backend behavior.

---

## How to Run Tests

### Cypress

1. Install dependencies:
   ```bash
   npm install

   Fixtures are located in cypress/fixtures/.

### Selenium

Make sure you have the following installed:

- Java 8+
- Maven
- Google Chrome Browser

---

##  Notes

- All API calls in Cypress tests are mocked using cy.intercept() and fixture files.

- The application under test simulates a Lazada-like e-commerce flow, but is not connected to any real production systems.

- Selenium tests are UI-level only and do not process real payments or call external payment gateways.



