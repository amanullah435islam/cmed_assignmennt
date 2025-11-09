package com.cmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cmed.model.Prescription;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    // ✅ Filter prescriptions by date range
    List<Prescription> findByPrescriptionDateBetween(LocalDate startDate, LocalDate endDate);

//    // ✅ Day-wise count report
//    @Query("SELECT p.prescriptionDate, COUNT(p) FROM Prescription p GROUP BY p.prescriptionDate ORDER BY p.prescriptionDate")
//    List<Object[]> getDayWisePrescriptionCount();
//    
//    @Query("SELECT p.prescriptionDate, COUNT(p) FROM Prescription p GROUP BY p.prescriptionDate ORDER BY p.prescriptionDate DESC")
//    List<Object[]> findDayWisePrescriptionCount();
	
    
    @Query("SELECT p.prescriptionDate, COUNT(p) FROM Prescription p GROUP BY p.prescriptionDate ORDER BY p.prescriptionDate DESC")
    List<Object[]> findDayWisePrescriptionCount();

    @Query("SELECT COUNT(p) FROM Prescription p")
    Long countTotalPrescriptions();
}