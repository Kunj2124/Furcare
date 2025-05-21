package com.furcare.controller;

import com.furcare.model.Donation;
import com.furcare.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://localhost:5500", "http://localhost:5501"}, allowCredentials = "true")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<Donation> addDonation(@RequestBody Donation donation) {
        Donation savedDonation = donationService.saveDonation(donation);
        System.out.println(donation);
        return new ResponseEntity<>(savedDonation, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }
}
