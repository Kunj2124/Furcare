package com.furcare.service;
import java.util.*;
import com.furcare.model.Veterinarian;
import com.furcare.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewVetService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public List<Veterinarian> getVetByPin(int pin) {
        return veterinarianRepository.findByPin(pin);
    }
}
