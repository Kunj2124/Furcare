package com.furcare.service.impl;

import com.furcare.model.Veterinarian;
import com.furcare.repository.VeterinarianRepository;
import com.furcare.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianServiceImpl implements VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public Veterinarian saveVeterinarian(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }
}
