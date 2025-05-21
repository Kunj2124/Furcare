package com.furcare.service;

import com.furcare.model.UserContribution;
import com.furcare.repository.UserContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class UserContributionService {
    
    @Autowired
    private UserContributionRepository userContributionRepository;

    public UserContribution getUserContribution(Long userId) {
        Optional<UserContribution> contribution = userContributionRepository.findByUserId(userId);
        if (contribution.isPresent()) {
            return contribution.get();
        }
        
        // Create new contribution record if none exists
        UserContribution newContribution = new UserContribution();
        newContribution.setUserId(userId);
        newContribution.setDonationCount(0);
        newContribution.setVolunteeringCount(0);
        newContribution.setDogHelpCount(0);
        newContribution.setTotalPoints(0);
        newContribution.setRewardTier("BRONZE");
        newContribution.setLastUpdated(new Date());
        
        return userContributionRepository.save(newContribution);
    }

    public UserContribution incrementDonationCount(Long userId) {
        UserContribution contribution = getUserContribution(userId);
        contribution.setDonationCount(contribution.getDonationCount() + 1);
        contribution.setLastUpdated(new Date());
        contribution.calculatePoints();
        return userContributionRepository.save(contribution);
    }

    public UserContribution incrementVolunteeringCount(Long userId) {
        UserContribution contribution = getUserContribution(userId);
        contribution.setVolunteeringCount(contribution.getVolunteeringCount() + 1);
        contribution.setLastUpdated(new Date());
        contribution.calculatePoints();
        return userContributionRepository.save(contribution);
    }

    public UserContribution incrementDogHelpCount(Long userId) {
        UserContribution contribution = getUserContribution(userId);
        contribution.setDogHelpCount(contribution.getDogHelpCount() + 1);
        contribution.setLastUpdated(new Date());
        contribution.calculatePoints();
        return userContributionRepository.save(contribution);
    }

    public String getRewardTier(Long userId) {
        UserContribution contribution = getUserContribution(userId);
        return contribution.getRewardTier();
    }

    public int getTotalPoints(Long userId) {
        UserContribution contribution = getUserContribution(userId);
        return contribution.getTotalPoints();
    }
} 