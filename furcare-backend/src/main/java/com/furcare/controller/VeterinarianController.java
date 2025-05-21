package com.furcare.controller;

import com.furcare.model.Veterinarian;
import com.furcare.service.VeterinarianService;
import com.furcare.service.NewVetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://localhost:5500", "http://localhost:5501"}, allowCredentials = "true")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    @Autowired
    private NewVetService newVetService;

    @PostMapping
    public ResponseEntity<Veterinarian> addDonation(@RequestBody Veterinarian donation) {
        Veterinarian savedVeterinarian = veterinarianService.saveVeterinarian(donation);
        return new ResponseEntity<>(savedVeterinarian, HttpStatus.CREATED);
    }

    
    
    @GetMapping
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianService.getAllVeterinarians();
    }
}