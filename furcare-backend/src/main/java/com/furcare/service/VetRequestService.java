package com.furcare.service;

import com.furcare.model.VetRequest;
import java.util.List;

public interface VetRequestService {
    VetRequest saveVetRequest(VetRequest vetRequest);
    List<VetRequest> getAllVetRequests();
}
