Project structure:
PrescriptionSystem/
 ┣ 📂 src/main/java/com/cmed/prescriptionapp/
 ┃ ┣ 📂 controller/
 ┃ ┃ ┣ AuthController.java
 ┃ ┃ ┗ PrescriptionController.java
 ┃ ┣ 📂 service/
 ┃ ┃ ┗ PrescriptionService.java
 ┃ ┣ 📂 repository/
 ┃ ┃ ┗ PrescriptionRepository.java
 ┃ ┣ 📂 model/
 ┃ ┃ ┣ User.java
 ┃ ┃ ┗ Prescription.java
 ┃ ┣ 📂 config/
 ┃ ┃ ┣ SecurityConfig.java
 ┃ ┃ ┗ WebConfig.java
 ┃ ┗ PrescriptionApplication.java
 ┣ 📂 src/main/resources/
 ┃ ┣ 📂 templates/
 ┃ ┃ ┣ login.html
 ┃ ┃ ┣ prescription_form.html
 ┃ ┃ ┣ prescription_list.html
 ┃ ┃ ┗ report.html
 ┃ ┣ 📂 static/
 ┃ ┃ ┣ 📂 css/
 ┃ ┃ ┃ ┗ style.css
 ┃ ┃ ┗ 📂 js/
 ┃ ┃   ┗ validation.js
 ┃ ┗ application.properties
 ┣ pom.xml
 ┗ README.md
