package com.furcare.repository;

import com.furcare.model.UserContribution;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserContributionRepository extends JpaRepository<UserContribution, Long> {
    Optional<UserContribution> findByUserId(Long userId);
} 