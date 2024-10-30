package com.cab.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "career_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String applyngForPost; // Position applied for
    private int experience;
    private String details;

    // Constructors, Getters, and Setters

  

    
}

