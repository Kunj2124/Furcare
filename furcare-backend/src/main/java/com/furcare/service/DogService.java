package com.furcare.service;

import com.furcare.model.Dog;
import com.furcare.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public Dog saveBeneficiary(Dog dog) {
        return dogRepository.save(dog);
    }

    public List<Dog> getAllBeneficiaries() {
        return dogRepository.findAll();
    }
}
