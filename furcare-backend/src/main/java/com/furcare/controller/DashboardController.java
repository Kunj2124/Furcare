package com.furcare.controller;

import com.furcare.model.Dog;
import com.furcare.model.UserContribution;
import com.furcare.service.DogService;
import com.furcare.service.UserContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.furcare.model.User;
import com.furcare.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://localhost:5500", "http://localhost:5501"}, allowCredentials = "true")
public class DashboardController {

    @Autowired
    private UserContributionService userContributionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DogService dogService;  // Corrected Service Name

    @GetMapping("/contributions")
    public ResponseEntity<?> getUserContributions(Authentication authentication) {
        try {
            String email = authentication.getName();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            UserContribution contribution = userContributionService.getUserContribution(user.getId());
            return ResponseEntity.ok(contribution);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching user contributions: " + e.getMessage());
        }
    }

    @GetMapping("/rewards")
    public ResponseEntity<?> getUserRewards(Authentication authentication) {
        try {
            String email = authentication.getName();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            String rewardTier = userContributionService.getRewardTier(user.getId());
            int totalPoints = userContributionService.getTotalPoints(user.getId());

            return ResponseEntity.ok(new Object() {
                public final String tier = rewardTier;
                public final int points = totalPoints;
            });
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching user rewards: " + e.getMessage());
        }
    }

    @PostMapping("/adddog")
    public ResponseEntity<Dog> addBeneficiary(@RequestBody Dog dog) {
        // try {
        //     Dog savedBeneficiary = dogService.saveBeneficiary(dog);
        //     return new ResponseEntity<>(savedBeneficiary, HttpStatus.CREATED);
        // } catch (Exception e) {
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        //             .body(null);
        // }
        System.out.println(dog);
        Dog savedBeneficiary = dogService.saveBeneficiary(dog);
        return new ResponseEntity<>(savedBeneficiary, HttpStatus.CREATED);
    }
    @GetMapping("/alldog")
    public ResponseEntity<List<Dog>> getAllDog() {
        return new ResponseEntity<>(dogService.getAllBeneficiaries(), HttpStatus.OK);
    }
}
