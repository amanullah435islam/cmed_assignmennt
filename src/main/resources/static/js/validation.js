// validation.js

function validateForm() {
    const name = document.querySelector('[name="patientName"]').value.trim();
    const age = document.querySelector('[name="patientAge"]').value;
    const gender = document.querySelector('[name="patientGender"]').value;
    const diagnosis = document.querySelector('[name="diagnosis"]').value.trim();
    const medicines = document.querySelector('[name="medicines"]').value.trim();

    if (name === "") {
        alert("Patient name is required");
        return false;
    }

    if (age === "" || isNaN(age) || age <= 0) {
        alert("Please enter a valid age");
        return false;
    }

    if (gender === "") {
        alert("Please select gender");
        return false;
    }

    if (diagnosis === "") {
        alert("Diagnosis cannot be empty");
        return false;
    }

    if (medicines === "") {
        alert("Medicines cannot be empty");
        return false;
    }

    return true; // form is valid
}

// Optional: Delete confirmation (already inline in template)
function confirmDelete() {
    return confirm("Are you sure you want to delete?");
}



/*function validateForm() {
    const patientName = document.querySelector('input[th\\:field="*{patientName}"]') || 
                       document.querySelector('input[name="patientName"]');
    const patientAge = document.querySelector('input[th\\:field="*{patientAge}"]') || 
                      document.querySelector('input[name="patientAge"]');
    
    // Patient Name validation
    if (patientName && patientName.value.trim() === '') {
        alert('Please enter patient name');
        patientName.focus();
        return false;
    }
    
    // Patient Age validation
    if (patientAge) {
        const age = parseInt(patientAge.value);
        if (isNaN(age) || age < 0 || age > 150) {
            alert('Please enter a valid age (0-150)');
            patientAge.focus();
            return false;
        }
    }
    
    // Date validation (if needed)
    const prescriptionDate = document.querySelector('input[th\\:field="*{prescriptionDate}"]') || 
                            document.querySelector('input[name="prescriptionDate"]');
    if (prescriptionDate && !prescriptionDate.value) {
        alert('Please select prescription date');
        prescriptionDate.focus();
        return false;
    }
    
    return true;
}*/

// Register form validation (if needed)
function validateRegisterForm() {
    const password = document.querySelector('input[th\\:field="*{password}"]') || 
                    document.querySelector('input[name="password"]');
    
    if (password && password.value.length < 4) {
        alert('Password must be at least 4 characters long');
        password.focus();
        return false;
    }
    
    return true;
}
