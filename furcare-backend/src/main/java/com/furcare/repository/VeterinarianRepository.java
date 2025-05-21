package com.furcare.repository;
import java.util.*;
import com.furcare.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    List<Veterinarian> findByPin(int pin);
}
