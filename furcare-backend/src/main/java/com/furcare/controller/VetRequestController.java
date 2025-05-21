package com.furcare.controller;

import com.furcare.model.Donation;
import com.furcare.model.VetRequest;
import com.furcare.service.VetRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vet-requests")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://localhost:5500", "http://localhost:5501"}, allowCredentials = "true")
public class VetRequestController {

    @Autowired
    private VetRequestService vetRequestService;

    @PostMapping
    public ResponseEntity<VetRequest> addVetRequest(@RequestBody VetRequest vetRequest) {
        VetRequest savedVetRequest = vetRequestService.saveVetRequest(vetRequest);
        return new ResponseEntity<>(savedVetRequest, HttpStatus.CREATED);
    }

    @GetMapping
    public List<VetRequest> getAllVetRequests() {
        return vetRequestService.getAllVetRequests();
    }
}
