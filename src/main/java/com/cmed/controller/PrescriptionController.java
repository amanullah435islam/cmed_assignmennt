package com.cmed.controller;

import com.cmed.model.Prescription;
import com.cmed.repository.PrescriptionRepository;
import com.cmed.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    private PrescriptionRepository prescriptionRepository;

    // ✅ List all prescriptions (default current month)
    @GetMapping
    public String listPrescriptions(Model model,
                                    @RequestParam(required = false)
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                    @RequestParam(required = false)
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Prescription> prescriptions;

        if (startDate != null && endDate != null) {
            prescriptions = prescriptionService.getPrescriptionsByDateRange(startDate, endDate);
        } else {
            // default all prescriptions
            prescriptions = prescriptionService.getAllPrescriptions();
        }

        model.addAttribute("prescriptions", prescriptions);
        return "prescription_list";
    }

    // ✅ Show create form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "prescription_form";
    }

    // ✅ Save new prescription
    @PostMapping("/save")
    public String savePrescription(@ModelAttribute Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return "redirect:/prescriptions";
    }

    // ✅ Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.getPrescriptionById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid prescription Id:" + id));
        model.addAttribute("prescription", prescription);
        return "prescription_form";
    }

    // ✅ Update prescription
    @PostMapping("/update/{id}")
    public String updatePrescription(@PathVariable Long id,
                                     @ModelAttribute Prescription prescription) {
        prescription.setId(id);
        prescriptionService.updatePrescription(prescription);
        return "redirect:/prescriptions";
    }

    // ✅ Delete prescription
    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return "redirect:/prescriptions";
    }

//    // ✅ Report page (day-wise count)
//    @GetMapping("/report")
//    public String showReport(Model model) {
//        List<Object[]> reportData = prescriptionService.getDayWisePrescriptionCount();
//        model.addAttribute("reportData", reportData);
//        return "report";
//    }

    
//    @GetMapping("/report")
//    public String showReport(Model model) {
//        try {
//            List<Object[]> reportData = prescriptionRepository.findDayWisePrescriptionCount;
//            Long totalPrescriptions = prescriptionRepository.countTotalPrescriptions();
//
//            if (totalPrescriptions == null) {
//                totalPrescriptions = 0L;
//            }
//
//            double averagePerDay = 0.0;
//            Object[] busiestDay = null;
//
//            if (reportData != null && !reportData.isEmpty()) {
//                int totalCount = reportData.stream()
//                    .mapToInt(r -> ((Number) r[1]).intValue())
//                    .sum();
//                averagePerDay = (double) totalCount / reportData.size();
//
//                busiestDay = reportData.stream()
//                    .max(Comparator.comparing(r -> ((Number) r[1]).intValue()))
//                    .orElse(null);
//            }
//
//            model.addAttribute("reportData", reportData);
//            model.addAttribute("totalPrescriptions", totalPrescriptions);
//            model.addAttribute("averagePerDay", String.format("%.1f", averagePerDay));
//            model.addAttribute("busiestDay", busiestDay);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("reportData", new ArrayList<>());
//            model.addAttribute("totalPrescriptions", 0L);
//            model.addAttribute("averagePerDay", "0.0");
//            model.addAttribute("busiestDay", null);
//        }
//
//        return "report";
//    }

    @GetMapping("/report")
    public String showReport(Model model) {
        List<Object[]> reportData = prescriptionService.getDayWiseReport();

        int totalPrescriptions = 0;
        double averagePerDay = 0.0;
        Object[] busiestDay = null;

        if (reportData != null && !reportData.isEmpty()) {
            totalPrescriptions = reportData.stream()
                    .mapToInt(r -> ((Number) r[1]).intValue())
                    .sum();
            averagePerDay = (double) totalPrescriptions / reportData.size();
            busiestDay = reportData.stream()
                    .max(Comparator.comparing(r -> ((Number) r[1]).intValue()))
                    .orElse(null);
        }

        model.addAttribute("reportData", reportData == null ? new ArrayList<>() : reportData);
        model.addAttribute("totalPrescriptions", totalPrescriptions);
        model.addAttribute("averagePerDay", String.format("%.1f", averagePerDay));
        model.addAttribute("busiestDay", busiestDay);

        return "report";
    }

    
    // ✅ REST API endpoint
    @GetMapping("/api/v1")
    @ResponseBody
    public List<Prescription> getPrescriptionsApi() {
        return prescriptionService.getAllPrescriptions();
    }
    
    
    @GetMapping("/prescriptions")
    public String listPrescriptions(Model model) {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        model.addAttribute("prescriptions", prescriptions != null ? prescriptions : new ArrayList<>());

        // ✅ ensure reportData is not null
        model.addAttribute("reportData", new ArrayList<>());

        return "prescription_list";
    }

    
}

