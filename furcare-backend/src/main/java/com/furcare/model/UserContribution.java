package com.furcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_contributions")
public class UserContribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "donation_count")
    private int donationCount;

    @Column(name = "volunteering_count")
    private int volunteeringCount;

    @Column(name = "dog_help_count")
    private int dogHelpCount;

    @Column(name = "total_points")
    private int totalPoints;

    @Column(name = "reward_tier")
    private String rewardTier; // BRONZE, SILVER, GOLD, PLATINUM

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getDonationCount() {
        return donationCount;
    }

    public void setDonationCount(int donationCount) {
        this.donationCount = donationCount;
    }

    public int getVolunteeringCount() {
        return volunteeringCount;
    }

    public void setVolunteeringCount(int volunteeringCount) {
        this.volunteeringCount = volunteeringCount;
    }

    public int getDogHelpCount() {
        return dogHelpCount;
    }

    public void setDogHelpCount(int dogHelpCount) {
        this.dogHelpCount = dogHelpCount;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getRewardTier() {
        return rewardTier;
    }

    public void setRewardTier(String rewardTier) {
        this.rewardTier = rewardTier;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    // Calculate points based on contributions
    public void calculatePoints() {
        // Points calculation logic
        // Donation: 10 points per donation
        // Volunteering: 20 points per session
        // Dog Help: 15 points per help
        this.totalPoints = (this.donationCount * 10) + 
                          (this.volunteeringCount * 20) + 
                          (this.dogHelpCount * 15);
        
        // Update reward tier based on total points
        if (this.totalPoints >= 1000) {
            this.rewardTier = "PLATINUM";
        } else if (this.totalPoints >= 500) {
            this.rewardTier = "GOLD";
        } else if (this.totalPoints >= 200) {
            this.rewardTier = "SILVER";
        } else {
            this.rewardTier = "BRONZE";
        }
    }
} 