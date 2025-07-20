# 🚀 API Test Automation Framework

A comprehensive API test automation framework built using **Java**, **REST Assured**, **TestNG**, and **Maven**. Designed for testing RESTful web services (GET, POST, PUT, DELETE) and easily extendable to UI tests with Selenium.

---

## 📌 Tech Stack

- **Java**
- **REST Assured** – for API testing
- **TestNG** – test framework
- **Maven** – build and dependency management
- **Log4j2** – logging support
- **Selenium** – optional for UI validation
- **JSONPlaceholder** – test API

---

## 📁 Project Structure

```
ApiAutomationProject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   ├── config/
│   │   │   └── utils/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │   └── data/
├── pom.xml
├── testng.xml
└── README.md
```

---

## ✅ Features

- Test automation for all main HTTP methods:
  - **GET** – Valid, invalid, non-numeric, empty
  - **POST** – Valid, malformed, missing fields
  - **PUT** – Valid updates, invalid/malformed data
  - **DELETE** – Valid & invalid deletions
- Modular test design using Page Object pattern (where applicable)
- Reusable base classes and config
- Data-driven tests using `@DataProvider`
- Supports expansion to UI tests

---

## ▶️ How to Run

```bash
# Clean and test using Maven
mvn clean test
```

You can also run using TestNG through your IDE via `testng.xml`.

---

## 🧪 Example Test Case

```java
@Test
public void getUser_ValidId_ReturnsUser() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    given().
    when().
        get("/users/1").
    then().
        statusCode(200).
        body("id", equalTo(1));
}
```

---

## 📦 API Endpoints Covered

| Method | Endpoint       | Description            |
|--------|----------------|------------------------|
| GET    | `/users/1`     | Fetch user by ID       |
| POST   | `/users`       | Create new user        |
| PUT    | `/users/1`     | Update user info       |
| DELETE | `/users/1`     | Delete user by ID      |

---

## 📈 Future Enhancements

- Integrate **Allure Reports**
- Add **GitHub Actions** for CI
- Add **JUnit XML Reports**
- Add **UI/API Hybrid Tests**

---

## 🙌 Author

**Shailesh Pokharkar**  
[GitHub Profile](https://github.com/Shaileshpokharkar)

---

## 📄 License

This project is licensed under the MIT License.

