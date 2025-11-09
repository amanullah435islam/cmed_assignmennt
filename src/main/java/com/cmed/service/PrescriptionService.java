package com.cmed.service;

import com.cmed.model.Prescription;
import com.cmed.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // ✅ Create বা Save prescription
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // ✅ Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // ✅ Get prescription by ID
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    // ✅ Update prescription
    public Prescription updatePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // ✅ Delete prescription
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    // ✅ Filter prescriptions by date range
    public List<Prescription> getPrescriptionsByDateRange(LocalDate startDate, LocalDate endDate) {
        return prescriptionRepository.findByPrescriptionDateBetween(startDate, endDate);
    }

//    // ✅ Day-wise prescription count for report
//    public List<Object[]> getDayWisePrescriptionCount() {
//        return prescriptionRepository.getDayWisePrescriptionCount();
//    }
    
        public Long countTotalPrescriptions() {
            return prescriptionRepository.countTotalPrescriptions();
        }
        public List<Object[]> getDayWiseReport() {
            try {
                return prescriptionRepository.findDayWisePrescriptionCount();
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
// // PrescriptionService.java
//    public List<Object[]> getDayWiseReport() {
//        try {
//            return prescriptionRepository.findDayWisePrescriptionCount();
//        } catch (Exception e) {
//            System.err.println("Error generating report: " + e.getMessage());
//            return new ArrayList<>();
//        }
//    }


   
}
