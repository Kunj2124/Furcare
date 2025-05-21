package com.furcare.model;

import jakarta.persistence.*;

@Entity
public class VetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNumber;
    private String address;
    private int numberOfDogs;
    private String typeOfExamination;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getNumberOfDogs() { return numberOfDogs; }
    public void setNumberOfDogs(int numberOfDogs) { this.numberOfDogs = numberOfDogs; }

    public String getTypeOfExamination() { return typeOfExamination; }
    public void setTypeOfExamination(String typeOfExamination) { this.typeOfExamination = typeOfExamination; }
}
