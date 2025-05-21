package com.furcare.repository;

import com.furcare.model.VetRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRequestRepository extends JpaRepository<VetRequest, Long> {
}
