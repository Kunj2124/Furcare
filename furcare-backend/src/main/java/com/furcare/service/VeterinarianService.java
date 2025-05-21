package com.furcare.service;

import com.furcare.model.Veterinarian;
import java.util.List;

public interface VeterinarianService {
    Veterinarian saveVeterinarian(Veterinarian veterinarian);
    List<Veterinarian> getAllVeterinarians();
}


