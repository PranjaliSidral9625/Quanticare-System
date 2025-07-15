

# 🏥 Quanticare System (Java Console App with Hibernate & PostgreSQL)

Quanticare is a clean, console-based Java application that demonstrates patient management in a health service context. It uses *Hibernate 6.4.4, **Jakarta Persistence (JPA 3.1), and **PostgreSQL* 

---

## 📌 Features

- 🆕 Register a new patient
- 🧾 Save patient records in PostgreSQL using Hibernate
- 🧵 Designed for simplicity, modularity, and extensibility
- 🌱 Easy to expand with modules like Doctors, Appointments, Billing, etc.

---

## 🛠 Technologies Used

| Tech                  | Version         |
|-----------------------|-----------------|
| Java                  | 17              |
| Maven                 | Latest          |
| Hibernate ORM         | 6.4.4.Final     |
| Jakarta Persistence   | 3.1.0           |
| PostgreSQL            | 15+             |
| IDE                   | VS Code / Eclipse / STS |

---

## 🧱 Project Structure

QuanticareSystem/
├── pom.xml
├── README.md
├── images/                          # (Optional) Screenshots for README
│   └── console_output.png
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── quanticare/
        │           ├── entity/
        │           │   └── Patient.java              # JPA Entity
        │           ├── util/
        │           │   └── HibernateUtil.java        # Hibernate Configuration
        │           └── main/
        │               └── MainApp.java              # Main console logic
        └── resources/
            └── META-INF/
                └── persistence.xml                   # JPA & Hibernate Config

---

## 🧾 Database Setup (PostgreSQL)

1. Open pgAdmin or terminal
2. Create the database:
```sql
CREATE DATABASE quanticare_db;

3. Hibernate will auto-generate the tables on first run.








---

⚙ Dependencies Used

hibernate-core 6.4.4

jakarta.persistence-api 3.1.0

postgresql JDBC driver 42.7.2

jakarta.xml.bind-api 4.0.0



---

▶ How to Run

mvn clean install
mvn exec:java

Or run MainApp.java directly from your IDE.


---

📂 Sample Output

<img src="C:\Users\pranj\Downloads\QuanticareSystemVSCode\Screenshot 2025-07-15 165334.png"width="400">


---

🌟 What Makes Quanticare Unique?

✅ Human-readable code for beginner to pro-level understanding

✅ Built without Spring, offering full manual control over ORM configuration

✅ Modular architecture — easily extendable to multiple real-world healthcare features



---

🙋‍♀ Author

Name: Pranjali Sidral
Email: [pranjalisidral@gmail.com]


---

✨ Thank You!

Thank you for exploring Quanticare System!
Feel free to fork, enhance, or turn it into your own full-stack healthcare app 🚀

---
