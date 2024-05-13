// PatientRepository.java

package com.repository;

import com.model.Patient;
import com.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // Add custom query methods if needed
	Patient findByEmail(String emailId);
}
