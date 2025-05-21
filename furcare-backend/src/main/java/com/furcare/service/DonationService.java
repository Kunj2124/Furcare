package com.furcare.service;

import com.furcare.model.Donation;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DonationService {
    Donation saveDonation(Donation donation);
    List<Donation> getAllDonations();
}
