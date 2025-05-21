package com.furcare.service;

import com.furcare.model.Volunteer;
import java.util.List;

public interface VolunteerService {
    Volunteer saveVolunteer(Volunteer volunteer);
    List<Volunteer> getAllVolunteers();
}
