# 💊 CMED Prescription Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?style=for-the-badge&logo=springboot)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template%20Engine-blue?style=for-the-badge&logo=thymeleaf)
![H2 Database](https://img.shields.io/badge/H2-Database-yellow?style=for-the-badge&logo=h2)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-7952B3?style=for-the-badge&logo=bootstrap)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

**A complete hospital management solution for digital prescription handling**

</div>

---

## 📖 Table of Contents
- [🌟 Overview](#-overview)
- [🚀 Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [📦 Installation](#-installation)
- [🎯 Usage Guide](#-usage-guide)
- [🏗️ Project Structure](#️-project-structure)
- [📊 Database Schema](#-database-schema)
- [🔗 API Endpoints](#-api-endpoints)
- [👥 Contributors](#-contributors)
- [📄 License](#-license)
- [🙏 Acknowledgments](#-acknowledgments)

---

## 🌟 Overview

**CMED Prescription System** is a web-based application designed for hospitals and clinics to manage patient prescriptions digitally.  
It replaces traditional paper-based systems with a **secure**, **efficient**, and **user-friendly** digital platform.

### 🎯 Purpose
- Digitalize prescription management  
- Improve patient record keeping  
- Generate analytical reports  
- Streamline hospital workflows  

---

## 🚀 Features

### 🔐 Authentication System

| Feature | Description | Status |
|----------|--------------|--------|
| User Registration | Create new doctor/staff accounts | ✅ Implemented |
| Secure Login | Role-based access control | ✅ Implemented |
| Session Management | Automatic session handling | ✅ Implemented |

### 💊 Prescription Management

| Feature | Description | Status |
|----------|--------------|--------|
| Add Prescription | Create new patient prescriptions | ✅ Implemented |
| Edit Prescription | Modify existing prescriptions | ✅ Implemented |
| Delete Prescription | Remove prescription records | ✅ Implemented |
| View All | Table-based prescription listing | ✅ Implemented |
| Date Filter | Filter by prescription date range | ✅ Implemented |

### 📈 Analytics & Reports

| Feature | Description | Status |
|----------|--------------|--------|
| Day-wise Reports | Prescription statistics by date | ✅ Implemented |
| Peak Day Analysis | Identify busiest days | ✅ Implemented |
| Average Calculation | Daily prescription averages | ✅ Implemented |
| Visual Charts | Graphical data representation | ✅ Implemented |

### 🎨 User Interface

| Feature | Description | Status |
|----------|--------------|--------|
| Responsive Design | Mobile and desktop compatible | ✅ Implemented |
| Card-based Layout | Modern UI components | ✅ Implemented |
| Color-coded Status | Visual indicators for different states | ✅ Implemented |
| Professional Theme | Healthcare-appropriate design | ✅ Implemented |

---

## 🛠️ Tech Stack

### 🖥️ Backend Technologies

| Technology | Version |
|-------------|----------|
| Java | 17 |
| Spring Boot | 3.5.7 |
| Spring Security | 6.5.6 |
| Spring Data JPA | 3.5.7 |
| H2 Database | 2.3.232 |
| Maven | 3.6+ |

### 💻 Frontend Technologies

| Technology | Usage |
|-------------|--------|
| Thymeleaf | Server-side templating |
| HTML5 | Page structure |
| CSS3 | Styling and responsive layout |
| JavaScript | Client-side interactions |
| Bootstrap 5 | UI Components |
| Custom CSS | Healthcare UI styling |

---

## 📦 Installation

### ✅ Prerequisites Checklist
- [ ] Java 17 or higher installed  
- [ ] Maven 3.6+ installed  
- [ ] Git installed  
- [ ] IDE (IntelliJ IDEA, Eclipse, or VS Code)

---

### ⚙️ Step-by-Step Setup

#### 1️⃣ Clone Repository
```bash
git clone https://github.com/amanullah435islam/cmed_assignmennt.git
cd cmed_assignmennt

2️⃣ Build Project
mvn clean install

3️⃣ Run Application
mvn spring-boot:run

4️⃣ Access Application

Open your browser and navigate to:
👉 http://localhost:8080

🗂️ Default Access
Service	URL	Credentials
Web Application	http://localhost:8080
	Register new account
H2 Console	http://localhost:8080/h2-console
	JDBC URL: jdbc:h2:mem:prescriptiondb
Username: sa
Password: (empty)
🎯 Usage Guide
👤 For Doctors & Medical Staff

1️⃣ Register an account
2️⃣ Login to the system
3️⃣ Add or manage prescriptions
4️⃣ View reports & analytics

📝 Prescription Form Fields
Field	Type	Required	Description
Patient Name	Text	✅	Full name of the patient
Age	Number	✅	Patient’s age
Gender	Dropdown	✅	Male/Female selection
Prescription Date	Date	✅	Date of prescription
Diagnosis	Textarea	❌	Medical diagnosis
Medicines	Textarea	❌	Prescribed medicines
Next Visit Date	Date	❌	Follow-up appointment


🏗️ Project Structure :

cmed_assignmennt/
├── src/main/java/com/cmed/prescriptionsystem/
│   ├── controller/
│   │   ├── AuthController.java
│   │   ├── PrescriptionController.java
│   │   └── ReportController.java
│   ├── model/
│   │   ├── User.java
│   │   └── Prescription.java
│   ├── repository/
│   │   ├── UserRepository.java
│   │   └── PrescriptionRepository.java
│   ├── service/
│   │   ├── UserService.java
│   │   └── PrescriptionService.java
│   └── config/
│       └── SecurityConfig.java
├── src/main/resources/
│   ├── static/css/
│   │   └── style.css
│   ├── templates/
│   │   ├── login.html
│   │   ├── register.html
│   │   ├── prescription_list.html
│   │   ├── prescription_form.html
│   │   └── report.html
│   └── application.properties
└── pom.xml

📊 Database Schema :

👥 Users Table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_role VARCHAR(255) NOT NULL
);

💊 Prescriptions Table
CREATE TABLE prescriptions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    prescription_date DATE NOT NULL,
    patient_name VARCHAR(255) NOT NULL,
    patient_age INTEGER NOT NULL,
    patient_gender VARCHAR(255) NOT NULL,
    diagnosis TEXT,
    medicines TEXT,
    next_visit_date DATE
);

📈 Sample Data
INSERT INTO users (name, username, password, user_role) 
VALUES ('Dr. Amanullah', 'doctor', 'encrypted_password', 'USER');

INSERT INTO prescriptions (prescription_date, patient_name, patient_age, patient_gender, diagnosis, medicines, next_visit_date)
VALUES ('2024-11-09', 'Imtiaz', 35, 'Male', 'Common Cold', 'Paracetamol 500mg', '2024-11-16');

🔗 API Endpoints:

🔐 Authentication Endpoints
Method	Endpoint	Description	Parameters
GET	/	Home page redirect	-
GET	/login	Login form	-
POST	/login	Process login	username, password
GET	/register	Registration form	-
POST	/register	Process registration	User object
GET	/logout	Logout user	-

💊 Prescription Endpoints
Method	Endpoint	Description	Parameters
GET	/prescriptions	List all prescriptions	startDate, endDate (optional)
GET	/prescriptions/create	Create form	-
POST	/prescriptions/save	Save new prescription	Prescription object
GET	/prescriptions/edit/{id}	Edit form	id
POST	/prescriptions/update/{id}	Update existing	id, Prescription object
GET	/prescriptions/delete/{id}	Delete prescription	id

📈 Report Endpoints
Method	Endpoint	Description	Parameters
GET	/prescriptions/report	Analytics dashboard	-

👥 Contributors :

<div align="center">
   🎓 Project Developed By
   Amanullah Islam
   💻 Full Stack Developer
   📧 Email: your.email@example.com
   🔗 GitHub: @amanullah435islam
</div>

🤝 Contribution Guidelines :

We welcome contributions! Follow these steps:

Fork the repository
Create a feature branch
git checkout -b feature/AmazingFeature
Commit your changes
git commit -m "Add AmazingFeature"
Push to branch
git push origin feature/AmazingFeature

Open a Pull Request 🎉

🐛 Issue Reporting 

Found a bug? Please create an issue with:
Detailed description
Steps to reproduce
Expected vs Actual behavior
Screenshots (if applicable)

📄 License

This project is licensed under the MIT License — see the LICENSE
 file for details.

🙏 Acknowledgments :

Spring Boot Team — For the amazing framework
Thymeleaf Community — For robust templating
H2 Database Team — For lightweight DB
Medical Professionals — For real-world insights

