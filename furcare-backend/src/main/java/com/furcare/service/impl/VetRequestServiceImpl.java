package com.furcare.service.impl;

import com.furcare.model.VetRequest;
import com.furcare.repository.VetRequestRepository;
import com.furcare.service.VetRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetRequestServiceImpl implements VetRequestService {

    @Autowired
    private VetRequestRepository vetRequestRepository;

    public VetRequest saveVetRequest(VetRequest vetRequest) {
        return vetRequestRepository.save(vetRequest);
    }

    public List<VetRequest> getAllVetRequests() {
        return vetRequestRepository.findAll();
    }
}
