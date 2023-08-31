package com.example.medionbd.doctor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @GetMapping
    public List<Doctor> getDoctors(){
       return doctorService.getDoctors();
    }
    @PostMapping
    public void createDoctor(@RequestBody Doctor doctor){
        doctorService.createDoctor(doctor);
    }

    @DeleteMapping(path = "{doctorId}")
    public  void deleteDoctor(@PathVariable("doctorId") UUID doctorId){
        doctorService.deleteDoctor(doctorId);
    }

    @PutMapping(path = "{doctorId}")
    public void updateDoctor(
            @PathVariable("doctorId") UUID doctorId,
            @RequestParam(required = false) Boolean isActive,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String biography,
            @RequestParam(required = false) String phoneNumber,
            @RequestBody Doctor updatedDoctor
    ){
        doctorService.updateDoctor(doctorId,updatedDoctor);
    }
}