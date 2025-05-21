package com.furcare.controller;

import com.furcare.model.Donation;
import com.furcare.model.Volunteer;
import com.furcare.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://localhost:5500", "http://localhost:5501"}, allowCredentials = "true")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @PostMapping
    public ResponseEntity<Volunteer> addVolunteers(@RequestBody Volunteer volunteer) {
        Volunteer savedDonation = volunteerService.saveVolunteer(volunteer);
        return new ResponseEntity<>(savedDonation, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Volunteer> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }
}
